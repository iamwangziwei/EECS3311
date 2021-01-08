note
	description: "A default business model."
	author: "Jackie Wang"
	date: "$Date$"
	revision: "$Revision$"

class
	SPACE_DEFENDER

inherit
	ANY
		redefine
			out
		end

create {SPACE_DEFENDER_ACCESS}
	make

feature {NONE} -- Initialization
	make
			-- Initialization for `Current'.
		local
			choose_weapon:SETUP_STATE
			choose_armour:SETUP_STATE
			choose_engine:SETUP_STATE
			choose_special:SETUP_STATE
			summary:SETUP_SUMMARY
		do
			create s.make_empty
			i := 0
			create_gameboard(3,5,0,0,0,0,0)
--flags			
			flag_setup_mode:=false
			flag_game_mode:=false
			flag_first_game:=true

--msg
			error_message:=""
			message:="%N  Welcome to Space Defender Version 2."

--setup pkg
			create setup_pkg.make(1)
--			if weapon /= 0 then
--				setup_pkg.force (weapon, setup_pkg.count+1)
--			else
--				setup_pkg.force (1, setup_pkg.count+1)
--			end

--			setup_pkg.force (armour, setup_pkg.count+1)
--			setup_pkg.force (engine, setup_pkg.count+1)
--			setup_pkg.force (power, setup_pkg.count+1)
			setup_cursor:=1
--			if weapon = 0 then setup_pkg.force ("%N  Weapon Selected:Standard", 1) weapon:=1 end
--			if armour=0 then setup_pkg.force ("%N  Armour Selected:None", 2) armour:=1 end
--			if engine =0 then setup_pkg.force ("%N  Engine Selected:Standard", 3) engine:=1 end
--			if power =0 then setup_pkg.force ("%N  Power Selected:Recall (50 energy): Teleport back to spawn.", 4) power:=1 end

--debug mode
			flag_debug_mode:=false
			flag_print_debug_msg:=false


--state
			state_type:="normal"
			state:="not started"
			flag_error_or_ok:=true


			create {WEAPON_STANDARD}choose_weapon.make
			create {ARMOUR_NONE}choose_armour.make
			create {ENGINE_STANDARD}choose_engine.make
			create {SPECIAL_RECALL}choose_special.make
			create {SETUP_SUMMARY}summary.make
			setup_pkg.force (choose_weapon, setup_pkg.count+1)
			setup_pkg.force (choose_armour, setup_pkg.count+1)
			setup_pkg.force (choose_engine, setup_pkg.count+1)
			setup_pkg.force (choose_special, setup_pkg.count+1)
			setup_pkg.force (summary, setup_pkg.count+1)
--table of transition
			create init.make
			create transition_table.make_filled(choose_weapon,10,10)
--			transition_table.force (create {WEAPON_STANDARD}.make ,1,1 )
--			transition_table.force (choose_weapon ,1,1 )
			transition_table[1,1]:=choose_weapon
			transition_table[1,2]:=create {WEAPON_SPREAD}.make
			transition_table[1,3]:=create {WEAPON_SNIPE}.make
			transition_table[1,4]:=create {WEAPON_ROCKET}.make
			transition_table[1,5]:=create {WEAPON_SPLITTER}.make
			transition_table[2,1]:=choose_armour
			transition_table[2,2]:=create {ARMOUR_LIGHT}.make
			transition_table[2,3]:=create {ARMOUR_MEDIUM}.make
			transition_table[2,4]:=create {ARMOUR_HEAVY}.make
			transition_table[3,1]:=create {ENGINE_STANDARD}.make
			transition_table[3,2]:=create {ENGINE_LIGHT}.make
			transition_table[3,3]:=create {ENGINE_ARMOURED}.make
			transition_table[4,1]:=create {SPECIAL_RECALL}.make
			transition_table[4,2]:=create {SEPCIAL_REPAIR}.make
			transition_table[4,3]:=create {SPECIAL_OVERCHARGE}.make
			transition_table[4,4]:=create {SPECIAL_DEPLOY_DRONE}.make
			transition_table[4,5]:=create {SPECIAL_ORBITAL_STRIKE}.make
			transition_table[5,1]:=create {SETUP_SUMMARY}.make





		end


feature
	create_gameboard(row: INTEGER ; column: INTEGER ; g_threshold: INTEGER; f_threshold: INTEGER; c_threshold: INTEGER; i_threshold: INTEGER; p_threshold: INTEGER)

		do
			create gameboard.make(row,column, g_threshold, f_threshold, c_threshold, i_threshold, p_threshold)
			setup_cursor:=1

		end
	gameboard:GAMEBOARD
--	star_fighter:STAR_FIGHTER

feature -- model attributes
	s : STRING
	i : INTEGER



--flags
	flag_setup_mode:BOOLEAN
	flag_game_mode:BOOLEAN
	flag_first_game:BOOLEAN
	flag_debug_mode:BOOLEAN--debug mode
	flag_print_debug_msg:BOOLEAN
	flag_error_or_ok:BOOLEAN
--message
	error_message:STRING
	message:STRING

--state number
	state:STRING
	state_type:STRING
	first:INTEGER
	second:INTEGER

--setup pkg
--	setup_pkg_msg:HASH_TABLE[STRING,INTEGER]
	setup_pkg:HASH_TABLE[SETUP_STATE,INTEGER]
--4 setup state
	weapon:INTEGER
	armour:INTEGER
	engine:INTEGER
	power:INTEGER

	setup_cursor:INTEGER

--table of transition
	transition_table: ARRAY2[SETUP_STATE]
	init:WEAPON_STANDARD
--	current_state:SETUP_STATE

feature --flags
	toggle_flag_setup_mode
		do
			if flag_setup_mode then
				flag_setup_mode := false
			else
				flag_setup_mode := true

			end
		end

	toggle_flag_game_mode
		do
			if flag_game_mode then
				flag_game_mode := false
			else
				flag_game_mode := true
				first:=0
				second:=0
			end
		end

	toggle_flag_first_game
		do
			if flag_first_game then
				flag_first_game := false
			else
				flag_first_game := true
				first:=0
				second:=0
			end
		end

	toggle_debug_mode
		do
			if flag_debug_mode then
				flag_debug_mode := false
				state_type:="normal"
				gameboard.toggle_flag_fog(flag_debug_mode)

--				if gameboard.flag_fog then
--					print("is fog")
--				else
--					print(" not fog ")
--				end
			else
				flag_debug_mode := true
				state_type:="debug"
				gameboard.toggle_flag_fog(flag_debug_mode)
			end
		end

	toggle_flag_print_debug_msg
		do
			if flag_print_debug_msg then
				flag_print_debug_msg := false

			else
				flag_print_debug_msg := true
			end
		end
	toggle_flag_error_or_ok
		do
			if flag_error_or_ok then
				flag_error_or_ok := false
			else
				flag_error_or_ok := true
			end
		end
feature --set msg and error msg
	set_message(msg:STRING)
		do
			message:=msg
		end

	set_error_message(msg:STRING)
		do
			error_message:=msg
		end

feature --debug mode


feature --state number
	valid_com
		do
			first:=first+1
			second:=0
		end


	invalid_com
		do
			second:=second+1
		end




feature -- model operations
	default_update
			-- Perform update to the model state.
		do
			i := i + 1
		end

	reset
			-- Reset model state.
		do
			make
		end


	play(row: INTEGER ; column: INTEGER ; g_threshold: INTEGER; f_threshold: INTEGER; c_threshold: INTEGER;
		i_threshold: INTEGER; p_threshold: INTEGER)
--		local
--			temp1:INTEGER
--			temp:RANDOM_GENERATOR_ACCESS

		do
			create_gameboard(row,column, g_threshold, f_threshold, c_threshold, i_threshold, p_threshold)
			toggle_flag_setup_mode
			current.set_state ("weapon setup")
			flag_error_or_ok:=true
			current.toggle_flag_first_game
			gameboard.toggle_flag_fog(flag_debug_mode)

		end


	fire
		local
			fr:TURN
		do
			create {TURN_FIRE}fr.make
			across gameboard.enemy_interceptor is ge loop ge.trigger_prp_action(fr) end
			across gameboard.enemy_fighter is ge loop ge.trigger_prp_action(fr) end
			fr.execute

		end



	pass
		local
			ps:TURN
		do
			create {TURN_PASS}ps.make
--preemptive action for grunt
			across gameboard.enemy_grunt is ge
			loop if ge.valid then
				ge.trigger_prp_action(ps)
				end
			end
			across gameboard.enemy_fighter is ge loop ge.trigger_prp_action(ps) end
			across gameboard.enemy_carrier is ge loop ge.trigger_prp_action(ps)  end
			ps.execute

		end

	special
		local sp:TURN
		do
			create {TURN_SPECIAL}sp.make
			across gameboard.enemy_grunt is ge
			loop if ge.valid then ge.trigger_prp_action(sp) end end
			across gameboard.enemy_carrier is ge
			loop if ge.valid then ge.trigger_prp_action(sp) end end
			sp.execute
		end

	abort
		do
			set_state ("not started")
			toggle_flag_first_game
			first:=0
			second:=0
		end
feature --setup mode


	setup_cursor_increase(val:INTEGER)
		do
			setup_cursor:=setup_cursor+val
		end


	setup_cursor_decrese(val:INTEGER)
		do
			setup_cursor:=setup_cursor-val
		end


	set_state(msg:STRING)
		do
			state:=msg
		end

feature -- for setup
	print_setup_msg
		do
			if attached setup_pkg.at (setup_cursor)  as pkg then
				message.append (pkg.out)

			end
		end

	transision(setup,choice:INTEGER)

		do
			setup_pkg.force (transition_table[setup,choice].deep_twin,setup )
		end





feature -- queries
	out : STRING
		do
			create Result.make_from_string ("")




--			result:=" %N scoreis "+gameboard.sf.sf_focus.get_score.out+"%N"




--first game
			if flag_first_game then

--				print("fist game from model")
				if flag_print_debug_msg then

						toggle_flag_print_debug_msg
				end
				if current.flag_error_or_ok then
					result.append("  state:"+ state+", "+ state_type+", "+"ok")
					result.append (message)
				else
					result.append("  state:"+ state+", "+ state_type+", "+"error")
					result.append(message)
					toggle_flag_error_or_ok
				end
				 message:=""
--				print("first fames")
			end



--setup msg
			if flag_setup_mode then

				if flag_error_or_ok --and not flag_print_debug_msg
				then
					if flag_print_debug_msg then

						toggle_flag_print_debug_msg
--						print("aaa")
					else
						print_setup_msg
--						print("bbb")
					end

				 	result.append("  state:"+ state+", "+ state_type+", "+"ok")
					result.append(message)

				else
					result.append("  state:"+ state+", "+ state_type+", "+"error")
					result.append(message)
					toggle_flag_error_or_ok
				end
				message:=""
--				print(" in game ")
			end

--gameboard output
			if flag_game_mode then
				if gameboard.sf.destroyed then
					set_state("not started")
					toggle_flag_game_mode
					toggle_flag_first_game
					result.append("  state:"+ state+", "+ state_type+", "+"ok")
					result.append (gameboard.sf.out)
					result.append (gameboard.out)
					result.append("%N  The game is over. Better luck next time!")

				else
					current.set_state ("in game")
					if flag_error_or_ok then
						result.append("  state:"+ state+"("+first.out+"."+second.out+")"+", "+ state_type+", "+"ok")
						if flag_print_debug_msg then
							toggle_flag_print_debug_msg
							result.append(message)
						else
							result.append (gameboard.sf.out)
							result.append (gameboard.out)


						end

					else
						result.append ("  state:"+ state+"("+first.out+"."+second.out+")"+", "+ state_type+", error")
						result.append(message)
						toggle_flag_error_or_ok

					end
					message:=""
				end




			end

		end

end





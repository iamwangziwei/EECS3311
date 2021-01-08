note
	description: "Summary description for {ENEMY_FIGHTER}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ENEMY_FIGHTER
inherit
	ENEMIES
--	redefine
--		fire_new
--	end
create
	make

feature
	make(enepo:POSITION;eneid:INTEGER)
		do
			create position.make (1, 1)
			position:=enepo
			before_position:=position
			symbol:='F'
			id:=eneid

			health:=150
			actual_health:=health
			regen_health:=5

			armour:=10
			vision:=10
			seen_by_Starfighter:=false
			can_see_Starfighter:=false

			name:="Fighter"
			is_valid:=true
			move:=3
			move_after:=1
			move_before:=3
--pjt
			pjt_damage:=20
			pjt_damage_after:=50
			pjt_damage_before:=20
			pjt_mv:=-3
			pjt_mv_after:=-6
			pjt_mv_before:=-3



			collide:=false
--action msg
			action_msg:=""
			enemy_action_msg:=""
			collide_with_others_msg:=""
			destroy_others_msg:=""
--preemptive action
			prp_action:=false
			create {TURN_FIRE} prp_action_cmd.make
			--need:may change after
			turn_over:=false

--drop score
			create {GOLD_ORB}drop.make
		end

turn_over:BOOLEAN

feature
	action
		local
			tmppos:POSITION
			tmp:INTEGER
		do
			if turn_over then
				turn_over:=false
			else
				if not gameboard.sf.destroyed or collide then
					regen
					from tmp:=position.col
					until tmp= position.col-move-1 or collide or flag_has_moved
					loop
						create tmppos.make (position.row,tmp )
						check_for_collision(tmppos)
						tmp:=tmp-1
					end
					if valid  and not flag_has_moved then
						backward
						current.toggle_flag_has_moved
					end
					generate_action_msg
					if flag_has_moved and valid and not gameboard.sf.destroyed then
						fire_new
					end
				end
			end


		end

	execute_prp_action(cmd:TURN)
		local
			tmppos:POSITION
			tmp:INTEGER
		do
			if attached {TURN_FIRE}prp_action_cmd  as c then
				armour:=armour+1
				gameboard.set_ene_preemptive_msg ("    A "+name+"(id:"+id.out+") gains 1 armour.%N")


			elseif attached {TURN_PASS}prp_action_cmd  as c then
				regen
				move:=6
				pjt_damage:=100
				pjt_mv:=-10

				turn_over:=true


				from tmp:=position.col
				until tmp=position.col-move-1 or collide or  flag_has_moved
				loop
					create tmppos.make (position.row,tmp )
					check_for_collision(tmppos)
					tmp:=tmp-1
				end




				if valid and not flag_has_moved then
					backward

				end

				if flag_has_moved then
					current.toggle_flag_has_moved
				end

				gameboard.set_ene_preemptive_msg(move_msg_helper)

				if collide_with_others_msg.count>0 then
					gameboard.set_ene_preemptive_msg(collide_with_others_msg)
				end
				collide_with_others_msg:=""

				if destroy_others_msg.count>0 then
					gameboard.set_ene_preemptive_msg(destroy_others_msg)

				end
				destroy_others_msg:=""

				if valid  then
					fire_new
				end
				if action_msg.count>0 then
					gameboard.set_ene_preemptive_msg(action_msg)
					current.clear_action_msg
				end

			end

		end



end

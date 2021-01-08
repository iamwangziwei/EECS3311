note
	description: "Summary description for {ENEMY_INTERCEPTOR}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ENEMY_INTERCEPTOR
inherit
	ENEMIES
--	redefine
--		preemptive_action_fire
--	end


create
	make



feature
	make(enepo:POSITION;eneid:INTEGER)
		do
			create position.make (1, 1)
			position:=enepo
			before_position:=position
			symbol:='I'
			id:=eneid

			health:=50
			actual_health:=health
			regen_health:=0

			armour:=0
			vision:=5
			seen_by_Starfighter:=false
			can_see_Starfighter:=false

			name:="Interceptor"
			is_valid:=true
			move:=3
			move_before:=3
			move_after:=3

			flag_is_interceptor:=false
			interceptor_collide_with_enemy:=false
			flag_interceptor_just_spawned:=false

			collide:=false
--action msg
			enemy_action_msg:=""
			action_msg:=""
			collide_with_others_msg:=""
			destroy_others_msg:=""
--preemptive action
			prp_action:=false
			create {TURN_FIRE} prp_action_cmd.make


--drop score
			create {BRONZE_ORB}drop.make

		end




feature
	action
		local
			tmppos:POSITION
			tmp:INTEGER
		do
			if not prp_action  then
				regen
				if not gameboard.sf.destroyed or collide then
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

				end
			end


		end


	execute_prp_action(cmd:TURN)
		local
			tmppos:POSITION
			tmp:INTEGER
			t1:INTEGER
		do
				regen
				if position.col /= gameboard.sf.position.col then
				 if position.row /= gameboard.sf.position.row  then
--					gameboard.game_board[position.row,position.col]:='_'
					flag_is_interceptor:=true
					if position.row> gameboard.sf.position.row  then

						from tmp:=position.row
						until tmp=gameboard.sf.position.row or collide or flag_has_moved
						loop
							create tmppos.make (tmp-1,position.col)

							check_for_collision(tmppos)
							if interceptor_collide_with_enemy then
								create tmppos.make (tmp,position.col)
								set_position (tmppos)
								interceptor_collide_with_enemy:=false
							end
--							flag_is_interceptor:=false
							tmp:= tmp- 1
						end

					else
						from tmp:=position.row
						until tmp=gameboard.sf.position.row or collide or flag_has_moved
						loop
							create tmppos.make (tmp+1,position.col)
--							flag_is_interceptor:=true
							check_for_collision(tmppos)
							if interceptor_collide_with_enemy then
								create tmppos.make (tmp,position.col)

								set_position (tmppos)
								interceptor_collide_with_enemy:=false
							end

							tmp:= tmp+ 1
						end
					end
					flag_is_interceptor:=false




					if valid and not flag_has_moved then
						create tmppos.make (gameboard.sf.position.row.deep_twin,position.col.deep_twin )
						set_position (tmppos)
					end


					gameboard.set_ene_preemptive_msg(move_msg_helper)

				else

					if valid  and not flag_has_moved then
						set_position (position)
						gameboard.set_ene_preemptive_msg(move_msg_helper)
					end

				end

			else
				flag_is_interceptor:=true
				if position.row> gameboard.sf.position.row  then

						from tmp:=position.row
						until tmp=gameboard.sf.position.row or collide or flag_has_moved
						loop
							create tmppos.make (tmp-1,position.col)
							flag_is_interceptor:=true
							check_for_collision(tmppos)
							if interceptor_collide_with_enemy then
								create tmppos.make (tmp,position.col)
								set_position (tmppos)
								interceptor_collide_with_enemy:=false
							end
							tmp:= tmp- 1
						end

				else
						from tmp:=position.row
						until tmp=gameboard.sf.position.row or collide or flag_has_moved
						loop
							create tmppos.make (tmp+1,position.col)
							flag_is_interceptor:=true
							check_for_collision(tmppos)
							if interceptor_collide_with_enemy then
								create tmppos.make (tmp,position.col)
								set_position (tmppos)
								interceptor_collide_with_enemy:=false
							end
							tmp:= tmp+ 1
						end
				end

				flag_is_interceptor:=false
				gameboard.set_ene_preemptive_msg(move_msg_helper)

			end



		end


end

note
	description: "Summary description for {ENEMY_CARRIER}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ENEMY_CARRIER

inherit
	ENEMIES
--	redefine
--		fire_new
--	end


create
	make



feature {NONE} 
	make(enepo:POSITION;eneid:INTEGER)
		do
			create position.make (1, 1)
			position:=enepo
			before_position:=position
			symbol:='C'
			id:=eneid

			health:=200
			actual_health:=health
			regen_health:=10

			armour:=15
			vision:=15
			seen_by_Starfighter:=false
			can_see_Starfighter:=false

			name:="Carrier"

			move:=2
			move_after:=1
			move_before:=2

			is_valid:=true

			collide:=false
--action msg
			action_msg:=""
			collide_with_others_msg:=""
			destroy_others_msg:=""
			enemy_action_msg:=""
--preemptive action
			prp_action:=false
			create {TURN_FIRE} prp_action_cmd.make

--need:may change after
			turn_over:=false


--focus
--			create {DIAMOND_FOCUS}focus.make_focus

--drop score
			create {DIAMOND_FOCUS}drop.make_focus
		end

--focus:ORB
turn_over:BOOLEAN
feature
	action
		local
			tmppos:POSITION
			tmp:INTEGER
			ene:ENEMIES
			flag:BOOLEAN
		do
			if turn_over then
				turn_over:=false
			else

				if not gameboard.sf.destroyed or collide then
					regen
					if  can_see_Starfighter=false then
						from tmp:=position.col
						until tmp=position.col-move-1 or collide or  flag_has_moved
						loop
							create tmppos.make (position.row,tmp )
							check_for_collision(tmppos)
							tmp:=tmp-1
						end

						if valid and not flag_has_moved then
							backward
							toggle_flag_has_moved
						end
						generate_action_msg

					elseif can_see_Starfighter=true then

						create tmppos.make (position.row,position.col-1 )
						check_for_collision(tmppos)
						if valid and not flag_has_moved then
							backward
							toggle_flag_has_moved
						end

						generate_action_msg
						flag:=false
						if valid then
							create tmppos.make (position.row,position.col-1 )
							across gameboard.enemy is e
							loop
								if e.valid and e.position ~ tmppos  then
									flag:=true

								end
							end
							if not flag then
								create {ENEMY_INTERCEPTOR}ene.make (tmppos,gameboard.enemy.count +1)
--								current.set_action_msg ("      A Interceptor(id:"+ene.id.out+") spawns at location ["+ene.position.correct_row.out+","+ene.position.col.out+"].%N")

								set_action_msg(spawn_msg_helper("Interceptor",ene.id,ene.position))
								ene.check_vision
								gameboard.enemy.force (ene)
								gameboard.enemy_interceptor.force (ene)
								ene.check_for_collision (ene.position)
								if ene.collide_with_others_msg.count>0 then
								set_action_msg(ene.collide_with_others_msg)
								ene.clear_collide_with_others_msg
								end
								if ene.destroy_others_msg.count >0 then
									set_action_msg(ene.destroy_others_msg)
									ene.clear_destroy_others_msg
								end
								ene.toggle_flag_has_moved
							end
						end


					end
				end
			end

		end

	execute_prp_action(cmd:TURN)
		local
			tmp:INTEGER
			tmppos:POSITION
			tmppos1:POSITION
			tmppos2:POSITION
			e1:ENEMIES
			e2:ENEMIES
			flag:BOOLEAN
		do
--			create tmppos.make (1, 1)
--			create {ENEMY_INTERCEPTOR} e1.make(tmppos,gameboard.enemy.count +1)

			if attached {TURN_SPECIAL}prp_action_cmd  as c then
				regen_health:=regen_health+10
				gameboard.set_ene_preemptive_msg ("    A "+name+"(id:"+id.out+") gains 10 regen.%N")
			end
			if attached {TURN_PASS}prp_action_cmd  as c then
				regen
				move:=2
				turn_over:=true


				from tmp:=position.col
				until tmp= position.col-move-1 or collide or flag_has_moved
				loop
					create tmppos.make (position.row,tmp )
					check_for_collision(tmppos)
					tmp:=tmp-1
				end
				if valid and not flag_has_moved then
					backward
--					current.toggle_flag_has_moved
				end
				if flag_has_moved then
					current.toggle_flag_has_moved
				end

				gameboard.set_ene_preemptive_msg(move_msg_helper)

				flag:=false
				if valid then
					create tmppos1.make (position.row -1,position.col )
					create tmppos2.make (position.row +1,position.col )

					across gameboard.enemy is e
					loop
						if e.valid and e.position ~ tmppos1 then
							flag:=true
						end
					end
					if not flag then
						create {ENEMY_INTERCEPTOR} e1.make(tmppos1,gameboard.enemy.count +1)
						gameboard.enemy.force (e1)
						gameboard.enemy_interceptor.force (e1)
						if e1.valid  then
							gameboard.set_ene_preemptive_msg(spawn_msg_helper("Interceptor",e1.id,e1.position))
--							gameboard.set_ene_preemptive_msg("      A Interceptor(id:"+e1.id.out+") spawns at location ["+e1.position.correct_row.out+","+e1.position.col.out+"].%N")
							e1.check_vision
							e1.check_for_collision (e1.position)
							if e1.collide_with_others_msg.count>0 then
								gameboard.set_ene_preemptive_msg(e1.collide_with_others_msg)
								e1.clear_collide_with_others_msg
							end
							if e1.destroy_others_msg.count >0 then
								gameboard.set_ene_preemptive_msg(e1.destroy_others_msg)
								e1.clear_destroy_others_msg
							end
							e1.toggle_flag_has_moved
						else
--							gameboard.set_ene_preemptive_msg(spawn_msg_helper("Interceptor",e1.id,e1.position))
							gameboard.set_ene_preemptive_msg("      A Interceptor(id:"+e1.id.out+") spawns at location out of board.%N")
						end


					end


					flag:=false

					across gameboard.enemy is e
					loop
						if e.valid and e.position ~ tmppos2 then
							flag:=true
						end
					end
					if not flag then
						create {ENEMY_INTERCEPTOR} e2.make(tmppos2,gameboard.enemy.count +1)
						gameboard.enemy.force (e2)
						gameboard.enemy_interceptor.force (e2)
						if e2.valid  then
							gameboard.set_ene_preemptive_msg("      A Interceptor(id:"+e2.id.out+") spawns at location ["+e2.position.correct_row.out+","+e2.position.col.out+"].%N")
							e2.check_vision
							e2.check_for_collision (e2.position)
							if e2.collide_with_others_msg.count>0 then
								gameboard.set_ene_preemptive_msg(e2.collide_with_others_msg)
								e2.clear_collide_with_others_msg
							end
							if e2.destroy_others_msg.count >0 then
								gameboard.set_ene_preemptive_msg(e2.destroy_others_msg)
								e2.clear_destroy_others_msg
							end
							e2.toggle_flag_has_moved
						else
							gameboard.set_ene_preemptive_msg("      A Interceptor(id:"+e2.id.out+") spawns at location out of board.%N")
						end


					end




				end



			end

		end


--	fire_new
--		do
--			

--			
--		end
end

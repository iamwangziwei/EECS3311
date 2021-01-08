note
	description: "Summary description for {ENEMY_PYLON}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ENEMY_PYLON

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
			symbol:='P'
			id:=eneid

			health:=300
			actual_health:=health
			regen_health:=0

			armour:=0
			vision:=5
			seen_by_Starfighter:=false
			can_see_Starfighter:=false

			name:="Pylon"

			move:=2
			move_after:=1
			move_before:=2
--pjt
			pjt_damage:=70
			pjt_damage_after:=70
--			pjt_damage_before:=20
			pjt_mv:=-2
			pjt_mv_after:=-2
--			pjt_mv_before:=-2
			is_valid:=true


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

--drop score
			create {PLATINUM_FOCUS}drop.make_focus
		end



feature
	action
		local
			tmppos:POSITION
			tmp:INTEGER
		do


				if not gameboard.sf.destroyed or collide then
					regen
					if not can_see_Starfighter then

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
						if valid then
							across gameboard.enemy is e
							loop
								if e.valid then
									if position.distance_between (e.position) <= vision then
									e.change_actual_health(10)
									set_action_msg ("      The Pylon heals "+e.name.out+"(id:"+e.id.out+") at location ["+e.position.correct_row.out+","+e.position.col.out+"] for 10 damage.%N")
									end
								end

							end
						end




					else
---need:
						create tmppos.make (position.row,position.col-1 )
						check_for_collision(tmppos)
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
		do

		end
end

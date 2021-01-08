note
	description: "Summary description for {ENEMY_GRUNT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ENEMY_GRUNT

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
			symbol:='G'
			id:=eneid

			health:=100
			actual_health:=health
			regen_health:=1

			armour:=1
			vision:=5
			seen_by_Starfighter:=false
			can_see_Starfighter:=false

			name:="Grunt"
			is_valid:=true
			move:=2
			move_after:=4
			move_before:=2
--pjt
			pjt_damage:=15
			pjt_damage_after:=15
			pjt_damage_before:=15
			pjt_mv:=-4
			pjt_mv_after:=-4
			pjt_mv_before:=-4
			collide:=false
			collide_by_others:=false
--action msg
			action_msg:=""
			enemy_action_msg:=""
			collide_with_others_msg:=""
			destroy_others_msg:=""
--preemptive action
			prp_action:=false

			create {TURN_PASS} prp_action_cmd.make


--drop score
			create {SILVER_ORB}drop.make
		end


--drop:ORB

feature
	action
		local
			tmppos:POSITION
			tmp:INTEGER
		do
				regen
			if not gameboard.sf.destroyed or collide then
				from tmp:=position.col
				until tmp= position.col-move-1 or collide or flag_has_moved
				loop
					create tmppos.make (position.row,tmp )
					check_for_collision(tmppos)
					tmp:=tmp-1
				end
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


--	fire_new
--		local
--			newp:PROJECTILE
--			pos:POSITION
--		do
----need: whether the place pjt spawn has other object
--			create pos.make (position.row , position.col-1)
--			create newp.make (pos, pjt_mv, -(gameboard.pjt_all.count+1),pjt_damage, '<')
--			gameboard.pjt_all.force (newp)
--			gameboard.pjt_enemy.force (newp)
--			set_action_msg("      A enemy projectile(id:"+gameboard.pjt_enemy.at (gameboard.pjt_enemy.count).id.out
--					+") spawns at location ["+gameboard.sf.correct_row (gameboard.pjt_enemy.at (gameboard.pjt_enemy.count).pjt_position.row).out+","
--					+gameboard.pjt_enemy.at (gameboard.pjt_enemy.count).pjt_position.col.out+"].%N")
--		end

	execute_prp_action(cmd:TURN)
		do

			if attached {TURN_PASS}cmd as c then
				change_health(10)
				change_actual_health(10)
				gameboard.set_ene_preemptive_msg ("    A Grunt(id:"+id.out+") gains 10 total health.%N")
			elseif attached {TURN_SPECIAL}cmd as c then
				change_health(20)
				change_actual_health(20)
				gameboard.set_ene_preemptive_msg ("    A Grunt(id:"+id.out+") gains 20 total health.%N")

			end
		end


end

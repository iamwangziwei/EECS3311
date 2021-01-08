note
	description: "Summary description for {ENEMIES}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	ENEMIES
inherit
	ANY
		undefine
			out
		end

feature{NONE}

	gameboard: GAMEBOARD

		local
			ma: SPACE_DEFENDER_ACCESS
--		once
		do
			Result := ma.m.gameboard
		end


feature
	health:INTEGER

	regen_health:INTEGER

	armour:INTEGER
	vision:INTEGER
	seen_by_Starfighter :BOOLEAN
	can_see_Starfighter:BOOLEAN
	id:INTEGER
	position:POSITION
	before_position:POSITION
	symbol:CHARACTER
	name:STRING
	actual_health:INTEGER
	move:INTEGER
	move_after:INTEGER
	move_before:INTEGER

	pjt_damage:INTEGER
	pjt_damage_after:INTEGER
	pjt_damage_before:INTEGER
	pjt_mv:INTEGER
	pjt_mv_after:INTEGER
	pjt_mv_before:INTEGER

	collide:BOOLEAN
	collide_by_others:BOOLEAN
	action_msg:STRING
	collide_with_others_msg:STRING
	destroy_others_msg:STRING
	prp_action:BOOLEAN
	prp_action_cmd:TURN
	enemy_action_msg:STRING
	flag_has_moved:BOOLEAN
    is_valid:BOOLEAN

	flag_interceptor_just_spawned:BOOLEAN
	flag_is_interceptor:BOOLEAN
	interceptor_collide_with_enemy:BOOLEAN

	drop:ORB
feature--enemy action
	execute
		require
			enemy_is_valid:is_valid
		do
			action
--			generate_action_msg
--			if valid then fire_new	end
			prp_action:=false
			collide_with_others_msg:=""
			destroy_others_msg:=""
		end


	action
		require
			enemy_is_valid:is_valid
		deferred
		end

	execute_prp_action(cmd:TURN)
		require
			enemy_is_valid:is_valid
		deferred
		end

feature
	check_for_collision(tmppos:POSITION)
		require
			enemy_is_valid:is_valid
		local
--			tmppos:POSITION
			tmp:INTEGER
			t1:INTEGER
		do

--if collide with friendly pjt
				across gameboard.pjt is p
				loop
					if p.valid and not p.collide_by_others then
						if p.pjt_position ~ tmppos then
							if p.flag_has_moved then
				 				p.toogle_collide_by_others
				 			else
				 				p.toogle_collide
				 			end
--							p.toogle_collide_by_others
							t1:=p.damage-armour
							if t1<0 then t1:= 0 end
							change_actual_health(-t1)

							current.set_collide_with_others_msg ("friendly projectile", p.id, p.pjt_position, "taking "+t1.out+" damage")

							if collide then
								toggle_flag_has_moved
								set_position (tmppos)
								set_destroy_others_msg("      The "+name+" at location ["+tmppos.correct_row.out+","+tmppos.col.out+"] has been destroyed.%N")
								gameboard.game_board[tmppos.row,tmppos.col]:='_'

								gameboard.sf.sf_focus.add (drop)
							end
						end
					end

				end


--need: if collide with enemy pjt
				across gameboard.pjt_enemy is p
				loop
					if p.valid and not p.collide_by_others then
						if p.pjt_position ~ tmppos then

							if p.flag_has_moved then
				 				p.toogle_collide_by_others
				 			else
				 				p.toogle_collide
				 			end

							change_actual_health(p.damage)

							current.set_collide_with_others_msg ("enemy projectile", p.id, p.pjt_position, "healing "+p.damage.out+" damage")
							if collide then
								toggle_flag_has_moved
								set_position (tmppos)
								set_destroy_others_msg("      The "+name+" at location ["+tmppos.correct_row.out+","+tmppos.col.out+"] has been destroyed.%N")
								gameboard.game_board[tmppos.row,tmppos.col]:='_'
							end
						end
					end
				end



				-- if collide with another enemy
				across gameboard.enemy is e
				loop
					if e.valid then
						if e.position ~ tmppos and e.id /= id then
							toggle_flag_has_moved
							if flag_is_interceptor then interceptor_collide_with_enemy:=true
								flag_is_interceptor :=false
							else
								set_position (e.position.to_right(1).deep_twin)
							end
						end
					end
				end

			--if collide with sf
			if tmppos~ gameboard.sf.position then
				toogle_collide_by_others
				set_position (tmppos.deep_twin)
				gameboard.sf.change_actual_health (-actual_health)
				set_collide_with_others_msg("Starfighter",0,tmppos.deep_twin,"trading "
					+actual_health.out+" damage")
				toggle_flag_has_moved
				set_destroy_others_msg("      The "+name+" at location ["
					+tmppos.correct_row.out+","+tmppos.col.out+"] has been destroyed.%N")
				gameboard.sf.sf_focus.add (drop)
				if gameboard.sf.destroyed then
					set_destroy_others_msg("      The Starfighter at location ["
					+tmppos.correct_row.out+","+tmppos.col.out +"] has been destroyed.%N")
				end
			end



		end
feature {ENEMIES}
	generate_action_msg
		do
			if flag_has_moved then

--				if flag_enemy_before_on_board and flag_enemy_on_board then
--				set_action_msg("    A "+name+"(id:"+id.out+") moves: ["+gameboard.sf.correct_row (before_position.row).out+","
--						+before_position.col.out+"] -> ["+gameboard.sf.correct_row(position.row).out+","+position.col.out+"]%N")

--				--add extra msg
--				elseif flag_enemy_before_on_board and  not flag_enemy_on_board
--				then
--					set_action_msg("    A "+name+"(id:"+id.out+") moves: ["+gameboard.sf.correct_row (before_position.row).out+","
--							+before_position.col.out+"] -> out of board%N")
--					--add extra msg	
--				elseif before_position ~ position then
--					set_action_msg("    A "+name+"(id:"+id.out+") stays at: ["+position.correct_row.out+","	+position.col.out+"]%N")
--				end
				set_action_msg(move_msg_helper)
--				if collide_with_others_msg.count>0 then
--					set_action_msg(collide_with_others_msg)
--				end
--				collide_with_others_msg:=""

--				if destroy_others_msg.count>0 then
--					set_action_msg(destroy_others_msg)

--				end
--				destroy_others_msg:=""
			end

		end

	spawn_msg_helper(na:STRING;i:INTEGER;pos:POSITION):STRING
		do
			if pos.row>gameboard.board_row or pos.col>gameboard.board_column or pos.row<=0 or pos.col<=0 then
				result:="      A "+na.out+"(id:"+i.out+") spawns at location out of board.%N"
			else
				result:="      A "+na.out+"(id:"+i.out+") spawns at location ["+pos.correct_row.out+","+pos.col.out+"].%N"

			end
		end
	move_msg_helper:STRING
		do
			result:=""
				if flag_enemy_before_on_board and flag_enemy_on_board and before_position /~ position then
				result:="    A "+name+"(id:"+id.out+") moves: ["+gameboard.sf.correct_row (before_position.row).out+","
						+before_position.col.out+"] -> ["+gameboard.sf.correct_row(position.row).out+","+position.col.out+"]%N"

				--add extra msg
				elseif flag_enemy_before_on_board and  not flag_enemy_on_board
				then
					result:="    A "+name+"(id:"+id.out+") moves: ["+gameboard.sf.correct_row (before_position.row).out+","
							+before_position.col.out+"] -> out of board%N"
					--add extra msg	
				elseif before_position ~ position then
					result:="    A "+name+"(id:"+id.out+") stays at: ["+position.correct_row.out+","	+position.col.out+"]%N"
				end

				if collide_with_others_msg.count>0 then
					result:=result+collide_with_others_msg
				end
				collide_with_others_msg:=""

				if destroy_others_msg.count>0 then
					result:=result+destroy_others_msg

				end
				destroy_others_msg:=""
		end

	fire_new
		require

			enemy_is_valid:is_valid
		local
			newp:PROJECTILE
			pos:POSITION
		do
			if gameboard.sf.destroyed then
			else
					create pos.make (position.row , position.col-1)
			create newp.make (pos, pjt_mv, -(gameboard.pjt_all.count+1),pjt_damage, '<')

			gameboard.pjt_all.force (newp)
			gameboard.pjt_enemy.force (newp)
			if newp.valid then
				set_action_msg("      A enemy projectile(id:"+gameboard.pjt_enemy.at (gameboard.pjt_enemy.count).id.out
					+") spawns at location ["+gameboard.sf.correct_row (gameboard.pjt_enemy.at (gameboard.pjt_enemy.count).pjt_position.row).out+","
					+gameboard.pjt_enemy.at (gameboard.pjt_enemy.count).pjt_position.col.out+"].%N")
			else
				set_action_msg("      A enemy projectile(id:"+gameboard.pjt_enemy.at (gameboard.pjt_enemy.count).id.out
					+") spawns at location out of board.%N")
			end

			gameboard.check_enemy_pjt_collision(newp,newp.pjt_position)
			if newp.flag_has_moved then
				newp.toggle_flag_has_moved
			end
			if newp.collide_with_others_msg.count >0 then
				set_action_msg(newp.collide_with_others_msg)
				newp.clear_collide_with_others_msg

			end
			if newp.destroy_others_msg.count >0 then
				set_action_msg(newp.destroy_others_msg)
				newp.clear_collide_with_others_msg
			end
			if newp.collide_by_others then
				newp.toogle_collide
			end
			end

--		ensure
--			new_pjt_added_to_pjt_all : old gameboard.pjt_all.count +1 =  gameboard.pjt_all.count --across gameboard.pjt_all is pjt some pjt ~ newp  end
--			new_pjt_added_to_pjt_enemy: old gameboard.pjt_enemy.count +1 =  gameboard.pjt_enemy.count
		end

feature
	toggle_flag_interceptor_just_spawned
		do
			if flag_interceptor_just_spawned then
				flag_interceptor_just_spawned:=false
			else
				flag_interceptor_just_spawned:=true
			end
		end





feature --collide
	toogle_collide
		do
			if not collide then
				collide:=true
			end
		end
	toogle_collide_by_others
	do
			if not collide then
				collide:=true
			end
		end
	toggle_flag_has_moved
		do
			if flag_has_moved then
				flag_has_moved:=false
			else
				flag_has_moved:=true
			end
		end
feature--change collide_with_others_msg

	set_collide_with_others_msg(othername:STRING;otherid:INTEGER;otherpos:POSITION;othermsg:STRING)
		do
			collide_with_others_msg:=collide_with_others_msg
			+"      The "+name+" collides with "+othername+"(id:"+otherid.out+") at location ["+otherpos.correct_row.out+","+otherpos.col.out+"], "+othermsg+".%N"
		end
	clear_collide_with_others_msg
		do
			collide_with_others_msg:=""
		end

	set_enemy_action_msg(msg:STRING)
		do
			enemy_action_msg:=msg
		end
	set_action_msg(msg:STRING)
		do
			action_msg:=action_msg+msg
		end

	clear_action_msg
		do
			action_msg:=""
		end
	set_destroy_others_msg(msg:STRING)
		do
			destroy_others_msg:=destroy_others_msg+msg
		end
	clear_destroy_others_msg
		do
			destroy_others_msg:=""
		end
feature --regen
	regen
		do
			change_actual_health(regen_health)
		end

	change_health(ah:INTEGER)
		do
				health:=health+ah

		end

	change_actual_health(ah:INTEGER)
		do

			actual_health:=actual_health+ah
			if actual_health > health then
				actual_health:=health
			end
			if actual_health<=0 then
				collide:=true
			end
		end

feature--check vision
	check_vision
		require
			enemy_is_valid:is_valid
		do
			check_can_see_Starfighter
			check_seen_by_Starfighter
	

		end
	check_can_see_Starfighter
		do
			if position.distance_between(gameboard.sf.position )  <= vision then
				can_see_Starfighter:= true
				move:=move_after
				pjt_damage:=pjt_damage_after
				pjt_mv:=pjt_mv_after
			else
				can_see_Starfighter:=false
				move:=move_before
				pjt_damage:=pjt_damage_before
				pjt_mv:=pjt_mv_before
			end
		end
	check_seen_by_Starfighter
		do
			seen_by_Starfighter:=position.distance_between(gameboard.sf.position ) <=
			gameboard.sf.vision
		end



feature--preemptive action
	trigger_prp_action(cmd:TURN)
		do

			prp_action_cmd:=cmd
			prp_action:=true
		end
	toggle_prp_action
		do
			if prp_action then
				prp_action:=false
			end
		end


feature -- check on board
	valid:BOOLEAN
		do
			result:=flag_enemy_on_board and not collide and not collide_by_others
		end
	flag_enemy_on_board:BOOLEAN
		do
			if position.row >gameboard.board_row or position.col>gameboard.board_column
			 	 or position.row <= 0 or position.col<=0
			then
				result:=false
			else
				result:=true
			end
		end
	flag_enemy_before_on_board:BOOLEAN
		do
			if before_position.row >gameboard.board_row or before_position.col>gameboard.board_column
			 	 or before_position.row <= 0 or before_position.col<=0
			then
				result:=false
			else
				result:=true
			end
		end
	set_position(newpo:POSITION)
		local
			t1:POSITION
			t2:POSITION
		do
			create t1.make (position.row , position.col)
			before_position:=t1
			create t2.make (newpo.row, newpo.col)
			position:=t2
		end



	seen_by_sf_msg:STRING
		Do
			if seen_by_Starfighter then
				result:="T"
			else
				result:="F"
			end
		end

	can_see_sf_msg:STRING
		Do
			if can_see_Starfighter then
				result:="T"
			else
				result:="F"
			end
		end
feature --move enemy
	backward
		local newpo:POSITION
		do
			before_position:=position
			create newpo.make (position.row,position.col-move)
			set_position(newpo)
		end

feature--out
	out:STRING
		do
			result:="    ["+id.out +","+symbol.out+"]->health:"+actual_health.out+"/"+health.out+", Regen:"
				+regen_health.out+", Armour:"+armour.out+", Vision:"+vision.out+", seen_by_Starfighter:"+seen_by_sf_msg
				+", can_see_Starfighter:"+can_see_sf_msg+", location:["+gameboard.sf.correct_row (position.row).out+","+position.col.out+"]%N"



		end
end

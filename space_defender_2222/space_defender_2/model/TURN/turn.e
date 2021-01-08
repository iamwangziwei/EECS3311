note
	description: "Summary description for {TURN}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	TURN
feature{NONE}

	gameboard: GAMEBOARD

		local
			ma: SPACE_DEFENDER_ACCESS
--		once
		do
			Result := ma.m.gameboard
		end
feature--attribute
--	sf_position:POSITION
feature --phase

	execute
		do
--			gameboard.sf.regen
			phase_a
			phase_b
			phase_c--(sf_position)
			phase_d
			phase_e
			phase_f
			phase_g
		end

--need: all add if sf.destroyed
	phase_a
		do
			if not gameboard.sf.destroyed then
				across gameboard.pjt is p loop  if p.flag_pjt_on_board and not p.collide then gameboard.game_board[p.pjt_position.row,p.pjt_position.col] :='_'  end end
				if attached gameboard.sf.setup_pkg.at (1) as pjtmove then pjtmove.execute end
			end

		end

	phase_b
		local
			tmp:INTEGER
			tmppos:POSITION
--			t1:INTEGER
		do
			if not gameboard.sf.destroyed then
				across gameboard.pjt_enemy is pe
				loop
					if gameboard.sf.destroyed then
						else
							if pe.valid or pe.collide_by_others
						then
							gameboard.game_board[pe.pjt_position.row,pe.pjt_position.col] :='_'
						end

						from tmp:=pe.pjt_position.col
						until tmp= pe.destination.col-1 or pe.collide or pe.collide_by_others
						loop
							create tmppos.make (pe.pjt_position.row, tmp)
							gameboard.check_enemy_pjt_collision(pe,tmppos)

							tmp:=tmp-1
						end

						if  not pe.collide and not pe.collide_by_others and not gameboard.sf.destroyed
						then pe.pjt_forth
							pe.	toggle_flag_has_moved
						end
					end


			end
			end

		end

	phase_c--(pos:POSITION)
		deferred
		end

	phase_d
		do
			if not gameboard.sf.destroyed then
				across gameboard.enemy is e
			loop
--				if gameboard.sf.destroyed then
--				else
					if e.flag_enemy_on_board and not e.collide then
					e.check_vision
					end
--				end


			end

			end




		end

	phase_e
		do
--preemptive acition		
			if not gameboard.sf.destroyed then
				across gameboard.enemy is e
				loop
					if e.prp_action and e.valid and not gameboard.sf.destroyed then
						gameboard.game_board[e.position.row ,e.position.col ] :='_'
						e.execute_prp_action(e.prp_action_cmd)
					end


				end

				across gameboard.enemy is e
				loop

					if e.valid and not gameboard.sf.destroyed and not e.flag_has_moved then

						gameboard.game_board[e.position.row ,e.position.col ] :='_'
						e.execute

					end
				end

				across gameboard.enemy is e
				loop
					e.toggle_prp_action
				end
			end


		end

	phase_f
		do
			if not gameboard.sf.destroyed then
				across gameboard.enemy is e
				loop
					if e.flag_enemy_on_board and not e.collide  then
						e.check_vision
					end

				end

			end


		end

	phase_g
		do
			if not gameboard.sf.destroyed then
				generate_enemy
				across gameboard.enemy is e loop e.check_vision end
--				gameboard.enemy.at (gameboard.enemy.count).check_vision
			end

			print_all_symbol
		end


feature
	generate:ARRAY[INTEGER]
		local

			temp:RANDOM_GENERATOR_ACCESS

		do
			create result.make_empty
			result.force (temp.rchoose (1,gameboard.board_row), 1)
			result.force (temp.rchoose (1, 100), 2)
		end





	generate_enemy
		local
			ene:ENEMIES
			t1:ARRAY[INTEGER]
			enepo:POSITION
			flag:BOOLEAN
		do
			flag:=false
			gameboard.clear_enemy_spawn_msg
			t1:=generate
			create enepo.make (t1.at(1), gameboard.board_column)
			create {ENEMY_GRUNT} ene.make (enepo,gameboard.enemy.count +1)
--			print(t1.at (1).out +t1.at(2).out+"%N")
			across gameboard.enemy is e
			loop
				if e.valid and e.position ~ enepo then
					flag:=true

				end
			end


			if flag then
			else
				if
					t1.at (2) >= 1 and t1.at (2)<gameboard.g_thd
				then
					create {ENEMY_GRUNT} ene.make (enepo,gameboard.enemy.count +1)
					generate_helper(ene,enepo)
--					ene.check_vision
--					gameboard.enemy.force (ene )
					gameboard.enemy_grunt.force (ene )
--					gameboard.game_board[enepo.row,enepo.col] := ene.symbol
----set enemy msg
--					gameboard.set_enemy_spawn_msg("    A "+ene.name+"(id:"+ene.id.out+") spawns at location ["+enepo.correct_row.out+","+enepo.col.out+"].%N")

----need: if spawn on sth
--					ene.check_for_collision(enepo)
--					if ene.collide_with_others_msg.count >0
--					then
--						gameboard.set_enemy_spawn_msg(ene.collide_with_others_msg)
--						ene.clear_collide_with_others_msg
--					end
--					if ene.destroy_others_msg.count >0 then
--						gameboard.set_enemy_spawn_msg(ene.destroy_others_msg)
--						ene.clear_destroy_others_msg

--					end

--generate enemy
				elseif
					t1.at (2) >= gameboard.g_thd and t1.at (2)<gameboard.f_thd
				then
					create {ENEMY_FIGHTER} ene.make(enepo,gameboard.enemy.count +1)
					generate_helper(ene,enepo)
--					ene.check_vision
--					gameboard.enemy.force (ene)
					gameboard.enemy_fighter.force (ene )
--					gameboard.game_board[enepo.row,enepo.col] := ene.symbol
--					gameboard.set_enemy_spawn_msg("    A "+ene.name+"(id:"+ene.id.out+") spawns at location ["+enepo.correct_row.out+","+enepo.col.out+"].%N")

--					ene.check_for_collision(enepo)
--					if ene.collide_with_others_msg.count >0
--					then
--						gameboard.set_enemy_spawn_msg(ene.collide_with_others_msg)
--						ene.clear_collide_with_others_msg
--					end
--					if ene.destroy_others_msg.count >0 then
--						gameboard.set_enemy_spawn_msg(ene.destroy_others_msg)
--						ene.clear_destroy_others_msg
--					end
--need generate Carrier					


				elseif
					t1.at (2) >= gameboard.f_thd and t1.at (2)<gameboard.c_thd
				then
					create {ENEMY_CARRIER} ene.make(enepo,gameboard.enemy.count +1)
					generate_helper(ene,enepo)
--					ene.check_vision
--					gameboard.enemy.force (ene)
					gameboard.enemy_carrier.force (ene )
--					gameboard.game_board[enepo.row,enepo.col] := ene.symbol
--					gameboard.set_enemy_spawn_msg("    A "+ene.name+"(id:"+ene.id.out+") spawns at location ["+enepo.correct_row.out+","+enepo.col.out+"].%N")
--					ene.check_for_collision(enepo)
--					if ene.collide_with_others_msg.count >0
--					then
--						gameboard.set_enemy_spawn_msg(ene.collide_with_others_msg)
--						ene.clear_collide_with_others_msg
--					end
--					if ene.destroy_others_msg.count >0 then
--						gameboard.set_enemy_spawn_msg(ene.destroy_others_msg)
--						ene.clear_destroy_others_msg
--					end
				elseif
					t1.at (2) >= gameboard.c_thd and t1.at (2)<gameboard.i_thd
				then
					create {ENEMY_INTERCEPTOR} ene.make(enepo,gameboard.enemy.count +1)
					generate_helper(ene,enepo)
					gameboard.enemy_interceptor.force (ene )
				elseif t1.at (2) >= gameboard.i_thd and t1.at (2)<gameboard.p_thd
				 then
					create {ENEMY_PYLON} ene.make(enepo,gameboard.enemy.count +1)
					generate_helper(ene,enepo)
					gameboard.enemy_pylon.force (ene )

				end
			end




		end



	generate_helper(ene:ENEMIES;enepo:POSITION)
		do
			ene.check_vision
			gameboard.enemy.force (ene )
--			gameboard.enemy_grunt.force (ene )
			gameboard.game_board[enepo.row,enepo.col] := ene.symbol
--set enemy msg
			gameboard.set_enemy_spawn_msg("    A "+ene.name+"(id:"+ene.id.out+") spawns at location ["+enepo.correct_row.out+","+enepo.col.out+"].%N")

--need: if spawn on sth
			ene.check_for_collision(enepo)

			if ene.collide_with_others_msg.count >0
			then
				gameboard.set_enemy_spawn_msg(ene.collide_with_others_msg)
				ene.clear_collide_with_others_msg
			end
			if ene.destroy_others_msg.count >0 then
				gameboard.set_enemy_spawn_msg(ene.destroy_others_msg)
				ene.clear_destroy_others_msg

			end
		end

	print_all_symbol
		do
			across gameboard.pjt is p loop  if p.flag_pjt_on_board and not p.collide and not p.collide_by_others then gameboard.game_board[p.pjt_position.row,p.pjt_position.col] :='*' end end
			across gameboard.pjt_enemy is pe loop if pe.flag_pjt_on_board and not pe.collide and not pe.collide_by_others  then gameboard.game_board[pe.pjt_position.row,pe.pjt_position.col] :=pe.symbol end end
			gameboard.game_board[gameboard.sf.position.row ,gameboard.sf.position.col ] :=gameboard.sf.symbol
			across gameboard.enemy is e  loop if e.flag_enemy_on_board and not e.collide   then gameboard.game_board[e.position.row ,e.position.col ] :=e.symbol end  end


		end

	clear_all_symbol
		do
			
		end

end

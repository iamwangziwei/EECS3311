note
	description: "Summary description for {GAMEBOARD}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	GAMEBOARD

inherit
	ANY
		redefine
			out
		end

create
	make


feature --attributes
	board_row:INTEGER
	board_column:INTEGER
	init:ARRAY[CHARACTER]
	game_board:ARRAY2[CHARACTER]
	fog_board:ARRAY2[CHARACTER]

--sf
	sf:STAR_FIGHTER
--	sf_setup_pkg:HASH_TABLE[INTEGER,INTEGER]
	sf_row:INTEGER
	sf_column:INTEGER

--pjt
	pjt:LIST[PROJECTILE]

	pjt_enemy:LIST[PROJECTILE]
	pjt_all:LIST[PROJECTILE]

--enemy
	enemy:LIST[ENEMIES]
	enemy_grunt:LIST[ENEMIES]
	enemy_fighter:LIST[ENEMIES]
	enemy_interceptor:LIST[ENEMIES]
	enemy_carrier:LIST[ENEMIES]
	enemy_pylon:LIST[ENEMIES]
--threshold
	g_thd:INTEGER
	f_thd:INTEGER
	c_thd:INTEGER
	i_thd:INTEGER
	p_thd:INTEGER

--flag

	flag_fog:BOOLEAN
	flag_collision:BOOLEAN

--output msg
	enemy_spawn_msg:STRING
	sf_action_msg:STRING
	ene_preemptive_msg:STRING
	ene_action_msg:STRING
feature {NONE}

	make(row: INTEGER ; column: INTEGER ; g_threshold: INTEGER; f_threshold: INTEGER; c_threshold: INTEGER;
		i_threshold: INTEGER; p_threshold: INTEGER )
		local
			temp1:INTEGER
		do
			create game_board.make_filled('_',row,column)
			create fog_board.make_filled('_',row,column)
			init:=<<'A','B','C','D','E','F','G','H','I','J'>>

--initial position for sf
			board_row:= row
			board_column:=column
			temp1:=board_row\\2
			if temp1 = 1 then
				sf_row:=board_row//2+1
			elseif temp1 = 0 then
				sf_row:=board_row//2
			end
			sf_column:=1
			game_board[sf_row,sf_column] :='S'

--pjt
			create {ARRAYED_LIST[PROJECTILE]}pjt.make (1)
			create {ARRAYED_LIST[PROJECTILE]}pjt_enemy.make (1)
			create {ARRAYED_LIST[PROJECTILE]}pjt_all.make (1)

--sf
			create sf.make (sf_row, sf_column)



--enemy
			create {ARRAYED_LIST[ENEMIES]}enemy.make (1)
			create {ARRAYED_LIST[ENEMIES]}enemy_grunt.make (1)
			create {ARRAYED_LIST[ENEMIES]}enemy_fighter.make(1)
			create {ARRAYED_LIST[ENEMIES]}enemy_interceptor.make (1)
			create {ARRAYED_LIST[ENEMIES]}enemy_carrier.make (1)
			create {ARRAYED_LIST[ENEMIES]}enemy_pylon.make (1)

--threshold
		    g_thd:=g_threshold
			f_thd:=f_threshold
			c_thd:=c_threshold
			i_thd:=i_threshold
			p_thd:=p_threshold

--flag

			flag_fog:=true

			flag_collision:=false
--output msg
			enemy_spawn_msg:=""
			sf_action_msg:=""
			ene_preemptive_msg:=""
			ene_action_msg:=""
		end

feature --phase

----phase 1
--	mv_friendly_pjt
--		do
--			across pjt is p loop  if p.flag_pjt_on_board and not p.collide then game_board[p.pjt_position.row,p.pjt_position.col] :='_'  end end
--			if attached sf.setup_pkg.at (1) as pjtmove then pjtmove.execute end
----			across pjt is p loop  if p.flag_pjt_on_board and not p.collide then game_board[p.pjt_position.row,p.pjt_position.col] :='*' end end
--		end

--phase 2		
--	mv_enemy_pjt --need work on collision
--		local
--			tmp:INTEGER
--			tmppos:POSITION
--			t1:INTEGER
--		do
--			across pjt_enemy is pe
--			loop
--				if pe.flag_pjt_on_board --and not pe.collide
--				then
--					game_board[pe.pjt_position.row,pe.pjt_position.col] :='_'
--				end

--				from tmp:=pe.pjt_position.row
--				until tmp= pe.destination.row+1 or pe.collide
--				loop
--					create tmppos.make (pe.pjt_position.row, tmp)
----Colliding with an friendly projectile	
--					across pjt  is pf
--					loop
--						if pf.pjt_position ~ tmppos then

--					 		if pf.damage< pe.damage then--if enemy projectile’s damage is higher
----need work						
--								pf.toogle_collide
--								pe.set_collide_with_others_msg("friendly projectile",pf.id,pf.pjt_position,"negating damage")
--					 			pe.change_damage(pe.damage-pf.damage)
--					 		elseif pf.damage> pe.damage then--if the friendly projectile’s damage is higher
--					 			pe.toogle_collide
----					 			gp.set_collide_with_others_msg("enemy projectile",ene.id,ene.pjt_position,"negating damage")
----					 			gp.change_damage(gp.damage-ene.damage)
----need work
--					 		elseif pf.damage= pe.damage then

--					 		end
--						end
--					end


--					tmp:=tmp+1
--				end


--				pe.pjt_back

----				if pe.flag_pjt_on_board and not pe.collide then
----					game_board[pe.pjt_position.row,pe.pjt_position.col] :=pe.symbol
----				end
--			end
--		end

--phase 3 for move
--	move_sf(newpos:POSITION)
--		local
--			num:INTEGER
--			tmppos:POSITION
--			tmp:INTEGER
--		DO
--			game_board[sf.position .row ,sf.position.col] :='_'
----at left bottom
--			if newpos.row> sf.position.row  and newpos.col <= sf.position.col then
--				from tmp:=sf.position.row
--				until tmp=newpos.row+1 or sf.destroyed
--				loop
--					create tmppos.make (tmp ,sf.position.col)
----					if game_board[tmp,player_column] ='*'
----					then
----						game_board[player_row,player_column] :='_'
----						current.toggle_flag_if_collision
----						game_board[tmp,player_column]:='X'
----						collision_row:=tmp
----						collision_col:=player_column
----					end
--					tmp:=tmp+1
--				end



----top right			
--			elseif  newpos.row< sf.position.row and newpos.col >= sf.position.col then
--				from tmp:= sf.position.row
--				until tmp=newpos.row-1  or sf.destroyed
--				loop
--					create tmppos.make (tmp ,sf.position.col )
--					sf_check_collison(tmppos)
--					tmp:=tmp-1

--				end

--				from tmp:= sf.position.col
--				until tmp=newpos.col+1  or sf.destroyed
--				loop
--					create tmppos.make (newpos.row ,tmp )
--					sf_check_collison(tmppos)
--					tmp:=tmp+1


--				end
----bottom right
--			elseif newpos.row>= sf.position.row and newpos.col > sf.position.col then

--				from tmp:=sf.position.row
--				until tmp=newpos.row+1 or sf.destroyed
--				loop

--					create tmppos.make (tmp ,sf.position.col )
--					sf_check_collison(tmppos)
--					tmp:=tmp+1
--				end

--				from tmp:= sf.position.col
--				until tmp=newpos.col+1 or sf.destroyed
--				loop

--					create tmppos.make (newpos.row ,tmp )
--					sf_check_collison(tmppos)
--					tmp:=tmp+1
--				end



--			end
--			if not sf.destroyed then
--				sf.set_position(newpos)
--			else
--				sf.set_symbol ('X')
--			end



---- need  check on collision
---- need work on reduce health/enegy after collide

--			set_sf_action_msg("    The Starfighter(id:0) moves: ["+sf.correct_row (sf.before_position.row).out+","+sf.before_position.col.out+"] -> ["+sf.correct_row (sf.position.row).out+","+sf.position.col.out+"]%N")
----			game_board[sf.position.row ,sf.position.col ] :='S'
--			num:=-(sf.move_cost * (sf.before_position.distance_between(sf.position)))
--			sf.change_actual_energy(num)


--		end



	sf_check_collison(pos:POSITION)
		local
			t1:INTEGER
		do
--collide with friendly pjt

			across pjt is p
			loop
				if p.valid and not p.collide_by_others then
					if p.pjt_position ~ pos then
						if p.flag_has_moved then
			 				p.toogle_collide_by_others
			 			else
			 				p.toogle_collide
			 			end

						t1:=p.damage-sf.armour
						if t1>0 then  else t1:=0 end
						sf.change_actual_health(-t1)
						sf.set_collide_with_others_msg("friendly projectile",p.id,p.pjt_position,"taking "+t1.out+" damage" )

						if sf.destroyed then  --if sf destroyed after this collision
							sf.set_position (pos)

							sf.set_destroy_others_msg("Starfighter",pos)
						end
					end
				end
			end
--collide with enemy pjt
			across pjt_enemy is pe
			loop
				if pe.valid and not pe.collide_by_others then
					if pe.pjt_position ~ pos then

						if pe.flag_has_moved then
			 				pe.toogle_collide_by_others
			 			else
			 				pe.toogle_collide
			 			end


						t1:=pe.damage-sf.armour
						if t1>0 then  else t1:=0 end
						sf.change_actual_health(-t1)
						sf.set_collide_with_others_msg("enemy projectile",pe.id,pe.pjt_position,"taking "+t1.out+" damage" )

						if sf.destroyed then  --if sf destroyed after this collision
							sf.set_position (pos)
							sf.set_destroy_others_msg("Starfighter",pos)
						end

					end
				end
			end

--collide with enemy
			across enemy is e
			loop
				if e.valid  then
					if e.position ~ pos then

						e.toogle_collide
--need: calculate the score
--						
						sf.sf_focus.add (e.drop)

						t1:=e.actual_health
						game_board[pos.row,pos.col]:='_'

						sf.change_actual_health(-e.actual_health)
						sf.set_collide_with_others_msg(e.name,e.id,e.position,"trading "+t1.out+" damage" )
						sf.set_destroy_others_msg(e.name,e.position)
						if sf.destroyed then  --if sf destroyed after this collision
							sf.set_position (pos)
							sf.set_destroy_others_msg("Starfighter",pos)

						end

					end
				end
			end


		end



----phase 4 5 6
--	enemy_act
--		do
--			across enemy is e
--			loop
--				if e.flag_enemy_on_board and not e.collide then
--					game_board[e.position.row ,e.position.col ] :='_'
--					e.action
----					if e.flag_enemy_on_board and not e.collide then
----						game_board[e.position.row ,e.position.col ] :=e.symbol
----					end

--				end

--			end
----			across pjt_enemy is pe loop if pe.flag_pjt_on_board and not pe.collide then game_board[pe.pjt_position.row ,pe.pjt_position.col ] :=pe.symbol end end



--		end

--	print_all_symbol
--		do
--			across pjt is p loop  if p.flag_pjt_on_board and not p.collide and not p.collide_by_others then game_board[p.pjt_position.row,p.pjt_position.col] :='*' end end
--			across pjt_enemy is pe loop if pe.flag_pjt_on_board and not pe.collide and not pe.collide_by_others  then game_board[pe.pjt_position.row,pe.pjt_position.col] :=pe.symbol end end
--			game_board[sf.position.row ,sf.position.col ] :=sf.symbol
--			across enemy is e  loop if e.flag_enemy_on_board and not e.collide   then game_board[e.position.row ,e.position.col ] :=e.symbol end  end


--		end
feature--command



--	move(position:POSITION)


--		do


--			sf.regen
----phase1 move the friendly pjt

--			mv_friendly_pjt



----phase2
--			mv_enemy_pjt

----phase 3			
--			move_sf(position)

----phase 4 5 6
--			enemy_act


----phase 7		
--			generate_enemy
--			print_all_symbol
--		end







--	fire
--		do
--			toggle_flag_is_fire
--			sf.regen
----phase 1
--			mv_friendly_pjt
----phase 2	
--			mv_enemy_pjt
----phase 3
--			if attached sf.setup_pkg.at (1) as pjtmove then pjtmove.fire_new_pjt end
----			across pjt is p loop  if p.flag_pjt_on_board and not p.collide then game_board[p.pjt_position.row,p.pjt_position.col] :='*' end end
----phase 4 5 6
--			enemy_act

----phase 7		
--			generate_enemy

--			toggle_flag_is_fire

--			print_all_symbol
--		end

--	pass
--		do
--			toggle_flag_is_pass
--			sf.regen
--			sf.regen
----phase 1
--			mv_friendly_pjt
----phase 2	
--			mv_enemy_pjt

----phase 3
--			set_sf_action_msg("    The Starfighter(id:0) passes at location ["+sf.position.correct_row.out+","+sf.position.col.out+"], doubling regen rate.%N")

----phase 4 5 6
--			enemy_act

----phase 7		
--			generate_enemy
--			print_all_symbol
--			toggle_flag_is_pass
--		end

--	special
--		local
--			temp1:INTEGER

--		do
--			toggle_flag_is_special
--			sf.regen
----phase 1
--			mv_friendly_pjt
----phase 2	
--			mv_enemy_pjt


----phase 3
----need change special msg

--			sf.change_actual_energy (-50)
--			game_board[sf.position.row ,sf.position.col]:='_'

--			if board_row\\2 = 1 then
--				temp1:=board_row//2+1
--			elseif board_row\\2 = 0 then
--				temp1:=board_row//2
--			end
--			sf.set_position (create {POSITION}.make (temp1, 1))
--			game_board[sf.position.row ,sf.position.col]:='S'

--			set_sf_action_msg("    The Starfighter(id:0) uses special, teleporting to: ["+sf.correct_row (sf.position.row ).out+",1]%N")
----phase 4 5 6
--			enemy_act
----phase 7		
--			generate_enemy

--			print_all_symbol
--			toggle_flag_is_special
--		end
feature

	toggle_flag_fog(flag:BOOLEAN)
		do
			if flag then
				flag_fog := false
			else
				flag_fog := true
			end
		end


feature--check collision
	check_enemy_pjt_collision(pe:PROJECTILE;tmppos:POSITION)
		local t1:INTEGER
		do

--Colliding with an friendly projectile	
					across pjt  is pf
					loop
						if pf.valid and not pf.collide_by_others then
							if pf.pjt_position ~ tmppos then

						 		if pf.damage< pe.damage then--if enemy projectile’s damage is higher
									if pf.flag_has_moved then
										pf.toogle_collide_by_others
									else
										pf.toogle_collide
									end
--									
--									pf.set_position(tmppos)
									pe.set_collide_with_others_msg("friendly projectile",pf.id,pf.pjt_position,"negating damage")
						 			pe.change_damage(pe.damage-pf.damage)
						 		elseif pf.damage> pe.damage then--if the friendly projectile’s damage is higher
--						 			if pe.flag_has_moved then
--						 				pe.toogle_collide_by_others
--						 			else
--						 				pe.toogle_collide
--						 			end
									pe.toogle_collide_by_others
									pe.toggle_flag_has_moved
						 			pf.change_damage(pf.damage-pe.damage)
						 			pe.set_position (pf.pjt_position.deep_twin)
						 			pe.set_collide_with_others_msg("friendly projectile",pf.id,pf.pjt_position,"negating damage")
	--					 			
	--need: if pf.damage= pe.damage
						 		elseif pf.damage= pe.damage then
									pe.toggle_flag_has_moved
									if pf.flag_has_moved then
										pf.toogle_collide_by_others
									else
										pf.toogle_collide
									end
									pe.toogle_collide_by_others
									game_board[pe.pjt_position.row,pe.pjt_position.col]:='_'
									pe.set_position (pf.pjt_position.deep_twin)
									pe.set_collide_with_others_msg("friendly projectile",pf.id,pf.pjt_position,"negating damage")

						 		end
							end
						end

					end

--need:collid with enemy pjt	

				across pjt_enemy is pf
				loop
					if pf.valid and not pf.collide_by_others  then
						if pf.pjt_position ~ tmppos and pf.id /=pe.id then
	--need work				
							if pf.flag_has_moved then
				 				pf.toogle_collide_by_others
				 			else
				 				pf.toogle_collide
				 			end
--							pf.toogle_collide_by_others
							pe.set_collide_with_others_msg("enemy projectile",pf.id,pf.pjt_position,"combining damage")
				 			pe.change_damage(pe.damage+pf.damage)



							end
					end

				end

--collid with enemy
				across enemy  is e
				loop
					if e.valid then
						if e.position ~ tmppos then
							pe.toggle_flag_has_moved
							pe.toogle_collide_by_others
							e.change_actual_health(pe.damage)
							pe.set_collide_with_others_msg(e.name,e.id,e.position,"healing "+pe.damage.out+" damage")
							pe.set_position(e.position.deep_twin)

						end
					end

				end

--collid with sf
			if tmppos~ sf.position then
				pe.toggle_flag_has_moved
				pe.toogle_collide_by_others
				pe.set_position (tmppos.deep_twin)
				t1:=pe.damage -sf.armour
				if t1<0 then t1:=0 end
				sf.change_actual_health (-t1)
				pe.set_collide_with_others_msg("Starfighter",0,tmppos.deep_twin,"dealing "+t1.out+" damage")
				if sf.destroyed then
					pe.set_destroy_others_msg("Starfighter",tmppos.deep_twin)
				end
			end
		end




feature --set msg
	set_enemy_spawn_msg (msg:STRING)
		do
			enemy_spawn_msg:=enemy_spawn_msg+msg
		end
	clear_enemy_spawn_msg
		do
			enemy_spawn_msg:=""
		end


--	set_sf_action_msg(msg:STRING)
--		do
--			sf_action_msg:=sf_action_msg+msg
--		end
--	clear_sf_action_msg
--		do
--			sf_action_msg:=""
--		end
feature
	fog
		do
			fog_board:=game_board.deep_twin
			across 1 |..| board_row is i
			loop
				across 1 |..| board_column is j
				loop
					if ((i-sf.position.row ).abs + (j-sf.position.col ).abs)> sf.vision then
						fog_board[i,j] :='?'
					end
				end

			end
		end



feature --out

	enemy_msg:STRING
		do
			result:="  Enemy:%N"
			if enemy.count >0 then
				across enemy is e
				loop
					if e.valid then
						result:=result+e.out

					end
				end
			end
		end


	pjt_msg:STRING
		do
			result:="  Projectile:%N"

			across pjt_all is p loop
				if not p.collide and p.flag_pjt_on_board and not p.collide_by_others then

						result:=result+"    ["+ p.id.out + ","+p.symbol.out+"]->damage:"+p.damage.out+", move:"+p.pjt_mov.abs.out+", location:["+sf.correct_row (p.pjt_position.row).out+","+p.pjt_position.col.out+"]%N"

				end


			end


		end



	print_frd_pjt_action:STRING
  		do
  			result:="  Friendly Projectile Action:%N"

  				across pjt is p
	  			loop
					if p.flag_has_moved  
					then
						if p.flag_pjt_before_on_board  and p.flag_pjt_on_board and p.before_position /~ p.pjt_position  then
	  						if p.before_position /= p.pjt_position or p.collide_with_others_msg.count>0  then
								result:=result+"    A friendly projectile(id:"+p.id.out+") moves: ["+sf.correct_row (p.before_position.row).out+","+p.before_position.col.out+"] -> ["+sf.correct_row (p.pjt_position.row).out+","+p.pjt_position.col.out+"]%N"
		  					end

		  				elseif p.flag_pjt_before_on_board  and not p.flag_pjt_on_board
		  				then
		  					result:=result+"    A friendly projectile(id:"+p.id.out+") moves: ["+sf.correct_row (p.before_position.row).out+","+p.before_position.col.out+"] -> out of board%N"
							p.toogle_collide
						elseif p.before_position ~ p.pjt_position then
							  result:=result+"    A friendly projectile(id:"+p.id.out+") stays at: ["+sf.correct_row (p.before_position.row).out+","+p.before_position.col.out+"]%N"
	  					end
					if p.collide_with_others_msg.count>0 then result:=result+p.collide_with_others_msg
			  			p.clear_collide_with_others_msg end

					if p.destroy_others_msg.count>0 then result:=result+p.destroy_others_msg p.clear_destroy_others_msg end

					end

					if p.collide_by_others then
						p.toogle_collide
					end

					if p.flag_has_moved then

						p.toggle_flag_has_moved
					end
	  			end

  		end


	print_ene_pjt_action:STRING
		do
			result:="  Enemy Projectile Action:%N"

  			across pjt_enemy is p
  			loop
  				if p.flag_has_moved  then --or p.collide_by_others
  					if p.flag_pjt_on_board  and p.flag_pjt_before_on_board  then
  						if p.before_position /= p.pjt_position  then
							result:=result+"    A enemy projectile(id:"+p.id.out+") moves: ["+sf.correct_row (p.before_position.row).out+","+p.before_position.col.out+"] -> ["+sf.correct_row (p.pjt_position.row).out+","+p.pjt_position.col.out+"]%N"
						end
  					elseif p.flag_pjt_before_on_board and not p.flag_pjt_on_board
  					then
  						result:=	result+"    A enemy projectile(id:"+p.id.out+") moves: ["+sf.correct_row (p.before_position.row).out+","+p.before_position.col.out+"] -> out of board%N"

  					end

  					if p.collide_with_others_msg.count>0 then
  						result:=result+p.collide_with_others_msg
						p.clear_collide_with_others_msg

  					end
					if p.destroy_others_msg.count>0 then result:=result+p.destroy_others_msg p.clear_destroy_others_msg end



	  				if p.collide_by_others then
	  					p.toogle_collide
  					end


  				end

			if p.flag_has_moved then
				p.toggle_flag_has_moved
			end

  			end

		end



	print_sf_action_msg:STRING
		do
			result:="  Starfighter Action:%N"
			result:=result+sf.action_msg
			result:=result+sf.sf_action_msg
--			if sf_action_msg.count >0 then
--				
--				sf_action_msg:=""
--			end
--			if sf.collide_with_others_msg.count>0 then
--				result:=result+sf.collide_with_others_msg
--				sf.clear_collide_with_others_msg
--			end
--			if sf.destroy_others_msg.count>0 then
--				result:=result+sf.destroy_others_msg
--				sf.clear_destroy_others_msg
--			end
		end


	set_ene_preemptive_msg(msg:STRING)
		do
			ene_preemptive_msg:=ene_preemptive_msg + msg
		end

	print_ene_action_msg:STRING

		do
			result:="  Enemy Action:%N"

			if ene_preemptive_msg.count>0 then
				result:=result+ene_preemptive_msg

			end
			ene_preemptive_msg:=""
			across enemy is ene
			loop
				if ene.flag_has_moved then

					if ene.action_msg.count>0
					then
						result:=result+ene.action_msg
					end
					ene.toggle_flag_has_moved
				end

				if ene.collide_by_others then
					ene.toogle_collide
				end

			end
			clear_ene_action_msg
		end

	clear_ene_action_msg
		do
			across enemy is ene
			loop
				ene.clear_action_msg
			end
			ene_preemptive_msg:=""
		end


	ene_spawn_msg:STRING
		do
			result:="  Natural Enemy Spawn:%N"
			if enemy_spawn_msg.count >0 then
				result:=result+enemy_spawn_msg
				enemy_spawn_msg:=""
			end
		end


	out:STRING
		local
			i:INTEGER
			j:INTEGER
			tmp:STRING
		do
			result:=""
			tmp:=""
			tmp:=enemy_msg
			tmp:=tmp+pjt_msg
			tmp:=tmp+	print_frd_pjt_action
			tmp:=tmp+print_ene_pjt_action
			tmp:=tmp+print_sf_action_msg
			tmp:=tmp+print_ene_action_msg
			tmp:=tmp+ene_spawn_msg
			if flag_fog then
			else 	result:=result+tmp
			end

				result:=result+"    "
	--			l_index:=1
	--			for l_index< current.board_column
				across 1 |..| current.board_column is l_index
				loop
					--			loop
	--			end
	--			projectile_row:=last_projectile_row
					if l_index<10 then
						result:=result+"  " + l_index.out
					else
						result:=result+" " +l_index.out
					end
				  end
				 result:=result+"%N"

				 i:=1
				 j:=1
				 across
				 	1 |..| current.board_row is l_row
	--				across 1 |..| starter_pjt_row.count  is i
	--				loop
	--					if  then
	--					
	--					end
	--				end
				 loop
				 	result:=result+"    "
				 	result:=result+init[l_row].out+" "
				 	across 1 |..| current.board_column is l_column
				 	loop
	--			current_projectile_row:=player_row
	--			current_projectile_column:=player_column+1
						if flag_fog then
							fog
							result:=result+fog_board[l_row,l_column].out--+" &"
						else
							result:=result+game_board[l_row,l_column].out
						end

				 		if j< board_column
				 		then
				 			result:=result+"  "
							j:=j+1

				 		end

				 	end
				 	j:=1
	--			 	result:=result+"1"
					if i<  current.board_row then
						result:=result+"%N"
					end
				 	i:=i+1
				 end

			current.clear_enemy_spawn_msg
			current.sf.clear_sf_action_msg

			clear_ene_action_msg


		end



end

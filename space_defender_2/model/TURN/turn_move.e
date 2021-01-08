note
	description: "Summary description for {TURN_MOVE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	TURN_MOVE
inherit
	TURN
	redefine
		execute
	end
create
	make

feature
	execute
		do

			phase_a
			phase_b
			phase_c_move(sf_position)
			phase_d
			phase_e
			phase_f
			phase_g
		end
feature
	make(pos:POSITION)
		do
			sf_position:=pos
		end
	sf_position:POSITION
feature
	phase_c
		do

		end
	phase_c_move(newpos:POSITION)
		local
			num:INTEGER
			tmppos:POSITION
			tmp:INTEGER
		DO
			if not gameboard.sf.destroyed then
				gameboard.sf.regen
			gameboard.game_board[gameboard.sf.position .row ,gameboard.sf.position.col] :='_'
--at left bottom
			if newpos.row> gameboard.sf.position.row  and newpos.col <= gameboard.sf.position.col then
				from tmp:=gameboard.sf.position.row
				until tmp=newpos.row+1 or gameboard.sf.destroyed
				loop
					create tmppos.make (tmp ,gameboard.sf.position.col)
					gameboard.sf_check_collison(tmppos)
					tmp:=tmp+1
				end

				from tmp:= gameboard.sf.position.col
				until tmp=newpos.col-1 or gameboard.sf.destroyed
				loop
					create tmppos.make (newpos.row ,tmp)
					gameboard.sf_check_collison(tmppos)
					tmp:=tmp-1
				end



--top right			
			elseif  newpos.row< gameboard.sf.position.row and newpos.col >= gameboard.sf.position.col then
				from tmp:= gameboard.sf.position.row
				until tmp=newpos.row-1  or gameboard.sf.destroyed
				loop

					create tmppos.make (tmp ,gameboard.sf.position.col )
					gameboard.sf_check_collison(tmppos)
					tmp:=tmp-1

				end

				from tmp:= gameboard.sf.position.col
				until tmp=newpos.col+1  or gameboard.sf.destroyed
				loop
					create tmppos.make (newpos.row ,tmp )
					gameboard.sf_check_collison(tmppos)
					tmp:=tmp+1


				end
--bottom right
			elseif newpos.row>= gameboard.sf.position.row and newpos.col > gameboard.sf.position.col then

				from tmp:=gameboard.sf.position.row
				until tmp=newpos.row+1 or gameboard.sf.destroyed
				loop

					create tmppos.make (tmp ,gameboard.sf.position.col )
					gameboard.sf_check_collison(tmppos)
					tmp:=tmp+1
				end

				from tmp:= gameboard.sf.position.col
				until tmp=newpos.col+1 or gameboard.sf.destroyed
				loop

					create tmppos.make (newpos.row ,tmp )
					gameboard.sf_check_collison(tmppos)
					tmp:=tmp+1
				end
--top left
			elseif newpos.row<= gameboard.sf.position.row and newpos.col < gameboard.sf.position.col then


				from tmp:= gameboard.sf.position.row
				until tmp=newpos.row-1 or gameboard.sf.destroyed
				loop

					create tmppos.make (tmp ,gameboard.sf.position.col)
					gameboard.sf_check_collison(tmppos)
					tmp:=tmp-1
				end

				from tmp:=gameboard.sf.position.col
				until tmp=newpos.col-1 or gameboard.sf.destroyed
				loop

					create tmppos.make ( newpos.row ,tmp )
					gameboard.sf_check_collison(tmppos)
					tmp:=tmp-1
				end


			end
			if not gameboard.sf.destroyed then
				gameboard.sf.set_position(newpos)
			else
				gameboard.sf.set_symbol ('X')
			end



-- need  check on collision
-- need work on reduce health/enegy after collide

			gameboard.sf.set_action_msg("    The Starfighter(id:0) moves: ["+gameboard.sf.correct_row (gameboard.sf.before_position.row).out+","+gameboard.sf.before_position.col.out+"] -> ["+gameboard.sf.correct_row (gameboard.sf.position.row).out+","+gameboard.sf.position.col.out+"]%N")
--			game_board[sf.position.row ,sf.position.col ] :='S'
			num:=-(gameboard.sf.move_cost * (gameboard.sf.before_position.distance_between(gameboard.sf.position)))
			gameboard.sf.change_actual_energy(num)
			end



		end



--	sf_check_collison(pos:POSITION)
--		local
--			t1:INTEGER
--		do
----collide with friendly pjt
--			
--			across gameboard.pjt is p
--			loop
--				if p.valid and not p.collide_by_others then
--					if p.pjt_position ~ pos then
--						p.toogle_collide_by_others
--						t1:=p.damage-sf.armour
--						if t1>0 then  else t1:=0 end
--						sf.change_actual_health(-t1)
--						sf.set_collide_with_others_msg("friendly projectile",p.id,p.pjt_position,"taking "+t1.out+" damage" )
----						print("sf collide with firendly pjt")
--						if sf.destroyed then  --if sf destroyed after this collision
--							sf.set_position (pos)
--						
--							sf.set_destroy_others_msg("Starfighter",pos)
--						end
--					end
--				end
--			end
----collide with enemy pjt
--			across pjt_enemy is pe
--			loop
--				if pe.valid and not pe.collide_by_others then
--					if pe.pjt_position ~ pos then

--						print("sf collide with enemy pjt")

--						pe.toogle_collide_by_others
--						t1:=pe.damage-sf.armour
--						if t1>0 then  else t1:=0 end
--						sf.change_actual_health(-t1)
--						sf.set_collide_with_others_msg("enemy projectile",pe.id,pe.pjt_position,"taking "+t1.out+" damage" )

--						if sf.destroyed then  --if sf destroyed after this collision
--							sf.set_position (pos)
--							sf.set_destroy_others_msg("Starfighter",pos)
--						end

--					end
--				end
--			end

----collide with enemy
--			across enemy is e
--			loop
--				if e.valid  then
--					if e.position ~ pos then

--						print("sf collide with enemy ")

--						e.toogle_collide
----need calculate the score
--						sf.set_score (2)

--						t1:=e.actual_health
--						sf.change_actual_health(-e.actual_health)
--						sf.set_collide_with_others_msg(e.name,e.id,e.position,"trading "+t1.out+" damage" )
--						sf.set_destroy_others_msg(e.name,e.position)
--						if sf.destroyed then  --if sf destroyed after this collision
--							sf.set_position (pos)
--							sf.set_destroy_others_msg("Starfighter",pos)

--						end

--					end
--				end
--			end


--		end

end

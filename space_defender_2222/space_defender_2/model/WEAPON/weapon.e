note
	description: "Summary description for {WEAPON}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	WEAPON
inherit
	SETUP_STATE
		redefine
			intro_msg,
			state_msg
		end




feature --check collision
	check_frienly_pjt_collsion(tmppos:POSITION;gp:PROJECTILE)
		local	t1:INTEGER
		do
			across gameboard.pjt_enemy  is ene  --collide with enemy pjt
			loop
				if ene.valid and not ene.collide_by_others  then
					if ene.pjt_position ~ tmppos then

				 		if gp.damage< ene.damage then--if enemy projectile’s damage is higher
							gp.toogle_collide_by_others
							gp.set_position (ene.pjt_position.deep_twin)
							gp.toggle_flag_has_moved
							gp.set_collide_with_others_msg ("enemy projectile",ene.id,ene.pjt_position,"negating damage")
				 			ene.change_damage(ene.damage-gp.damage)
				 		elseif gp.damage> ene.damage then--if the friendly projectile’s damage is higher
--				 			print(gp.id.out+"  "+ ene.id.out+"%N")----------------------

				 			if ene.flag_has_moved then
				 				ene.toogle_collide_by_others
				 			else
				 				ene.toogle_collide
				 			end

				 			gameboard.game_board[ene.pjt_position.row,ene.pjt_position.col]:='_'
				 			gp.set_collide_with_others_msg("enemy projectile",ene.id,ene.pjt_position,"negating damage")
				 			gp.change_damage(gp.damage-ene.damage)
-- - gp.damage= ene.damage
				 		elseif gp.damage= ene.damage then
							gp.toggle_flag_has_moved
							gp.toogle_collide_by_others

							if ene.flag_has_moved then
								ene.toogle_collide_by_others
							else
								ene.toogle_collide
							end
							gameboard.game_board[tmppos.row,tmppos.col]:='_'
							gp.set_position (tmppos)
							gp.set_collide_with_others_msg("enemy projectile",ene.id,ene.pjt_position,"negating damage")




				 		end
					end
				end

			end

			across gameboard.pjt  is p --Colliding with a friendly projectile
			loop
				if p.valid and not p.collide_by_others then
					if p.pjt_position ~ tmppos and p.id /= gp.id
					then
						p.toogle_collide_by_others
						if p.flag_has_moved then
				 			p.toogle_collide_by_others
			 			else
			 				p.toogle_collide
			 			end
						gp.change_damage(gp.damage+ p.damage)
						gp.set_collide_with_others_msg("friendly projectile",p.id,p.pjt_position,"combining damage")
					end
				end

			end

			across gameboard.enemy  is ene  --Colliding with enemy
			loop
				if ene.valid then
					if ene.position ~ tmppos
					then

--									gp.toogle_collide
						t1:=gp.damage-ene.armour
						if t1>0 then  else t1:=0 end
						ene.change_actual_health(-t1)
						gp.set_collide_with_others_msg(ene.name,ene.id,ene.position,"dealing "+t1.out+" damage")
--need calculate score
						gp.toggle_flag_has_moved
						if ene.collide then
--							gameboard.sf.set_score (2)
							gameboard.sf.sf_focus.add (ene.drop)
							gp.set_destroy_others_msg(ene.name,ene.position)
							gameboard.game_board[ene.position.row,ene.position.col]:='_'
						end
						gp.set_position(tmppos)

--						gp.toogle_collide_by_others
						gp.toogle_collide
--									ene.set_collide_with_others_msg("friendly projectile",gp.id,gp.pjt_position,"taking "+t1.out+" damage" )
					end
				end

			end

			if gameboard.sf.position ~tmppos  then--Colliding with an Starfighter
--need			
				gp.toggle_flag_has_moved
				gp.set_position (tmppos)
				gp.toogle_collide_by_others
				t1:=gp.damage-gameboard.sf.armour
				if t1>0 then  else t1:=0 end
				gameboard.sf.change_actual_health (-t1)
				gp.set_collide_with_others_msg ("Starfighter", 0,tmppos , "dealing "+t1.out+" damage")
				if gameboard.sf.destroyed then
					gp.set_destroy_others_msg("Starfighter",tmppos)
				end
			end

		end



feature
	intro_msg:STRING
		do
			result:="%N  1:Standard (A single projectile is fired in front)%N"+
   				"    Health:10, Energy:10, Regen:0/1, Armour:0, Vision:1, Move:1, Move Cost:1,%N"+
				"    Projectile Damage:70, Projectile Cost:5 (energy)%N"+
				"  2:Spread (Three projectiles are fired in front, two going diagonal)%N"+
				"    Health:0, Energy:60, Regen:0/2, Armour:1, Vision:0, Move:0, Move Cost:2,%N"+
				"    Projectile Damage:50, Projectile Cost:10 (energy)%N"+
				"  3:Snipe (Fast and high damage projectile, but only travels via teleporting)%N"+
				"    Health:0, Energy:100, Regen:0/5, Armour:0, Vision:10, Move:3, Move Cost:0,%N"+
				"    Projectile Damage:1000, Projectile Cost:20 (energy)%N"+
				"  4:Rocket (Two projectiles appear behind to the sides of the Starfighter and accelerates)%N"+
				"    Health:10, Energy:0, Regen:10/0, Armour:2, Vision:2, Move:0, Move Cost:3,%N"+
				"    Projectile Damage:100, Projectile Cost:10 (health)%N"+
				"  5:Splitter (A single mine projectile is placed in front of the Starfighter)%N"+
				"    Health:0, Energy:100, Regen:0/10, Armour:0, Vision:0, Move:0, Move Cost:5,%N"+
				"    Projectile Damage:150, Projectile Cost:70 (energy)"
		end

	state_msg:STRING
		do
			result:="weapon setup"
		end



end

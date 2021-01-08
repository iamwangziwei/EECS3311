note
	description: "Summary description for {WEAPON_STANDARD}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	WEAPON_STANDARD
inherit
	WEAPON
		redefine
			equip_msg,pjt_pattern,fire_new_pjt,out
		end
--	ANY
--		redefine
--			
--		end
create
	make

feature
	make
		do
			health:=10
			energy:=10
			regen_health:=0
			regen_energy:=1
			armour:=0
			vision:=1
			move:=1
			move_cost:=1
			projectile_damage:=70
			projectile_cost:=5 --(energy)
			projectile_cost_type:=2
			pjt_mv:=5
		end


feature
	execute
		local
			tmp:INTEGER
			tmppos:POSITION
			t1:INTEGER
		do

---need work check for collision(partially)

			across gameboard.pjt  is gp
			loop
				if gp.valid then
					from tmp:=gp.pjt_position.col
					until tmp=gp.destination.col+1 or gp.collide or gp.collide_by_others or gameboard.sf.destroyed
					loop
						create tmppos.make (gp.pjt_position.row, tmp)
						check_frienly_pjt_collsion(tmppos,gp)
--						across gameboard.pjt_enemy  is ene  --collide with enemy pjt
--						loop
--							if ene.valid then
--								if ene.pjt_position ~ tmppos then

--							 		if gp.damage< ene.damage then--if enemy projectile’s damage is higher
--		--need work
--							 		elseif gp.damage> ene.damage then--if the friendly projectile’s damage is higher
--							 			ene.toogle_collide
--							 			gp.set_collide_with_others_msg("enemy projectile",ene.id,ene.pjt_position,"negating damage")
--							 			gp.change_damage(gp.damage-ene.damage)
--		--need work - gp.damage= ene.damage
--							 		elseif gp.damage= ene.damage then

--							 		end
--								end
--							end

--						end

--						across gameboard.pjt  is p --Colliding with a friendly projectile
--						loop
--							if p.valid then
--								if p.pjt_position ~ tmppos and p.id /= gp.id
--								then
--									p.toogle_collide
--									gp.change_damage(gp.damage+ p.damage)
--								end
--							end

--						end

--						across gameboard.enemy  is ene  --Colliding with enemy
--						loop
--							if ene.valid then
--								if ene.position ~ tmppos
--								then

----									gp.toogle_collide
--									t1:=gp.damage-ene.armour
--									if t1>0 then  else t1:=0 end
--									ene.change_actual_health(-t1)
--									gp.set_collide_with_others_msg(ene.name,ene.id,ene.position,"dealing "+t1.out+" damage")
--	--need calculate score
--									if ene.collide then
--										gameboard.sf.set_score (2)
--										gp.set_destroy_others_msg(ene.name,ene.position)
--										gameboard.game_board[ene.position.row,ene.position.col]:='_'
--									end
--									gp.set_position(tmppos.deep_twin)

--									gp.toogle_collide_by_others
----									ene.set_collide_with_others_msg("friendly projectile",gp.id,gp.pjt_position,"taking "+t1.out+" damage" )
--								end
--							end

--						end

--						if gameboard.sf.position ~tmppos  then--Colliding with an Starfighter
--	--need
--						end


						tmp:=tmp+1
					end
				end



				if not gp.collide and not gp.collide_by_others and not gp.flag_has_moved then 	gp.pjt_forth gp.toggle_flag_has_moved end


			end



		end

--create a new pjt
	fire_new_pjt
		local
			newpjt:PROJECTILE
			po:POSITION
		do

			create po.make_by_position (gameboard.sf.position.to_right(1))
			create newpjt.make (po, pjt_mv,-(gameboard.pjt_all.count+1),projectile_damage,'*')
			gameboard.pjt.force (newpjt )
			gameboard.pjt_all.force (newpjt )
			gameboard.sf.change_actual_energy (-projectile_cost)
			gameboard.sf.set_action_msg("    The Starfighter(id:0) fires at location ["+gameboard.sf.correct_row (gameboard.sf.position.row).out+","+gameboard.sf.position.col.out+"].%N")
			if newpjt.valid then
				gameboard.sf.set_sf_action_msg(	"      A friendly projectile(id:"+newpjt.id.out +") spawns at location ["+gameboard.sf.correct_row (newpjt.pjt_position.row).out+","+newpjt.pjt_position.col.out+"].%N")
			else
				gameboard.sf.set_sf_action_msg(	"      A friendly projectile(id:"+newpjt.id.out +") spawns at location out of board.%N")
			end

			current.check_frienly_pjt_collsion(newpjt.pjt_position ,newpjt)

--need: the new pjt spawn on sth ,might need test on it
			if newpjt.collide_with_others_msg.count >0 then
				gameboard.sf.set_sf_action_msg(newpjt.collide_with_others_msg)
				newpjt.clear_collide_with_others_msg
			end
			if newpjt.destroy_others_msg.count >0 then
				gameboard.sf.set_sf_action_msg(newpjt.destroy_others_msg)
				newpjt.clear_destroy_others_msg
			end
			if newpjt.collide_by_others then
				newpjt.toogle_collide
			end
			if newpjt.flag_has_moved then
				newpjt.toggle_flag_has_moved
			end
		end

	equip_msg:STRING
		DO
			result:="%N  Weapon Selected:Standard"
		end

	pjt_pattern:STRING
		do
			result:="Standard"
		end
	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

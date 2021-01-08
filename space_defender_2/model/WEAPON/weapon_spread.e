note
	description: "Summary description for {WEAPON_SPREAD}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	WEAPON_SPREAD
inherit
	WEAPON
		redefine
			equip_msg,pjt_pattern,fire_new_pjt,out
		end
create
	make

feature
	make
		do
			health:=0
			energy:=60
			regen_health:=0
			regen_energy:=2
			armour:=1
			vision:=0
			move:=0
			move_cost:=2
			projectile_damage:=50
			projectile_cost:=10 --(energy)
			projectile_cost_type:=2
			pjt_mv:=1
		end


feature
	execute
		local
			tmp:INTEGER
			tmppos:POSITION
		do

			across gameboard.pjt  is gp
			loop
				tmp:=1
				if gp.valid and not  gameboard.sf.destroyed then
					if gameboard.pjt.index_of (gp, 1) \\3 =1 then
--						tmp:=gp.id.abs \\ 3
--						print(gp.id.out+" " +tmp.out  +"%N")
						create tmppos.make (gp.pjt_position.row-1, gp.pjt_position.col+1)
						check_frienly_pjt_collsion(tmppos,gp)
						if not gp.collide  and not gp.flag_has_moved then 	gp.set_position(tmppos) gp.toggle_flag_has_moved end
					elseif gameboard.pjt.index_of (gp, 1) \\3 =2  then
--						tmp:=gp.id.abs \\ 3
--						print(gp.id.out+" " +tmp.out  +"%N")
						create tmppos.make (gp.pjt_position.row, gp.pjt_position.col+1)
						check_frienly_pjt_collsion(tmppos,gp)
						if not gp.collide and not gp.flag_has_moved then 	gp.set_position(tmppos) gp.toggle_flag_has_moved end
					elseif  gameboard.pjt.index_of (gp, 1) \\3  =0  then
--						tmp:=gp.id.abs \\ 3
--						print(gp.id.out+" " +tmp.out  +"%N")
						create tmppos.make (gp.pjt_position.row+1, gp.pjt_position.col+1)
						check_frienly_pjt_collsion(tmppos,gp)
						if not gp.collide and not gp.flag_has_moved then 	gp.set_position(tmppos) gp.toggle_flag_has_moved  end
					end
				end
				tmp:=tmp+1
				if tmp=4 then
					tmp:=1
				end
			end

		end
	--create a new pjt
	fire_new_pjt
		local
			new1:PROJECTILE
			new2:PROJECTILE
			new3:PROJECTILE
			po:POSITION
		do


			create po.make (gameboard.sf.position.row-1,gameboard.sf.position.col+1)
			create new1.make (po, pjt_mv,-(gameboard.pjt_all.count+1),projectile_damage,'*')
			gameboard.pjt.force (new1 )
			gameboard.pjt_all.force (new1 )


			create po.make_by_position (gameboard.sf.position.to_right(1))
			create new2.make (po, pjt_mv,-(gameboard.pjt_all.count+1),projectile_damage,'*')
			gameboard.pjt.force (new2 )
			gameboard.pjt_all.force (new2 )



			create po.make (gameboard.sf.position.row+1,gameboard.sf.position.col+1)
			create new3.make (po, pjt_mv,-(gameboard.pjt_all.count+1),projectile_damage,'*')
			gameboard.pjt.force (new3 )
			gameboard.pjt_all.force (new3 )




			gameboard.sf.change_actual_energy (-projectile_cost)




			gameboard.sf.set_action_msg("    The Starfighter(id:0) fires at location ["+gameboard.sf.correct_row (gameboard.sf.position.row).out+","+gameboard.sf.position.col.out+"].%N")
			if new1.valid  then
				gameboard.sf.set_sf_action_msg(	"      A friendly projectile(id:"+new1.id.out +") spawns at location ["+new1.pjt_position.correct_row.out+","+new1.pjt_position.col.out+"].%N")
			else
				gameboard.sf.set_sf_action_msg(	"      A friendly projectile(id:"+new1.id.out +") spawns at location out of board.%N")
			end

			check_frienly_pjt_collsion(new1.pjt_position ,new1)
			if new1.collide_with_others_msg.count >0 then
				gameboard.sf.set_sf_action_msg(new1.collide_with_others_msg)
				new1.clear_collide_with_others_msg
			end
			if new1.destroy_others_msg.count >0 then
				gameboard.sf.set_sf_action_msg(new1.destroy_others_msg)
				new1.clear_destroy_others_msg
			end
			if new1.collide_by_others then
				new1.toogle_collide
			end

			if new2.valid  then
				gameboard.sf.set_sf_action_msg(	"      A friendly projectile(id:"+new2.id.out +") spawns at location ["+new2.pjt_position.correct_row.out+","+new2.pjt_position.col.out+"].%N")
			else
				gameboard.sf.set_sf_action_msg(	"      A friendly projectile(id:"+new2.id.out +") spawns at location out of board.%N")
			end
			check_frienly_pjt_collsion(new2.pjt_position ,new2)
			if new2.collide_with_others_msg.count >0 then
				gameboard.sf.set_sf_action_msg(new2.collide_with_others_msg)
				new2.clear_collide_with_others_msg
			end
			if new2.destroy_others_msg.count >0 then
				gameboard.sf.set_sf_action_msg(new2.destroy_others_msg)
				new2.clear_destroy_others_msg
			end
			if new2.collide_by_others then
				new2.toogle_collide
			end

			if new3.valid  then
				gameboard.sf.set_sf_action_msg(	"      A friendly projectile(id:"+new3.id.out +") spawns at location ["+new3.pjt_position.correct_row.out+","+new3.pjt_position.col.out+"].%N")
			else
				gameboard.sf.set_sf_action_msg(	"      A friendly projectile(id:"+new3.id.out +") spawns at location out of board.%N")
			end


--need:if collide with other stuff



			check_frienly_pjt_collsion(new3.pjt_position ,new3)




			if new3.collide_with_others_msg.count >0 then
				gameboard.sf.set_sf_action_msg(new3.collide_with_others_msg)
				new3.clear_collide_with_others_msg
			end
			if new3.destroy_others_msg.count >0 then
				gameboard.sf.set_sf_action_msg(new3.destroy_others_msg)
				new3.clear_destroy_others_msg
			end



			if new3.collide_by_others then
				new3.toogle_collide
			end


			if new1.flag_has_moved then
				new1.toggle_flag_has_moved
			end
			if new2.flag_has_moved then
				new2.toggle_flag_has_moved
			end
			if new3.flag_has_moved then
				new3.toggle_flag_has_moved
			end
		end



feature --msg
	equip_msg:STRING
		DO
			result:="%N  Weapon Selected:Spread"
		end

	pjt_pattern:STRING
		do
			result:="Spread"
		end
	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

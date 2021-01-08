note
	description: "Summary description for {WEAPON_ROCKET}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	WEAPON_ROCKET
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
			health:=10
			energy:=0
			regen_health:=10
			regen_energy:=0
			armour:=2
			vision:=2
			move:=0
			move_cost:=3
			projectile_damage:=100
			projectile_cost:=10 --(health)
			projectile_cost_type:=1
			pjt_mv:=1
--			count:=0
		end


feature
--	count:INTEGER

	execute
		local
			tmp:INTEGER
			tmppos:POSITION
			t1:INTEGER
		do
			t1:=2

			across gameboard.pjt is gp
			loop
				if gp.valid then
					from tmp:=gp.pjt_position.col
					until tmp=gp.destination.col+1 or gp.collide or gp.flag_has_moved
					loop
						create tmppos.make (gp.pjt_position.row, tmp)
						check_frienly_pjt_collsion(tmppos,gp)
						tmp:=tmp+1
					end

					if not gp.collide and not gp.flag_has_moved and not gp.collide_by_others
					then 	gp.pjt_forth
							gp.toggle_flag_has_moved
							gp.change_pjt_mov((t1^gp.count).truncated_to_integer)
							gp.change_count

					end
				end
			end
		end


	--create a new pjt
	fire_new_pjt
		local
			new1:PROJECTILE
			new2:PROJECTILE
			po:POSITION
		do
			create po.make (gameboard.sf.position.row-1,gameboard.sf.position.col-1)
			create new1.make (po, pjt_mv, -(gameboard.pjt_all.count+1), projectile_damage, '*')
			gameboard.pjt.force (new1 )
			gameboard.pjt_all.force (new1 )


			create po.make (gameboard.sf.position.row+1,gameboard.sf.position.col-1)
			create new2.make (po, pjt_mv, -(gameboard.pjt_all.count+1), projectile_damage, '*')
			gameboard.pjt.force (new2 )
			gameboard.pjt_all.force (new2 )
			gameboard.sf.change_actual_health (-projectile_cost)

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
--need:if collide with other stuff

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

			if new1.flag_has_moved then
				new1.toggle_flag_has_moved
			end
			if new2.flag_has_moved then
				new2.toggle_flag_has_moved
			end
		end


feature --msg

	equip_msg:STRING
		DO
			result:="%N  Weapon Selected:Rocket"
		end

	pjt_pattern:STRING
		do
			result:="Rocket"
		end
	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

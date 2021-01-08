note
	description: "Summary description for {WEAPON_SPLITTER}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	WEAPON_SPLITTER
inherit
	WEAPON
		redefine
			equip_msg,pjt_pattern,out,fire_new_pjt
		end
create
	make

feature
	make
		do
			health:=0
			energy:=100
			regen_health:=0
			regen_energy:=10
			armour:=0
			vision:=0
			move:=0
			move_cost:=5
			projectile_damage:=150
			projectile_cost:=70 --(energy)
			projectile_cost_type:=2
		end


feature
	execute
		do
			across gameboard.pjt  is p
			loop
				if p.valid then
					p.toggle_flag_has_moved
					p.set_position(p.pjt_position)
				end
			end

		end

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
			result:="%N  Weapon Selected:Splitter"
		end

	pjt_pattern:STRING
		do
			result:="Splitter"
		end
	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

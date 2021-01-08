note
	description: "Summary description for {SPECIAL_DEPLOY_DRONE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	SPECIAL_DEPLOY_DRONE

inherit
	SPECIALS
		redefine
			equip_msg,pwr_msg,out
		end
create
	make

feature
	make
		do
			energy:=100
			special_cost_type:=2
		end







feature

	execute
	local
			temp1:INTEGER
		do
			gameboard.sf.change_actual_energy (-energy)
			gameboard.sf.set_action_msg("    The Starfighter(id:0) uses special, clearing projectiles with drones.%N")
			across
				gameboard.pjt_all is p
			loop
				if p.valid then
					p.toogle_collide
					gameboard.sf.set_sf_action_msg("      A projectile(id:"+p.id.out+") at location ["+p.pjt_position.correct_row.out+","+p.pjt_position.col.out+"] has been neutralized.%N")
				end
			end





		end
	equip_msg:STRING
		DO
			result:="%N  Power Selected:Deploy Drones (100 energy): Clear all projectiles."
		end

	pwr_msg:STRING
		do
			result:="Deploy Drones (100 energy): Clear all projectiles."
		end

	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

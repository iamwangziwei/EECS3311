note
	description: "Summary description for {ENGINE_ARMOURED}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ENGINE_ARMOURED
inherit
	ENGINE
		redefine
			equip_msg,out
		end
create
	make

feature
	make
		do
			health:=50
			energy:=100
			regen_health:=0
			regen_energy:=3
			armour:=3
			vision:=6
			move:=4
			move_cost:=5
--			projectile_damage:=70
--			projectile_cost:=5 --(energy)
--			projectile_cost_type:=1
--			pjt_mv:=5
		end




feature
	execute
		do

		end

	equip_msg:STRING
			DO
				result:="%N  Engine Selected:Armoured"
			end

	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

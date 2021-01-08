note
	description: "Summary description for {ARMOUR_LIGHT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ARMOUR_LIGHT
inherit
	ARMOUR
		redefine
			equip_msg,out
		end
create
	make

feature
	make
		do
			health:=75
			energy:=0
			regen_health:=2
			regen_energy:=0
			armour:=3
			vision:=0
			move:=0
			move_cost:=1
--			projectile_damage:=50
--			projectile_cost:=10 --(energy)
--			projectile_cost_type:=2
		end


feature
	execute
		do

		end

	equip_msg:STRING
		DO
			result:="%N  Armour Selected:Light"
		end
	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

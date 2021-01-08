note
	description: "Summary description for {ARMOUR_NONE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ARMOUR_NONE
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
			health:=50
			energy:=0
			regen_health:=1
			regen_energy:=0
			armour:=0
			vision:=0
			move:=1
			move_cost:=0
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
			result:="%N  Armour Selected:None"
		end
	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

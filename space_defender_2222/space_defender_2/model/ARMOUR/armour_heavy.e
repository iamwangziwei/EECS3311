note
	description: "Summary description for {ARMOUR_HEAVY}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ARMOUR_HEAVY
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
			health:=200
			energy:=0
			regen_health:=4
			regen_energy:=0
			armour:=10
			vision:=0
			move:=-1
			move_cost:=5
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
			result:="%N  Armour Selected:Heavy"
		end
	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

note
	description: "Summary description for {ENGINE_STANDARD}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ENGINE_STANDARD


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
			health:=10
			energy:=60
			regen_health:=0
			regen_energy:=2
			armour:=1
			vision:=12
			move:=8
			move_cost:=2
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
				result:="%N  Engine Selected:Standard"
			end

	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

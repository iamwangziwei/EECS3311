note
	description: "Summary description for {ENGINE_LIGHT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ENGINE_LIGHT
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
			health:=0
			energy:=30
			regen_health:=0
			regen_energy:=1
			armour:=0
			vision:=15
			move:=10
			move_cost:=1

		end




feature
	execute
		do
			
		end
	equip_msg:STRING
			DO
				result:="%N  Engine Selected:Light"
			end

	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

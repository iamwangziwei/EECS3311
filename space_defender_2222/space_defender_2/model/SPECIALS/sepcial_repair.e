note
	description: "Summary description for {SEPCIAL_REPAIR}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	SEPCIAL_REPAIR
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
			energy:=50
			special_cost_type:=2
		end







feature

	execute
		do
			gameboard.sf.change_actual_energy (-energy)
			gameboard.sf.set_action_msg("    The Starfighter(id:0) uses special, gaining 50 health.%N")
			gameboard.sf.change_special_health(50)
		end
	equip_msg:STRING
		DO
			result:="%N  Power Selected:Repair (50 energy): Gain 50 health, can go over max health. Health regen will not be in effect if over cap."

		end

	pwr_msg:STRING
		do
			result:="Repair (50 energy): Gain 50 health, can go over max health. Health regen will not be in effect if over cap."
		end

	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

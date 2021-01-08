note
	description: "Summary description for {SPECIAL_OVERCHARGE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	SPECIAL_OVERCHARGE
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
			energy:=1
			special_cost_type:=1
		end







feature

	execute
		local
			t1:INTEGER
			t2:INTEGER
		do
			if gameboard.sf.actual_health>50 then
				gameboard.sf.change_actual_health (-50)
				gameboard.sf.change_special_energy(100)
				t1:=50
				t2:=100
			else
				t1:=gameboard.sf.actual_health-1
				gameboard.sf.change_actual_health(-t1)
				t2:=t1*2
				gameboard.sf.change_special_energy(t2)
			end

			gameboard.sf.set_action_msg("    The Starfighter(id:0) uses special, gaining "+t2.out+" energy at the expense of "+t1.out+" health.%N")

		end
	equip_msg:STRING
		DO
			result:="%N  Power Selected:Overcharge (up to 50 health): Gain 2*health spent energy, can go over max energy. Energy regen will not be in effect if over cap."

		end

	pwr_msg:STRING
		do
			result:="Overcharge (up to 50 health): Gain 2*health spent energy, can go over max energy. Energy regen will not be in effect if over cap."
		end

	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

note
	description: "Summary description for {ARMOUR}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	ARMOUR

inherit
	SETUP_STATE
		redefine
			intro_msg,
			state_msg
		end
--create
--	make

--feature
--	make
--		do

--		end

feature
	intro_msg:STRING
		do
			result:="%N  1:None%N"+
			    "    Health:50, Energy:0, Regen:1/0, Armour:0, Vision:0, Move:1, Move Cost:0%N"+
				"  2:Light%N"+
				"    Health:75, Energy:0, Regen:2/0, Armour:3, Vision:0, Move:0, Move Cost:1%N"+
				"  3:Medium%N"+
				"    Health:100, Energy:0, Regen:3/0, Armour:5, Vision:0, Move:0, Move Cost:3%N"+
				"  4:Heavy%N"+
				"    Health:200, Energy:0, Regen:4/0, Armour:10, Vision:0, Move:-1, Move Cost:5"
		end

	state_msg:STRING
		do
			result:="armour setup"
		end

end

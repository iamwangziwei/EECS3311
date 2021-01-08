note
	description: "Summary description for {ENGINE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	ENGINE
inherit
	SETUP_STATE
		redefine
			intro_msg,
			state_msg
		end


feature
	intro_msg:STRING
		do
			result:="%N  1:Standard%N"+
			"    Health:10, Energy:60, Regen:0/2, Armour:1, Vision:12, Move:8, Move Cost:2%N"+
			"  2:Light%N"+
			"    Health:0, Energy:30, Regen:0/1, Armour:0, Vision:15, Move:10, Move Cost:1%N"+
			"  3:Armoured%N"+
			"    Health:50, Energy:100, Regen:0/3, Armour:3, Vision:6, Move:4, Move Cost:5"
		end

	state_msg:STRING
		do
			result:="engine setup"
		end
end

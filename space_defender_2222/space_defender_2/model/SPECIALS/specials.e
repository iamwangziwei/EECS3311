note
	description: "Summary description for {SPECIALS}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	SPECIALS

inherit
	SETUP_STATE
		redefine
			intro_msg,
			state_msg
		end



feature
	intro_msg:STRING
		do
			result:="%N  1:Recall (50 energy): Teleport back to spawn.%N"+
			"  2:Repair (50 energy): Gain 50 health, can go over max health. Health regen will not be in effect if over cap.%N"+
			"  3:Overcharge (up to 50 health): Gain 2*health spent energy, can go over max energy. Energy regen will not be in effect if over cap.%N"+
			"  4:Deploy Drones (100 energy): Clear all projectiles.%N"+
			"  5:Orbital Strike (100 energy): Deal 100 damage to all enemies, affected by armour."
		end

	state_msg:STRING
		do
			result:="power setup"
		end

end

note
	description: "Summary description for {SETUP_STATE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	SETUP_STATE
inherit
		ANY
			redefine
				out
			end
--create
--	make
--feature
--	make
--		do

--		end
feature{NONE}

	gameboard: GAMEBOARD

		local
			ma: SPACE_DEFENDER_ACCESS
		do
			Result := ma.m.gameboard
		end

feature
	health:INTEGER
	energy:INTEGER
	regen_health:INTEGER
	regen_energy:INTEGER
	armour:INTEGER
	vision:INTEGER
	move:INTEGER
	move_cost:INTEGER
	projectile_damage:INTEGER
	projectile_cost:INTEGER --(energy)
	projectile_cost_type:INTEGER
	pjt_mv:INTEGER
special_cost_type:INTEGER

feature
	execute
		deferred
--		do
		end
	out:STRING
		do

			result:=""
		end

	intro_msg:STRING
		do

			result:=""
		end

	state_msg:STRING
		do

			result:=""
		end
	equip_msg:STRING
		DO
			result:=""
		end

	pjt_pattern:STRING
		do
			result:=""

		end

	pwr_msg:STRING
		do
			result:=""

		end

	fire_new_pjt
		do

		end

--	init_summary:ARRAY[STRING]
--		do
--			result:=
--		end
end

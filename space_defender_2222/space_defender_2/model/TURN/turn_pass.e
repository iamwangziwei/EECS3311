note
	description: "Summary description for {TURN_PASS}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	TURN_PASS
inherit
	TURN
	redefine
		execute
		end

create
	make
feature
	make
		do

		end
feature
	execute
		do

			phase_a
			phase_b
			phase_c--(sf_position)
			phase_d
			phase_e
			phase_f
			phase_g
		end
feature
	phase_c--(newpos:POSITION)
		DO
			if not gameboard.sf.destroyed then
				gameboard.sf.regen
				gameboard.sf.regen
				gameboard.sf.set_action_msg("    The Starfighter(id:0) passes at location ["+gameboard.sf.position.correct_row.out+","+gameboard.sf.position.col.out+"], doubling regen rate.%N")

			end

		end
end

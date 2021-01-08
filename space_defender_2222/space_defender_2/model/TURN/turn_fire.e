note
	description: "Summary description for {TURN_FIRE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	TURN_FIRE
inherit
	TURN

create
	make
feature
	make
		do


		end
		
feature
	phase_c--(newpos:POSITION)
		do
			if not gameboard.sf.destroyed then
				gameboard.sf.regen
				if attached gameboard.sf.setup_pkg.at (1) as pjtmove then pjtmove.fire_new_pjt end
			end

		end
end

note
	description: "Summary description for {TURN_SPECIAL}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	TURN_SPECIAL
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
				if attached gameboard.sf.setup_pkg.at (4) as pkg then pkg.execute end


			end



		end
end

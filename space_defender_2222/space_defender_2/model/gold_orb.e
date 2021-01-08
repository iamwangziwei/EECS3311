note
	description: "Summary description for {GOLD_ORB}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	GOLD_ORB
	inherit ORB
create
	make
feature
	make--(sc:INTEGER )
		do
			score:=3
			flag_full:=true
			slot:=1
		end
end

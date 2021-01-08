note
	description: "Summary description for {SILVER_ORB}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	SILVER_ORB
	inherit ORB
create
	make
feature
	make--(sc:INTEGER )
		do
			score:=2
			flag_full:=true
			slot:=1
		end
end

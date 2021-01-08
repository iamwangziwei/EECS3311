note
	description: "Summary description for {PLATINUM_FOCUS}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	PLATINUM_FOCUS
inherit
	FOCUS
create
	make_focus
feature
	make_focus
		local
			bronze_orb:ORB
		do
			create  {BRONZE_ORB}bronze_orb.make
			flag_full:=false
			create {LINKED_LIST[ORB]}focus_list.make
			focus_list.force (bronze_orb)

			slot:=3

		end


end

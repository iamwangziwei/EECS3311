note
	description: "Summary description for {DIAMOND_FOCUS}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	DIAMOND_FOCUS
inherit
	FOCUS
create
	make_focus
feature
	make_focus
		local
			gold_orb:ORB
		do
			create  {GOLD_ORB}gold_orb.make
			flag_full:=false
			create {LINKED_LIST[ORB]}focus_list.make
			focus_list.force (gold_orb)
--			focus_list.force (gold_orb)
--			focus_list.force (gold_orb)
--			focus_list.force (gold_orb)
			slot:=4
--			print("  diamoint foucs list count :" + focus_list.count.out+"%N")
--			check_flag_full
--			if flag_full then
--				print("  full  ")
--			else print("   not f  ")
--			end
		end


end

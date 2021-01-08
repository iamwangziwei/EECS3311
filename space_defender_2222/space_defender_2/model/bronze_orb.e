note
	description: "Summary description for {BRONZE_ORB}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	BRONZE_ORB

	inherit ORB
create
	make
feature
	make--(sc:INTEGER )
		do
			score:=1
			flag_full:=true
			slot:=1
		end
--feature
--	add_item(sc:ORB)
--		local
--			flag:BOOLEAN
--		do
--			flag:=false
--			across score_list is list
--			 loop

--				if attached {FOCUS}list as l then

--					l.check_flag_full
--					if not l.flag_full then
--						l.add (sc)
--						flag:=true
--					end
--				end

--			 end
--			 if not flag then
--			 	score_list.extend(sc)
--			 end


--			across score_list is list
--			loop	 	if attached {DIAMOND_FOCUS}list then
--							print("DIAMOND_FOCUS")
--					elseif attached {ORB}list then
--						print("%Norb")
--					end
--			end
--			print(score_list.count.out)
--		end

--	calculate_score:INTEGER
--		do
--			across score_list is list
--			loop
--				result:=result+list.get_score
--			end
--		end
end

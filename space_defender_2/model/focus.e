note
	description: "Summary description for {FOCUS}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	FOCUS


inherit
	ORB
	redefine get_score end
	;COMPOSITE [ORB]

feature



feature
--	make_focus(sc:ORB)
--		do

--		end

feature

--	check_flag_full
--		local
--			f:BOOLEAN
--		do
--			f:=true
--			across focus_list is li
--			loop
--				f:= f and li.flag_full
--			end

--			flag_full := focus_list.count = slot

--		end

	check_flag_full
		local
			f:BOOLEAN
		do
			f:=true
			across focus_list is li
			loop
				f:= f and li.flag_full
			end

			flag_full := f and focus_list.count = slot

		end
--	get_score:INTEGER
--		do

--			across focus_list is li
--			loop
--				result:=result + li.get_score
--			end
--			if flag_full then
--				if slot/=1 then
--					result:=result * (slot-1)
--				end

--			end
--		end

	get_score:INTEGER
		do

			across focus_list is li
			loop
				result:=result + li.get_score
			end
			if focus_list.count = slot then
				if slot/=1 then
					result:=result * (slot-1)
				end

			end
		end

--	add(sc:ORB)
--		local
--			flag:BOOLEAN
--		do
--			flag:=false
----			if focus_list.count = slot then
----					flag_full:=true
----			else
--				across focus_list is li
--				loop
--					if not li.flag_full then
--						if attached {FOCUS}li as l then
--							l.add (sc)
----							print("a")
--							flag:=true
--						end
--					end
--				end
--				if not flag then
--					focus_list.extend (sc)
--				end
----			end
--			check_flag_full
--		end

	add(sc:ORB)
		local
			flag:BOOLEAN
		do
			flag:=false

				across focus_list is li
				loop
					if not li.flag_full then
						if attached {FOCUS}li as l then
							l.add (sc)

							flag:=true
						end
					end
				end
				if not flag then
					focus_list.extend (sc)
				end

			check_flag_full
		end
end

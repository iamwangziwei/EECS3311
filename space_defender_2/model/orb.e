note
	description: "Summary description for {ORB}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	ORB
--inherit

--create make

feature
	score:INTEGER
	flag_full:BOOLEAN
	slot:INTEGER

feature
	get_score:INTEGER
		do
			result:=score
		end


end

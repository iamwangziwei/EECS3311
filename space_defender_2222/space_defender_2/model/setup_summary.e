note
	description: "Summary description for {SETUP_SUMMARY}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	SETUP_SUMMARY
inherit
	SETUP_STATE
		redefine
			out,state_msg
--			equip_msg,pwr_msg,out
		end
create
	make

feature{NONE}

	model: SPACE_DEFENDER

		local
			ma: SPACE_DEFENDER_ACCESS
		do
			Result := ma.m
		end

feature
	make
		do
--			energy:=-50
		end







feature

	execute
		do

		end
--	equip_msg:STRING
--		DO
--			result:="%N  Power Selected:Recall (50 energy): Teleport back to spawn."
--		end

--	pwr_msg:STRING
--		do
--			result:="Recall (50 energy): Teleport back to spawn."
--		end
	state_msg:STRING
		do
			result:="setup summary"
		end

	out:STRING
		do
			result:=""
			across model.setup_pkg is pkg
			loop
				if attached pkg as p then
					result:=result+p.equip_msg

				end
			end


		end
end

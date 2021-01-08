note
	description: ""
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ETF_SETUP_BACK
inherit
	ETF_SETUP_BACK_INTERFACE
create
	make
feature -- command
	setup_back(state: INTEGER_32)
--		local
--			tmp:INTEGER
		require else
			setup_back_precond(state)
    	do
			-- perform some update on the model state


			if model.flag_setup_mode then
				if model.setup_cursor-state <=0 then

					model.setup_cursor_decrese(model.setup_cursor-1)
					model.toggle_flag_setup_mode
					model.toggle_flag_first_game
					model.set_state ("not started")
					model.set_message ("%N  Welcome to Space Defender Version 2.")
				else
					model.setup_cursor_decrese(state)
					if attached model.setup_pkg.at (model.setup_cursor) as pkg then
						model.set_state (pkg.state_msg)
					end
				end
			elseif model.flag_first_game then
				model.set_state("not started")
				model.toggle_flag_error_or_ok
				model.set_message ("%N  Command can only be used in setup mode.")
			elseif model.flag_game_mode then
				model.toggle_flag_error_or_ok
				model.set_message ("%N  Command can only be used in setup mode.")
				model.invalid_com
			end
			



			etf_cmd_container.on_change.notify ([Current])
    	end

end

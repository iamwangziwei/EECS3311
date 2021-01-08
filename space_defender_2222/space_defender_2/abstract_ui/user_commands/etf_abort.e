note
	description: ""
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ETF_ABORT
inherit
	ETF_ABORT_INTERFACE
create
	make
feature -- command
	abort
    	do
			-- perform some update on the model state
--			model.default_update
			if model.flag_first_game then
				model.set_message ("%N  Command can only be used in setup mode or in game.")
				model.toggle_flag_error_or_ok
			elseif model.flag_setup_mode then
				model.set_message ("%N  Exited from setup mode.")
				model.set_state ("not started")
				model.toggle_flag_setup_mode
--				model.toggle_flag_first_game
				model.abort
			elseif model.flag_game_mode then
				model.set_message ("%N  Exited from game.")
				model.set_state ("not started")
				model.toggle_flag_game_mode
				model.abort
			end
			etf_cmd_container.on_change.notify ([Current])
    	end

end

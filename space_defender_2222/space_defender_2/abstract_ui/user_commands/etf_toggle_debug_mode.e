note
	description: ""
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ETF_TOGGLE_DEBUG_MODE
inherit
	ETF_TOGGLE_DEBUG_MODE_INTERFACE
create
	make
feature -- command
	toggle_debug_mode
    	do
			-- perform some update on the model state
			model.toggle_debug_mode
			model.toggle_flag_print_debug_msg
			if model.flag_debug_mode then
				model.set_message ("%N  In debug mode.")
				if model.flag_game_mode then
					model.invalid_com
				end
--				
			else
				model.set_message ("%N  Not in debug mode.")
				if model.flag_game_mode then
					model.invalid_com
				end
			end

			etf_cmd_container.on_change.notify ([Current])
    	end

end

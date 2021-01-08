note
	description: ""
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ETF_SETUP_NEXT
inherit
	ETF_SETUP_NEXT_INTERFACE
create
	make
feature -- command
	setup_next(state: INTEGER_32)
		require else
			setup_next_precond(state)
    	do
			-- perform some update on the model state
			if  not model.flag_setup_mode then
				model.toggle_flag_error_or_ok
				model.invalid_com
				model.set_message ("%N  Command can only be used in setup mode.")
			else
				model.setup_cursor_increase(state)
				if attached model.setup_pkg.at (model.setup_cursor) as pkg then
					model.set_state (pkg.state_msg)
				end
--				model.set_state (model.setup_pkg.at (model.setup_cursor).state_msg)
--				model.print_setup_msg
				if model.setup_cursor>5 then
--					model.print_setup_msg
					model.gameboard.sf.set_sf_pkg (model.setup_pkg)
					model.gameboard.sf.sf_setup_all
					model.toggle_flag_game_mode
					model.toggle_flag_setup_mode
				end
			end




			etf_cmd_container.on_change.notify ([Current])
    	end

end

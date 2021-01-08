note
	description: ""
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ETF_SETUP_SELECT
inherit
	ETF_SETUP_SELECT_INTERFACE
create
	make
feature -- command
	setup_select(value: INTEGER_32)
		require else
			setup_select_precond(value)
    	do
			-- perform some update on the model state
			if  model.flag_first_game  then

				model.set_state ("not started")
				model.toggle_flag_error_or_ok
				model.set_message ("%N  Command can only be used in setup mode (excluding summary in setup).")
--			elseif not model.flag_first_game  then print("not flag_first_game")
			elseif model.flag_game_mode then
				model.invalid_com
				model.toggle_flag_error_or_ok
				model.set_message ("%N  Command can only be used in setup mode (excluding summary in setup).")
			elseif model.flag_setup_mode
			then


				if model.setup_cursor=2 and value=5
				then
					model.set_message ("%N  Menu option selected out of range.")
					model.toggle_flag_error_or_ok
				elseif model.setup_cursor=3 and value=5
				then model.set_message ("%N  Menu option selected out of range.")
					model.toggle_flag_error_or_ok
				elseif model.setup_cursor=3 and value=4
				then model.set_message ("%N  Menu option selected out of range.")
					model.toggle_flag_error_or_ok

				elseif model.setup_cursor=5 then
					model.set_message ("%N  Command can only be used in setup mode (excluding summary in setup).")
					model.toggle_flag_error_or_ok
				else
					model.transision (model.setup_cursor,value )
				end

			end

			etf_cmd_container.on_change.notify ([Current])
    	end

end

note
	description: ""
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ETF_PLAY
inherit
	ETF_PLAY_INTERFACE
create
	make
feature -- command
	play(row: INTEGER_32 ; column: INTEGER_32 ; g_threshold: INTEGER_32 ; f_threshold: INTEGER_32 ; c_threshold: INTEGER_32 ; i_threshold: INTEGER_32 ; p_threshold: INTEGER_32)
		require else
			play_precond(row, column, g_threshold, f_threshold, c_threshold, i_threshold, p_threshold)
    	do
			-- perform some update on the model state
			if model.flag_setup_mode then
				model.toggle_flag_error_or_ok
				model.set_message ("%N  Already in setup mode.")
			elseif model.flag_game_mode then
				model.toggle_flag_error_or_ok
				model.set_message ("%N  Already in a game. Please abort to start a new one.")
				model.invalid_com
			elseif g_threshold > f_threshold or f_threshold >c_threshold or c_threshold > i_threshold or i_threshold >p_threshold then
				model.toggle_flag_error_or_ok
				model.set_message ("%N  Threshold values are not non-decreasing.")
			else

				model.play(row, column, g_threshold, f_threshold, c_threshold, i_threshold, p_threshold)

			end

			etf_cmd_container.on_change.notify ([Current])
    	end

end

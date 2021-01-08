note
	description: ""
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ETF_MOVE
inherit
	ETF_MOVE_INTERFACE
create
	make
feature -- command
	move(row: INTEGER_32 ; column: INTEGER_32)
		require else
			move_precond(row, column)
		local
			mv:TURN
			newpos:POSITION
			oldpos:POSITION
			t1:INTEGER
			t2:INTEGER
    	do
			-- perform some update on the model state
--			model.default_update
			if not model.flag_game_mode then
				model.toggle_flag_error_or_ok
				model.set_message("%N  Command can only be used in game.")
			else
				oldpos:= model.gameboard.sf.position
				create newpos.make (row, column)
				if
					newpos.row >model.gameboard.board_row or newpos.col >model.gameboard.board_column
				then
					model.toggle_flag_error_or_ok
					model.set_message("%N  Cannot move outside of board.")
					model.invalid_com
				elseif
					oldpos ~ newpos
				then
					model.set_message ("%N  Already there.")
					model.toggle_flag_error_or_ok
					model.invalid_com


				elseif oldpos.distance_between (newpos) > model.gameboard.sf.move then
					model.set_message ("%N  Out of movement range.")
					model.toggle_flag_error_or_ok
					model.invalid_com
--not enough resource
				elseif oldpos.distance_between (newpos) * model.gameboard.sf.move_cost > model.gameboard.sf.estimate_energy then

					model.set_message ("%N  Not enough resources to move.")
					model.toggle_flag_error_or_ok
					model.invalid_com
				else
--use turn
					create {TURN_MOVE}mv.make (newpos)
					mv.execute

					model.valid_com
				end

	--	



			end



			etf_cmd_container.on_change.notify ([Current])
    	end

end

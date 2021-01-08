note
	description: ""
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ETF_PASS
inherit
	ETF_PASS_INTERFACE
create
	make
feature -- command
	pass


    	do
			-- perform some update on the model state


			if not model.flag_game_mode then
				model.toggle_flag_error_or_ok
				model.set_message("%N  Command can only be used in game.")
			else

				model.pass

				model.valid_com

			end

--			model.default_update
			etf_cmd_container.on_change.notify ([Current])
    	end

end

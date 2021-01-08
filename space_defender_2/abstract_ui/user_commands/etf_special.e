note
	description: ""
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ETF_SPECIAL
inherit
	ETF_SPECIAL_INTERFACE
create
	make
feature -- command
	special
		local

    	do
			-- perform some update on the model state
--			model.default_update
			if not model.flag_game_mode then
				model.toggle_flag_error_or_ok
				model.set_message("%N  Command can only be used in game.")
			else
--need error msg
--				model.gameboard.special
				if attached model.gameboard.sf.setup_pkg.at (4)  as pkg then

					if pkg.special_cost_type=1 then

						if pkg.energy > model.gameboard.sf.estimate_health then
							model.toggle_flag_error_or_ok
							model.invalid_com
							model.set_message("%N  Not enough resources to use special.")
						else
							model.special
							model.valid_com

						end
					elseif pkg.special_cost_type=2 then
						if pkg.energy > model.gameboard.sf.estimate_energy then
							model.toggle_flag_error_or_ok
							model.invalid_com
							model.set_message("%N  Not enough resources to use special.")
						else
							model.special
							model.valid_com
						end
					end

				end


			end
			etf_cmd_container.on_change.notify ([Current])
    	end

end

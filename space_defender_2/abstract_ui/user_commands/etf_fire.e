note
	description: ""
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ETF_FIRE
inherit
	ETF_FIRE_INTERFACE
create
	make
feature -- command
	fire

    	do
			-- perform some update on the model state
--			model.default_update


			if not model.flag_game_mode then
				model.toggle_flag_error_or_ok
				model.set_message("%N  Command can only be used in game.")
			else
				--"%N  Not enough resources to fire."
				if attached model.gameboard.sf.setup_pkg.at (1) as pkg then
					if pkg.projectile_cost_type=1 then
						if pkg.projectile_cost > model.gameboard.sf.estimate_health then
							model.toggle_flag_error_or_ok
							model.invalid_com
							model.set_message("%N  Not enough resources to fire.")
						else
							model.fire
							model.valid_com

						end
					elseif pkg.projectile_cost_type=2 then
						if pkg.projectile_cost > model.gameboard.sf.estimate_energy then
							model.toggle_flag_error_or_ok
							model.invalid_com
							model.set_message("%N  Not enough resources to fire.")
						else
							model.fire
							model.valid_com
						end
					end








					end


			end




			etf_cmd_container.on_change.notify ([Current])
    	end

end

note
	description: "Summary description for {SPECIAL_RECALL}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	SPECIAL_RECALL

inherit
	SPECIALS
		redefine
			equip_msg,pwr_msg,out
		end
create
	make

feature
	make
		do
			energy:=50
			special_cost_type:=2
		end







feature

	execute
	local
			temp1:INTEGER
		do
			gameboard.sf.change_actual_energy (-energy)
				gameboard.game_board[gameboard.sf.position.row ,gameboard.sf.position.col]:='_'

				if gameboard.board_row\\2 = 1 then
					temp1:=gameboard.board_row//2+1
				elseif gameboard.board_row\\2 = 0 then
					temp1:=gameboard.board_row//2
				end
				gameboard.sf.set_position (create {POSITION}.make (temp1, 1))
				gameboard.sf.set_action_msg("    The Starfighter(id:0) uses special, teleporting to: ["+gameboard.sf.correct_row (gameboard.sf.position.row ).out+",1]%N")
				gameboard.sf_check_collison(create {POSITION}.make (temp1, 1))
				if gameboard.sf.collide_with_others_msg.count>0 then
					gameboard.sf.set_sf_action_msg(gameboard.sf.collide_with_others_msg)
					gameboard.sf.clear_collide_with_others_msg
				end
				if gameboard.sf.destroy_others_msg.count >0 then
					gameboard.sf.set_sf_action_msg(gameboard.sf.destroy_others_msg)
					gameboard.sf.clear_destroy_others_msg
				end

				if gameboard.sf.destroyed then
					gameboard.game_board[gameboard.sf.position.row ,gameboard.sf.position.col]:='X'
				else
					gameboard.game_board[gameboard.sf.position.row ,gameboard.sf.position.col]:='S'
				end






		end
	equip_msg:STRING
		DO
			result:="%N  Power Selected:Recall (50 energy): Teleport back to spawn."
		end

	pwr_msg:STRING
		do
			result:="Recall (50 energy): Teleport back to spawn."
		end

	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

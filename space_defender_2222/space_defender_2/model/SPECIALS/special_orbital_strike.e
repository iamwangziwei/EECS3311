note
	description: "Summary description for {SPECIAL_ORBITAL_STRIKE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	SPECIAL_ORBITAL_STRIKE
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
			energy:=100
			special_cost_type:=2
		end


feature

	execute
		local
			t1:INTEGER
		do
			gameboard.sf.change_actual_energy (-energy)
			gameboard.sf.set_action_msg("    The Starfighter(id:0) uses special, unleashing a wave of energy.%N")
			across gameboard.enemy is e
			loop
				if e.valid then
					t1:=100-e.armour
					e.change_actual_health(-t1)
					gameboard.sf.set_sf_action_msg("      A "+e.name.out+"(id:"+e.id.out+") at location ["+e.position.correct_row.out+","+e.position.col.out+"] takes "+t1.out+" damage.%N")
					if e.collide then
						gameboard.sf.set_sf_action_msg("      The "+e.name.out+" at location ["+e.position.correct_row.out+","+e.position.col.out+"] has been destroyed.%N")
						gameboard.game_board[e.position.row,e.position.col]:='_'
						gameboard.sf.sf_focus.add (e.drop)
					end
				end
			end
		end
	equip_msg:STRING
		DO
			result:="%N  Power Selected:Orbital Strike (100 energy): Deal 100 damage to all enemies, affected by armour."

		end

	pwr_msg:STRING
		do
			result:="Orbital Strike (100 energy): Deal 100 damage to all enemies, affected by armour."
		end

	out:STRING
		do
			result:=intro_msg + equip_msg
		end
end

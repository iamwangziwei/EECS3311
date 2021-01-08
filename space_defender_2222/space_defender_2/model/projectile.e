note
	description: "Summary description for {PROJECTILE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	PROJECTILE
create
	make


feature{NONE}

	gameboard: GAMEBOARD
			-- access board via singleton
		local
			ma: SPACE_DEFENDER_ACCESS
--		once
		do
			Result := ma.m.gameboard
		end

feature
--	pjt_row:INTEGER
--	pjt_column:INTEGER
	pjt_mov:INTEGER
	pjt_position:POSITION
	before_position:POSITION

	id:INTEGER

	is_valid:BOOLEAN
	damage:INTEGER
	collide:BOOLEAN
	collide_by_others:BOOLEAN
	symbol:CHARACTER
	collide_with_others_msg:STRING
	destroy_others_msg:STRING
	flag_has_moved:BOOLEAN
--for weapon rocket
	count:INTEGER
feature
	make(position:POSITION;mov:INTEGER;pjt_id:INTEGER;dam:INTEGER;pjtsymbol:CHARACTER)
	do

		pjt_mov:=mov

		pjt_position:=position
		before_position:=pjt_position

		id:=pjt_id
		damage:=dam
		is_valid:=true
		collide:=false
		collide_by_others:=false
		symbol:=pjtsymbol
		collide_with_others_msg:=""
		destroy_others_msg:=""

--for weapon rocket	
		count:=1

		flag_has_moved:=false
	end

--	board:BOARD


feature  --change para
	change_damage(da:INTEGER)
		do
			damage:=da
		ensure
			damage=da
		end
	change_pjt_mov(mv:INTEGER)
		do
			pjt_mov:=mv
		end
	change_count
		do
			count:=count+1
		end
	set_position(pos:POSITION)
--		require
--			valid_position: pos.col>0 and pos.row >0 -- and pos.row <=gameboard.board_row  and pos.col <=  gameboard.board_column
		local
			t1:POSITION
			t2:POSITION
		do
			create t1.make (pjt_position.row , pjt_position.col)
			before_position:=t1
			create t2.make (pos.row, pos.col)
			pjt_position:=t2
		ensure
			pjt_has_moved: before_position ~ old pjt_position and pjt_position ~ pos
		end
feature
	toogle_collide
		do
			if collide then

			else
				collide := true
				collide_by_others:=false
			end
		end
	toogle_collide_by_others
		do
			if collide_by_others then

			else
				collide_by_others := true
			end
		end
	toggle_flag_has_moved
		do
			if flag_has_moved then
				flag_has_moved := false
			else
				flag_has_moved := true
			end
		end
feature --move the pjt

	pjt_forth
	require
		pjt_is_valilid: is_valid
	local
		 po:POSITION
	do
		before_position:=pjt_position
		create po.make (pjt_position.row , pjt_position.col+pjt_mov)
--		pjt_column:=pjt_column+pjt_mov
		pjt_position:=po
	ensure
		pjt_has_moved: pjt_position.row ~ before_position.row
	end


	pjt_top_right
		do

		end

	pjt_btm_right
		do

		end
	destination:POSITION
		local
			 po:POSITION
		do
			create po.make (pjt_position.row , pjt_position.col+pjt_mov)
			result:=po
		end

feature--flags
	valid:BOOLEAN

		do
			result:=not collide and flag_pjt_on_board and not collide_by_others
--		ensure
--			result=not collide and flag_pjt_on_board and not collide_by_others
		end


	flag_pjt_on_board:BOOLEAN
		do
			if pjt_position.row >gameboard.board_row or pjt_position.col>gameboard.board_column
				or pjt_position.row <= 0 or pjt_position.col<=0
			then
				result:=false
			else
				result:=true
			end
		end
	flag_pjt_before_on_board:BOOLEAN
		do
			if before_position.row >gameboard.board_row or before_position.col>gameboard.board_column
				or before_position.row <= 0 or before_position.col<=0
			then
				result:=false
			else
				result:=true
			end
		end

feature-- check for collision
	set_collide_with_others_msg(othername:STRING;otherid:INTEGER;otherpos:POSITION;othermsg:STRING)
		do
			collide_with_others_msg:=collide_with_others_msg
			+"      The projectile collides with "+othername+"(id:"+otherid.out+") at location ["+gameboard.sf.correct_row (otherpos.row).out+","+otherpos.col.out+"], "+othermsg+".%N"
		end
	clear_collide_with_others_msg
		do
			collide_with_others_msg:=""
		end
	set_destroy_others_msg(othername:STRING;otherpos:POSITION)
		do
			destroy_others_msg:=destroy_others_msg
			+ "      The "+othername+" at location ["+otherpos.correct_row.out+","+otherpos.col.out+"] has been destroyed.%N"
		end
	clear_destroy_others_msg
		do
			destroy_others_msg:=""
		end



end



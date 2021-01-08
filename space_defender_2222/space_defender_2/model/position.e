note
	description: "Summary description for {POSITION}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	POSITION
inherit
	ANY
		redefine is_equal end
create
	make,
	make_by_position

feature{NONE}
	make(mv_row,mv_col: INTEGER)
			-- may not be a valid square
		do
			row := mv_row
			col:= mv_col

		end
	make_by_position(position:POSITION)
		do
			row:=position.row
			col:=position.col
		end

	gameboard: GAMEBOARD
			-- access board via singleton
		local
			ma: SPACE_DEFENDER_ACCESS
		once
			Result := ma.m.gameboard
		end
	is_equal (other:POSITION):BOOLEAN
		do
			if current.col = other.col and current.row =other.row
			then
				result:=true
			else
				result:=false
			end
		end



feature
	to_right(mv:INTEGER):POSITION
		local
			newpo:POSITION
		do
			create newpo.make (row,col+mv )
			result:=newpo
		end
feature --query
	distance_between(other:POSITION):INTEGER
		do
			result:=(other.row -row).abs + (other.col -col).abs
		end

	correct_row:CHARACTER
--		local c_row:CHARACTER
		do
			if row=1 then
				result:='A'
			elseif
				row=4 then result:='D'
			elseif row=3 then result:='C'
			elseif row=10 then result:='J'
			elseif row=6 then result:='F'
			elseif row=5 then result:='E'
			elseif row=2 then result:='B'
			elseif row=7 then result:='G'
			elseif row=9 then result:='I'
			elseif row=8 then result:='H'
			else
			end

	
		end

feature
	row: INTEGER

	col:INTEGER


end

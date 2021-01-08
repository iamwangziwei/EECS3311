note
	description: "Summary description for {STAR_FIGHTER}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	STAR_FIGHTER
inherit
	ANY
		redefine
			out
		end
create
	make

--feature -- Attributes
--	-- may declare your own model state here
--	model : SPACE_DEFENDER

--feature{NONE}

--	get_setup_pkg:HASH_TABLE[STRING,INTEGER]
--		local
--			ma: SPACE_DEFENDER_ACCESS
--		do
--			result:=	ma.m.setup_pkg
--			print(result.count)
--		end

feature-- attribute
--	weapon:WEAPON
--	armourrrrrr:ARMOUR


	health:INTEGER
	energy:INTEGER
	regen_health:INTEGER
	regen_energy:INTEGER
	armour:INTEGER
	vision:INTEGER
	move:INTEGER
	move_cost:INTEGER
	setup_pkg:HASH_TABLE[SETUP_STATE,INTEGER]
	symbol:CHARACTER

	actual_health:INTEGER
	actual_energy:INTEGER

	before_position:POSITION
	position:POSITION

--	score:INTEGER
	destroyed:BOOLEAN

--collide with other msg
	collide_with_others_msg:STRING
	destroy_others_msg:STRING
	sf_action_msg:STRING
	action_msg:STRING
--score
	sf_focus:SF_FOCUS
--	df1:ORB
--	df2:ORB
--	df3:ORB
--	df4:ORB
--	ob1:ORB
--	ob2:ORB
--	ob3:ORB
--	ob4:ORB
--	ob5:ORB
--	ob6:ORB
--	ob7:ORB
--	ob8:ORB
feature
	make(row:INTEGER;column:INTEGER)
	do
		create position.make (row, column)
		create before_position.make(row, column)
		create setup_pkg.make (5)

		symbol:='S'

		destroyed:=false
		collide_with_others_msg:=""
		destroy_others_msg:=""
		sf_action_msg:=""
		action_msg:=""
--score
		create {SF_FOCUS}sf_focus.make_focus

--		create {DIAMOND_FOCUS}df1.make_focus
--		create {DIAMOND_FOCUS}df2.make_focus
--		create {GOLD_ORB}ob1.make
--		create {BRONZE_ORB}ob2.make
--		create {BRONZE_ORB}ob3.make
--		create {SILVER_ORB}ob4.make
--		create {SILVER_ORB}ob5.make
--		create {SILVER_ORB}ob6.make
--		create {SILVER_ORB}ob7.make
--		create {BRONZE_ORB}ob8.make
--		create {PLATINUM_FOCUS}df3.make_focus
--		create {PLATINUM_FOCUS}df4.make_focus
--		sf_focus.add (df3)
--		sf_focus.add (ob1)
------		sf_focus.add (ob1)

------		
----------		sf_focus.add (ob)
----------		sf_focus.add (ob)
--		sf_focus.add (df1)
--		sf_focus.add (ob2)
--		sf_focus.add (ob3)
--		sf_focus.add (ob4)
--		sf_focus.add (ob5)
----		sf_focus.add (df1)
----		sf_focus.add (ob3)
--		sf_focus.add (df2)
--		sf_focus.add (ob6)
--		sf_focus.add (ob7)
--		sf_focus.add (df4)
--		sf_focus.add (ob8)
--		print(sf_focus.focus_list.count.out+"%N")
--		if attached sf_focus.focus_list.at (3) as a then
--			
--		end
--		sf_focus.add (ob2)
--		sf_focus.add (ob2)
--		sf_focus.add (ob1)
----		sf_focus.add (ob2)
--				score.add_item (df)
----		score.add_item (df)
----		score.add_item (df)
--		print("sf cfocsu list count :" +sf_focus.focus_list.count.out)


	end
feature{NONE}

	gameboard: GAMEBOARD
		local
			ma: SPACE_DEFENDER_ACCESS
--		once
		do
			Result := ma.m.gameboard
		end

feature --sf setup




--can creat a new generic class for setup_all
	set_sf_pkg(pkg:HASH_TABLE[SETUP_STATE,INTEGER])
		do
			setup_pkg:=pkg
		end
	sf_setup_all
		do
			set_health
			set_energy
			set_regen_health
			set_regen_energy
			set_armour
			set_vision
			set_move
			set_move_cost

			actual_health:=health
			actual_energy:=energy

		end
	set_health
		do
			across 1 |..| setup_pkg.count  is i
			loop
				if attached setup_pkg.at (i) as ii then health :=health+ii.health

				end

			end

		end


	set_energy
		do
			across 1 |..| 3  is i
			loop
				if attached setup_pkg.at (i) as ii then energy :=energy+ii.energy   end

			end
		end

	set_regen_health
		do
			across 1 |..| setup_pkg.count  is i
			loop
				if attached setup_pkg.at (i) as ii then regen_health :=regen_health+ii.regen_health   end

			end
		end

	set_regen_energy
		do
			across 1 |..| setup_pkg.count  is i
			loop
				if attached setup_pkg.at (i) as ii then regen_energy :=regen_energy+ii.regen_energy   end

			end
		end

	set_armour
		do
			across 1 |..| setup_pkg.count  is i
			loop
				if attached setup_pkg.at (i) as ii then armour :=armour+ii.armour   end

			end
		end


	set_vision
		do
			across 1 |..| setup_pkg.count  is i
			loop
				if attached setup_pkg.at (i) as ii then vision :=vision+ii.vision   end

			end
		end

	set_move
			do
				across 1 |..| setup_pkg.count  is i
				loop
					if attached setup_pkg.at (i) as ii then move :=move+ii.move   end

				end
			end
	set_move_cost
		do
			across 1 |..| setup_pkg.count  is i
			loop
				if attached setup_pkg.at (i) as ii then move_cost :=move_cost+ii.move_cost  end

			end
		end

	set_position(pos:POSITION)
		do
			before_position:=position
			position:=pos
		end


feature --estimate
	estimate_health:INTEGER
		do
			if actual_health>health then

				result:=actual_health

			else
				result:=actual_health+regen_health
				if result > health then
					result:=health
				end

			end
		end

	estimate_energy:INTEGER
		do
			if actual_energy>energy then

				result:=actual_energy

			else
				result:=actual_energy+regen_energy
				if result > energy then
					result:=energy
				end

			end
		end


feature  --adjust parameter
	regen
		do
			change_actual_health(regen_health)
			change_actual_energy(regen_energy)
		end
	change_special_health(ah:INTEGER)
		do
			actual_health:=actual_health+ah

		end
	change_actual_health(ah:INTEGER)
		do
			if actual_health>health then
				if ah>0 then
				else
					actual_health:=actual_health+ah

				end
			else
				actual_health:=actual_health+ah
				if actual_health > health then
					actual_health:=health
				end
			end


			if actual_health<=0 then
				actual_health:=0
				destroyed:=true
				symbol:='X'
			end
		end

	change_special_energy(ae:INTEGER)
		do
			actual_energy:=actual_energy+ae

		end

	change_actual_energy(ah:INTEGER)
		do
			if actual_energy>energy then
				if ah>0 then
				else
					actual_energy:=actual_energy+ah
				end
			else
				actual_energy:=actual_energy+ah
				if actual_energy > energy then
					actual_energy:=energy
				end
			end


		end

	set_symbol(s:CHARACTER)
		do
			symbol:=s
		end
--	set_score(n:INTEGER)
--		do
--			score:=score+n
--		end

feature
	prp_fire
		do

		end
	prp_pass
		do

		end
feature -- set_action_msg
	set_action_msg(msg:STRING)
		do
			action_msg:=msg
		end
	set_sf_action_msg(msg:STRING)
		do
			sf_action_msg:=sf_action_msg+msg
		end
	clear_sf_action_msg
		do
			sf_action_msg:=""
			action_msg:=""
		end

	set_collide_with_others_msg(othername:STRING;otherid:INTEGER;otherpos:POSITION;othermsg:STRING)
		do
			collide_with_others_msg:=collide_with_others_msg
			+"      The Starfighter collides with "+othername+"(id:"+otherid.out+") at location ["+otherpos.correct_row.out+","+otherpos.col.out+"], "+othermsg+".%N"
			set_sf_action_msg(collide_with_others_msg)
			clear_collide_with_others_msg
		end
	clear_collide_with_others_msg
		do
			collide_with_others_msg:=""
		end
	set_destroy_others_msg(othername:STRING;otherpos:POSITION)
		do
			destroy_others_msg:=destroy_others_msg
			+ "      The "+othername+" at location ["+otherpos.correct_row.out+","+otherpos.col.out+"] has been destroyed.%N"
			set_sf_action_msg(destroy_others_msg)
			clear_destroy_others_msg
		end
	clear_destroy_others_msg
		do
			destroy_others_msg:=""

		end
feature --helper function
	pjt_pt_msg:STRING
	do
		result:=""
		if attached setup_pkg.at (1) as j then
			result:=j.pjt_pattern
		end
	end

	pjt_damage_msg:INTEGER
		do
			result:=0
			if attached setup_pkg.at (1) as j then
				result:=j.projectile_damage
			end
		end
	pjt_cost_msg:INTEGER
		do
			result:=0
			if attached setup_pkg.at (1) as j then
				result:=j.projectile_cost
			end
		end
	pjt_cost_type_msg:STRING
	do
		result:=""
		if attached setup_pkg.at (1) as j then
			if j.projectile_cost_type =1 then result:=" (health)"
			elseif j.projectile_cost_type =2 then result:=" (energy)"
			end

		end
	end


	ep_msg:STRING
		do
			result:=""
			if attached setup_pkg.at (4) as j then
				result:=j.pwr_msg
			end
		end


	correct_row(row:INTEGER):CHARACTER
		local c_row:CHARACTER
		do
			if row=1 then
				c_row:='A'
			elseif
				row=4 then c_row:='D'
			elseif row=3 then c_row:='C'
			elseif row=10 then c_row:='J'
			elseif row=6 then c_row:='F'
			elseif row=5 then c_row:='E'
			elseif row=2 then c_row:='B'
			elseif row=7 then c_row:='G'
			elseif row=9 then c_row:='I'
			elseif row=8 then c_row:='H'
			else
			end

			result:=c_row
		end

feature-- sf out
	out:STRING
	do
		result:=""










		result.append("%N  Starfighter:")

		result.append ("%N    [0,S]->health:"+actual_health.out+"/"+health.out+", energy:"+actual_energy.out+"/"+energy.out+", Regen:"+regen_health.out+"/"+regen_energy.out+
						", Armour:"+armour.out+", Vision:"+vision.out +", Move:"+move.out+", Move Cost:"+move_cost.out+", location:["+correct_row(position.row).out +","+position.col.out+"]"+"%N"
						+"      Projectile Pattern:" +pjt_pt_msg+", Projectile Damage:"+pjt_damage_msg.out+", Projectile Cost:"+pjt_cost_msg.out +pjt_cost_type_msg.out
						+"%N      Power:"+ep_msg+


						  "%N      score:"+sf_focus.get_score.out+


						  "%N"

						)
	end



end

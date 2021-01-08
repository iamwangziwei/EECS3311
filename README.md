# Space Defender

### Background
Many years have passed since the first battle between the creatures of the Void and humankind. Time changes everything. With the research branch at work, the current iteration of Starfighter feature customizable parts for weapons, armour and engine, allowing for specialization based on the battlefield. In addition, salvaged parts (orbment and focus) from the enemy units have allowed for development of special abilities for Starfighters. The countless engagements with the enemy monsters allowed for a better understanding of them. So far, five different types of enemy units have been discovered. First is the generic Grunt. Next is the improved version of a Grunt, the Fighter. We have the large Carrier which releases a torrent of drones known as Interceptor. The Interceptor’s goal is to simply absorb projectile damage, serving as a shield to other units. Finally, a massive structure called Pylon which heals surrounding units. The enemy units appear to behave differently based on how the Starfighter acts and whether they see the Starfighter or not.


### How to run it
- Download the zip folder
     
- get into the folder   
  ```
    $ cd space_defender_2
  ```
- compile the project.  
  ```
    $ estudio space_defender_2.ecf &            
  ```
- execute the generated code in Interactive Mode  
  ```
    $ EIFGENs/space_defender_2/W_code/space_defender_2 -i
  ```
    
    
    
### How to play it
- Initial state





0. See this tutorial video to get started:

	https://www.youtube.com/watch?v=pjXjlPNpb5c&list=PL5dxAmCmjv_5q9wBFXV-M4S4VbB1T0EJg&index=9

1. Upload the starter `space_defender_2.zip` to your Prism account (e.g., via an FTP program).
	Unzip it: unzip space_defender_2.zip

2. Login to your Prism account, change the current directory to this starter folder, then run the following command:

	etf -new space_defender_2.grammar.txt .

3. Do the following re-arrangements of files:
	A. Move the given acceptance tests to the `tests/acceptance/instructor` folder:

		at001.txt
		at001.expected.txt
		at002.txt
		at002.expected.txt
		...
		at015.txt
		at015.expected.txt
		
	B. Move the following files to the `docs` folder:
		
		messages.txt
		errors.txt
		space_defender_2.grammar.txt
		starter_code (this project contains two classes which you are expected to reuse verbatim: see the "Getting Starter" section in the PDF instructions)
 
4. Change the root class:

	A. Run: gedit root/root.e &

	B. Change the `switch` query so that `eft_cl_show_history` is uncommented:
		
		feature -- Queries
			switch: INTEGER
					-- Running mode of ETF application
				do
		--			Result := etf_gui_show_history 	-- GUI mode
					Result := etf_cl_show_history
		--			Result := unit_test 			-- Unit Testing mode
				end

5. Compile the project:

	ec19.05 -c_compile -freeze -config space_defender_2.ecf

6. Change the current directory to: `regression-testing`.

7. Invoke the regression testing script: ./ETF_Test.py

8. Then you should see a message saying that NONE of the three starter tests passed.
	Actual outputs produced by your program are placed: log/instructor/at001.actual.txt
	Expected outputs produced by the oracle are placed: log/instructor/at001.expected.txt
	
	Use `meld` to see the difference between the actual and expected outputs. e.g.,
	
	meld log/instructor/at001.actual.txt log/instructor/at001.expected.txt &

9. How to go from here?
	
	A. Complete your development in "space_defender_2/abstract_ui/user_commands" and "space_defender_2/model".
	
	B. Add more test cases to "tests/acceptance/student".
	
	C. Constantly re-run the regression testing script (this is how you will be graded).
	
	D. Submit the intermediate version of your work constantly. 
>>>>>>> 9c6f906c4231f07426b47f5e3b5b8e9c09d7af74

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
    
    
    

### Introduce the command 

- **play()**   e.g., play(10,30,1,1,1,1,1)

  * The first two numbers are for specifying the size of the board (in this example, a 10-by-30 board). The first number represents the number of rows (ranging       from 5 to 10), whereas the second number represents the number of columns (ranging from 10 to 30).
  * Each of the remaining five numbers ranges from 1 to 101 and must be non-decreasing (e.g., invoking play( , , 101, 101, 60, 60, 1) should trigger an error         message). The combination of these last 5 numbers serves the following purpose: during the end of each turn in a game, a random number generator (RNG) is         used to generate two numbers (and we refer to the first number as i and the second number as j).
  
  Say the number of rows is r and the number of columns is c.
  * The first number i (ranging from 1 to r) determines which row in the last column of the board an enemy should spawn (i.e., an enemy should spawn at location [i,c]).
  * The second number (ranging from 1 to 100) is used to determine which enemy spawns.
  * From an invocation of the play command play( , ,n1,n2,n3,n4,n5), the last five numbers specify the thresholds for Grunt (n1), Fighter (n2), Carrier (n3), Interceptor (n4), and Pylon (n5). And these five threshold values suggest six intervals to consider for generating enemies
  * If the second number j is in the interval [1,n1) (i.e., between 1 inclusive and the grunt threshold
n1 exclusive), then a Grunt will spawn.
  * If the second number j is in the interval [n1, n2) (i.e., between grunt threshold inclusive and fighter
threshold exclusive), then a Fighter will spawn.
  ...
  * If the second number j is is in the interval [n5, 101) (i.e., between pylon threshold inclusive and 101
exclusive), then nothing is spawned.

- **abort**  
  * used to exit from either the setup stage (before a game starts) or the current turn (during a game).

- **toggle_debug_mode**
  * “flips” the debug mode (e.g., to on if it is currently off ). By default, the debug mode is initialized to off. If in game mode and the debug mode is on, the  abstract state displayed shows more information. Essentially, a normal game should have its debug mode switched off, whereas switching it on shows everything     in that state which allows for a programmer to debug.

- **toggle_RNG_out**
  * This command is available for use in the oracle provided. The purpose is to help you debug RNG (random number generator) usage. This command can be used anytime and toggles a flag on use.
 
- **setup_back()** and **setup_next()**
  * Navigating between each state in the setup stage
  
- **setup_select()**
  * select the Weapon, Armour, Engine, Power in the setup stage
  
- **move()**
  * move the star fighter

- **fire**
  * fire the projectile

- **pass**
  * the star fighter does nothing

- **special**
  * use the special power


#### Symbols
- ?: This symbol only shows up in normal mode. It represents the fog of war meaning from the perspective of the Starfighter, the location is too far away for the Starfighter to see what entity is in that location.   
- : This symbol means the location is not occupied by any entity.              
- G : This symbol means the location is occupied by a Grunt.           
- F : This symbol means the location is occupied by a Fighter.           
- C : This symbol means the location is occupied by a Carrier.           
- I : This symbol means the location is occupied by a Interceptor.      
- P : This symbol means the location is occupied by a Pylon.       
- < : This symbol means the location is occupied by an enemy projectile (fired by some kinds of enemies).         
- S : This symbol means the location is occupied by the Starfighter (which fires friendly projectiles).         
- * : This symbol means the location is occupied by a friendly projectile.          
- X : This symbol means the location is where the Starfighter was destroyed. This symbol is only present when the game is over due to destruction of the Starfighter.       

#### Starfighter’s attribute
- **Health**: It represents the maximum integrity of the entity (e.g., Starfighter, Grunt), also known as the total health. An entity’s current health value has the lower bound of 0 and upper bound of this maximum Health value. If the current health falls to 0, the entity is destroyed. Note that in the game, for the Starfighter only, it is possible for its current health value to exceed this maximum Health value by using a power.
 are three ways for exiting the setup stage: abort, setup back before the weapon state, or setup next beyond the
9
- **Energy**: It represents the maximum energy of the Starfighter, also known as the total energy. Note that the current energy cannot exceed total energy (with the exception of using a power). Energy is required for the Starfighter to move, to use a power, or to fire projectiles.
- **Regen**    (for regeneration):   
There are two numbers.The first number represents the amount of current health the Starfighter gains per turn passively
(health regeneration). 
Note. Regen is the base value for the (health or energy) regeneration process to take place.
- **Armour**: If the Starfighter and a projectile collide, the damage done to the Starfighter is the projectile’s damage minus the Starfighter’s armour. Armour does not have any cancelling effect on collisions with non-projectiles.
- **Vision**: It represents how many spaces away, on the board, the Starfighter can see from its current location.
For example, if the Starfighter is in [D,1], in normal mode, to see what entity is in [C,3], you need a vision of 3 (1 vertical + 2 horizontal) or more. Spaces beyond the range of the Starfighter’s vision are known to be in the fog of war and, in normal mode, are represented by a ? symbol on the board output.
Note that in debug mode, the fog of war is not displayed on the board output.
- **Move**: It represents how many spaces away the Starfighter can move from its current location (assuming it has enough energy). The distance calculation is the same as vision calculation: vertical distance plus
horizontal distance in terms of spaces.
- **Move Cost**: It represents how many energy unit it takes for the Starfighter to move 1 space. If the
move cost is 5 and we make a move from [A,1] to [D,3], it would cost 25 energy units: 5 spaces (3 vertical + 2 horizontal) × 5.


### Weapon Types
- **Standard**: One projectile is spawned. It appears to the right of the Starfighter. For example, if the Starfighter is at [A,2], the projectile appears at [A,3]. Every subsequent turn after, the projectile moves 5 units to the right.
- **Spread**: Three projectiles are spawned:
  * The first one is spawned to the top-right of the Starfighter, the second to the right of the Starfighter while
the last projectile is spawned to the bottom-right of the Starfighter. For example:
  * If the Starfighter is at [D,4], the projectiles appear at [C,5], [D,5] and [E,5] in that order.
  * Every subsequent turn after, the projectiles move 1 unit in the direction where they spawned relative to the Starfighter when it fired. 

- **Snipe**: One projectile is spawned. It appears to the right of the Starfighter. For example, if the Starfighter is at [A,2], the projectile appears at [A,3]. Every subsequent turn after, the projectile moves 8 units to the right.
-  **Rocket**: Two projectiles are spawned. The first one is spawned to the top-left of the Starfighter while the second projectile is spawned to the bottom-left of the Starfighter. 
- **Splitter**: One projectile is spawned. It appears to the right of the Starfighter. For example, if the Starfighter is at [A,2], the projectile appears at [A,3]. The projectile does not move.

### Special Power Types
- **Recall**: When you start a game, the Starfighter spawns in a certain location. When this special is used, teleport the Starfighter to that location.
- **Repair**: Increase current health by 50 units.
- **Overcharge**: This is to sacrifice current health for gaining current energy. This is dependent on the amount of the current health spent. It will use up to 50 current health as long as the Starfighter is not destroyed to convert to current energy. The conversion is: 1 current health for 2 current energy.
- **Deploy Drones**: Clears out all the projectiles on the board. The order of removal is from projectiles that
spawned earliest to latest.
- **Orbital Strike**: All enemies take 100 damage, reduced by their armour value. Suppose an enemy has 15 armour, they will take 85 (i.e., 100 - 15) damage. The order of taking damage is from enemies that spawned earliest to latest.

### Enemy Types
- **Grunt**, Health:100, Regen:1, Armour:1, Vision:5.
- **Fighter**, Health:150, Regen:5, Armour:10, Vision:10.
- **Carrier**, Health:200, Regen:10, Armour:15, Vision:15.
- **Interceptor**, Health:50, Regen:0, Armour:0, Vision:5.
- **Pylon**, Health:300, Regen:0, Armour:0, Vision:5.

### How to calculate the score
  - Scoring Components
    * A Grunt, on destruction, drops a silver orb worth 2 points. A Fighter drops a gold orb worth 3 points. An Interceptor drops a bronze orb worth 1 point.
    * Focuses are containers of orbments and if they are full, a score multiplier is applied to the sum of the score of the orbments the focus is holding.
      - A Carrier drops a diamond focus which has a gold orb in the first slot. A diamond focus has the capacity of 4 orbments and if it is full, a ×3 (triple) score multiplier is applied to the sum of the score of the 4 orbments.
      - A Pylon drops a platinum focus which has a bronze orb in the first slot. A platinum focus has the capacity of 3 orbments and if it is full, a ×2 (double) score multiplier is applied to the sum of the score of the 3 orbments.
      - A Starfighter has its own focus that has unlimited capacity (hence there is not a multiplier). Orbments obtained from destroying other enemies are added to it.
  - Combining Scoring Components
    * In order to add an orbment to a focus (whose capacity may or may not be fixed), traverses, from left to right, as follows:
      - If the current slot contains an orb, then skip (as an orbment cannot be added to an orb) and move on to the next slot.
      - If the current slot contains a focus where you can add an orbment, then add it there; otherwise, skip and move on to the next slot.
      - If the current slot is empty/unfilled, then add it there.
    * Whenever an enemy is destroyed, add the dropped orbment to the Starfighter’s focus, by applying the above traversal.
    
  - Calculating Scores
    * To calculate the score, traverse the Starfighter’s focus:
      - Orbs are worth the flat amounts as mentioned above.
      - The score of a focus is the sum of the score of each orbment in the focus. If every slot in that focus is occupied (even by another focus that is not itself full), apply the score multiplier to the sum of the score of each orbment in the focus.
    * There is no need to worry about integer overflow.
    * Score is not preserved between games.
      
### Let's play!

- **Initial state**
<img width="780" alt="Screen Shot 2021-01-07 at 9 26 06 PM" src="https://user-images.githubusercontent.com/35870166/104082506-bda53600-5204-11eb-99ec-d52792546428.png">  


- **Invoke the** ***play*** **command***

  <img width="831" alt="Screen Shot 2021-01-08 at 11 06 09 PM" src="https://user-images.githubusercontent.com/35870166/104082697-1b864d80-5206-11eb-8926-b93d8991d1a5.png">    

- **select the weapon using** ***setup_select()***
<img width="829" alt="Screen Shot 2021-01-08 at 11 37 39 PM" src="https://user-images.githubusercontent.com/35870166/104083167-80dc3d80-520a-11eb-9ea0-ad5b694ff4c0.png">    

- **go to next stage using** ***setup_next()***
<img width="778" alt="Screen Shot 2021-01-08 at 11 38 16 PM" src="https://user-images.githubusercontent.com/35870166/104083177-96516780-520a-11eb-9a2e-e01aafb7c77f.png">

- **select the armour**
<img width="748" alt="Screen Shot 2021-01-08 at 11 39 12 PM" src="https://user-images.githubusercontent.com/35870166/104083190-b7b25380-520a-11eb-9ad2-61c2b57cd4db.png">    

- **go to next stage**
<img width="749" alt="Screen Shot 2021-01-08 at 11 39 45 PM" src="https://user-images.githubusercontent.com/35870166/104083205-cb5dba00-520a-11eb-84d7-0b3bf664e59b.png">    


- **select the engine**
<img width="750" alt="Screen Shot 2021-01-08 at 11 40 57 PM" src="https://user-images.githubusercontent.com/35870166/104083222-f5af7780-520a-11eb-80d9-7e231c510ab7.png">    

- **go to next stage**
<img width="1019" alt="Screen Shot 2021-01-08 at 11 41 29 PM" src="https://user-images.githubusercontent.com/35870166/104083237-095ade00-520b-11eb-9301-21e09664d932.png">   

- **select special power**
<img width="1030" alt="Screen Shot 2021-01-08 at 11 42 19 PM" src="https://user-images.githubusercontent.com/35870166/104083254-28597000-520b-11eb-9feb-bc0b67b480c1.png">      

- **go to next stage**
<img width="901" alt="Screen Shot 2021-01-08 at 11 42 55 PM" src="https://user-images.githubusercontent.com/35870166/104083265-3c9d6d00-520b-11eb-867f-3eef3a16fe19.png">    

- **enter the game mode**
<img width="1010" alt="Screen Shot 2021-01-08 at 11 43 33 PM" src="https://user-images.githubusercontent.com/35870166/104083279-5343c400-520b-11eb-81d3-446aa3cc1819.png">    

- **use** ***move, fire, pass, special*** **to kill as many enemy as you can!**
<img width="1156" alt="Screen Shot 2021-01-08 at 11 50 17 PM" src="https://user-images.githubusercontent.com/35870166/104083408-48d5fa00-520c-11eb-8922-28945f46d97b.png">
<img width="1160" alt="Screen Shot 2021-01-08 at 11 51 17 PM" src="https://user-images.githubusercontent.com/35870166/104083426-686d2280-520c-11eb-9f70-c35b0f82503d.png">
<img width="1162" alt="Screen Shot 2021-01-08 at 11 52 16 PM" src="https://user-images.githubusercontent.com/35870166/104083448-8c306880-520c-11eb-8fef-26f66f860c36.png">
<img width="1159" alt="Screen Shot 2021-01-08 at 11 52 52 PM" src="https://user-images.githubusercontent.com/35870166/104083454-a10cfc00-520c-11eb-93c4-af3a03c745fb.png">
<img width="1158" alt="Screen Shot 2021-01-08 at 11 53 23 PM" src="https://user-images.githubusercontent.com/35870166/104083461-b3873580-520c-11eb-843c-c64868c49ccb.png">







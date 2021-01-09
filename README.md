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
- Health: It represents the maximum integrity of the entity (e.g., Starfighter, Grunt), also known as the total health. An entity’s current health value has the lower bound of 0 and upper bound of this maximum Health value. If the current health falls to 0, the entity is destroyed. Note that in the game, for the Starfighter only, it is possible for its current health value to exceed this maximum Health value by using a power.
 are three ways for exiting the setup stage: abort, setup back before the weapon state, or setup next beyond the
9
- Energy: It represents the maximum energy of the Starfighter, also known as the total energy. Note that the current energy cannot exceed total energy (with the exception of using a power). Energy is required for the Starfighter to move, to use a power, or to fire projectiles.
- Regen (for regeneration): There are two numbers.
⋄ The first number represents the amount of current health the Starfighter gains per turn passively
(health regeneration). Recall that the current health cannot exceed total health, so regeneration
only works up to the total health value (except with the use of a power).
⋄ The second number is for energy regeneration and it works the same way as health (with respect
to the Energy value above).
Note. Regen is the base value for the (health or energy) regeneration process to take place.
- Armour: If the Starfighter and a projectile collide, the damage done to the Starfighter is the projectile’s damage minus the Starfighter’s armour. Armour does not have any cancelling effect on collisions with non-projectiles.
- Vision: It represents how many spaces away, on the board, the Starfighter can see from its current location.
For example, if the Starfighter is in [D,1], in normal mode, to see what entity is in [C,3], you need a vision of 3 (1 vertical + 2 horizontal) or more. Spaces beyond the range of the Starfighter’s vision are known to be in the fog of war and, in normal mode, are represented by a ? symbol on the board output.
Note that in debug mode, the fog of war is not displayed on the board output.
- Move: It represents how many spaces away the Starfighter can move from its current location (assuming it has enough energy). The distance calculation is the same as vision calculation: vertical distance plus
horizontal distance in terms of spaces.
- Move Cost: It represents how many energy unit it takes for the Starfighter to move 1 space. If the
move cost is 5 and we make a move from [A,1] to [D,3], it would cost 25 energy units: 5 spaces (3 vertical + 2 horizontal) × 5.




- Initial state
<img width="780" alt="Screen Shot 2021-01-07 at 9 26 06 PM" src="https://user-images.githubusercontent.com/35870166/104082506-bda53600-5204-11eb-99ec-d52792546428.png">

- Invoke the **play** command, . 
 

  <img width="831" alt="Screen Shot 2021-01-08 at 11 06 09 PM" src="https://user-images.githubusercontent.com/35870166/104082697-1b864d80-5206-11eb-8926-b93d8991d1a5.png">

- 










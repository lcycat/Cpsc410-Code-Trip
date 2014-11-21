Cpsc410-Code-Trip
=================
Project group members:

James Ma, 
Kathy Ye, 
Jennifer Leung, 
Chenyang Li

=================
Works are mainly in classes of:

src/minecraft/net.mincraft.src package-

these are:

mod_CodeTrip,

codebase1block,

codebase2block,

CodeParser,

XMLParser.

and some of the exsiting classes are modified:
world,

createWorld,

ModLoader,

GuiMainMeun,

GuicreatWorld,

Block,

blockTNT,

TitleEntitySign,
================================================================
How to run the code:
Pre-process:
1.Compile the code base and obtain a .jar file.

2.Run FindBugs on command line to save the .jar file from step 1 into a .fbp stored in the code base root directory.

3.Edit JAVA_HOME=<jdk directory> in /lib/javancss-32.53/bin/javancss.bat.

Run the program:
1.Run startclient.bat.

2.Click ‘singleplayer’ and  ‘Create New World’ button to enter the world.

3.Press ‘E’ key to open the inventory, choose ‘RedStone’ at the top and drag TNT to the inventory slot.

4.Equiped ‘TNT’ block and place it on the ground.

5.Right click the ‘TNT’ block and you will get two block : codebase1 and codebase2.

6.Place these blocks on where you want to show the codebase.

7.Right click the block to show the output.


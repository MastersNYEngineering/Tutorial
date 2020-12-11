# How to Code FTC Robots
The point of the code is to allow the robot to be controlled by a person. At a high level, all the code needs to do is read input from a human (the gamepad controller), do logic/calculations on that input, and then tell the robot what to do based on the output of that logic. Consider a robotic arm that moves up when you press A and moves down when you press B on the controller. The code for this would:

1. Check if A is pressed or if B is pressed.
2. If A is pressed, tell the motor controlling the arm to turn in one direction.
3. If B is pressed, tell the motor controlling the arm to turn in the other direction.
4. Repeat until the robot stops.

Really, these are the steps for coding any component of a robot.

note:
Keep every component separate.


There are a few steps involved with programming a robot.
1. Initialization
2. Writing custom methods
3. Writing the main loop

## Step 1: Initialization
This step can be a little boring, but it is very necessary to make sure that all of the components of the robot will work properly. The point of code is to control the hardware of the robot. So, the initialization step builds that layer between code and hardware. The FTC library makes initializing the code pretty easy. 


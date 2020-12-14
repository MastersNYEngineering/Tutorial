# How to Code FTC Robots
The point of the code is to allow the robot to be controlled by a person. At a high level, all the code needs to do is read input from a human (the gamepad controller), do logic/calculations on that input, and then tell the robot what to do based on the output of that logic. Consider a robotic arm that moves up when you press A and moves down when you press B on the controller. The code for this would look like this:

1. Check if A is pressed or if B is pressed.
2. If A is pressed, tell the motor controlling the arm to turn in one direction.
3. If B is pressed, tell the motor controlling the arm to turn in the other direction.
4. Repeat until the robot stops.

It is a good idea to break complex tasks into smaller, easy tasks, then put them all together. That is how you should be thinking about writing code for robots. These steps, although slightly simplified, is the general idea of what the life cycle of robot code looks like. More abstractly, any component of a robot's code (the drive mechanism, lift mechanism, launching mechanism, etc) will:

1. Read from the controller and sensors
2. Use that input, and calculations on that input, to make a decision (deciding which direction to turn, how much power to send to the lift, etc...)
3. Actually execute that decision in hardware (telling a motor to start moving, rotating a servo, etc)
4. Repeat until the robot is told to stop (at the end of the round)

This is really all there is to it, conceptually. The only other step is to *initialize* the robot, but that only needs to be done once, in the beginning, before the game round actually starts. Okay. Now, let's learn how to actually do all of these steps.

There are a few steps involved with programming a robot.
1. Initialization
2. Writing custom methods (the movement mechanism, )
3. Writing the main loop

## Step 0: How this document works
Every "step" will have a link to a code file, which contains the necessary code to do the step at hand. Open that file in a new tab in your editor (or your browser) while you read along with this guide to see a complete, working example of the stuff being talked about in each step.

## Step 1: Initialization
This step it is very necessary to make sure that all of the components of the robot will work properly during the round. The initialization method runs once, right before the start of every round. The point of this code is to set up connections with the hardware of the robot. After all, the point of code is to control the hardware. So, this initialization step builds that connection between code and hardware. The FTC library makes initializing the code pretty easy. 

There are two parts to the initialization code: *declaration* and *definition*. *Declaring* a variable simply introduces the name of the variable and its type. So, you don't actually give the variable a value in this step. Rather, you just annotate the name and type of the variable. All declarations go inside the main `class`, before any methods are defined.

```java
@TeleOp(name="Robot Name", group="Examples")
public class MyRobot extends OpMode { // This is the "main class"
    
    /* declarations go here, before methods */

    /* methods go here, after declarations */

}
```

Declaring a variable (also called a field, in this case), is just like you learned how to do in the Java crash course:
```java
Type variable_name = value;
```
Except in this case, there is no `value`, because you are just *declaring* the variable, not *defining* it yet. So, declaring a variable looks like this:
```java
Type variable_name;
```

<u>**Exercise 1**</u><br>
Declare a `double` called `robot_speed` in a class called `AwesomeRobot`.
<details>
    <summary>See answer (try it first, though!!!!)</summary>

```java
@TeleOp(name="My super cool robot", group="Examples")
public class AwesomeRobot extends OpMode {
    
    double robot_speed;

    /* methods are here */

}
```
</details>

So, now that you know how to declare a basic variable, let's look at how to declare something like a motor, servo, or sensor.

IMPORTANT NOTE: If you want to use any FTC class, you must *import* that class into the code file. See [this guide]() on how to import stuff from FTC.

To declare a regular 20:1 or 40:1 motor, say
```java
DcMotor my_motor;
```

If your robot has 4 motors, simply say
```java
DcMotor front_left;
DcMotor front_right;
DcMotor back_left;
DcMotor back_right;
```
Of course, you might want to name things differently, but this is a pretty nice naming convention.

To declare a continuous rotation servo or a VEX393 motor:
```java
CRServo my_cr_servo;
```

To declare a regular servo:
```java
Servo my_servo;
```

All analog inputs take the `AnalogInput` type (stuff like potentiometers):
```java
AnalogInput my_analog_input;
```

Etc... I think you get it.

If there is a "thing" you want to use that we did not list here (like more advanced sensors and obscure components/electronics), check out the left side panel on [this page](https://ftctechnh.github.io/ftc_app/doc/javadoc/index.html) to get a list of all the FTC classes (you can search the page to find what you're looking for, like a `ColorSensor`).

<u>**Exercise 2**</u><br>
Declare all the components that you would need for a 3-wheeled triangle bot (RIP) that has two CRServos powering a lift mechanism.
<details>
    <summary>See answer (NO CHEATING)</summary>

```java
@TeleOp(name="TriangleBot", group="Examples")
public class TriangleBot extends OpMode {
    DcMotor wheel_1;
    DcMotor wheel_2;
    DcMotor wheel_3;

    CRServo lift_left;
    CRServo lift_right;

    /* methods are here */
}
```
</details>

## Exercise ideas
1. Write the method for a tank drive
2. Claw
3. Shovel
4. Marker deployment
5. 4-bar lift

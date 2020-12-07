package org.firstinspires.ftc.teamcode;

/* -- IMPORTS -- */
/*
    Here is where you actually import the FTC library. Whenever you need something,
    check the docs and find the import for it, and put the import here.
*/

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import java.util.concurrent.TimeUnit;
import java.lang.Math;
import java.util.*;

// The @TeleOp allows you to set the robot name that will appear on the phone
@TeleOp(name="Robot Name", group="Examples")
public class OctoBot extends OpMode {

    /* -- GLOBAL VARIABLES -- */

    /*
        Here is where you declare all global variables
        or any data that your robot needs. These data points are called "fields"
        You also declare all of the motors and sensors here.
        anything and everything that needs to be controlled by the code.
    */

    // This is helpful so that you can time certain actions.
    private ElapsedTime runtime = new ElapsedTime();

    // It is a good idea to declare everything as null initially,
    // before initializing it.
   
    // Here is where you declare all the regular DcMotors
    // You need to create a DcMotor object for each motor that
    // you have plugged in.
    private DcMotor motor_1 = null;
    private DcMotor motor_2 = null;

    // VEX393s count as CRServos. If you have any 393s,
    // declare them here.
    private CRServo vex393_1 = null;

    // If you have servo motors, declare them here.
    private Servo servo_1 = null;

    // Declare a color sensor like this
    private ColorSensor color_sensor = null;

    // Declare a potentiometer like this.
    private AnalogInput pot = null;

    // Various constants for motors and such
    private double MAX_SPEED;
    private double TURN_BUFFER;
    private double SERVO_BUFFER;
    private double STOP_VAL;

    /* -- INTERNAL METHODS -- */

    /*
       Here are where you define all the methods that your robot will
       use. You write the code for the required methods, and you
       can also create custom methods of your own.
    */

    // Here are some very helpful custom methods to initialize different
    // components given their hardware address (the id/name on the phone).
    
    // These initialization methods are very handy to quickly initialize motors,
    // sensors, and other stuff like that. Make sure to change
    // RUN_WITHOUT_ENCODERS to RUN_WITHOUT_ENCODERS if you need encoders.
    // Same is true with REVERSE and FORWARD.
   
    // init_motor initializes a motor given its hardware address.
    private DcMotor init_motor(String id) {
        DcMotor m = null;
        m = hardwareMap.get(DcMotor.class, id);
        m.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        m.setDirection(DcMotor.Direction.REVERSE);
        return m;
    }

    // init_servo initializes a servo given its hardware address.
    private Servo init_servo(String id) {
        Servo s = null;
        s = hardwareMap.get(Servo.class, id);
        s.setDirection(Servo.Direction.FORWARD);
        return s;
    }

    // init_CRServo initializes a continuous rotation servo given its
    // hardware address.
    private CRServo init_crservo(String id, boolean forward) {
        CRServo s = null;
        s = hardwareMap.get(CRServo.class, id);
        if (forward) {
            s.setDirection(CRServo.Direction.FORWARD);
        } else {
            s.setDirection(CRServo.Direction.REVERSE);
        }
        return s;
    }

    // init_colorsensor initializes a color sensor given its hardware address.
    private ColorSensor init_colorsensor(String id) {
        ColorSensor s = null;
        s = hardwareMap.get(ColorSensor.class, id);
        return s;
    }

    // This is a required method. The init() method runs once, when you click
    // the start button on the phone for the first time. The code in this method
    // should initialize all motors and set any numerical constants your robot
    // might need.
    @Override
    public void init() {
        MAX_SPEED = 0.85;
        TURN_BUFFER = 0.38;
        SERVO_BUFFER = 1;
        // SERVO_BUFFER = 0.47;

        STOP_VAL = 0;

        // Initialize the wheels
        w0 = init_motor("w0");
        w1 = init_motor("w1");
        w2 = init_motor("w2");
        w3 = init_motor("w3");

        // Initialize the lift motors
        lift0 = init_CRservo("lift0", true);
        lift1 = init_CRservo("lift1", true);

        // Initialize the shovel motors
        shovel0 = init_servo("shovel0");
        shovel1 = init_servo("shovel1");

        // Initialize the color sensors
        colorSensor = init_colorSensor("color_sensor");

        // Initialize other sensors
        driverpoten = hardwareMap.get(AnalogInput.class, "driverpoten");
    }

    // This is the move function. It does not actually set the power to
    // the wheels. All this method does it *calculate* how much power needs to be
    // sent to the wheel for it to move properly, and then it *returns* those values.
    // Once you write this method, it becomes a black box; you don't need to think about
    // how it works in order to use it. You simply call move() to get the motor
    // movement calculations. Keep in mind that because this is a holonomic robot,
    // the calculations are going to be more complex than a tank drive (or anything else)
    double[] move() {
        double x_left_joy;
        double y_left_joy;

        x_left_joy = -gamepad1.right_stick_x;
        y_left_joy = gamepad1.right_stick_y;

        double phi_joy = Math.atan2(y_left_joy, x_left_joy);

        double x_left_joy_sq = Math.pow(x_left_joy, 2);
        double y_left_joy_sq = Math.pow(y_left_joy, 2);

        double r_joy = Math.sqrt(x_left_joy_sq + y_left_joy_sq);

        double speed = MAX_SPEED * r_joy;

        double alpha_1 = Math.PI / 4;
        double alpha_2 = 3 * Math.PI / 4;
        double alpha_3 = 5 * Math.PI / 4;
        double alpha_4 = 7 * Math.PI / 4;

        double theta_1 = alpha_1 - phi_joy;
        double theta_2 = alpha_2 - phi_joy;
        double theta_3 = alpha_3 - phi_joy;
        double theta_4 = alpha_4 - phi_joy;

        double w0_power = -speed * Math.sin(theta_1);
        double w1_power = -speed * Math.sin(theta_2);
        double w2_power = -speed * Math.sin(theta_3);
        double w3_power = -speed * Math.sin(theta_4);

        // Print out the calculated values for debugging purposes.
        // Telemetry.addData() is basically just System.out.println(), but the
        // text is displayed ON THE PHONE, because there is no "console" like there
        // is in traditional Java programs.
        telemetry.addData(" -- POWERS IN CALCULATION --", "");
        telemetry.addData("w0_power", w0_power);
        telemetry.addData("w1_power", w1_power);
        telemetry.addData("w2_power", w2_power);
        telemetry.addData("w3_power", w3_power);
        telemetry.addData(" -- END --", "");

        double[] speeds = {
            w0_power,
            w1_power,
            w2_power,
            w3_power
        };

        return speeds;
    }

    // lift() powers the 4 bar lift. This actually sets the motor power.
    void lift() {
        // Get the input from the gamepad
        boolean right_bumper = gamepad1.left_bumper;
        boolean left_bumper  = gamepad1.right_bumper;

        // Power the motors accordingly
        double power = 0.85;
        if (right_bumper) {
            lift0.setPower(power);
            lift1.setPower(power);
        }
        else if (left_bumper) {
            lift0.setPower(-power);
            lift1.setPower(-power);
        }
        else if (!left_bumper && !right_bumper) {
            lift0.setPower(0);
            lift1.setPower(0);
        }
    }

    // shovel() powers the shovel. This actually sets the motor power.
    void shovel() {
        // Read from the gamepad
        double rt = gamepad1.right_trigger;
        double lt = gamepad1.left_trigger;

        // NOTE: Recall that these motors are VEX393s, so they have weird behavior.
        if (rt > 0) { // If the right trigger is being pressed
            // Move both the shovel motors up (NOTE: you will need to play around
            // with the value, but just make sure that you send the same value to 
            // both motors)
            shovel0.setPosition(-.5);
            shovel1.setPosition(-.5);
        } else if (lt > 0) { // If the left trigger is being pressed
            // Move both the shovel motors down. See note above, too.
            shovel0.setPosition(0.5);
            shovel1.setPosition(0.5);
        } else if (lt == 0 && rt == 0) { // If nothing is being pressed
            // This is kind of weird, because VEX393s are very weird within FTC.
            // Setting both motors to 0 will actually make the 393s hold their position,
            // whereever they are. This was the behavior that we wanted. Without this
            // branch of the if-statement, gravity would just bring the shovel down
            // when nothing was being pressed. But we wanted the shovel to stay in
            // place when nothing was being pressed.
            shovel0.setPosition(0);
            shovel1.setPosition(0);
        }

        // Print out the trigger values for debugging purposes
        telemetry.addData("right trigger", rt);
        telemetry.addData("left trigger", lt);
    }

    // turn() calculates the turning speed. This does not send power to the motor,
    // it just calculates the value, and returns it.
    double turn() {
        double x_left_joy = gamepad1.left_stick_x; // Read from the controller
     
        // Map the left joystick x value to the range [-1, 1], and multiply
        // by the buffer speeds.
        double speed = Range.clip(x_right_joy, -1.0, 1.0) * TURN_BUFFER * MAX_SPEED;

        // Return the value
        return speed;
    }

    /* -- REQUIRED METHODS -- */

    /*
       Here are the required methods for any OpMode.
       Any method marked with @Override is a required method.
       If you do not declare these methods, the code will not compile!
       So even if you don't need to put anything in a method (like in init_loop),
       you still need to declare it, and leave the function body empty.
    */

    // You will probably never need to use this. This loop will continuously run
    // once you hit "init" on the phone, and will stop running once you hit "start"
    @Override
    public void init_loop() {
    }

    // This is the code that runs when you click "start", right before running the
    // main game loop (below).
    @Override
    public void start() {
        runtime.reset(); // Reset the clock
    }

    // The main game loop. This is a very important method!!! This is the method where
    // everything happens! This is also a very special method: it runs continuously.
    // This method will automatically run many many times per second. So, you need to
    // get into the mindset of thinking that this loop is always running, always
    // repeating itself. The code will continuously run from top to bottom, top to bottom
    // forever (or until you click stop on the phone).
    @Override
    public void loop() {
        // Calculate moving and turning speeds. By calling move() and turn() in loop(),
        // they will constantly be running, until the robot stops.
        double[] move = move();
        double turn = turn();

        // Sum the turn speed and move speed (to get the final motor speed)
        // This is only necessary for holonomic robots. For non-holonomic drives,
        // you will often only need one move() function, not a turn function.
        // For example, think about tank drives. They cannot turn and move at the same
        // time, so only one method is necessary.
        double w0_vel = move[0] + turn;
        double w1_vel = move[1] + turn;
        double w2_vel = move[2] + turn;
        double w3_vel = move[3] + turn;

        // Power the motors with the calculated speed.
        // This is what actually powers the motors
        w0.setPower(w0_vel);
        w1.setPower(w1_vel);
        w2.setPower(w2_vel);
        w3.setPower(w3_vel);

        // Print the turn speed (for debugging)
        telemetry.addData("turn", turn);

        // Power the shovel and the lift
        // Note, these methods are being called continuously, so they are always
        // going to be running.
        lift();
        shovel();
    }

    // This is the code that runs when you click stop. It should forcefully
    // stop all moving parts (for safety reasons).
    @Override
    public void stop() {
        // Forcefully stop all of the motors
        w0 = null;
        w1 = null;
        w2 = null;
        w3 = null;

        lift0 = null;
        lift1 = null;
        shovel0 = null;
        shovel1 = null;
    }
}

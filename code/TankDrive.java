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

class TankDrive extends OpMode {

	DcMotor left_wheel;
	DcMotor right_wheel;

	double MAX_SPEED = 0.5;

    DcMotor init_dcmotor(String id) {
        DcMotor m = null;
        m = hardwareMap.get(DcMotor.class, id);
        m.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        m.setDirection(DcMotor.Direction.REVERSE);
        return m;
    }

	@Override
	void init() {
		left_wheel  = init_dcmotor("left_wheel");
		right_wheel = init_dcmotor("right_wheel");
	}

	void tank_drive() {
		 // code goes in here
		double right_y = gamepad1.right_stick_y / 127;
		double left_y = gamepad1.left_stick_y / 127;

		left_wheel.setPower (left_y  * MAX_SPEED);
		right_wheel.setPower(right_y * MAX_SPEED);
	}

	@Override
	void loop() {
		tank_drive();
	}
}


package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class HandSubsystem {
    public CANSparkMax leftIntake = new CANSparkMax(7, MotorType.kBrushless);
    public CANSparkMax rightIntake = new CANSparkMax(8, MotorType.kBrushless);
    public static CANSparkMax wrist = new CANSparkMax(9, MotorType.kBrushless);
    public static SparkMaxAbsoluteEncoder wrist_encoder = wrist.getAbsoluteEncoder(Type.kDutyCycle);

    public static ArmFeedforward wristfeedforward = new ArmFeedforward(0.1, 0.3, 1.71,0.02);

    public PneumaticHub RoboComp = new PneumaticHub(10);
    public static DoubleSolenoid HandSolenoid = new DoubleSolenoid(10, PneumaticsModuleType.REVPH, 1, 2);

    public HandSubsystem() {
        HandSolenoid.set(Value.kOff);
        HandSolenoid.set(Value.kReverse);    
        RoboComp.enableCompressorAnalog(80, 110);
    }

    public static void useOutput(double destination) {
       // wrist_controller.setReference(destination,CANSparkMax.ControlType.kPosition);
       wristfeedforward.calculate(wrist_encoder.getPosition(), destination);
    }
}

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class DrivetrainSubsystem {
    public CANSparkMax left_back_drive = new CANSparkMax(Constants.LeftBackMotor, MotorType.kBrushless);
    public CANSparkMax left_front_drive = new CANSparkMax(Constants.LeftFrontMotor, MotorType.kBrushless);
    public CANSparkMax right_back_drive = new CANSparkMax(Constants.RightBackMotor, MotorType.kBrushless);
    public CANSparkMax right_front_drive = new CANSparkMax(Constants.RightFrontMotor, MotorType.kBrushless);    
    public ControllerSubsystem controllerSubsystem;



    public DrivetrainSubsystem() {
        //invert the "right" side of the drivetrain
        right_back_drive.setInverted(true);
        right_front_drive.setInverted(true);
        
        //follow the "leaders" of the right and the left side to minimize the amount of code we need to write
        left_back_drive.follow(left_front_drive);
        right_back_drive.follow(right_front_drive);
    }
}

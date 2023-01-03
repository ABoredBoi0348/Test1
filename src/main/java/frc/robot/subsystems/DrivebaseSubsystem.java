package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.Robot;
import frc.robot.RobotMap.DrivebaseConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;


public class DrivebaseSubsystem extends SubsystemBase {
    private final CANSparkMax leftFrontSparkMax;
    private final CANSparkMax leftBackSparkMax;
    private final CANSparkMax rightFrontSparkMax;
    private final CANSparkMax rightBackSparkMax;
    private final MotorControllerGroup leftmotors;
    private final MotorControllerGroup rightmotors;
    private final DifferentialDrive drive;

    private final RelativeEncoder frontLeftEncoder;
	private final RelativeEncoder backLeftEncoder;
	private final RelativeEncoder frontRightEncoder;
	private final RelativeEncoder backRightEncoder;


    public DifferentialDrive getDrive(){
        return drive;
    }
    public DrivebaseSubsystem(){

        


        leftFrontSparkMax = new CANSparkMax(DrivebaseConstants.LEFT_FRONT_SPARK_ID, MotorType.kBrushless);
        leftBackSparkMax = new CANSparkMax(DrivebaseConstants.LEFT_BACK_SPARK_ID, MotorType.kBrushless);
        rightFrontSparkMax = new CANSparkMax(DrivebaseConstants.RIGHT_FRONT_SPARK_ID, MotorType.kBrushless);
        rightBackSparkMax = new CANSparkMax(DrivebaseConstants.RIGHT_BACK_SPARK_ID, MotorType.kBrushless);

        leftFrontSparkMax.setIdleMode(IdleMode.kBrake);
        rightFrontSparkMax.setIdleMode(IdleMode.kBrake);
        leftBackSparkMax.setIdleMode(IdleMode.kBrake);
        rightBackSparkMax.setIdleMode(IdleMode.kBrake);

        leftFrontSparkMax.setInverted(DrivebaseConstants.LEFT_FRONT_SPARK_INVERTED);
        rightFrontSparkMax.setInverted(DrivebaseConstants.RIGHT_FRONT_SPARK_INVERTED);
        leftBackSparkMax.setInverted(DrivebaseConstants.LEFT_BACK_SPARK_INVERTED);
        rightBackSparkMax.setInverted(DrivebaseConstants.RIGHT_BACK_SPARK_INVERTED);

        leftmotors = new MotorControllerGroup(leftFrontSparkMax,leftBackSparkMax);
        rightmotors = new MotorControllerGroup(rightFrontSparkMax, rightBackSparkMax);

        this.drive = new DifferentialDrive(leftmotors, rightmotors);


        frontLeftEncoder = leftFrontSparkMax.getEncoder();
        backLeftEncoder = leftBackSparkMax.getEncoder();
        frontRightEncoder = rightFrontSparkMax.getEncoder();
        backRightEncoder = rightBackSparkMax.getEncoder();
        


        
    }

    public double getLeftEncoder(){
        return Math.abs(frontLeftEncoder.getPosition() + backLeftEncoder.getPosition());
    }
    public double getRightEncoder(){
        return Math.abs(backRightEncoder.getPosition() + frontRightEncoder.getPosition());
    }

    public void resetEncoders(){
        frontLeftEncoder.setPosition(0.0);
        backLeftEncoder.setPosition(0.0);
        frontRightEncoder.setPosition(0.0);
        backRightEncoder.setPosition(0.0);
    }

    public void resetEncoder(double value){
        frontLeftEncoder.setPosition(0.0);
        backLeftEncoder.setPosition(0.0);
        frontRightEncoder.setPosition(0.0);
        backRightEncoder.setPosition(0.0);
    }

    public void arcadeDrive(double arcadeSpeed, double arcadeRotation){
        getDrive().arcadeDrive(arcadeSpeed, arcadeRotation);
    }
    public void tankDrive(double rightSpeed, double leftSpeed){
        getDrive().tankDrive(rightSpeed, leftSpeed);
    }
    public void curvatureDrive(double curveSpeed, double curveRotation, Boolean RotateInPlace){
        getDrive().curvatureDrive(curveSpeed, curveRotation, RotateInPlace);
    }
}

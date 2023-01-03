package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;


public class DefaultDrive extends CommandBase{
    public DefaultDrive(){
        addRequirements(Robot.drivebase);
    }

    @Override
    public void execute()
    {
        Robot.getDrivebase().tankDrive(-Robot.rightJoystick.getY(),-Robot.rightJoystick.getY());
    }
}

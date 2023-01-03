package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.*;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class DriveStraight extends CommandBase {
    private final int speed;
    private final double time;
    private final double distance;
    private final Timer timer = new Timer();

    public DriveStraight(int s, double t, double d){
        this.speed = s;
        this.time = t;
        this.distance = d;
        addRequirements(Robot.drivebase);
        

    }

    @Override
    public void initialize(){
        timer.start();
    }

    @Override
    public void execute() {
        Robot.drivebase.tankDrive(speed,speed);
    }

    @Override
    public void end(boolean i){
        timer.reset();
        Robot.drivebase.tankDrive(0,0);
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= time;
    }
}

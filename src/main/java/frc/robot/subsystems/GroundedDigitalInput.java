// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;

/** Add your docs here. */
public class GroundedDigitalInput extends DigitalInput {

    public GroundedDigitalInput(int channel) {
        super(channel);
    }

    @Override
    public boolean get() {
        return !super.get();
    }
    
}
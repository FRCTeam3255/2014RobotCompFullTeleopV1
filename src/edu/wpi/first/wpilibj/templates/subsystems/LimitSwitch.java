package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 * @author Super NURDs
 */
public class LimitSwitch extends Subsystem {

    protected DigitalInput di;
    // create boolean values to remember the last state of the button
    // for rising and falling edges
    protected boolean lastPressedRising = false;
    protected boolean lastPressedFalling = false;

    public LimitSwitch(int portNumber) {
        di = new DigitalInput(portNumber);
    }

    public boolean isOpen() {
        return di.get() == true;
    }

    public boolean isClosed() {
        return (!isOpen());
    }

    /*
     * This routine returns true if the limit switch is closed and wasn't
     * closed the prior time this routine was called.
     */
    public boolean isRisingEdge() {
        // determine whether the button is currently pressed
        boolean pressed = isClosed();

        // by default, set the return value to reflect this is not a rising edge
        boolean returnValue = false;

        // if the button is currently pressed, and it wasn't pressed last time
        // then set the return value to reflect this is a rising edge
        if (pressed && (lastPressedRising == false)) {
            returnValue = true;
        }

        // update the last pressed value to the currently pressed value
        lastPressedRising = pressed;

        // return the result of whether or not this was a rising edge
        return returnValue;
    }

    /*
     * This routine returns true if the limit switch is open and wasn't
     * open the prior time this routine was called.
     */
    public boolean isFallingEdge() {
        // determine whether the button is currently pressed
        boolean pressed = isClosed();

        // by default, set the return value to reflect this is not a falling edge
        boolean returnValue = false;

        // if the button is not currently pressed, and it was pressed last time
        // then set the return value to reflect this is a falling edge
        if ((pressed == false) && (lastPressedFalling == true)) {
            returnValue = true;
        }

        // update the last pressed value to the currently pressed value
        lastPressedFalling = pressed;

        // return the result of whether or not this was a falling edge
        return returnValue;
    }

    public void initDefaultCommand() {
    }
}
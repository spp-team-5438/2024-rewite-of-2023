package frc.robot.components;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class LEDObject
{
    public static AddressableLED Strip;
    public static AddressableLEDBuffer StripBuffer;

    public LEDObject(int port, int length)
    {
        Strip = new AddressableLED(port);
        StripBuffer = new AddressableLEDBuffer(length);

        Strip.setLength(length);
        Strip.setData(StripBuffer);
        Strip.start();
    }

    public void SetStripColor(int r, int g, int b)
    {
        for (int i = 0; i < StripBuffer.getLength(); i++)
            StripBuffer.setRGB(i, r, g, b);
        
            Strip.setData(StripBuffer);
    }
}
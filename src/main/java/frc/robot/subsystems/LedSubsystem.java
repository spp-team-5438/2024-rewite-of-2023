package frc.robot.subsystems;

import frc.robot.components.*;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class LedSubsystem {

    
    public LEDObject sponsorLED = new LEDObject(0, 56);


    public LedSubsystem()
    {

    }
    
    public void setStripColor(AddressableLED m_led, AddressableLEDBuffer m_ledbuffer, int r, int g, int b) {
        for (int i = 0; i < m_ledbuffer.getLength(); i++) {
            m_ledbuffer.setRGB(i, r, g, b);
        }
        m_led.setData(m_ledbuffer);
    }

}

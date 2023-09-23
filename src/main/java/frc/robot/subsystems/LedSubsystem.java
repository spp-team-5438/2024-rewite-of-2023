package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class LedSubsystem {
    public static AddressableLED sponsorStrip1;
    public AddressableLED electronicStrip;
    public static AddressableLEDBuffer sponsorStrip1Buffer;
    public AddressableLEDBuffer electronicLedBuffer;

    public LedSubsystem()
    {
        sponsorStrip1 = new AddressableLED(0);
        sponsorStrip1Buffer = new AddressableLEDBuffer(56);
        sponsorStrip1.setLength(56);
        sponsorStrip1.setData(sponsorStrip1Buffer);
        sponsorStrip1.start();
    }
    
    public static void setStripColor(AddressableLED m_led, AddressableLEDBuffer m_ledbuffer, int r, int g, int b) {
        for (int i = 0; i < m_ledbuffer.getLength(); i++) {
            m_ledbuffer.setRGB(i, r, g, b);
        }
        m_led.setData(m_ledbuffer);
    }

}

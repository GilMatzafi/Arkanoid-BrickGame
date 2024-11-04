import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called WinGameScreen that implements Animtaion.
 */

public class WinGameScreen implements Animation {

    private int finalScore;
    private boolean stop;

    private KeyboardSensor ks;

    /**
     * This is constructor that initialize the WinGameScreen.
     *
     * @param finalScore
     * @param ks
     */
    public WinGameScreen(int finalScore, KeyboardSensor ks) {
        this.stop = false;
        this.finalScore = finalScore;
        this.ks = ks;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(96, 96, 96));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.drawText(150, 300, "You Win! Your score is: " + finalScore, 40);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

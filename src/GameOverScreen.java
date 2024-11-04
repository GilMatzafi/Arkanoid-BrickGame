import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;


// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called GameOverScreen that implements Animation.
 */

public class GameOverScreen implements Animation {

    private int finalScore;
    private boolean stop;

    private KeyboardSensor ks;


    /**
     * This is constructor that initialize the GameOverScreen.
     *
     * @param finalScore
     * @param ks
     */
    public GameOverScreen(int finalScore, KeyboardSensor ks) {
        this.stop = false;
        this.finalScore = finalScore;
        this.ks = ks;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(96, 96, 96));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.drawText(150, 300, "Game Over Your score is: " + finalScore, 40);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called CountdownAnimation that implements animation.
 */

public class CountdownAnimation implements Animation {

    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;

    private Integer updateCount;

    /**
     * This is constructor that initialize the CountdownAnimation.
     *
     * @param numOfSeconds
     * @param countFrom
     * @param gameScreen
     */

    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.stop = false;
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.updateCount = countFrom;
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(new Color(102, 102, 0));
        if (updateCount == 0) {
            d.drawText(200, d.getHeight() / 2, "GO ! ", 200);
        } else if (updateCount > 0) {
            d.drawText(350, d.getHeight() / 2, updateCount.toString(), 200);
        } else {
            this.stop = true;
        }
        Sleeper sleeper = new Sleeper();
        sleeper.sleepFor((long) this.numOfSeconds * 1000 / countFrom);
        updateCount -= 1;
    }


    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

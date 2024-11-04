import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called PauseScreen that implements Animtaion.
 */

public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * This is constructor that initialize the PauseScreen.
     *
     * @param k
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 52);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

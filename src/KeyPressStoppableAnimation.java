import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called KeyPressStoppableAnimation that implements Animation.
 */

public class KeyPressStoppableAnimation implements Animation {


    private KeyboardSensor sensor;
    private String key;
    private Animation animation;

    private boolean stop;

    private boolean isAlreadyPressed = true;

    /**
     * This is constructor that initialize the KeyPressStoppableAnimation.
     *
     * @param sensor
     * @param key
     * @param animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
    }

    @Override

    public void doOneFrame(DrawSurface d) {

        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(this.key)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

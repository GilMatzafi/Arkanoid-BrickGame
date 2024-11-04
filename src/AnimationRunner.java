import biuoop.DrawSurface;
import biuoop.GUI;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called AnimationRunner that in charge the looping of our frames.
 */

public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;

    /**
     * This is constructor that initialize the AnimationRunner.
     *
     * @param gui
     * @param framesPerSecond
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
    }


    /**
     * This method run our program and created our loop.
     *
     * @param animation
     */
    public void run(Animation animation) {

        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        biuoop.Sleeper sleeper = new biuoop.Sleeper();

        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();
            animation.doOneFrame(d);

            this.gui.show(d);

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }

    }

}

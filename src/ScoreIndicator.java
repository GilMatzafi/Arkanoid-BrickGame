import biuoop.DrawSurface;

import java.awt.Color;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called ScoreIndicator that implements Sprite.
 */

public class ScoreIndicator implements Sprite {

    private Counter scoreCount;

    /**
     * This is constructor that initialize the rectangle.
     *
     * @param score
     */
    public ScoreIndicator(Counter score) {
        scoreCount = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(155, 30, "score: " + scoreCount.getValue(), 20);
    }

    @Override
    public void timePassed() {
    }

    /**
     * This method is used to add the score indicator to the game.
     *
     * @param gameLevel
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}

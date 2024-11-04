
// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called BallRemover that implements HitListener.
 */

public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * This is constructor that initialize the BallRemover.
     *
     * @param gameLevel
     * @param remainingBalls
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    /**
     * This method make the ball to be removed if they go to the death region.
     *
     * @param beingHit
     * @param hitter
     */

    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        remainingBalls.decrease(1);
    }
}


// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called ScoreTrackingListener that implements HitListener.
 */

public class ScoreTrackingListener implements HitListener {

    private Counter score;

    /**
     * This is constructor that initialize the ScoreTrackingListener.
     *
     * @param scoreCounter
     */

    public ScoreTrackingListener(Counter scoreCounter) {
        this.score = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.score.increase(10);
    }
}
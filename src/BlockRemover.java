// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called BlockRemover that implements HitListener.
 */

public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;


    /**
     * This is constructor that initialize the BlockRemover.
     *
     * @param gameLevel
     * @param removedBlocks
     */

    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }


    /**
     * This method make the block to be removed id they hit by the ball.
     *
     * @param beingHit
     * @param hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(gameLevel);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}

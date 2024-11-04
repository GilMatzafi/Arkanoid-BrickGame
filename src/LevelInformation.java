import java.util.List;


// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This interface called LevelInformation that have the technical details about the level.
 */

public interface LevelInformation {

    /**
     * This is a method that return the number of balls of the level.
     *
     * @return int.
     */

    int numberOfBalls();


    /**
     * This is a method that initialize the velocity of each ball.
     *
     * @return List.
     */

    List<Velocity> initialBallVelocities();

    /**
     * This is a method that return the speed of the paddle.
     *
     * @return List.
     */

    int paddleSpeed();

    /**
     * This is a method that return the width of the paddle.
     *
     * @return List.
     */

    int paddleWidth();

    /**
     * This is a method that return the level name by string.
     *
     * @return List.
     */

    String levelName();


    /**
     * This is a method that returns a sprite with the background of the level.
     *
     * @return List.
     */

    Sprite getBackground();


    /**
     * This is a method that return the list of the block of the level.
     *
     * @return List.
     */

    List<Block> blocks();

    /**
     * This is a method that return number of blocks that need to be removed.
     *
     * @return List.
     */

    int numberOfBlocksToRemove();
}

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;


// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called GameLevel.
 */

public class GameLevel implements Animation {

    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();

    private Counter numOfBlocks;

    private Counter score;
    private Counter numOfBalls;

    private BallRemover ballRemover;

    private KeyboardSensor kb;
    private GUI gui;

    private AnimationRunner runner;
    private boolean running;

    private LevelInformation levelInformation;


    /**
     * This is constructor that initialize the GameLevel.
     *
     * @param levelInformation
     * @param kb
     * @param gui
     * @param runner
     * @param score
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor kb, GUI gui, AnimationRunner runner,
                     Counter score) {
        this.kb = kb;
        this.gui = gui;
        this.runner = runner;
        this.levelInformation = levelInformation;
        this.score = score;
    }

    /**
     * This is a method that get collidable and add him to the array list of collidable.
     *
     * @param c
     */

    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * This is a method that get Sprite and add him to the array list of Sprites.
     *
     * @param s
     */

    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * This is a method that get collidable and remove him from the array list of collidable.
     *
     * @param c
     */

    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * This is a method that get Sprite and add remove him from the array list of Sprites.
     *
     * @param s
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    private void initializeScore() {
        ScoreIndicator si = new ScoreIndicator(this.score);
        si.addToGame(this);
    }

    private void initializeFrame() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        Point point3 = new Point(790, 10);
        Point point4 = new Point(0, 590);
        Rectangle rectangle1 = new Rectangle(point1, 10, 600);
        Rectangle rectangle2 = new Rectangle(point2, 800, 10);
        Rectangle rectangle3 = new Rectangle(point3, 10, 600);
        Rectangle rectangle4 = new Rectangle(point4, 800, 10);
        Block block1 = new Block(rectangle1, Color.darkGray);
        Block block2 = new Block(rectangle2, Color.darkGray);
        Block block3 = new Block(rectangle3, Color.darkGray);
        Block block4 = new Block(rectangle4, Color.darkGray);
        block1.addToGame(this);
        block2.addToGame(this);
        block3.addToGame(this);
        block4.addToGame(this);

    }

    private void initializeRemovableBlocks() {


        ScoreTrackingListener stl = new ScoreTrackingListener(this.score);
        this.numOfBlocks = new Counter(0);
        BlockRemover blockRemover = new BlockRemover(this, this.numOfBlocks);

        for (Block block : this.levelInformation.blocks()) {
            block.addToGame(this);
            this.numOfBlocks.increase(1);
            block.addHitListener(blockRemover);
            block.addHitListener(stl);
        }
    }

    private void initializeDeathBlock() {
        Point point7 = new Point(0, 589);
        Rectangle rectangle7 = new Rectangle(point7, 800, 20);
        Block deathBlock = new Block(rectangle7, Color.darkGray);
        deathBlock.addToGame(this);
        deathBlock.addHitListener(this.ballRemover);
    }

    private void initializeBalls() {

        this.numOfBalls = new Counter(0);
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Point center = new Point(395, 500);
            Ball ball = new Ball(center, 4, Color.WHITE);
            this.numOfBalls.increase(1);
            ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
            ball.addToGame(this);
            ball.setGameEnvironment(this.environment);

        }
        this.ballRemover = new BallRemover(this, this.numOfBalls);
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.cyan);
        d.fillRectangle(0, 0, 800, 600);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (this.kb.isPressed("p") || this.kb.isPressed("P")) {
            PauseScreen ps = new PauseScreen(this.kb);
            KeyPressStoppableAnimation kps = new KeyPressStoppableAnimation(this.kb, KeyboardSensor.SPACE_KEY, ps);
            this.runner.run(kps);
        }

        if (this.numOfBalls.getValue() == 0) {
            this.running = false;
        }

        if (this.numOfBlocks.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }

    }

    private void initializePaddle(KeyboardSensor keyboard) {
        Paddle paddle = new Paddle(new Rectangle(new Point(400 - (this.levelInformation.paddleWidth()) / 2, 560),
                this.levelInformation.paddleWidth(),
                20), this.levelInformation.paddleSpeed());
        paddle.addToGame(this);
        paddle.setKeyboard(keyboard);
    }


    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        this.addSprite(this.levelInformation.getBackground());
        this.initializeScore();
        this.initializeFrame();
        this.initializeRemovableBlocks();
        this.initializeBalls();
        this.initializeDeathBlock();
        this.initializePaddle(this.kb);
    }

    /**
     * This method run our game.
     */
    public void run() {
        this.running = true;
        CountdownAnimation cda = new CountdownAnimation(2, 3, this.sprites);
        this.runner.run(cda);
        this.runner.run(this);

    }

    /**
     * This method return the number of balls.
     *
     * @return class of Counter.
     */

    public Counter getNumOfBalls() {
        return this.numOfBalls;
    }

    /**
     * This method return the number of blocks to remove.
     *
     * @return class of Counter.
     */

    public Counter getNumOfBlocks() {
        return this.numOfBlocks;
    }
}

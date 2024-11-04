import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called Green3 that represnt the third level in our game.
 */

public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < numberOfBalls(); i++) {
            velocityList.add(new Velocity(rand.nextInt(3) + 3, -rand.nextInt(3) - 3));
        }
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        Sprite greenBackground = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(76, 153, 0));
                d.fillRectangle(0, 20, 800, 600);

                d.setColor(Color.lightGray);
                d.fillRectangle(0, 0, 800, 40);
                d.setColor(Color.black);
                d.drawText(500, 30, "level name: " + levelName(), 20);

                d.setColor(new Color(96, 96, 96));
                d.fillRectangle(110, 200, 10, 200);

                d.setColor(new Color(255, 178, 102));
                d.fillCircle(115, 200, 11);

                d.setColor(new Color(255, 51, 51));
                d.fillCircle(115, 200, 8);

                d.setColor(Color.WHITE);
                d.fillCircle(115, 200, 3);

                d.setColor(new Color(64, 64, 64));
                d.fillRectangle(100, 400, 30, 200);

                d.setColor(Color.BLACK);
                d.fillRectangle(65, 450, 100, 200);

                d.setColor(Color.WHITE);

                for (int x = 0; x < 5; ++x) {
                    for (int y = 0; y < 5; ++y) {
                        d.fillRectangle(75 + x * 18, 460 + y * 32, 10, 25);
                    }
                }

            }
            @Override
            public void timePassed() {

            }
        };
        return greenBackground;
    }
    @Override
    public List<Block> blocks() {

        List<Block> blocks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int width = i * 50;
            Point point = new Point(290 + width, 140);
            Rectangle rectangle = new Rectangle(point, 50, 25);
            Block block = new Block(rectangle, Color.gray);
            blocks.add(block);
        }
        for (int i = 0; i < 9; i++) {
            int width = i * 50;
            Point point = new Point(340 + width, 165);
            Rectangle rectangle = new Rectangle(point, 50, 25);
            Block block = new Block(rectangle, Color.red);
            blocks.add(block);
        }
        for (int i = 0; i < 8; i++) {
            int width = i * 50;
            Point point = new Point(390 + width, 190);
            Rectangle rectangle5 = new Rectangle(point, 50, 25);
            Block block = new Block(rectangle5, Color.yellow);
            blocks.add(block);
        }
        for (int i = 0; i < 7; i++) {
            int width = i * 50;
            Point point = new Point(440 + width, 215);
            Rectangle rectangle = new Rectangle(point, 50, 25);
            Block block = new Block(rectangle, Color.blue);
            blocks.add(block);
        }
        for (int i = 0; i < 6; i++) {
            int width = i * 50;
            Point point = new Point(490 + width, 240);
            Rectangle rectangle = new Rectangle(point, 50, 25);
            Block block = new Block(rectangle, Color.white);
            blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 34;
    }
}

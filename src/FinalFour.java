import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// 318597879 Gil Matzafi

/**
 * @author Gil Matzafi
 * This class called FinalFour represnt the fourth level in our game.
 */

public class FinalFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < numberOfBalls(); i++) {
            velList.add(new Velocity(-rand.nextInt(4) + 3, -rand.nextInt(4) - 3));
        }
        return velList;
    }

    @Override
    public int paddleSpeed() {
        return 8;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Sprite finalFourBackground = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(51, 153, 255));
                d.fillRectangle(0, 20, 800, 600);

                d.setColor(Color.lightGray);
                d.fillRectangle(0, 0, 800, 40);
                d.setColor(Color.black);
                d.drawText(500, 30, "level name: " + levelName(), 20);

                d.setColor(Color.WHITE);
                for (int i = 0; i < 10; i++) {
                    d.drawLine(70 + i * 8, 400, 40 + i * 8, 600);
                }

                d.setColor(new Color(209, 209, 226));
                d.fillCircle(80, 380, 20);
                d.fillCircle(90, 410, 24);
                d.setColor(new Color(190, 190, 190));
                d.fillCircle(100, 375, 22);
                d.setColor(new Color(150, 150, 150));
                d.fillCircle(125, 385, 25);
                d.fillCircle(105, 405, 15);

                d.setColor(Color.WHITE);
                for (int i = 0; i < 10; i++) {
                    d.drawLine(620 + i * 8, 500, 570 + i * 8, 600);
                }

                d.setColor(new Color(209, 209, 226));
                d.fillCircle(620, 480, 20);
                d.fillCircle(630, 510, 24);
                d.setColor(new Color(190, 190, 190));
                d.fillCircle(650, 480, 25);
                d.setColor(new Color(150, 150, 150));
                d.fillCircle(660, 500, 17);
                d.fillCircle(680, 490, 25);
            }

            @Override
            public void timePassed() {

            }
        };

        return finalFourBackground;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int width = i * 52;
            Point point = new Point(10 + width, 100);
            Rectangle rectangle = new Rectangle(point, 52, 25);
            Block block = new Block(rectangle, Color.gray);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            int width = i * 52;
            Point point = new Point(10 + width, 125);
            Rectangle rectangle = new Rectangle(point, 52, 25);
            Block block = new Block(rectangle, Color.RED);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            int width = i * 52;
            Point point = new Point(10 + width, 150);
            Rectangle rectangle = new Rectangle(point, 52, 25);
            Block block = new Block(rectangle, Color.YELLOW);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            int width = i * 52;
            Point point = new Point(10 + width, 175);
            Rectangle rectangle = new Rectangle(point, 52, 25);
            Block block = new Block(rectangle, Color.GREEN);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            int width = i * 52;
            Point point = new Point(10 + width, 200);
            Rectangle rectangle = new Rectangle(point, 52, 25);
            Block block = new Block(rectangle, Color.white);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            int width = i * 52;
            Point point = new Point(10 + width, 225);
            Rectangle rectangle = new Rectangle(point, 52, 25);
            Block block = new Block(rectangle, Color.pink);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            int width = i * 52;
            Point point = new Point(10 + width, 250);
            Rectangle rectangle = new Rectangle(point, 52, 25);
            Block block = new Block(rectangle, Color.cyan);
            blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 0;
    }
}

import sprite.GrayRock;
import sprite.RedLava;
import sprite.RedLavaFlipped;
import sprite.doubleeyeballfireball.DoubleEyeFireball;
import sprite.tile.DarkGrayCastleMiddleTile;
import spritesheet.EnemySpriteSheet;
import spritesheet.MarioSpriteSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Cody Thomas Zeitler on 12/17/2015.
 */
public class LevelThree extends JPanel implements ActionListener, Runnable{

    private int origin_x;
    private int origin_y;

    private Timer gameLoop;

    private GreenTurtle greenTurtle;

    private int frameCounter;

    private LinkedList<DarkGrayCastleMiddleTile> backgroundList;
    private DarkGrayCastleMiddleTile background;

    private LinkedList<RedLava> redLavaLinkedList;
    private LinkedList<RedLavaFlipped> topRedLavaLinkedList;
    private RedLava redLava;
    private RedLavaFlipped topRedLava;

    private GrayRock grayRock;
    private LinkedList<GrayRock> grayRockLinkedList;


    private int screenScrollSpeed;
    private int total_origin_x_moved;

    private DoubleEyeFireball doubleEyeFireball;
    private DoubleEyeFireball secondDoubleEyeFireball;
    private DoubleEyeFireball thirdDoubleEyeFireball;




    public LevelThree(){

        GameControl.getMario().setMarioPosition(Level.Levels.THREE);

        doubleEyeFireball = new DoubleEyeFireball(1175,0, 90, 90, true);
        doubleEyeFireball.setBottomY(630);
        doubleEyeFireball.setTopY(-100);
        doubleEyeFireball.setSpeedOfFireball(13);

        secondDoubleEyeFireball = new DoubleEyeFireball(1600, 500, 90, 90, false);
        secondDoubleEyeFireball.setBottomY(1100);
        secondDoubleEyeFireball.setTopY(400);
        secondDoubleEyeFireball.setSpeedOfFireball(13);

        thirdDoubleEyeFireball = new DoubleEyeFireball(2280,0,90,90, false);
        thirdDoubleEyeFireball.setBottomY(1100);
        thirdDoubleEyeFireball.setTopY(-100);
        thirdDoubleEyeFireball.setSpeedOfFireball(13);

        greenTurtle = new GreenTurtle(500,500,50,50);

        backgroundList = new LinkedList<>();

        for(int z = 0; z < GameControl.getMainGameFrame().getHeight() ; z = z +  50) {
            for (int i = 0; i < 10000; i = i +  50 ) {

                background = new DarkGrayCastleMiddleTile(i, z, 50, 50);
                backgroundList.add(background);

            }
        }

        redLavaLinkedList = new LinkedList<>();
        topRedLavaLinkedList = new LinkedList<>();

        for(int i = 0; i < GameControl.getMainGameFrame().getWidth() * 3; i = i + 250){

            redLava = new RedLava(i,GameControl.getMainGameFrame().getHeight() - 125,250,200);
            redLavaLinkedList.add(redLava);

        }
        for(int i = 0; i < GameControl.getMainGameFrame().getWidth() * 3; i = i + 250){

            topRedLava = new RedLavaFlipped(i, - 110,250,200);
            topRedLavaLinkedList.add(topRedLava);

        }

        grayRockLinkedList = new LinkedList<>();
        grayRock = new GrayRock(0,0,300,300);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(0,GameControl.getMainGameFrame().getHeight() - 350,300,300);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(600,375, 250, 250);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(600, 0, 250, 250);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(600, 750, 250 ,250);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(-200,300,300,190);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(-200, 490, 300, 190);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(1300, 0, 425, 425);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(1150, 700, 425, 425);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2000,800, 150,150);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2000,650,150,150);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2000,500,150,150);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2000,350,150,150);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2000,300,50,50);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2050, 300, 50 ,50);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2100,300,50,50);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2500,0,250,250);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2500,250,250,250);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2500,500,250,250);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2150,300,75,75);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2225,300,75,75);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2300,300,75,75);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2425,500,75,75);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2350, 500, 75, 75);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2275, 500,75,75);
        grayRockLinkedList.add(grayRock);
        grayRock = new GrayRock(2150,800,250,250);
        grayRockLinkedList.add(grayRock);


        screenScrollSpeed = -2;
        total_origin_x_moved = 0;

        origin_x = 0;
        origin_y = 0;

        frameCounter = 0;

        initializeGameLoop();
    }
    private void initializeGameLoop(){
        gameLoop = new Timer(1000/60,this);
        gameLoop.addActionListener(doubleEyeFireball);
        gameLoop.addActionListener(secondDoubleEyeFireball);
        gameLoop.addActionListener(thirdDoubleEyeFireball);
    }
    public Timer getGameLoop(){
        return gameLoop;
    }

    public boolean checkCollision(){



        Iterator<GrayRock> grayRockIterator = grayRockLinkedList.iterator();

        while(grayRockIterator.hasNext()){

            if(grayRockIterator.next().getCollisionBox().intersects(GameControl.getMario().getCollisionRectangle())){
                return true;
            }


        }

        Iterator<RedLava> redLavaIterator = redLavaLinkedList.iterator();

        while(redLavaIterator.hasNext()){

            if(redLavaIterator.next().getCollisionBox().intersects(GameControl.getMario().getCollisionRectangle())){
                return true;
            }



        }

        Iterator<RedLavaFlipped> topRedLavaIterator = topRedLavaLinkedList.iterator();

        while(topRedLavaIterator.hasNext()){

            if(topRedLavaIterator.next().getCollisionBox().intersects(GameControl.getMario().getCollisionRectangle())){
                return true;
            }


        }

        if(GameControl.getMario().getCollisionRectangle().intersects(
                new Rectangle(-50,0,50,GameControl.getMainGameFrame().getHeight()))){
            return true;
        }
        if(GameControl.getMario().getCollisionRectangle().intersects(
                new Rectangle(GameControl.getMainGameFrame().getWidth(), 0, 50, GameControl.getMainGameFrame().getHeight())
        )){
            return true;
        }


        if(GameControl.getMario().getCollisionRectangle().intersects(doubleEyeFireball.getCollisionBox())){
            return true;
        }
        if(GameControl.getMario().getCollisionRectangle().intersects(secondDoubleEyeFireball.getCollisionBox())){
            return true;
        }
        if(GameControl.getMario().getCollisionRectangle().intersects(thirdDoubleEyeFireball.getCollisionBox())){
            return true;
        }
        return false;

    }

    public void resetLevel(){

        ListIterator<RedLava> iterator = (ListIterator<RedLava>) redLavaLinkedList.iterator();
        while (iterator.hasNext()) {

            RedLava temp = iterator.next();

            temp.setX(temp.getX()  + total_origin_x_moved);

        }

        Iterator<GrayRock> grayRockIterator = grayRockLinkedList.iterator();

        while(grayRockIterator.hasNext()){

            GrayRock temp = grayRockIterator.next();

            temp.setX(temp.getX() + total_origin_x_moved);

        }


        Iterator<RedLavaFlipped> topRedLavaFlippedListIterator = topRedLavaLinkedList.iterator();

        while(topRedLavaFlippedListIterator.hasNext()){

            RedLavaFlipped temp = topRedLavaFlippedListIterator.next();

            temp.setX(temp.getX() + total_origin_x_moved);

        }

        Iterator<DarkGrayCastleMiddleTile> backgroundIterator = backgroundList.iterator();

        while(backgroundIterator.hasNext()){

            DarkGrayCastleMiddleTile temp = backgroundIterator.next();

            temp.setX(temp.getX() + total_origin_x_moved);

        }


        doubleEyeFireball.setX(doubleEyeFireball.getX() + total_origin_x_moved);
        secondDoubleEyeFireball.setX(secondDoubleEyeFireball.getX() + total_origin_x_moved);
        thirdDoubleEyeFireball.setX(thirdDoubleEyeFireball.getX() + total_origin_x_moved);
        total_origin_x_moved = 0;
        frameCounter = 0;


    }

    public void actionPerformed(ActionEvent e){
        if(frameCounter >= 180) {
            GameControl.getMario().setX(GameControl.getMario().getX() + screenScrollSpeed);
        }
        EventQueue.invokeLater(this);


    }
    public void run(){
        frameCounter++;


        if(checkCollision()){

            GameControl.getMario().resetMarioPosition(Level.Levels.THREE);
            resetLevel();

        }

        if(frameCounter >= 180) {
            ListIterator<RedLava> iterator = (ListIterator<RedLava>) redLavaLinkedList.iterator();
            while (iterator.hasNext()) {

                RedLava temp = iterator.next();

                temp.setX(temp.getX() + screenScrollSpeed);


            }
            Iterator<RedLavaFlipped> topRedLavaFlippedListIterator = topRedLavaLinkedList.iterator();

            while (topRedLavaFlippedListIterator.hasNext()) {

                RedLavaFlipped temp = topRedLavaFlippedListIterator.next();

                temp.setX(temp.getX() + screenScrollSpeed);

            }

            Iterator<DarkGrayCastleMiddleTile> backgroundIterator = backgroundList.iterator();

            while (backgroundIterator.hasNext()) {

                DarkGrayCastleMiddleTile temp = backgroundIterator.next();

                temp.setX(temp.getX() + screenScrollSpeed);

            }

            Iterator<GrayRock> grayRockIterator = grayRockLinkedList.iterator();

            while (grayRockIterator.hasNext()) {

                GrayRock temp = grayRockIterator.next();

                temp.setX(temp.getX() + screenScrollSpeed);


            }


            doubleEyeFireball.setX(doubleEyeFireball.getX() + screenScrollSpeed);
            secondDoubleEyeFireball.setX(secondDoubleEyeFireball.getX() + screenScrollSpeed);
            thirdDoubleEyeFireball.setX(thirdDoubleEyeFireball.getX() + screenScrollSpeed);


            total_origin_x_moved -= screenScrollSpeed;

        }






    }

    public void paintComponent(Graphics g){


        Iterator<DarkGrayCastleMiddleTile> backgroundIterator = backgroundList.iterator();

        while(backgroundIterator.hasNext()){

            DarkGrayCastleMiddleTile temp = backgroundIterator.next();
            g.drawImage(temp.getAssociatedSpriteSheet(),
                    temp.getDx1(), temp.getDy1(),
                    temp.getDx2(), temp.getDy2(),
                    temp.getSX1(), temp.getSY1(),
                    temp.getSX2(), temp.getSY2(),
                    null);

        }

        Iterator<GrayRock> grayRockIterator = grayRockLinkedList.iterator();

        while(grayRockIterator.hasNext()){

            GrayRock temp = grayRockIterator.next();
            g.drawImage(temp.getAssociatedSpriteSheet(),
                    temp.getDx1(), temp.getDy1(),
                    temp.getDx2(), temp.getDy2(),
                    temp.getSX1(), temp.getSY1(),
                    temp.getSX2(), temp.getSY2(),
                    null);


        }

        int s_double_eye_fireball[] = doubleEyeFireball.getSLocations();

        g.drawImage(doubleEyeFireball.getAssociatedSpriteSheet(),
                doubleEyeFireball.getDx1(), doubleEyeFireball.getDy1(),
                doubleEyeFireball.getDx2(), doubleEyeFireball.getDy2(),
                s_double_eye_fireball[0], s_double_eye_fireball[1],
                s_double_eye_fireball[2], s_double_eye_fireball[3],
                null);
        int s_second_double_eye_fireball[] = secondDoubleEyeFireball.getSLocations();

        g.drawImage(secondDoubleEyeFireball.getAssociatedSpriteSheet(),
                secondDoubleEyeFireball.getDx1(), secondDoubleEyeFireball.getDy1(),
                secondDoubleEyeFireball.getDx2(), secondDoubleEyeFireball.getDy2(),
                s_second_double_eye_fireball[0], s_second_double_eye_fireball[1],
                s_second_double_eye_fireball[2], s_second_double_eye_fireball[3],
                null);


        int s_third_double_eye_fireball[] = thirdDoubleEyeFireball.getSLocations();

        g.drawImage(thirdDoubleEyeFireball.getAssociatedSpriteSheet(),
                thirdDoubleEyeFireball.getDx1(), thirdDoubleEyeFireball.getDy1(),
                thirdDoubleEyeFireball.getDx2(), thirdDoubleEyeFireball.getDy2(),
                s_third_double_eye_fireball[0], s_third_double_eye_fireball[1],
                s_third_double_eye_fireball[2], s_third_double_eye_fireball[3],
                null);

        //Drawing all red lava.

        ListIterator<RedLava> redLavaListIterator = (ListIterator<RedLava>) redLavaLinkedList.iterator();

        while(redLavaListIterator.hasNext()){

            RedLava temp = redLavaListIterator.next();


            g.drawImage(temp.getAssociatedSpriteSheet(),
                    temp.getDx1(), temp.getDy1(),
                    temp.getDx2(), temp.getDy2(),
                    temp.getSX1(), temp.getSY1(),
                    temp.getSX2(), temp.getSY2(),
                    null);
        }

        Iterator<RedLavaFlipped> topRedLavaListIterator =  topRedLavaLinkedList.iterator();

        while(topRedLavaListIterator.hasNext()){

            RedLavaFlipped temp = topRedLavaListIterator.next();


            g.drawImage(temp.getAssociatedSpriteSheet(),
                    temp.getDx1(), temp.getDy1(),
                    temp.getDx2(), temp.getDy2(),
                    temp.getSX1(), temp.getSY1(),
                    temp.getSX2(), temp.getSY2(),
                    null);
        }



        int s_mario[] = GameControl.getMario().getSLocations();

        g.drawImage(MarioSpriteSheet.getSpriteSheet(),
                GameControl.getMario().getX(), GameControl.getMario().getY(),
                GameControl.getMario().getWidth() + GameControl.getMario().getX(),
                GameControl.getMario().getHeight() + GameControl.getMario().getY(),
                s_mario[0], s_mario[1],
                s_mario[2], s_mario[3],
                null);
    }

}

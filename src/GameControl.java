/**
 * Created by Cody Thomas Zeitler on 12/8/2015.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.ListIterator;


public class GameControl implements ActionListener, KeyListener {



    public enum Difficulty{
        EASY(10), NORMAL(7), HARD(30);

        int diff;

        private Difficulty(int diff){
            this.diff = diff;
        }

        public int getDifficulty(){
            return diff;
        }
    }

    private static Difficulty game_difficulty = Difficulty.NORMAL;
    public static Difficulty getDifficulty (){return game_difficulty;}

    Level currentLevel;
    Life currentLifes;

    private static Mario mario =  new Mario(125,125, 50, 75);  //Level one starting positions.
    public static Mario getMario(){
        return mario;
    }

    private static GameFrame mainGameFrame;
    public static GameFrame getMainGameFrame(){
        return mainGameFrame;
    }

    private String gameTitle;
    private int gameWindowWidth;
    private int gameWindowHeight;
    private LevelOne levelOne;
    private LevelTwo levelTwo;
    private LevelThree levelThree;
    private Timer timer;
   // private Timer timer_2;
  //  private Timer level_2_game_loop;


    //private VictoryScreen victoryScreen;

   // private LinkedList<Rectangle> collision_boxes;
   // private ListIterator<Rectangle> iterator;


    public GameControl() {

        gameWindowWidth = 1900;
        gameWindowHeight = 1025;
        gameTitle = "Mario in the Darker World @LostTriangleStudios.";
        mainGameFrame = new GameFrame(gameTitle, gameWindowWidth, gameWindowHeight);
        mainGameFrame.addKeyListener(this);
        currentLifes = new Life();

        //levelOne = new LevelOne();
        currentLevel = new Level(Level.Levels.ONE);
        //currentLevel.setCurrentLevel(levelOne.getCurrentLevel());
        //mainGameFrame.add(levelOne);
        //timer = levelOne.getTimer();
        //timer.addActionListener(mario);
        //timer.addActionListener(this);
        initializeLevelThree();

        mainGameFrame.add(levelThree);

        mainGameFrame.setVisible(true);
    }
    private void initializeLevelTwo(){

        levelTwo = new LevelTwo();
        currentLevel.setCurrentLevel(Level.Levels.TWO);
        timer = levelTwo.getGameLoop();
        timer.addActionListener(mario);
        timer.addActionListener(this);
    }
    private void initializeLevelThree(){

        levelThree = new LevelThree();
        currentLevel.setCurrentLevel(Level.Levels.THREE);
        timer = levelThree.getGameLoop();
        timer.addActionListener(mario);
        timer.addActionListener(this);

    }

    public void startGame(){
       timer.start();
    }
    public void stopGame(){
        timer.stop();
    }

    public void actionPerformed(ActionEvent e){

        if(currentLevel.getCurrentLevel() == Level.Levels.ONE) {
            if (levelOne.getIsLevelComplete() && currentLevel.getCurrentLevel() == Level.Levels.ONE) {

                timer.stop();
                initializeLevelTwo();
                mainGameFrame.remove(levelOne);
                mainGameFrame.revalidate();
                mainGameFrame.add(levelTwo);
                mainGameFrame.revalidate();
                mainGameFrame.repaint();
                timer.start();
            }
        }
        if(currentLevel.getCurrentLevel() == Level.Levels.TWO) {
            if (levelTwo.getIsLevelComplete()) {

                timer.stop();
                initializeLevelThree();
                mainGameFrame.remove(levelTwo);
                mainGameFrame.revalidate();
                mainGameFrame.add(levelThree);
                mainGameFrame.revalidate();
                mainGameFrame.repaint();

                timer.start();
            }
        }

        mainGameFrame.repaint();

    }
    public void keyPressed(KeyEvent e){

        if ( e.getKeyCode() == KeyEvent.VK_LEFT ){

            mario.setMarioDirection("LEFT");

        }
        else if ( e.getKeyCode() == KeyEvent.VK_RIGHT ){

            mario.setMarioDirection("RIGHT");

        }
        else if ( e.getKeyCode() == KeyEvent.VK_DOWN ){

            mario.setMarioDirection("DOWN");

        }
        else if ( e.getKeyCode() == KeyEvent.VK_UP ){

            mario.setMarioDirection("UP");

        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE){
            int current_lives = Life.getNumberOfLives() - 1;
            Life.setNumberOfLives(current_lives);
            mario.resetMarioPosition(currentLevel.getCurrentLevel());
        }
        else {
            System.out.println(e.getKeyChar());
        }

    }
    public void keyReleased(KeyEvent e){


    }
    public void keyTyped(KeyEvent e){

    }




}

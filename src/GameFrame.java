/**
 * Created by Cody Thomas Zeitler on 12/8/2015.
 */

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    private int mainWindowWidth; //width of game window
    private int mainWindowHeight; //height of game window
    private String gameName; //name of the game frame. (displayed on the top border)
    private boolean isWindowVisible;

    public GameFrame(String gameName, int mainWindowWidth, int mainWindowHeight){

        //Setting instance variables.
        this.gameName = gameName;
        this.mainWindowWidth = mainWindowWidth;
        this.mainWindowHeight = mainWindowHeight;
        isWindowVisible = true;

        //Sets the title of GameControl to the inputted string gameName.
        this.setTitle(gameName);
        //Re-sizes GameControl so that it has width mainWindowWidth and mainWindowHeight
        this.setSize(mainWindowWidth, mainWindowHeight);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);
    }

    public int getWidth(){
        return mainWindowWidth;
    }
    public int getHeight(){
        return mainWindowHeight;
    }

}
/**
 * Created by Cody Thomas Zeitler on 12/8/2015.
 */

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.nio.Buffer;

public class BackGroundImageGrayMiddle {

    int x_location;

    public int getX(){
        return x_location;
    }

    public void setX(int x_location){
        this.x_location = x_location;
    }

    int y_location;

    public int getY(){
        return y_location;
    }

    public void setY(int y_location){
        this.y_location = y_location;
    }

    int sprite_width;

    public int getWidth(){
        return sprite_width;
    }

    public void setWidth(int sprite_width){
        this.sprite_width = sprite_width;
    }

    int sprite_height;

    public int getHeight(){
        return sprite_height;
    }

    public void setHeight(int sprite_height){
        this.sprite_height = sprite_height;
    }

    final int SX_1 = 17;
    final int SY_1 = 381;
    final int SX_2 = 33;
    final int SY_2 = 397;

    public BackGroundImageGrayMiddle(int x_location, int y_location,
                                     int sprite_width, int sprite_height){
        this.x_location = x_location;
        this.y_location = y_location;
        this.sprite_width = sprite_width;
        this.sprite_height = sprite_height;


    }

    public int getSX1(){
        return SX_1;
    }
    public int getSX2(){
        return SX_2;
    }
    public int getSY1(){
        return SY_1;
    }
    public int getSY2(){
        return SY_2;
    }
}

import turtle.green.GreenTurtleStandingLeft;
import turtle.green.GreenTurtleStandingRight;
import turtle.green.GreenTurtleWalkingLeft;
import turtle.green.GreenTurtleWalkingRight;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Cody Thomas Zeitler on 12/9/2015.
 */
public class GreenTurtle implements ActionListener {

    private GreenTurtleStandingRight standingRight;
    private GreenTurtleWalkingRight walkingRight;
    private GreenTurtleStandingLeft standingLeft;
    private GreenTurtleWalkingLeft walkingLeft;
    private int frame_counter;

    int index_in_linked_list;
    public int getIndexInLinkedList(){return index_in_linked_list;}
    public void setIndexInLinkedList(int index_in_linked_list){this.index_in_linked_list = index_in_linked_list;}

    private int x;
    public int getX(){return x;}
    public void setX(int x){this.x = x;}

    private int y;
    public int getY(){return y;}
    public void setY(int y){this.y = y;}

    private int width;
    public int getWidth(){return width;}
    public void setWidth(int width){this.width = width;}

    private int height;
    public int getHeight(){return height;}
    public void setHeight(int height){this.height = height;}

    /*private boolean isGoingRight;
    public boolean getIsGoingRight(){
        return isGoingRight;
    }
    public void setIsGoingRight(boolean isGoingRight){
        this.isGoingRight = isGoingRight;
    }*/

    private Animation current_frame;
    public void setCurrentFrame(String frame){

        if(frame.equals("STANDING_RIGHT")){
            current_frame = Animation.STANDING_RIGHT;
        }
        else if (frame.equals("WALKING_RIGHT")){
            current_frame = Animation.WALKING_RIGHT;
        }
        else if (frame.equals("STANDING_LEFT")){
            current_frame = Animation.STANDING_LEFT;
        }
        else if (frame.equals("WALKING_LEFT")){
            current_frame = Animation.WALKING_LEFT;
        }
        else{
            System.out.println("Error occurred in setCurrentFrame in GreenTurtle object.");
        }


    }
    public Animation getCurrentFrame(){return current_frame;}



    public GreenTurtle(int x, int y, int width, int height){

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        //isGoingRight = true;

        standingRight = new GreenTurtleStandingRight();
        walkingRight = new GreenTurtleWalkingRight();
        standingLeft = new GreenTurtleStandingLeft();
        walkingLeft = new GreenTurtleWalkingLeft();
        s_locations = new int[4];
        frame_counter = 0;
        current_frame = Animation.STANDING_RIGHT;

        environment = new LinkedList<Rectangle>();

        index_in_linked_list = 0;
    }

    public Rectangle getCollisionRectangle(){
        return new Rectangle(x,y,width,height);
    }

    private enum Animation{

        STANDING_RIGHT, WALKING_RIGHT, STANDING_LEFT, WALKING_LEFT;

    }

    private int[] s_locations;
    //0 will hold SX1
    //1 will hold SY2
    //2 will hold SX2
    //3 will hold SY2
    public int[] getSLocations(){
        frame_counter++;

        if(frame_counter == 15){

            if(current_frame == Animation.STANDING_RIGHT || current_frame == Animation.WALKING_RIGHT){//if(isGoingRight) {
                if (current_frame == Animation.STANDING_RIGHT) {
                    current_frame = Animation.WALKING_RIGHT;
                    frame_counter = 0;
                } else if (current_frame == Animation.WALKING_RIGHT) {
                    current_frame = Animation.STANDING_RIGHT;
                    frame_counter = 0;
                } else {
                    System.out.println("Error occurred in getSLocation() of GreenTurtle.");
                    frame_counter = 0;
                }
            }
            else{

                if(current_frame == Animation.STANDING_LEFT){
                    current_frame = Animation.WALKING_LEFT;
                    frame_counter = 0;
                }
                else if(current_frame == Animation.WALKING_LEFT){
                    current_frame = Animation.STANDING_LEFT;
                    frame_counter = 0;
                }
                else{
                    System.out.println("Error occurred in getSLocation else statement of Green Turtle left");
                    frame_counter = 0;
                }
            }

        }

        if(current_frame == Animation.STANDING_RIGHT){

            s_locations[0] = standingRight.getSX1();
            s_locations[1] = standingRight.getSY1();
            s_locations[2] = standingRight.getSX2();
            s_locations[3] = standingRight.getSY2();
            return s_locations;

        }
        else if (current_frame == Animation. WALKING_RIGHT){

            s_locations[0] = walkingRight.getSX1();
            s_locations[1] = walkingRight.getSY1();
            s_locations[2] = walkingRight.getSX2();
            s_locations[3] = walkingRight.getSY2();
            return s_locations;
        }
        else if (current_frame == Animation.WALKING_LEFT){


            s_locations[0] = walkingLeft.getSX1();
            s_locations[1] = walkingLeft.getSY1();
            s_locations[2] = walkingLeft.getSX2();
            s_locations[3] = walkingLeft.getSY2();



            return s_locations;
        }
        else if (current_frame == Animation.STANDING_LEFT){

            s_locations[0] = standingLeft.getSX1();
            s_locations[1] = standingLeft.getSY1();
            s_locations[2] = standingLeft.getSX2();
            s_locations[3] = standingLeft.getSY2();
            return s_locations;
        }
        else{

            s_locations[0] = standingRight.getSX1();
            s_locations[1] = standingRight.getSY1();
            s_locations[2] = standingRight.getSX2();
            s_locations[3] = standingRight.getSY2();

            System.out.println("Error occurred. Current frame is not equivalent to STANDING or WALKING" +
                    " in getSLocation() in GreenTurtle");

            return s_locations;
        }
    }



    private LinkedList environment;

    public LinkedList getEnvironment(){return environment;}
    public void setEnvironment(LinkedList<Rectangle> environment, int index_of_turtle_collision_box){

        LinkedList<Rectangle> collision_boxes = (LinkedList) environment.clone();

        collision_boxes.remove(index_of_turtle_collision_box);

        this.environment = collision_boxes;
    }
    public void setEnvironment(CollisionBoxList collisionBoxes, int index_of_turtle_collision_box){

        CollisionBoxList _collision_boxes = (CollisionBoxList)collisionBoxes.clone();

        _collision_boxes.remove(index_of_turtle_collision_box);

        environment =_collision_boxes;
    }
    public void actionPerformed(ActionEvent e){

        //Go through every collision box possible on the map. If the turtle collides with one of these collision
        //boxes he needs to turn around.

        boolean collisionDetected = false;

        ListIterator<Rectangle> collision_detector = environment.listIterator();

        while(collision_detector.hasNext()){

            Rectangle temp_rectangle = collision_detector.next();

            if(temp_rectangle.intersects(getCollisionRectangle())) {

                collisionDetected = true;
            }
        }

        if((getCurrentFrame() == Animation.STANDING_LEFT
                || getCurrentFrame() == Animation.WALKING_LEFT)
                 && collisionDetected){


            current_frame = Animation.STANDING_RIGHT;

            int x = getX() + 5;
            setX(x);

        }
        else if ((getCurrentFrame() == Animation.STANDING_RIGHT
                || getCurrentFrame() == Animation.WALKING_RIGHT)
                && collisionDetected){


            current_frame = Animation.STANDING_LEFT;

            int x = getX() - 5;
            setX(x);
        }
        else {
            if(current_frame == Animation.STANDING_LEFT || current_frame == Animation.WALKING_LEFT){


                int new_x_location = getX() - 5;

                setX(new_x_location);
            }

            else if (current_frame == Animation.STANDING_RIGHT || current_frame == Animation.WALKING_RIGHT){

                int new_x_location = getX() + 5;

                setX(new_x_location);
            }
            else {
                System.out.println("Error updating X coordinate of Green Koopa in GreenTurtle object.");
            }
        }

    }



}

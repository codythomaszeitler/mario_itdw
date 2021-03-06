package sprite.sun.animation;

/**
 * Created by Cody Thomas Zeitler on 12/21/2015.
 */
public class SunEyesClosed {

    private final int SX_1;
    public int getSX1(){return SX_1;}

    private final int SY_1;
    public int getSY1(){return SY_1;}

    private final int SX_2;
    public int getSX2(){return SX_2;}

    private final int SY_2;
    public int getSY2(){return SY_2;}

    public  SunEyesClosed(){

        SX_1 = 212;
        SY_1 = 347;
        SX_2 = 243;
        SY_2 = 378;

    }

    public int[] getSLocations(){

        int[] s_locations = new int[4];

        s_locations[0] = getSX1();
        s_locations[1] = getSY1();
        s_locations[2] = getSX2();
        s_locations[3] = getSY2();

        return s_locations;
    }

}

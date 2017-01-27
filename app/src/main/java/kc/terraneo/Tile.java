package kc.terraneo;

import android.graphics.Color;

/**
 * Created by iyaerP on 1/20/2017.
 */

class Tile extends BoardObject {
    private boolean hasPlayer;
    private boolean isSiphoned;
    private boolean hasTemple;
    private int resonance;
    private int color;
    private String artPath;
    private Position position;


    /**
     *
     */
    public Tile(int _resonance, int _color, Position p)
    {
         hasPlayer = false;
        hasTemple = false;
        isSiphoned = false;
        position = p;
        color = _color;
        resonance = _resonance;
        switch(resonance) {
            case -1: artPath = "empty";
                break;
            case 0: artPath = "calm";
                break;
            case 1: artPath = "agitated";
                break;
            case 2: artPath = "violent";
                break;
        }

        switch(color){
            case Color.RED: artPath += "fire";
                break;
            case Color.BLUE: artPath += "water";
                break;
            case Color.YELLOW: artPath += "air";
                break;
            case Color.GREEN: artPath += "earth";
                break;
            case Color.BLACK: artPath += "source";
        }
    }
}

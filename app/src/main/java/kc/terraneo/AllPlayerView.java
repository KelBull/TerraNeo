package kc.terraneo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by John on 4/26/2017.
 */

public class AllPlayerView extends View {

      private GameBoard gameBoard;
    private GameWindow gameWindow;
    private Paint rowPaint;
    private Client parent;

    public AllPlayerView(Client context, GameBoard board, GameWindow window){
        super(context);
        parent = context;
        gameBoard = board;
        gameWindow = window;
    }
    public AllPlayerView(Client context, AttributeSet atters){
        super(context, atters);
        // setOnTouchListener(this);
    }

    protected void onDraw (Canvas canvas){

        super.onDraw(canvas);
        canvas.drawColor(0xff000000); //set the color of the background

    }
}

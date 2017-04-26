package kc.terraneo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by John&Jess on 4/26/2017.
 */

public class UpgradeView extends View {

    private GameBoard gameBoard;
    private GameWindow gameWindow;
    private Paint rowPaint;
    private Client parent;

    public UpgradeView(Client context, GameBoard board, GameWindow window){
        super(context);
        parent = context;
        gameBoard = board;
        gameWindow = window;
        rowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rowPaint.setColor(0xffff0000); // sets the color of the grid
        rowPaint.setStrokeWidth(2); // sets line width of the grid
    }
    public UpgradeView(Client context, AttributeSet atters){
        super(context, atters);
        rowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rowPaint.setColor(0xffff0000); // sets the color of the grid
        rowPaint.setStrokeWidth(2); // sets line width of the grid
        // setOnTouchListener(this);
    }

    protected void onDraw (Canvas canvas){

        super.onDraw(canvas);
        canvas.drawColor(0xff000000); //set the color of the background

    }
}



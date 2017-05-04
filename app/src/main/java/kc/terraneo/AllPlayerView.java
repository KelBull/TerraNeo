package kc.terraneo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

/**
 * Created by John on 4/26/2017.
 */

public class AllPlayerView extends View {

    private GameBoard gameBoard;
    private GameWindow gameWindow;
    private Client parent;
    private int identifier;
    private Activity activity;


    public AllPlayerView(Client context, GameBoard board, GameWindow window){
        super(context);
        parent = context;
        gameBoard = board;
        gameWindow = window;
        activity = context;
    }
    public AllPlayerView(Context context, AttributeSet atters){
        super(context, atters);
        activity = (Activity) context;
        // setOnTouchListener(this);
    }
    public void setBoard (GameBoard board){
        gameBoard = board;
    }
    public void setWindow (GameWindow window){
        gameWindow = window;
    }
    public void setIdentifier(int i)
    {
        identifier = i;
    }

    private void drawPlayer(Canvas canvas, Drawable image) {

        float scale = getHeight()/1584.0f;
        Drawable scaled = new ScaleDrawable(image, Gravity.CENTER, scale, scale);
        if (image != null) {
            image.setBounds(0, 0, getWidth(), getHeight());
            image.draw(canvas);
        }
    }
    protected void onDraw (Canvas canvas){

        super.onDraw(canvas);
        canvas.drawColor(0xff000000); //set the color of the background

        drawPlayer(canvas, activity.getResources().getDrawable(R.drawable.fskt));

    }
}

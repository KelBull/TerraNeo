package kc.terraneo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by John on 4/26/2017.
 */

public class TileView extends View implements View.OnTouchListener {

    private GameBoard gameBoard;
    private GameWindow gameWindow;
    private Activity activity;
    private Paint rowPaint;
    private Client parent;
    private int identifier;
    private Drawable tileImage;
    public static final float S = (float) Math.sqrt(3); //square root of 3

    public TileView(Client context, GameBoard board, GameWindow window){
        super(context);
        parent = context;
        gameBoard = board;
        gameWindow = window;
        activity = context;
        rowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rowPaint.setColor(0xffff0000); // sets the color of the grid
        rowPaint.setStrokeWidth(2); // sets line width of the grid
    }
    public TileView(Context context, AttributeSet atters){
        super(context, atters);
        rowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rowPaint.setColor(0xffff0000); // sets the color of the grid
        rowPaint.setStrokeWidth(2); // sets line width of the grid
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

    private void drawHex(Canvas canvas) { //draws a hex
        float cy = getHeight()/2;
        float cx = getWidth()/2;
        float r = gameBoard.getTileRadius();

        float By = cy - (S / 2) * r;
        float Ax = cx + r;
        float Ay = cy;
        float Bx = cx + (r / 2);
        float Cx = cx - (r / 2);
        float Cy = By;
        float Dx = cx - r;
        float Dy = Ay;
        float Ex = Cx;
        float Ey = cy + (S / 2) * r;
        float Fx = Bx;
        float Fy = Ey;

        canvas.drawLine(Ax, Ay, Bx, By, rowPaint); //Point A to B
        canvas.drawLine(Bx, By, Cx, Cy, rowPaint); //Point B to C
        canvas.drawLine(Cx, Cy, Dx, Ay, rowPaint); //Point C to D
        canvas.drawLine(Dx, Dy, Ex, Ey, rowPaint); //Point D to E
        canvas.drawLine(Ex, Ey, Fx, Fy, rowPaint); //Point E to F
        canvas.drawLine(Fx, Fy, Ax, Ay, rowPaint); //Point F to A
       // Log.i("neo gen", "drawing hex " + x + "," + y + " centered at " + cx + "," + cy);
//        Log.i("neo gen", "points: "+Ax+","+Ay+" "+Bx+","+By+" "+
//                Cx+","+Cy+" "+Dx+","+Dy+" "+Ex+","+Ey+" "+Fx+","+Fy);
    }

    private void drawTile(Canvas canvas, Drawable image) {
        float r = gameBoard.getTileRadius();
        float cy = getHeight()/2;
        float cx = getWidth()/2;

        float scale = 2 * (r/150);
        Drawable scaled = new ScaleDrawable(image, Gravity.CENTER, scale, scale);
        image.setBounds((int)(cx-r), (int)(cy-r*(S/2)), (int)(cx +r), (int)(cy+r*(S/2)));
        // image.setBounds(350,150,500,300);
        image.draw(canvas);
    }

    protected void onDraw (Canvas canvas){

        super.onDraw(canvas);
        canvas.drawColor(0xff000000); //set the color of the background

        drawHex(canvas);
        //tileImage = activity.getResources().getDrawable(R.drawable.violent_earth);
        Tile t;
        switch(identifier)
        {
            case 1: t = gameWindow.getTileSource1().peek();
                break;
            case 2: t = gameWindow.getTileSource2().peek();
                break;
            case 3: t = gameWindow.getTileSource3().peek();
                break;
            case 4: t = gameWindow.getTileSource4().peek();
                break;
            default: t= new EmptyTile(new OffBoardPosition());
        }
        String path = t.getArtPath();
        switch(path)
        {
            case "violent_earth.png": tileImage = activity.getResources().getDrawable(R.drawable.violent_earth);
                break;
            case "agitated_earth.png": tileImage = activity.getResources().getDrawable(R.drawable.agitated_earth);
                break;
            case "calm_earth.png": tileImage = activity.getResources().getDrawable(R.drawable.calm_earth);
                break;
            case "violent_wind.png": tileImage = activity.getResources().getDrawable(R.drawable.violent_wind);
                break;
            case "agitated_wind.png": tileImage = activity.getResources().getDrawable(R.drawable.agitated_wind);
                break;
            case "calm_wind.png": tileImage = activity.getResources().getDrawable(R.drawable.calm_wind);
                break;
            case "violent_fire.png": tileImage = activity.getResources().getDrawable(R.drawable.violent_fire);
                break;
            case "agitated_fire.png": tileImage = activity.getResources().getDrawable(R.drawable.agitated_fire);
                break;
            case "calm_fire.png": tileImage = activity.getResources().getDrawable(R.drawable.calm_fire);
                break;
            case "violent_water.png": tileImage = activity.getResources().getDrawable(R.drawable.violent_water);
                break;
            case "agitated_water.png": tileImage = activity.getResources().getDrawable(R.drawable.agitated_water);
                break;
            case "calm_water.png": tileImage = activity.getResources().getDrawable(R.drawable.calm_water);
                break;
            default: tileImage = activity.getResources().getDrawable(R.drawable.source_tile);
        }
        drawTile(canvas, tileImage);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            //This is where we do click and drag stuff!
            //TODO: IMPLEMENT

        }
        return false;
    }
}

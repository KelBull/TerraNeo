package kc.terraneo;
/**
 * Created by John Candido.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.HashMap;
import java.util.Map;


/**
GAME BOARD SET UP
if 2 or 3 players  |    if 4 players     |    if 5 or 6 players
    radius = 3     |     radius = 4      |      radius = 5
*/
public class GridView extends View implements View.OnTouchListener {

    private RelativeLayout mRelativeLayout;
    private Activity activity;
    private GameBoard gameBoard;
    private GameWindow gameWindow;
    private Paint rowPaint;
    private Client parent;
    private Map<String, Drawable> tileImages;
    int hexSize = 50;
    private float r;
    public static final float S = (float) Math.sqrt(3); //square root of 3
    float topMargin;
    float leftMargin;
    int radius;



    public GridView(Client context, GameBoard board, GameWindow window) {
        super(context);
        parent = context;
        gameBoard = board;
        gameWindow = window;
        rowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rowPaint.setColor(0xffff0000); // sets the color of the grid
        rowPaint.setStrokeWidth(2); // sets line width of the grid
        activity = context;
        radius = gameBoard.getRadius();
        setOnTouchListener(this);
        tileImages = new HashMap<>();
    }

    public GridView(Context context, AttributeSet atters) {
        super(context, atters);
        rowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rowPaint.setColor(0xffff0000); // sets the color of the grid
        rowPaint.setStrokeWidth(2); // sets line width of the grid
        activity = (Activity) context;
        setOnTouchListener(this);
        tileImages = new HashMap<>();
    }

    public void setBoard (GameBoard board){
        gameBoard = board;
        radius = gameBoard.getRadius();
    }
    public void setWindow (GameWindow window){
        gameWindow = window;
        radius = gameBoard.getRadius();
    }
    public void setParent(Client c)
    {
        parent = c;
    }

    public boolean AddTile(Tile tile, float x, float y)
    { //move a tile
        //TODO: draw dat tile!
        return false;
    }


    public Tile ChooseTile(float x, float y){ //select a tile that has already been played
        float edgeX = x - r;
        float edgeY = y + (S / 2) * r;
        int column;
        int row;

        for (column = 0; column < radius*2; column++){
            float cx = computeCenterX(column);
            if (edgeX < cx){
                //return new IllegalTile(gameBoard, new OffBoardPosition());
                break;
            }
        }
        for (row = 0; row< radius*2; row++){
            float cy = computeCenterY(column, row);
            if (edgeY > cy){
                //return new IllegalTile(gameBoard, new OffBoardPosition());
                break;
            }
        }
        int maxSize = gameBoard.getGridSide();
        if(column > maxSize)
        {
            column = maxSize-1;
        }
        if(row > maxSize)
        {
            row = maxSize-1;
        }
        Tile t = gameBoard.getTileAt(column, row);
        Log.i ("terraneo", "found " + x + "," + y + " at " + column + "," + row);
        Log.i ("terraneo", "found Tile "+ t );
        return t;
    }

    private void drawHex(Canvas canvas, int x, int y) { //draws a hex
        float cy;
        float cx = computeCenterX(x);
        cy = computeCenterY(x, y);

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
        Log.i("neo gen", "drawing hex " + x + "," + y + " centered at " + cx + "," + cy);
//        Log.i("neo gen", "points: "+Ax+","+Ay+" "+Bx+","+By+" "+
//                Cx+","+Cy+" "+Dx+","+Dy+" "+Ex+","+Ey+" "+Fx+","+Fy);
    }

    private float computeCenterY(int x, int y) {
        float cy;
        if (x % 2 == 0) {
            cy = getHeight() - (y * S * r + (S / 2) * r + (S / 2) * r + topMargin);
        } else
            cy = getHeight() - (y * S * r + (S / 2) * r + topMargin);
        return cy;
    }

    private float computeCenterX(int x) {
        return x * 1.5f * r + r + leftMargin;
    }

    private int firstColumn(int row, int radius) {
        int start = -1;
        if (radius == 3) {
            switch (row) {
                case 0:
                    start = 2;
                    break;
                case 1:
                    start = 0;
                    break;
                case 2:
                    start = 0;
                    break;
                case 3:
                    start = 0;
                    break;
                case 4:
                    start = 0;
                    break;
                case 5:
                    start = 1;
                    break;
                case 6:
                    start = 3;
                    break;
            }
        } else if (radius == 4) {
            switch (row) {
                case 0:
                    start = 4;
                    break;
                case 1:
                    start = 2;
                    break;
                case 2:
                    start = 0;
                    break;
                case 3:
                    start = 0;
                    break;
                case 4:
                    start = 0;
                    break;
                case 5:
                    start = 0;
                    break;
                case 6:
                    start = 0;
                    break;
                case 7:
                    start = 1;
                    break;
                case 8:
                    start = 3;
                    break;
            }
        } else if (radius == 5) {
            switch (row) {
                case 0:
                    start = 6;
                    break;
                case 1:
                    start = 4;
                    break;
                case 2:
                    start = 2;
                    break;
                case 3:
                    start = 0;
                    break;
                case 4:
                    start = 0;
                    break;
                case 5:
                    start = 0;
                    break;
                case 6:
                    start = 0;
                    break;
                case 7:
                    start = 0;
                    break;
                case 8:
                    start = 0;
                    break;
                case 9:
                    start = 1;
                    break;
                case 10:
                    start = 3;
                    break;
            }
        }
        return start;
    }

    private int lastColumn(int row, int radius) {
        int last = -1;
        if (radius == 3) {
            switch (row) {
                case 0:
                    last = 4;
                    break;
                case 1:
                    last = 6;
                    break;
                case 2:
                    last = 6;
                    break;
                case 3:
                    last = 6;
                    break;
                case 4:
                    last = 6;
                    break;
                case 5:
                    last = 5;
                    break;
                case 6:
                    last = 3;
                    break;
            }
        }
        else if (radius == 4){
            switch (row) {
                case 0:
                    last = 4;
                    break;
                case 1:
                    last = 6;
                    break;
                case 2:
                    last = 8;
                    break;
                case 3:
                    last = 8;
                    break;
                case 4:
                    last = 8;
                    break;
                case 5:
                    last = 8;
                    break;
                case 6:
                    last = 8;
                    break;
                case 7:
                    last = 7;
                    break;
                case 8:
                    last = 5;
                    break;
            }
        }
        else if (radius == 5){
            switch (row) {
                case 0:
                    last = 4;
                    break;
                case 1:
                    last = 6;
                    break;
                case 2:
                    last = 8;
                    break;
                case 3:
                    last = 10;
                    break;
                case 4:
                    last = 10;
                    break;
                case 5:
                    last = 10;
                    break;
                case 6:
                    last = 10;
                    break;
                case 7:
                    last = 10;
                    break;
                case 8:
                    last = 10;
                    break;
                case 9:
                    last = 9;
                    break;
                case 10:
                    last = 7;
                    break;
            }
        }
        return last;
    }
    private void drawTile(Canvas canvas, int row, int column, Drawable image)
    {
        float cy;
        float cx = computeCenterX(column);
        cy = computeCenterY(column, row);
        float scale = 2 * (r/150);
        //Drawable scaled = new ScaleDrawable(image, Gravity.CENTER, scale, scale);
        image.setBounds((int)(cx-r), (int)(cy-r*(S/2)), (int)(cx +r), (int)(cy+r*(S/2)));
       // image.setBounds(350,150,500,300);
        image.draw(canvas);
    }
    @Override
    public boolean onTouch (View view, MotionEvent event)
    {
        switch (event.getAction()){
               case MotionEvent.ACTION_DOWN: Tile t = ChooseTile (event.getX(), event.getY());
                   Log.i("debugging", "Tile:" +t);
                   int sourceVal = gameWindow.getSourceTracker();
                    if(gameWindow.pushLocationTwo(t.getLocation(), parent.getCurrentPlayer()))
                    {
                        Log.i("pushing ",t.getLocation()+" ");
                        //Drawable d = findResource(t.getArtPath());
                        //drawTile(canvasC,t.getLocation().getX(), t.getLocation().getY(), d);

                        invalidate();
                        TileView tV;
                        switch (sourceVal)
                        {
                            case 1: tV= parent.getTileSource1();
                                tV.invalidate();
                                break;
                            case 2:
                                tV = parent.getTileSource2();
                                tV.invalidate();
                                break;

                            case 3:
                                tV = parent.getTileSource3();
                                tV.invalidate();
                                break;

                            case 4:
                                tV = parent.getTileSource4();
                                tV.invalidate();
                                break;
                        }
                        return true;
                    }
                   break;
        }
        return false;
    }
        @Override
    protected void onDraw (Canvas canvas)
    { //draws the grid\
            super.onDraw(canvas);
            canvas.drawColor(0xff000000); //set the color of the background
            float h = getHeight()-30; //gets the height of the screen
            float w = getWidth()-30; //gets the width of the screen
            int numTiles = radius * 2 + 1;

            float maxWidth = w / (1.5f * numTiles);
            float maxHeight = h / (S * numTiles);

            r = Math.min(maxWidth, maxHeight); //calculates the radius of each hex
            gameBoard.setTileRadius(r);

            leftMargin = (getWidth()-(r*numTiles*1.5f))/2;
            topMargin = ((getHeight()-(r*numTiles*S))/2)-25;

         // Log.i("neo gen", "drawing grid with r="+r + " w =" +w +" h=" +h);

            for (int row = 0; row < numTiles; row++) {
                for (int column = firstColumn(row, radius); column <= lastColumn(row, radius); column++) {
                    drawHex(canvas, column, row);
                }
            }
            //Drawable tileSource = activity.getResources().getDrawable(R.drawable.source_hex);
            //drawTile(canvas, radius, radius, tileSource);

        for (int row = 0; row < numTiles; row++) {
            for (int column = firstColumn(row, radius); column <= lastColumn(row, radius); column++) {

                Tile t = gameBoard.getTileAt(column, row);
                Drawable tileImage = findResource(t.getArtPath());
                drawTile(canvas, row, column, tileImage);
                Log.i("neo gen", "drawing tile: "+t);
            }
            Drawable tileSource = activity.getResources().getDrawable(R.drawable.source_hex);
            drawTile(canvas, radius, radius, tileSource);
        }
    }

    protected Drawable findResource(String artPath)
    {
        Drawable tileImage;
        if(tileImages.containsKey(artPath))
        {
            return tileImages.get(artPath);
        }
        switch(artPath)
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
            default: tileImage = activity.getResources().getDrawable(R.drawable.empty_hex);

        }
        tileImages.put(artPath,tileImage);

        return tileImage;
    }

}








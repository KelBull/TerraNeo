package kc.terraneo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by John on 4/26/2017.
 */

public class UpgradeView extends View {

    private GameBoard gameBoard;
    private GameWindow gameWindow;
    private Client parent;
    private int identifier;
    private Activity activity;
    private Drawable upgradeImage;

    public UpgradeView(Client context, GameBoard board, GameWindow window){
        super(context);
        parent = context;
        gameBoard = board;
        gameWindow = window;
        activity = context;
    }
    public UpgradeView(Context context, AttributeSet atters){
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

    private void drawUpgrade(Canvas canvas, Drawable image) {

        float scale = getHeight()/1275.0f;
        Drawable scaled = new ScaleDrawable(image, Gravity.CENTER, scale, scale);
        if (image != null) {
            image.setBounds(0, 0, getWidth(), getHeight());
            image.draw(canvas);
        }
    }

    @Override
    protected void onDraw (Canvas canvas){

        super.onDraw(canvas);
        canvas.drawColor(0xff000000); //set the color of the background

        Upgrade u;
        switch(identifier) {
            case 1: u = gameWindow.getUpgradeSource1().peek();
                break;
            case 2: u = gameWindow.getUpgradeSource2().peek();
                break;
            case 3: u = gameWindow.getUpgradeSource3().peek();
                break;
            default: u = null;

        }
        String path = u.getArtPath();
        if (path == null) {
            path = "";
        }
        switch(path) {
            case "card_chaos.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_chaos);
                break;
            case "card_cities.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_cities);
                break;
            case "card_crime.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_crime);
                break;
            case "card_death.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_death);
                break;
            case "card_destruction.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_destruction);
                break;
            case "card_dreams.png":upgradeImage = activity.getResources().getDrawable(R.drawable.card_dreams);
                break;
            case "cad_exploration.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_exploration);
                break;
            case "card_games.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_games);
                break;
            case "card_harvests.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_harvests);
                break;
            case "card_invention.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_invention);
                break;
            case "card_knowledge.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_knowledge);
                break;
            case "card_magic.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_magic);
                break;
            case "card_medicine.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_medicine);
                break;
            case "card_music.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_music);
                break;
            case "card_plague.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_plague);
                break;
            case "card_time.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_time);
                break;
            case "card_war.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_war);
                break;
            case "card_wealth.png": upgradeImage = activity.getResources().getDrawable(R.drawable.card_wealth);
                break;
            default: upgradeImage = null;
        }
        drawUpgrade(canvas, upgradeImage);
    }

    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            //This is where we do click and drag stuff!
            //TODO: IMPLEMENT

        }
        return false;
    }
}



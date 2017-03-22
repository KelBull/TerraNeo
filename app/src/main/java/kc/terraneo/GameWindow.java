package kc.terraneo;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

import kc.terraneo.R;
import kc.terraneo.upgrades.Chaos;
import kc.terraneo.upgrades.Cities;
import kc.terraneo.upgrades.Crime;
import kc.terraneo.upgrades.Death;
import kc.terraneo.upgrades.Destruction;
import kc.terraneo.upgrades.Dreams;
import kc.terraneo.upgrades.Exploration;
import kc.terraneo.upgrades.Games;
import kc.terraneo.upgrades.Harvests;
import kc.terraneo.upgrades.Invention;
import kc.terraneo.upgrades.Knowledge;
import kc.terraneo.upgrades.Magic;
import kc.terraneo.upgrades.Medicine;
import kc.terraneo.upgrades.Music;
import kc.terraneo.upgrades.Plague;
import kc.terraneo.upgrades.Time;
import kc.terraneo.upgrades.War;
import kc.terraneo.upgrades.Wealth;

public class GameWindow extends AppCompatActivity {
    GameBoard gBoard;
    UpgradeSource uS1;
    UpgradeSource uS2;
    UpgradeSource uS3;
    TileSource tS1;
    TileSource tS2;
    TileSource tS3;
    TileSource tS4;
    ArrayList<Tile> masterTileList;
    ArrayList<Upgrade> masterUpgradeList;

    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_window);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    /**
     * starts the game client up for a new session. This should only ever be run once/game
     * @param numPlayers the number of players
     */
    private void start(int numPlayers)
    {
        try {
            gBoard = new GameBoard(numPlayers);
        }catch(Exception e){
            Log.e("error",e.getMessage());
        }
        populateTileList();
        Collections.shuffle(masterTileList);
        Collections.shuffle(masterUpgradeList);

        Tile[] tiles = new Tile[27];
        Tile[] tiles2 = new Tile[27];
        Tile[] tiles3 = new Tile[27];
        Tile[] tiles4 = new Tile[27];
        for(int i=0; i<27; i++)
        {
            tiles[i] = masterTileList.get(i);
            tiles2[i] = masterTileList.get(i+27);
            tiles3[i] = masterTileList.get(i+54);
            tiles4[i] = masterTileList.get(i+81);
        }
        tS1 = new TileSource(tiles);
        tS2 = new TileSource(tiles2);
        tS3 = new TileSource(tiles3);
        tS4 = new TileSource(tiles4);

        Upgrade[] u1 = new Upgrade[6];
        Upgrade[] u2 = new Upgrade[6];
        Upgrade[] u3 = new Upgrade[6];

        for(int i=0; i<6; i++)
        {
            u1[i] = masterUpgradeList.get(i);
            u2[i] = masterUpgradeList.get(i+6);
            u3[i] = masterUpgradeList.get(i+12);
        }
        uS1 = new UpgradeSource(u1);
        uS2 = new UpgradeSource(u2);
        uS3 = new UpgradeSource(u3);

        for(int i=0; i<numPlayers; i++)
        {
            //TODO: add a popup that asks each player to pick a god
        }
    }

    /**
     * fills the masterTileList with all the tiles for the game
     */
    private void populateTileList()
    {
        masterTileList = new ArrayList<Tile>();
        for(int i = 0; i<9; i++)
        {
            for(int j = 1; j<4; j++)
            {
                masterTileList.add(new Tile(j, Color.RED, new OffBoardPosition()));
                masterTileList.add(new Tile(j, Color.GREEN, new OffBoardPosition()));
                masterTileList.add(new Tile(j, Color.YELLOW, new OffBoardPosition()));
                masterTileList.add(new Tile(j, Color.BLUE, new OffBoardPosition()));
            }
        }

        masterUpgradeList = new ArrayList<Upgrade>();
        masterUpgradeList.add(new Chaos());
        masterUpgradeList.add(new Cities());
        masterUpgradeList.add(new Crime());
        masterUpgradeList.add(new Death());
        masterUpgradeList.add(new Destruction());
        masterUpgradeList.add(new Dreams());
        masterUpgradeList.add(new Exploration());
        masterUpgradeList.add(new Games());
        masterUpgradeList.add(new Harvests());
        masterUpgradeList.add(new Invention());
        masterUpgradeList.add(new Knowledge());
        masterUpgradeList.add(new Magic());
        masterUpgradeList.add(new Medicine());
        masterUpgradeList.add(new Music());
        masterUpgradeList.add(new Plague());
        masterUpgradeList.add(new Time());
        masterUpgradeList.add(new War());
        masterUpgradeList.add(new Wealth());
    }
}

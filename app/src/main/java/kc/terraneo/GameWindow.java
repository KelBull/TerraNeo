package kc.terraneo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

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

public class GameWindow{
    private GameBoard gBoard;
    private UpgradeSource uS1;
    private UpgradeSource uS2;
    private UpgradeSource uS3;
    private TileSource tS1;
    private TileSource tS2;
    private TileSource tS3;
    private TileSource tS4;
    private ArrayList<Tile> masterTileList;
    private ArrayList<Upgrade> masterUpgradeList;
    private ArrayList<Player> players;
    private Intent intent;
    private int playerCount;

    //God[] remainingGods;


    public GameWindow(GameBoard gB)
    {
        gBoard = gB;
        playerCount = gBoard.getPlayerCount();
        String godName;
        players = new ArrayList<Player>();
        for(int i=0; i< playerCount; i++)
        {
            godName = God.getGodNames()[i];
            players.add(new Player("Player"+i, new God(godName), gBoard, this));
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

    }
    /**
     * starts the game client up for a new session. This should only ever be run once/game
     */
    private void start()
    {


        for(int i=0; i<playerCount; i++)
        {
            //start at new activity to give each player a god
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
                masterTileList.add(new Tile(gBoard, j, Color.RED, new OffBoardPosition()));
                masterTileList.add(new Tile(gBoard, j, Color.GREEN, new OffBoardPosition()));
                masterTileList.add(new Tile(gBoard, j, Color.YELLOW, new OffBoardPosition()));
                masterTileList.add(new Tile(gBoard, j, Color.BLUE, new OffBoardPosition()));
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

    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    public UpgradeSource getUpgradeSource1() {
        return uS1;
    }

    public UpgradeSource getUpgradeSource2() {
        return uS2;
    }

    public UpgradeSource getUpgradeSource3() {
        return uS3;
    }
    public TileSource getTileSource1() {
        return tS1;
    }

    public TileSource getTileSource2() {
        return tS2;
    }

    public TileSource getTileSource3() {
        return tS3;
    }

    public TileSource getTileSource4() {
        return tS4;
    }

}

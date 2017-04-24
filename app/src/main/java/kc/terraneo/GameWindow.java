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
    ArrayList<Player> players;
    Intent intent;
    private int playerCount;

    //God[] remainingGods;


    public GameWindow(GameBoard gB) {

        playerCount = gB.getPlayerCount();
        String godName;
        for(int i=0; i< playerCount; i++)
        {
            godName = God.getGodNames()[i];
            players.add(new Player("Player"+i, new God(godName)));
        }

       /* remainingGods  = new God[6];
        remainingGods[0] = new God("fskt");
        remainingGods[1] = new God("shaelys");
        remainingGods[2] = new God("pundr");
        remainingGods[3] = new God("lomhae");
        remainingGods[4] = new God("tkyrll");
        remainingGods[5] = new God("zolack");*/

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

    /*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super(requestCode, resultCode, data);
        switch(resultCode){
            case 10000:
           // numPlayers = resultCode-999;
                break;
            case 10010:
                players.add(new Player(remainingGods[0]));
                remainingGods[0]=null;
                break;
            case 10011:
                players.add(new Player(remainingGods[1]));
                remainingGods[1]=null;
                break;
            case 10012:
                players.add(new Player(remainingGods[2]));
                remainingGods[2]=null;
                break;
            case 10013:
                players.add(new Player(remainingGods[3]));
                remainingGods[3]=null;
                break;
            case 10014:
                players.add(new Player(remainingGods[4]));
                remainingGods[4]=null;
                break;
            case 10015:
                players.add(new Player(remainingGods[5]));
                remainingGods[5]=null;
                break;


        }
    }*/

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

    public ArrayList<Player> getPlayers()
    {
        return players;
    }
}

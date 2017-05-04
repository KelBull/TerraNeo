package kc.terraneo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

public class Client extends AppCompatActivity {
    private GameWindow gameWindow;
    private int playerCount;
    private GameBoard board;
    private Player currentPlayer;
    private int currentPlayerNum;
    private int actionCount;
    private int remainingTurns;
    private boolean isRunning;
    private TileView tilePile1;
    private TileView tilePile2;
    private TileView tilePile3;
    private TileView tilePile4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        Bundle bundle = getIntent().getExtras();
        playerCount = bundle.getInt("playerCount", 4);
        board = new GameBoard(playerCount);
        gameWindow = new GameWindow(board);
        currentPlayer = gameWindow.getPlayers().get(0);
        currentPlayerNum = 0;
        actionCount = 0;

        remainingTurns = Integer.MAX_VALUE;
        GridView grid = (GridView) findViewById(R.id.grid);
        grid.setBoard(board);
        grid.setWindow(gameWindow);
        grid.setParent(this);

        tilePile1 = (TileView) findViewById(R.id.pileOne);
        tilePile1.setBoard(board);
        tilePile1.setWindow(gameWindow);
        tilePile1.setIdentifier(1);

        tilePile2 = (TileView) findViewById(R.id.pileTwo);
        tilePile2.setBoard(board);
        tilePile2.setWindow(gameWindow);
        tilePile2.setIdentifier(2);

        tilePile3 = (TileView) findViewById(R.id.pileThree);
        tilePile3.setBoard(board);
        tilePile3.setWindow(gameWindow);
        tilePile3.setIdentifier(3);

        tilePile4 = (TileView) findViewById(R.id.pileFour);
        tilePile4.setBoard(board);
        tilePile4.setWindow(gameWindow);
        tilePile4.setIdentifier(4);

        UpgradeView upgrade = (UpgradeView) findViewById(R.id.upgradeOne);
        upgrade.setBoard(board);
        upgrade.setWindow(gameWindow);
        upgrade.setIdentifier(1);

        upgrade = (UpgradeView) findViewById(R.id.upgradeTwo);
        upgrade.setBoard(board);
        upgrade.setWindow(gameWindow);
        upgrade.setIdentifier(2);

        upgrade = (UpgradeView) findViewById(R.id.upgradeThree);
        upgrade.setBoard(board);
        upgrade.setWindow(gameWindow);
        upgrade.setIdentifier(3);

        CurrentPlayerView currentplayer = (CurrentPlayerView) findViewById(R.id.currentPlayer);
        currentplayer.setBoard(board);
        currentplayer.setWindow(gameWindow);


       /* AllPlayerView player = (AllPlayerView) findViewById(R.id.playerOne);
        player.setBoard(board);
        player.setWindow(gameWindow);

        player = (AllPlayerView) findViewById(R.id.playerTwo);
        player.setBoard(board);
        player.setWindow(gameWindow);

        player = (AllPlayerView) findViewById(R.id.playerThree);
        player.setBoard(board);
        player.setWindow(gameWindow);

        player = (AllPlayerView) findViewById(R.id.playerFour);
        player.setBoard(board);
        player.setWindow(gameWindow);*/


        isRunning = true;
        startTurn(currentPlayer);
       //ViewGroup V = (ViewGroup)findViewById(R.id.activity_grid);
       //V.addView(new GridView(this, board, gameWindow));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gameboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * runs the game
     * I don't actually know if we need this or not
    private void runGame()
    {
        while(isRunning)
        {
            startTurn(currentPlayer);
        }
    }*/

    private void passTurn()
    {
        if(remainingTurns==0)
        {
            Intent intent = new Intent(this, EndGame.class);
            for(Player p: gameWindow.getPlayers())
            {
                intent.putExtra(p.getName(), p.getScore());
            }
            startActivity(intent);
        }
        if(doesGameEnd() && remainingTurns > playerCount)
        {
            remainingTurns = playerCount;
        }
        currentPlayerNum++;
        if(currentPlayerNum == gameWindow.getPlayers().size())
        {
            currentPlayerNum = 0;
        }
        currentPlayer = gameWindow.getPlayers().get(currentPlayerNum);

        remainingTurns--;
        startTurn(currentPlayer);
    }

    private void startTurn(Player p)
    {
        actionCount = 0;
        p.setLastActionTaken(null);
        p.updateLegalActions();

        //TODO: change the UI so that the current player's god is centered. highlight their pawn.
    }

    private boolean doesGameEnd()
    {
        if(currentPlayer.getGod().getTempleCount()==0)
            return true;
        else
            return false;
    }

    public Player getCurrentPlayer(){ return currentPlayer;}
    public GameWindow getGameWindow(){return gameWindow;}
    public GameBoard getBoard(){return board;}
    public TileView getTileSource1(){return tilePile1;}
    public TileView getTileSource2(){return tilePile2;}
    public TileView getTileSource3(){return tilePile3;}
    public TileView getTileSource4(){return tilePile4;}
}

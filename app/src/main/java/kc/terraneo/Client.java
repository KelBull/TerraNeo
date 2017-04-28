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

        TileView tilePile = (TileView) findViewById(R.id.pileOne);
        tilePile.setBoard(board);
        tilePile.setWindow(gameWindow);

        tilePile = (TileView) findViewById(R.id.pileTwo);
        tilePile.setBoard(board);
        tilePile.setWindow(gameWindow);

        tilePile = (TileView) findViewById(R.id.pileThree);
        tilePile.setBoard(board);
        tilePile.setWindow(gameWindow);

        tilePile = (TileView) findViewById(R.id.pileFour);
        tilePile.setBoard(board);
        tilePile.setWindow(gameWindow);

        //UpgradeView upgrade = (UpgradeView) findViewById(R.id.grid);
        //upgrade.setBoard(board);
        //upgrade.setWindow(gameWindow);

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

        //TODO: change the UI so that the current player's god is centered. highlight their pawn.
    }

    private boolean doesGameEnd()
    {
        if(currentPlayer.getGod().getTempleCount()==0)
            return true;
        else
            return false;
    }

}

package kc.terraneo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;


/*
GAME BOARD SET UP
if 2 or 3 players  |    if 4 players     |    if 5 or 6 players
    radius = 3     |     radius = 4      |      radius = 5

    H H H H              H H H H H              H H H H H H
   H H H H H            H H H H H H            H H H H H H H
  H H H H H H          H H H H H H H          H H H H H H H H
 H H H 0 H H H        H H H H H H H H        H H H H H H H H H
  H H H H H H        H H H H 0 H H H H      H H H H H H H H H H
   H H H H H          H H H H H H H H      H H H H H 0 H H H H H
    H H H H            H H H H H H H        H H H H H H H H H H
                        H H H H H H          H H H H H H H H H
                         H H H H H            H H H H H H H H
                                               H H H H H H H
                                                H H H H H H
 */


public class GridActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    GameBoard boardSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.activity_grid);
        boardSize = new GameBoard(4);

        int hexSize = 60;

        int radius = boardSize.getRadius() * 2 + 1; //radius of grid

        int[][] board = new int[radius][radius];



    }
}







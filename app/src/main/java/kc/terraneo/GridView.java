package kc.terraneo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
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


public class GridView extends View {

    private RelativeLayout mRelativeLayout;
    private GameBoard boardSize;
    private Paint rowPaint;
    int hexSize = 50;

    public GridView(Context context, GameBoard board) {
        super(context);
        boardSize = board;
        rowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rowPaint.setColor(0xffff0000);
        rowPaint.setTextSize(4*hexSize/5);
    }
        @Override
        protected void onDraw (Canvas canvas){


            super.onDraw(canvas);
            float h = getHeight();
            float w = getWidth();

            int radius = boardSize.getRadius() * 2 + 1; //radius of grid

            int[][] board = new int[radius][radius];


            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    canvas.drawText("0", 0, 0, rowPaint);
                }
            }
        }
}







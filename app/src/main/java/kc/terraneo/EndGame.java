package kc.terraneo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import kc.terraneo.R;

public class EndGame extends AppCompatActivity {

    TableLayout layout;
    TextView finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        finalScore = new TextView(this);
        int players = getIntent().getIntExtra("playerCount",2);
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for(int i=0; i<players; i++)
        {
            names.add(i, "Player"+i);
            scores.add(i, getIntent().getIntExtra(names.get(i),0));
        }
        int winNum = Collections.max(scores);
        finalScore.setText("The winner is: "+ names.get(winNum) + ", with a score of: "+scores.get(winNum));

    }

}

package kc.terraneo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ChooseGod extends AppCompatActivity {
    ArrayList<String> godList;
    TableLayout layout;
    int iterator;
    int playerCount;
    int playerIterator;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_god);
        layout = (TableLayout) findViewById(R.id.TableLayout);
        godList = new ArrayList<>();

        for(int i=0; i<God.getGodNames().length; i++)
        {
            godList.add(God.getGodNames()[i]);
        }
        iterator = 1;
        playerIterator = 1;
        playerCount = getIntent().getIntExtra("playerCount", 0);
        intent = new Intent(this.getApplicationContext(), MainActivity.class);
        TableRow row0 = new TableRow(this);
        TextView label = new TextView(this);
        label.setText("Player "+playerIterator+", select your god.");
        row0.addView(label);
        layout.addView(row0);

        relistGods();

    }

    private void relistGods()
    {
        for(int i=0; i<godList.size(); i++)
        {
            TableRow row = new TableRow(this);
            Button bob = new Button(this);
            bob.setText(godList.get(i));

            bob.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    iterator++;
                    String name = (((Button)v).getText()).toString();
                    Log.i("Adding god","Successfully added new God "+name);
                    addGod(name);
                    godList.remove(name);
                    iterator=0;
                    relistGods();
                    if(iterator==playerCount) {
                        startActivity(intent);
                        finish();
                    }
                }

            });
            row.addView(bob);
            layout.addView(row);
        }
    }
    protected void addGod(String name)
    {
        intent.putExtra("Player"+playerIterator,name);
        playerIterator++;
    }

}

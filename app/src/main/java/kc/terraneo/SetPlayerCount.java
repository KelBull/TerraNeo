package kc.terraneo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

public class SetPlayerCount extends AppCompatActivity {
    private int playerCount;
    TableLayout layout;
    TextView label;
    EditText typer;
    Button done;
    final int minPlayers = 2;
    final int maxPlayers = 6;
    Intent returnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_player_count);
        layout = (TableLayout)findViewById(R.id.TableLayout3);

        label = (TextView)findViewById(R.id.textView1);
        typer = (EditText)findViewById(R.id.editText1);
        done = (Button)findViewById(R.id.button1);
        done.setText("Set Player Count");
        returnIntent = new Intent();
    }
    public void onClick(View v) {

    }
    public void done(View v)
    {
        try
        {
            playerCount = (Integer.valueOf(typer.getText().toString())).intValue();
            if(playerCount < minPlayers || playerCount > maxPlayers)
            {
                return;
            }
            Log.i("done clicked","playerCount got: "+String.valueOf(playerCount));
            returnIntent = new Intent(this, Client.class);
            returnIntent.putExtra("playerCount", playerCount);
            startActivity(returnIntent);
        }catch(Exception e)
        {
            Log.i("Error", "When done key was pressed, "+e.toString());
        }
    }
}

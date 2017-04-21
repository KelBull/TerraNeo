package kc.terraneo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartMenu extends AppCompatActivity {
    Button newGameButton;
    Button settingsButton;
    Button quitButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        newGameButton = new Button(this);
        settingsButton = new Button(this);
        quitButton  = new Button(this);
        newGameButton.setText("New Game");
        settingsButton.setText("Settings");
        quitButton.setText("Quit");
        intent = new Intent(this, SetPlayerCount.class);

        Button NewGame = (Button) findViewById(R.id.New_Game);
        NewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartMenu.this, SetPlayerCount.class);
                startActivity(intent);
                Log.i("clicks", "you have clicked New Game");
            }
        });
        Button Quit = (Button) findViewById(R.id.Quit);
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
    public void start()
    {
        startActivity(intent);
    }
}

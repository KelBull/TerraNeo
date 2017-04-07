package kc.terraneo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        intent = new Intent(this, GameWindow.class);

    }

    public void start()
    {
        startActivity(intent);
    }
}

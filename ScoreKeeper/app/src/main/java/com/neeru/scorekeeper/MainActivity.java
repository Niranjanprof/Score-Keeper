package com.neeru.scorekeeper;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    int scoreA = 0;
    int scoreB = 0;
    int foul_A = 0;
    int foul_B = 0;

    public void foulA(View v) {
        display("");
        displayForFTeamA(++foul_A);
    }

    public void goalA(View v) {
        display("");
        displayForTeamA(++scoreA);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForFTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf(score));
    }

    public void foulB(View v) {
        display("");
        displayForFTeamB(++foul_B);
    }

    public void displayForFTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(score));
    }

    public void goalB(View v) {
        display("");
        displayForTeamB(++scoreB);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void reset(View view) {
        displayForTeamA(0);
        displayForTeamB(0);
        displayForFTeamA(0);
        displayForFTeamB(0);
        scoreB = 0;
        scoreA = 0;
        foul_A = 0;
        foul_B = 0;
    }

    public void finish(View view) {
        if (scoreB > scoreA) {
            display("Team B Wins");
        } else if (scoreB < scoreA) {
            display("Team A Wins");
        } else {
            display("Draw");
        }

        reset(view);
    }

    public void display(String message) {
        TextView disp = (TextView) findViewById(R.id.Result);
        disp.setText(message);
    }
}
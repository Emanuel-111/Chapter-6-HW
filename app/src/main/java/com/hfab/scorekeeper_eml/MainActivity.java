package com.hfab.scorekeeper_eml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The user presses one of two buttons to add to the home score or the away score.
 *
 * When flipping the screen, the numbers should stay the same.
 */
public class MainActivity extends AppCompatActivity {

    private int homeScore; // Home Score
    private int awayScore; // Away Score

    private String homeTeamName; // Home team name
    private String awayTeamName; // Away team name

    // Keys
    private static final String HOME_TEAM_NAME_KEY = "homeTeamName";
    private static final String AWAY_TEAM_NAME_KEY = "awayTeamName";
    private static final String HOME_SCORE_KEY = "homeScore";
    private static final String AWAY_SCORE_KEY = "awayScore";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHome = findViewById(R.id.btnAddHomePt);
        Button btnAway = findViewById(R.id.btnAddAwayPt);

        TextView tvHomeDisplay = findViewById(R.id.tvHomeScore);
        TextView tvAwayDisplay = findViewById(R.id.tvAwayScore);

        EditText txtHomeTeam = findViewById(R.id.editTxtHomeTeam);
        EditText txtAwayTeam = findViewById(R.id.editTxtAwayTeam);


        if(savedInstanceState != null)
        {
            homeScore = savedInstanceState.getInt(HOME_SCORE_KEY);
            awayScore = savedInstanceState.getInt(AWAY_SCORE_KEY);
            homeTeamName = savedInstanceState.getString(HOME_TEAM_NAME_KEY);
            awayTeamName = savedInstanceState.getString(AWAY_TEAM_NAME_KEY);

        }

        tvHomeDisplay.setText("" + homeScore);
        tvAwayDisplay.setText("" + awayScore);

        /**
         * btnHome adds a point to the home team
         */
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int total = addPoint(homeScore);

            homeScore = total;
            tvHomeDisplay.setText("" + total);
            }
        });

        /**
         * btnAway adds a point to the away team
         */
        btnAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = addPoint(awayScore);

                awayScore = total;
                tvAwayDisplay.setText("" + total);
            }
        });

        /**
         * txtHomeTeam checks if the text field is empty
         * and tells the user to make the text field not empty
         */
        txtHomeTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtHomeTeam.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please give the team a name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * txtAwayTeam checks if the text field is empty
         * and tells the user to make the text field not empty
         */
        txtAwayTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtAwayTeam.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please give the team a name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * OnSaveInstanceState puts all variables where needed
     *
     * @param savedInstanceState - saved instance
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(HOME_SCORE_KEY, homeScore);
        savedInstanceState.putInt(AWAY_SCORE_KEY, awayScore);
        savedInstanceState.putString(HOME_TEAM_NAME_KEY, homeTeamName);
        savedInstanceState.putString(AWAY_TEAM_NAME_KEY, awayTeamName);
    }

    /**
     * addPoint adds a point to one of the two teams
     *
     * @param totalPts - total points from one team
     * @return totalPts
     */
    public int addPoint(int totalPts)
    {
        totalPts += 1;
        return totalPts;
    }


}
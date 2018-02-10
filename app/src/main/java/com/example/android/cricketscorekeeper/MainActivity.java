package com.example.android.cricketscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.cricketscorekeeper.R;

public class MainActivity extends AppCompatActivity {

    // Tracks the runs for Team A
    int runsTeamA = 0;

    // Tracks the no of wickets out for Team A
    int wicketsOutTeamA = 0;

    // Tracks the runs for Team B
    int runsTeamB = 0;

    // Tracks the no of wickets out for Team B
    int wicketsOutTeamB = 0;

    //Tracks last action
    int lastScore = 0;

    //Tracks which score/wickets was last updated
    int detector = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the runs for Team A by 6 points.
     */
    public void add_six_to_teamA_score (View view){
        runsTeamA = runsTeamA + 6;
        displayRunsForTeamA(runsTeamA);
        lastScore = 6;
        detector = runsTeamA;
    }

    /**
     * Increase the runs for Team A by 4 points.
     */
    public void add_four_to_teamA_score (View view){
        runsTeamA = runsTeamA + 4;
        displayRunsForTeamA(runsTeamA);
        lastScore = 4;
        detector = runsTeamA;
    }

    /**
     * Increase the runs for Team A by 1 point.
     */
    public void add_one_to_teamA_score (View view){
        runsTeamA = runsTeamA + 1;
        displayRunsForTeamA(runsTeamA);
        lastScore = 1;
        detector = runsTeamA;
    }

    /**
     * Displays the given no of wickets down for Team A.
     */
    public void add_wickets_out_for_teamA (View view){
        wicketsOutTeamA = wicketsOutTeamA + 1;
        displayWicketsOutForTeamA(wicketsOutTeamA);
        lastScore = 1;
        detector = wicketsOutTeamA;
    }

    /**
     * Increase the runs for Team B by 6 points.
     */
    public void add_six_to_teamB_score (View view){
        runsTeamB = runsTeamB + 6;
        displayRunsForTeamB(runsTeamB);
        lastScore = 6;
        detector = runsTeamB;
    }

    /**
     * Increase the runs for Team B by 4 points.
     */
    public void add_four_to_teamB_score (View view){
        runsTeamB = runsTeamB + 4;
        displayRunsForTeamB(runsTeamB);
        lastScore = 4;
        detector = runsTeamB;
    }

    /**
     * Increase the runs for Team B by 1 point.
     */
    public void add_one_to_teamB_score (View view){
        runsTeamB = runsTeamB + 1;
        displayRunsForTeamB(runsTeamB );
        lastScore = 1;
        detector = runsTeamB;
    }

    /**
     * Displays the given no of wickets down for Team B.
     */
    public void add_wickets_out_for_teamB (View view){
        wicketsOutTeamB = wicketsOutTeamB + 1;
        displayWicketsOutForTeamB(wicketsOutTeamB);
        lastScore = 1;
        detector = wicketsOutTeamB;
    }

    /**
     * Undo es last action.
     */
    public void undo_last_action (View view) {
        if (detector == runsTeamA) {
            runsTeamA = runsTeamA - lastScore;
            displayRunsForTeamA(runsTeamA);
        } else if (detector == wicketsOutTeamA) {
            wicketsOutTeamA = wicketsOutTeamA - lastScore;
            displayWicketsOutForTeamA(wicketsOutTeamA);
        } else if (detector == runsTeamB) {
            runsTeamB = runsTeamB - lastScore;
            displayRunsForTeamB(runsTeamB);
        } else if (detector == wicketsOutTeamB) {
            wicketsOutTeamB = wicketsOutTeamB - lastScore;
            displayWicketsOutForTeamB(wicketsOutTeamB);
        }
        lastScore = 0;
    }

    /**
     * Resets everything to initial stage
     */
    public void Reset_to_zero (View view){
        displayRunsForTeamA(runsTeamA = 0);
        displayRunsForTeamB(runsTeamB = 0);
        displayWicketsOutForTeamA(wicketsOutTeamA=0);
        displayWicketsOutForTeamB(wicketsOutTeamB=0);
        display("");
    }

    /**
     * Displays result of the match
     */
    public void match_results (View view) {
        if (runsTeamA > runsTeamB) {
            display("TeamA won the match");
        } else {
            display("Team B won the match");
        }
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayRunsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.teamA_runs_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given no of wickets out for Team A.
     */
    public void displayWicketsOutForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.teamA_wickets);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayRunsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.teamB_runs_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given no of wickets out for Team B.
     */
    public void displayWicketsOutForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.teamB_wickets);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the result of the match.
     */
    private void display(String message) {
        TextView resultTextView = (TextView) findViewById(R.id.final_results);
        resultTextView.setText(message);
    }

}

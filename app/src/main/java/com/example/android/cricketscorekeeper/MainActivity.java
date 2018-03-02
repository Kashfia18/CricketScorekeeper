package com.example.android.cricketscorekeeper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    //Tracks which runs/outs was last updated
    String detector;

    String nameTeamA;
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
        detector = "TeamA";
    }

    /**
     * Increase the runs for Team A by 4 points.
     */
    public void add_four_to_teamA_score (View view){
        runsTeamA = runsTeamA + 4;
        displayRunsForTeamA(runsTeamA);
        lastScore = 4;
        detector = "TeamA";
    }

    /**
     * Increase the runs for Team A by 1 point.
     */
    public void add_one_to_teamA_score (View view){
        runsTeamA = runsTeamA + 1;
        displayRunsForTeamA(runsTeamA);
        lastScore = 1;
        detector = "TeamA";
    }

    /**
     * Displays the given no of wickets down for Team A.
     */
    public void add_wickets_out_for_teamA (View view){
        wicketsOutTeamA = wicketsOutTeamA + 1;
        displayWicketsOutForTeamA(wicketsOutTeamA);
        lastScore = 1;
        detector = "TeamAOuts";
    }

    /**
     * Increase the runs for Team B by 6 points.
     */
    public void add_six_to_teamB_score (View view){
        runsTeamB = runsTeamB + 6;
        displayRunsForTeamB(runsTeamB);
        lastScore = 6;
        detector = "TeamB";
    }

    /**
     * Increase the runs for Team B by 4 points.
     */
    public void add_four_to_teamB_score (View view){
        runsTeamB = runsTeamB + 4;
        displayRunsForTeamB(runsTeamB);
        lastScore = 4;
        detector = "TeamB";
    }

    /**
     * Increase the runs for Team B by 1 point.
     */
    public void add_one_to_teamB_score (View view){
        runsTeamB = runsTeamB + 1;
        displayRunsForTeamB(runsTeamB );
        lastScore = 1;
        detector = "TeamB";
    }

    /**
     * Displays the given no of wickets down for Team B.
     */
    public void add_wickets_out_for_teamB (View view){
        wicketsOutTeamB = wicketsOutTeamB + 1;
        displayWicketsOutForTeamB(wicketsOutTeamB);
        lastScore = 1;
        detector = "TeamBOuts";
    }

    /**
     * Undo es last action.
     */

    public void undo_last_action (View view) {
        if (detector == "TeamA") {
           runsTeamA = runsTeamA - lastScore;
           displayRunsForTeamA(runsTeamA);
        } else if (detector == "TeamAOuts") {
            wicketsOutTeamA = wicketsOutTeamA - lastScore;
            displayWicketsOutForTeamA(wicketsOutTeamA);
        } else if (detector == "TeamB") {
           runsTeamB = runsTeamB - lastScore;
           displayRunsForTeamB(runsTeamB);
        } else if (detector == "TeamBOuts") {
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
        //Clears name of TeamA
        EditText nameOfTeamA = (EditText) findViewById(R.id.TeamA_name_input);
        nameOfTeamA.getText().clear();
        //Clears name of TeamB
        EditText nameOfTeamB = (EditText) findViewById(R.id.TeamB_name_input);
        nameOfTeamB.getText().clear();

    }

    EditText nameOfTeamA = (EditText) findViewById(R.id.TeamA_name_input);
    nameOfTeamA.setOnFocusChangeListener(new OnFocusChangeListener() {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
   /* When focus is lost check that the text field
   * has valid values.
   */
            if (!hasFocus) {
                String nameTeamA = nameOfTeamA.getText().toString();
            }
        }
    });

    /**
     * Displays result of the match
     */
    public void match_results (View view) {
        //Figure out name of TeamA
        //EditText nameOfTeamA = (EditText) findViewById(R.id.TeamA_name_input);
        //String nameTeamA = nameOfTeamA.getText().toString();

        //Figure out name of the TeamB
        EditText nameOfTeamB = (EditText) findViewById(R.id.TeamB_name_input);
        String nameTeamB = nameOfTeamB.getText().toString();

        if (runsTeamA > runsTeamB) {
            display(nameTeamA + " won the match");
        } else if (runsTeamA < runsTeamB){
            display(nameTeamB + " won the match");
        }else{
            display("Tie");
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

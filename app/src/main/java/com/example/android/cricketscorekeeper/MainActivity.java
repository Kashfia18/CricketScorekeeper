package com.example.android.cricketscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//Main class needs to implement listener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //initial run score for Team A.
    int runsTeamA = 0;

    //initial outs score for Team A.
    int wicketsOutTeamA = 0;

    //initial run score for Team B.
    int runsTeamB = 0;

    //initial outs score for Team B.
    int wicketsOutTeamB = 0;

    //Tracks last action.
    int lastScore = 0;

    //Tracks which teams runs/outs was last updated.
    String detector;
//    String nameTeamA;
//    String nameTeamB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final EditText nameOfTeamA = (EditText) findViewById(R.id.TeamA_name_input);
//        nameTeamA = nameOfTeamA.getText().toString();
//        final EditText nameOfTeamB = (EditText) findViewById(R.id.TeamB_name_input);
//        nameTeamB = nameOfTeamB.getText().toString();
        //Next two lines just tell the app to listen for a button click. findviewbyid tells which button was clicked.
        //Once this happens it calls public void onClick(View view)

        Button sixRunsTeamA = findViewById(R.id.add_six_to_teamA);
        sixRunsTeamA.setOnClickListener(this);

        Button fourRunsTeamA = findViewById(R.id.add_four_to_teamA);
        fourRunsTeamA.setOnClickListener(this);

        Button oneRunTeamA = findViewById(R.id.add_one_to_teamA);
        oneRunTeamA.setOnClickListener(this);

        Button outsTeamA = findViewById(R.id.add_one_out_for_TeamA);
        outsTeamA.setOnClickListener(this);

        Button sixRunsTeamB = findViewById(R.id.add_six_to_teamB);
        sixRunsTeamB.setOnClickListener(this);

        Button fourRunsTeamB = findViewById(R.id.add_four_to_teamB);
        fourRunsTeamB.setOnClickListener(this);

        Button oneRunTeamB = findViewById(R.id.add_one_to_teamB);
        oneRunTeamB.setOnClickListener(this);

        Button outsTeamB = findViewById(R.id.add_one_out_for_TeamB);
        outsTeamB.setOnClickListener(this);

    }

  public void onClick (View view){

      switch(view.getId()){

          //Increase the runs for Team A by 6 points.

          case R.id.add_six_to_teamA:
              runsTeamA=runsTeamA+6;
              displayRunsForTeamA(runsTeamA);
              lastScore = 6;
              detector = "TeamA";
              break;

          //Increase the runs for Team A by 4 points.

          case R.id.add_four_to_teamA:
              runsTeamA=runsTeamA+4;
              lastScore =4;
              displayRunsForTeamA(runsTeamA);
              lastScore = 4;
              detector = "TeamA";
              break;

          //Increase the runs for Team A by 1 point.

          case R.id.add_one_to_teamA:
              runsTeamA=runsTeamA+1;
              displayRunsForTeamA(runsTeamA);
              lastScore = 1;
              detector = "TeamA";
              break;

          //Displays the given no of wickets out for Team A.

          case R.id.add_one_out_for_TeamA:
              wicketsOutTeamA = wicketsOutTeamA + 1;
              displayWicketsOutForTeamA(wicketsOutTeamA);
              lastScore = 1;
              detector = "TeamAOuts";
              break;

          //Increase the runs for Team B by 6 points.

          case R.id.add_six_to_teamB:
              runsTeamB=runsTeamB+6;
              displayRunsForTeamB(runsTeamB);
              lastScore = 6;
              detector = "TeamB";
              break;

          //Increase the runs for Team B by 4 points.

          case R.id.add_four_to_teamB:
              runsTeamB=runsTeamB+4;
              lastScore =4;
              displayRunsForTeamB(runsTeamB);
              lastScore = 4;
              detector = "TeamB";
              break;

          //Increase the runs for Team B by 1 point.

          case R.id.add_one_to_teamB:
              runsTeamB=runsTeamB+1;
              displayRunsForTeamB(runsTeamB);
              lastScore = 1;
              detector = "TeamB";
              break;

          //Displays the given no of wickets out for Team B.

          case R.id.add_one_out_for_TeamB:
              wicketsOutTeamB = wicketsOutTeamB + 1;
              displayWicketsOutForTeamB(wicketsOutTeamB);
              lastScore = 1;
              detector = "TeamBOuts";
              break;
      }
  }

    /**
     *
     * Increase the runs for Team A by 6 points.
     */
//    public void add_six_to_teamA_score(View view) {
//        runsTeamA = runsTeamA + 6;
//        displayRunsForTeamA(runsTeamA);
//        lastScore = 6;
//        detector = "TeamA";
//    }
    /**
     * Increase the runs for Team A by 4 points.
     */
//    public void add_four_to_teamA_score(View view) {
//        runsTeamA = runsTeamA + 4;
//        displayRunsForTeamA(runsTeamA);
//        lastScore = 4;
//        detector = "TeamA";
//    }

    /**
     * Increase the runs for Team A by 1 point.
     */
//    public void add_one_to_teamA_score(View view) {
//        runsTeamA = runsTeamA + 1;
//        displayRunsForTeamA(runsTeamA);
//        lastScore = 1;
//        detector = "TeamA";
//    }
//    /**
//     * Displays the given no of wickets down for Team A.
//     */
//    public void add_wickets_out_for_teamA(View view) {
//        wicketsOutTeamA = wicketsOutTeamA + 1;
//        displayWicketsOutForTeamA(wicketsOutTeamA);
//        lastScore = 1;
//        detector = "TeamAOuts";
//    }
    /**
     * Increase the runs for Team B by 6 points.
     */
//    public void add_six_to_teamB_score(View view) {
//        runsTeamB = runsTeamB + 6;
//        displayRunsForTeamB(runsTeamB);
//        lastScore = 6;
//        detector = "TeamB";
//    }
    /**
     * Increase the runs for Team B by 4 points.
     */
//    public void add_four_to_teamB_score(View view) {
//        runsTeamB = runsTeamB + 4;
//        displayRunsForTeamB(runsTeamB);
//        lastScore = 4;
//        detector = "TeamB";
//    }
    /**
     * Increase the runs for Team B by 1 point.
     */
//    public void add_one_to_teamB_score(View view) {
//        runsTeamB = runsTeamB + 1;
//        displayRunsForTeamB(runsTeamB);
//        lastScore = 1;
//        detector = "TeamB";
//    }
    /**
     * Displays the given no of wickets down for Team B.
     */
//    public void add_wickets_out_for_teamB(View view) {
//        wicketsOutTeamB = wicketsOutTeamB + 1;
//        displayWicketsOutForTeamB(wicketsOutTeamB);
//        lastScore = 1;
//        detector = "TeamBOuts";
//    }
    /**
     * Undo es last action.
     */
    public void undo_last_action(View view) {
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
    public void Reset_to_zero(View view) {
        displayRunsForTeamA(runsTeamA = 0);
        displayRunsForTeamB(runsTeamB = 0);
        displayWicketsOutForTeamA(wicketsOutTeamA = 0);
        displayWicketsOutForTeamB(wicketsOutTeamB = 0);
        matchResultDisplay("");
        //Clears name of TeamA
        EditText nameOfTeamA = (EditText) findViewById(R.id.TeamA_name_input);
        nameOfTeamA.getText().clear();
        //Clears name of TeamB
        EditText nameOfTeamB = (EditText) findViewById(R.id.TeamB_name_input);
        nameOfTeamB.getText().clear();
    }
    /**
     * Displays result of the match
     */
    public void match_results(View view) {
        //Figure out name of TeamA
        EditText nameOfTeamA = (EditText) findViewById(R.id.TeamA_name_input);
        String nameTeamA = nameOfTeamA.getText().toString();
        //Figure out name of the TeamB
        EditText nameOfTeamB = (EditText) findViewById(R.id.TeamB_name_input);
        String nameTeamB = nameOfTeamB.getText().toString();
        if (runsTeamA > runsTeamB) {
            matchResultDisplay(nameTeamA + " won the match");
        } else if (runsTeamA < runsTeamB) {
            matchResultDisplay(nameTeamB + " won the match");
        } else {
            matchResultDisplay("Tie");
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
     * Displays the final results of the match
     */
    private void matchResultDisplay(String message) {
        TextView resultTextView = (TextView) findViewById(R.id.final_results);
        resultTextView.setText(message);
    }
}
package com.example.android.cricketscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//Main class needs to implement listener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //initial run score for Team A.
    private int runsTeamA = 0;

    //initial outs score for Team A.
    private int wicketsOutTeamA = 0;

    //initial run score for Team B.
    private int runsTeamB = 0;

    //initial outs score for Team B.
    private int wicketsOutTeamB = 0;

    //Tracks last action.
    private int lastScore = 0;

    //Tracks which teams runs/outs was last updated.
    private String detector;

    //Declare the TextViews, EditText Views and their string variables
    private TextView textviewSavedStateRunsTeamA;
    private TextView textviewSavedStateWicketsTeamA;
    private TextView textviewSavedStateRunsTeamB;
    private TextView textviewSavedStateWicketsTeamB;
    private TextView textviewSavedStateFinalResults;
    private EditText editTextSavedStateTeamAName;
    private EditText editTextSavedStateTeamBName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hides the keyboard for EditText views.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //Declare and initialize the button objects. findViewById links the button view of xml with the button object.
        Button sixRunsTeamA = findViewById(R.id.add_six_to_teamA);
        //setting listener to button
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

        //Initialize the TextViews and EditText Views
        textviewSavedStateRunsTeamA = findViewById(R.id. teamA_runs_score);
        textviewSavedStateWicketsTeamA = findViewById(R.id. teamA_wickets);
        textviewSavedStateRunsTeamB = findViewById(R.id. teamB_runs_score);
        textviewSavedStateWicketsTeamB = findViewById(R.id. teamB_wickets);
        textviewSavedStateFinalResults = findViewById(R.id.final_results);
        editTextSavedStateTeamAName = findViewById(R.id.TeamA_name_input);
        editTextSavedStateTeamBName = findViewById(R.id.TeamB_name_input);

    }
    /**
     * Saves data of activity before it is destroyed
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {

        //Declare the string variables that will store the names and values in string.
        String textviewSavedStateRunsTeamAString;
        String textviewSavedStateWicketsTeamAString;
        String textviewSavedStateRunsTeamBString;
        String textviewSavedStateWicketsTeamBString;
        String textviewSavedStateFinalResultsString;
        String editTextSavedStateTeamANameString;
        String editTextSavedStateTeamBNameString;

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);

        //extract text from the TextViews and EditText Views and store it in string
        textviewSavedStateRunsTeamAString = textviewSavedStateRunsTeamA.getText().toString();
        textviewSavedStateWicketsTeamAString = textviewSavedStateWicketsTeamA.getText().toString();
        textviewSavedStateRunsTeamBString = textviewSavedStateRunsTeamB.getText().toString();
        textviewSavedStateWicketsTeamBString = textviewSavedStateWicketsTeamB.getText().toString();
        textviewSavedStateFinalResultsString = textviewSavedStateFinalResults.getText().toString();
        editTextSavedStateTeamANameString = editTextSavedStateTeamAName.getText().toString();
        editTextSavedStateTeamBNameString = editTextSavedStateTeamBName.getText().toString();

        //save the user's current game's state. Saves the values as well as the display, as strings.
        outState.putInt("runsTeamA", runsTeamA);
        outState.putInt("wicketsOutTeamA", wicketsOutTeamA);
        outState.putInt("runsTeamB", runsTeamB);
        outState.putInt("wicketsOutTeamB", wicketsOutTeamB);
        outState.putInt("lastScore", lastScore);
        outState.putString ("detector",detector );
        outState.putString ("runsTeamAString",textviewSavedStateRunsTeamAString );
        outState.putString ("outsTeamAString",textviewSavedStateWicketsTeamAString);
        outState.putString ("runsTeamBString",textviewSavedStateRunsTeamBString );
        outState.putString ("outsTeamBString",textviewSavedStateWicketsTeamBString);
        outState.putString ("finalResults",textviewSavedStateFinalResultsString);
        outState.putString ("teamAName",editTextSavedStateTeamANameString);
        outState.putString ("teamBName",editTextSavedStateTeamBNameString);
    }

    /**
     * Restores data to the saved state when activity is recreated.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // restores the values from their saved instances
        textviewSavedStateRunsTeamA.setText(savedInstanceState.getString("runsTeamAString"));
        textviewSavedStateWicketsTeamA.setText(savedInstanceState.getString("outsTeamAString"));
        textviewSavedStateRunsTeamB.setText(savedInstanceState.getString("runsTeamBString"));
        textviewSavedStateWicketsTeamB.setText(savedInstanceState.getString("outsTeamBString"));
        textviewSavedStateFinalResults.setText(savedInstanceState.getString("finalResults"));
        editTextSavedStateTeamAName.setText(savedInstanceState.getString("teamAName"));
        editTextSavedStateTeamBName.setText(savedInstanceState.getString("teamBName"));
        detector = savedInstanceState.getString("detector");
        lastScore = savedInstanceState.getInt("lastScore");
        runsTeamA = savedInstanceState.getInt("runsTeamA");
        wicketsOutTeamA = savedInstanceState.getInt("wicketsOutTeamA");
        runsTeamB = savedInstanceState.getInt("runsTeamB");
        wicketsOutTeamB = savedInstanceState.getInt("wicketsOutTeamB");
        }


    /**
     * Calculates and updates score based on button clicks.
     */
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
     * Undo es last action.
     */
    public void undo_last_action(View view) {

        switch (detector) {

            //Undo es the last clicked run for Team A.
            case "TeamA":
                runsTeamA = runsTeamA - lastScore;
                displayRunsForTeamA(runsTeamA);
                break;

            //Undo es the last clicked out for Team A.
            case "TeamAOuts":
                wicketsOutTeamA = wicketsOutTeamA - lastScore;
                displayWicketsOutForTeamA(wicketsOutTeamA);
                break;

            //Undo es the last clicked run for Team A.
            case "TeamB":
                runsTeamB = runsTeamB - lastScore;
                displayRunsForTeamB(runsTeamB);
                break;

            //Undo es the last clicked out for Team A.
            case "TeamBOuts":
                wicketsOutTeamB = wicketsOutTeamB - lastScore;
                displayWicketsOutForTeamB(wicketsOutTeamB);
                break;

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
        editTextSavedStateTeamAName.getText().clear();

        //Clears name of TeamB
        editTextSavedStateTeamBName.getText().clear();
    }
    /**
     * Displays result of the match
     */
    public void match_results(View view) {

        //initialize the string variable to save the input names of the teams.
        String nameTeamA;
        String nameTeamB;

        //Figure out name of TeamA
        nameTeamA = editTextSavedStateTeamAName.getText().toString();

        //Figure out name of the TeamB
        nameTeamB = editTextSavedStateTeamBName.getText().toString();

        if (runsTeamA > runsTeamB) {
            matchResultDisplay(nameTeamA + " won the match");
        } else if (runsTeamA < runsTeamB) {
            matchResultDisplay(nameTeamB + " won the match");
        } else {
            matchResultDisplay("Tie");
        }
    }
    /**
     * Displays the given runs for Team A.
     */
    private void displayRunsForTeamA(int score) {
        textviewSavedStateRunsTeamA.setText(String.valueOf(score));
    }

    /**
     * Displays the given no of wickets out for Team A.
     */
    private void displayWicketsOutForTeamA(int score) {
        textviewSavedStateWicketsTeamA.setText(String.valueOf(score));
    }

    /**
     * Displays the given runs for Team B.
     */
    private void displayRunsForTeamB(int score) {
        textviewSavedStateRunsTeamB.setText(String.valueOf(score));
    }

    /**
     * Displays the given no of wickets out for Team B.
     */
    private void displayWicketsOutForTeamB(int score) {
        textviewSavedStateWicketsTeamB.setText(String.valueOf(score));
    }

    /**
     * Displays the final results of the match
     */
    private void matchResultDisplay(String message) {
        textviewSavedStateFinalResults.setText(message);
    }
}
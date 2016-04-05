package xyz.valeev.numberguessing;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RookieActivity extends AppCompatActivity {


    public final int MAX_VALUE = 10;
    public final int MAX_ATTEMPTS = 5;
    int userNumber, randomNumber;
    int attemptCounter =0;
    PromptGenerator promptGenerator = new PromptGenerator();
/*
    IntegerParser intParser = new IntegerParser();
    TextView attemptField = (TextView)findViewById(R.id.textViewAttemptNumber);
   TextView currentInputField = (TextView)findViewById(R.id.textViewInputValue);
    TextView promptField = (TextView)findViewById(R.id.textViewPrompt);
    Button confirmButton = (Button)findViewById(R.id.guess_button);
    EditText userText = (EditText)findViewById(R.id.userInput);




*/
    public void onClickSubmitNumber (View view){



        Button confirmButton = (Button)findViewById(R.id.guess_button);


        attemptCounter ++;
        String attemptString = "" + attemptCounter;
        ((TextView) findViewById(R.id.textViewAttemptNumber)).setText(attemptString);

        if (attemptCounter == MAX_ATTEMPTS){

            ((TextView)findViewById(R.id.textViewPrompt)).setText("YOU LOOSE !!!");

            MainActivity.rookieLooses++;

            confirmButton.setVisibility(View.INVISIBLE);


        }else {




            EditText userText = (EditText) findViewById(R.id.userInput);

            String userString = userText.getText().toString();

            IntegerParser intParser = new IntegerParser();
            int clearInput = intParser.parseNumber(userString, MAX_VALUE);

            ((TextView) findViewById(R.id.textViewInputValue)).setText("" + clearInput);
            userText.setText("");


            if (clearInput == -1) {
                attemptCounter--;
                ((TextView) findViewById(R.id.textViewPrompt)).setText("WRONG INPUT, TRY AGAIN !");
                ((TextView) findViewById(R.id.textViewInputValue)).setText("NULL");
            } else {

                String currentPrompt = promptGenerator.generatePrompt(clearInput);
                ((TextView) findViewById(R.id.textViewPrompt)).setText(currentPrompt);

            }

            if (clearInput == randomNumber) {

                MainActivity.rookieWins++;

                confirmButton.setVisibility(View.INVISIBLE);
            }


        }
    }

    public  void onClickStartNewGame (View view){
        //Initial status
        Button confirmButton = (Button)findViewById(R.id.guess_button);
        confirmButton.setVisibility(View.VISIBLE);
        attemptCounter=0;
        ((TextView)findViewById(R.id.textViewPrompt)).setText("TRY  NOW !  GOOD  LUCK ! ");

        TextView attemptField = (TextView)findViewById(R.id.textViewAttemptNumber);
        attemptField.setText(""+attemptCounter);


        //New random
        randomNumber = (int) ((Math.random())*9 + Math.random());
        promptGenerator.setRandom(randomNumber);
        promptGenerator.setLeft(0);
        promptGenerator.setRight(MAX_VALUE);

    }

        public void onClickBackToMenu(View view){

            Intent backIntent = new Intent(this, MainActivity.class);

            startActivity(backIntent);

        }


/*
    public void initGame(){

        IntegerParser intParser = new IntegerParser();
        TextView attemptField = (TextView)findViewById(R.id.textViewAttemptNumber);
        TextView currentInputField = (TextView)findViewById(R.id.textViewInputValue);
        TextView promptField = (TextView)findViewById(R.id.textViewPrompt);
        Button confirmButton = (Button)findViewById(R.id.guess_button);
        EditText userText = (EditText)findViewById(R.id.userInput);

        confirmButton.setVisibility(View.VISIBLE);
        randomNumber = (int) (Math.round(Math.random())*10);
        promptField.setText("TRY NOW !!!");
        attemptCounter=0;
        attemptField.setText(""+attemptCounter);
        currentInputField.setText("NULL");

    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rookie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //TODO Starting new game automatically ?





    }

}

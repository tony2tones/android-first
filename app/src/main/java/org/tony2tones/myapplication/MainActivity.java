package org.tony2tones.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void highOrLower(View view) {

        Random randomGen2 = new Random();
        System.out.println("show me this random number " + randomNumber);
        String message = "";

        try {

        EditText numberGuessed = (EditText) findViewById(R.id.guessNumber);


            int number = Integer.parseInt(numberGuessed.getText().toString());

            System.out.println("show me this random number " + randomNumber);

                if (number == randomNumber) {

                    message = "You are correct, well done, try again.";
                    numberGuessed.getText().clear();
                    randomNumber = randomGen2.nextInt(21);

                } else if (number < randomNumber) {

                    numberGuessed.getText().clear();
                    message = " You have a lower number";

                } else if (number > randomNumber) {

                    numberGuessed.getText().clear();
                    message = " You have a higher number";
                }

            } catch (NumberFormatException error) {

            //numberGuessed.getText().clear();
            message = "Please enter a valid number";

        }
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

    }

    public void clearButton(View view){


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Random randomGen = new Random();
        randomNumber = randomGen.nextInt(21);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

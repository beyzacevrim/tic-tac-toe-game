// Import necessary libraries and packages
package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class resultActivity extends AppCompatActivity {

    // Declare TextViews to display congratulatory message
    TextView congratstv2, congratstv3, congratstv;

    // onCreate is the main method that is executed when the activity is launched
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout of the activity to the winner screen
        setContentView(R.layout.activity_winner_screen);

        // Get the Intent sent from the previous activity, which contains information about the winner
        Intent i = getIntent();

        // Retrieve the winner's character from the Intent
        char winner = i.getCharExtra("winner", 'z');

        // Initialize TextViews to display congratulatory message
        congratstv = findViewById(R.id.congratstv);
        congratstv2 = findViewById(R.id.congratstv2);
        congratstv3 = findViewById(R.id.congratstv3);

        // If there is a winner, set the winner's character to congratstv3 and create a Konfetti explosion animation
        if (winner == 'x' || winner == 'o') {
            congratstv3.setText(Character.toString(winner));

            // Initialize KonfettiView
            KonfettiView konfetti = findViewById(R.id.konfettiView);

            // Set the emitter configuration for the KonfettiView
            EmitterConfig emitterconfig = new Emitter(300L, TimeUnit.MILLISECONDS).max(300);

            // Create a PartyFactory to configure the KonfettiView
            konfetti.start(
                    new PartyFactory(emitterconfig)
                            .shapes(Shape.Circle.Square.INSTANCE, Shape.Rectangle.Circle.INSTANCE)
                            .spread(360)
                            .position(0.20, 0.25, 1, 1)
                            .sizes(new Size(7, 70, 10))
                            .timeToLive(8000).fadeOutEnabled(true).build());

            // Create a timer to finish the activity after 5 seconds
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    finish();
                }
            };
            timer.schedule(task, 5000);
        }

        // If there is no winner, display a message indicating that there are no winners
        else if (winner == 'n') {
            renameTextViews("NO","WINNERS !");
        }

        // If there is an error, display an error message
        else {
            renameTextViews("ERROR !","");
        }
    }

    // Helper method to update the TextViews with new text
    protected void renameTextViews( String text2, String text3){
        congratstv2.setText(text2);
        congratstv.setText(text3);
    }
}

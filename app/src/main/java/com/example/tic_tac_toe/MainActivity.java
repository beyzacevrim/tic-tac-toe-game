// import necessary packages
package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // This method is called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content view to be the activity_main.xml file
        setContentView(R.layout.activity_main);
    }

    // Method called when the Play button is clicked
    public void launchPlayScreen(View v){
        // Create an intent to launch the playActivity
        Intent i = new Intent(this, playActivity.class);
        // Start the activity
        startActivity(i);
    }

}

package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class playActivity extends AppCompatActivity {

    char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}}; // must have 9 elements with indexes between 0...8
    ImageView b1, b2, b3, b4, b5, b6, b7, b8, b9;
    TextView playerTV;
    boolean[] imageViewsClicked = new boolean[9] ;
    byte totalClicks = 0;
    char player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        // imageview initializations
        b1 = findViewById(R.id.imageView1);
        b2 = findViewById(R.id.imageView2);
        b3 = findViewById(R.id.imageView3);
        b4 = findViewById(R.id.imageView4);
        b5 = findViewById(R.id.imageView5);
        b6 = findViewById(R.id.imageView6);
        b7 = findViewById(R.id.imageView7);
        b8 = findViewById(R.id.imageView8);
        b9 = findViewById(R.id.imageView9);
        player = 'x';
        playerTV = findViewById(R.id.playerTV);
        playerTV.setText(String.valueOf(player));

        // Set an OnClickListener on each ImageView to handle clicks
            b1.setOnClickListener(v -> {
                // If the ImageView has already been clicked, do nothing
                if (imageViewsClicked[0]) {
                    return;
                }
                imageViewsClicked[0] = true;
                totalClicks++;
                board[0][0] = player; // Replace 'x' with 'o' or the appropriate symbol
                updateButtonForPlayer(b1, player);
                player = switchPlayer(player);playerTV.setText(String.valueOf(player));
            });
            b2.setOnClickListener(v -> {
                // If the ImageView has already been clicked, do nothing
                if (imageViewsClicked[1]) {
                    return;
                }
                imageViewsClicked[1] = true;
                totalClicks++;
                board[0][1] = player; // Replace 'x' with 'o' or the appropriate symbol
                updateButtonForPlayer(b2, player);
                player = switchPlayer(player);playerTV.setText(String.valueOf(player));
            });
            b3.setOnClickListener(v -> {
                // If the ImageView has already been clicked, do nothing
                if (imageViewsClicked[2]) {
                    return;
                }
                imageViewsClicked[2] = true;
                totalClicks++;
                board[0][2] = player; // Replace 'x' with 'o' or the appropriate symbol
                updateButtonForPlayer(b3, player);
                player = switchPlayer(player);playerTV.setText(String.valueOf(player));
            });
            b4.setOnClickListener(v -> {
                // If the ImageView has already been clicked, do nothing
                if (imageViewsClicked[3]) {
                    return;
                }
                imageViewsClicked[3] = true;
                totalClicks++;
                board[1][0] = player; // Replace 'x' with 'o' or the appropriate symbol
                updateButtonForPlayer(b4, player);
                player = switchPlayer(player);playerTV.setText(String.valueOf(player));
            });
            b5.setOnClickListener(v -> {
                // If the ImageView has already been clicked, do nothing
                if (imageViewsClicked[4]) {
                    return;
                }
                imageViewsClicked[4] = true;
                totalClicks++;
                board[1][1] = player; // Replace 'x' with 'o' or the appropriate symbol
                updateButtonForPlayer(b5, player);
                player = switchPlayer(player);playerTV.setText(String.valueOf(player));
            });
            b6.setOnClickListener(v -> {
                // If the ImageView has already been clicked, do nothing
                if (imageViewsClicked[5]) {
                    return;
                }
                imageViewsClicked[5] = true;
                totalClicks++;
                board[1][2] = player; // Replace 'x' with 'o' or the appropriate symbol
                updateButtonForPlayer(b6, player);
                player = switchPlayer(player);playerTV.setText(String.valueOf(player));
            });
            b7.setOnClickListener(v -> {
                // If the ImageView has already been clicked, do nothing
                if (imageViewsClicked[6]) {
                    return;
                }
                imageViewsClicked[6] = true;
                totalClicks++;
                board[2][0] = player; // Replace 'x' with 'o' or the appropriate symbol
                updateButtonForPlayer(b7, player);
                player = switchPlayer(player);playerTV.setText(String.valueOf(player));
            });
            b8.setOnClickListener(v -> {
                // If the ImageView has already been clicked, do nothing
                if (imageViewsClicked[7]) {
                    return;
                }
                imageViewsClicked[7] = true;
                totalClicks++;
                board[2][1] = player; // Replace 'x' with 'o' or the appropriate symbol
                updateButtonForPlayer(b8, player);
                player = switchPlayer(player);playerTV.setText(String.valueOf(player));
            });
            b9.setOnClickListener(v -> {
                // If the ImageView has already been clicked, do nothing
                if (imageViewsClicked[8]) {
                    return;
                }
                imageViewsClicked[8] = true;
                totalClicks++;
                board[2][2] = player; // Replace 'x' with 'o' or the appropriate symbol
                updateButtonForPlayer(b9, player);
                player = switchPlayer(player);playerTV.setText(String.valueOf(player));
            });

    }

    public void updateButtonForPlayer(ImageView image, char player){
        // code unwritten
        if(player == 'x'){
            image.setImageResource(R.drawable.signx);
        }else{
            image.setImageResource(R.drawable.signo);
        }
        image.setClickable(false);
        caseControl(board, totalClicks);

    }

    public void caseControl(char[][] board, byte totalClicks){
// check for horizontal wins
        for (int row = 0; row < 3; row++) {
            if (board[row][0]==board[row][2] && board[row][1]==board[row][2]) {
                launchResultScreen(board[row][0]);
            }
        }
        // Check for vertical win
        for (int col = 0; col < 3; col++) {
            if (board[0][col]==board[2][col] && board[1][col]==board[2][col]) {
                launchResultScreen(board[0][col]);
            }
        }
        // Check for diagonal win
        if (board[0][0]==board[2][2] && board[1][1]==board[2][2]) {
            launchResultScreen(board[0][0]);
        }
        if (board[0][2]==board[2][0] && board[1][1]==board[2][0]) {
            launchResultScreen(board[0][2]);
        }

        // No win found
        if(totalClicks==9){
            launchResultScreen('n'); // n = no winners
        }
    }

    protected char switchPlayer(char player){
        if(player == 'x')
            return 'o';
        else
            return 'x';
    }

    protected void launchResultScreen(char winner){
        Intent intent = new Intent(this, resultActivity.class);
        intent.putExtra("winner",winner);
        // Start a new activity after a delay of 2 seconds
        new Handler().postDelayed(() -> {
            reset();
            startActivity(intent);
        }, 200); // 2000 milliseconds = 2 seconds
    }

    public void reset(){
        // reset board
        char[][] element = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        for (int row = 0; row < board.length; row++) {
            System.arraycopy(element[row], 0, board[row], 0, board[row].length);
        }
        //reset player
        player = 'x';
        // reset click savings
        for(int i=0 ; i<9 ; i++){
            imageViewsClicked[i]=false;
        }
        totalClicks=0;

        //reset the image views
        b1.setClickable(true);
        b1.setImageResource(R.drawable.white);
        b2.setClickable(true);
        b2.setImageResource(R.drawable.white);
        b3.setClickable(true);
        b3.setImageResource(R.drawable.white);
        b4.setClickable(true);
        b4.setImageResource(R.drawable.white);
        b5.setClickable(true);
        b5.setImageResource(R.drawable.white);
        b6.setClickable(true);
        b6.setImageResource(R.drawable.white);
        b7.setClickable(true);
        b7.setImageResource(R.drawable.white);
        b8.setClickable(true);
        b8.setImageResource(R.drawable.white);
        b9.setClickable(true);
        b9.setImageResource(R.drawable.white);


    }
}

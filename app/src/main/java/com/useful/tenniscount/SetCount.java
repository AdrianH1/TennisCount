package com.useful.tenniscount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SetCount extends AppCompatActivity {

    TextView player1;
    TextView player2;

    ImageView serve1;
    ImageView serve2;

    Button btn_point1;
    Button btn_point2;
    Button btn_matchend;

    EditText edit_currentcount_player1;
    EditText edit_currentcount_player2;
    EditText edit_gamecount_player1;
    EditText edit_gamecount_player2;

    int game_count1 = 0;
    int game_count2 = 0;
    int player_won;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setcount_layout);

        btn_point1 = (Button) findViewById(R.id.btn_point_player1);
        btn_point2 = (Button) findViewById(R.id.btn_point_player2);
        btn_matchend = (Button) findViewById(R.id.btn_gameend);
        edit_currentcount_player1 = (EditText) findViewById(R.id.edit_current_player1);
        edit_currentcount_player2 = (EditText) findViewById(R.id.edit_current_player2);
        edit_gamecount_player1 = (EditText) findViewById(R.id.edit_game_player1);
        edit_gamecount_player2 = (EditText) findViewById(R.id.edit_game_player2);

        edit_currentcount_player1.setKeyListener(null);
        edit_currentcount_player2.setKeyListener(null);
        edit_gamecount_player1.setKeyListener(null);
        edit_gamecount_player2.setKeyListener(null);

        player1 = (TextView) findViewById(R.id.txt_count_player1);
        player2 = (TextView) findViewById(R.id.txt_count_player2);

        serve1 = (ImageView) findViewById(R.id.serve1);
        serve2 = (ImageView) findViewById(R.id.serve2);

        String name_player1= (String) getIntent().getSerializableExtra("player1");
        String name_player2= (String) getIntent().getSerializableExtra("player2");
        final Boolean serve = (Boolean) getIntent().getSerializableExtra("first"); //true = Player1

        player1.setText(name_player1);
        player2.setText(name_player2);

        if (serve == true) {
            serve1.setVisibility(View.VISIBLE);
            serve2.setVisibility(View.INVISIBLE);
        }else {
            serve2.setVisibility(View.VISIBLE);
            serve1.setVisibility(View.INVISIBLE);
        }

        btn_point1.setOnClickListener(new View.OnClickListener() {
            int zero = 0;
            int fifteen = 15;
            int thirty = 30;
            int forty = 40;
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(String.valueOf(edit_currentcount_player1.getText())) == zero) {
                    edit_currentcount_player1.setText(String.valueOf(fifteen));
                } else if (Integer.parseInt(String.valueOf(edit_currentcount_player1.getText())) == fifteen) {
                    edit_currentcount_player1.setText(String.valueOf(thirty));
                } else if (Integer.parseInt(String.valueOf(edit_currentcount_player1.getText())) == thirty) {
                    edit_currentcount_player1.setText(String.valueOf(forty));
                } else if (Integer.parseInt(String.valueOf(edit_currentcount_player1.getText())) == forty) {
                    edit_currentcount_player1.setText(String.valueOf(zero));
                    edit_currentcount_player2.setText(String.valueOf(zero));
                    game1();
                }
            }
        });

        btn_point2.setOnClickListener(new View.OnClickListener() {
            int zero = 0;
            int fifteen = 15;
            int thirty = 30;
            int forty = 40;
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(String.valueOf(edit_currentcount_player2.getText())) == zero) {
                    edit_currentcount_player2.setText(String.valueOf(fifteen));
                } else if (Integer.parseInt(String.valueOf(edit_currentcount_player2.getText())) == fifteen) {
                    edit_currentcount_player2.setText(String.valueOf(thirty));
                } else if (Integer.parseInt(String.valueOf(edit_currentcount_player2.getText())) == thirty) {
                    edit_currentcount_player2.setText(String.valueOf(forty));
                } else if (Integer.parseInt(String.valueOf(edit_currentcount_player2.getText())) == forty) {
                    edit_currentcount_player2.setText(String.valueOf(zero));
                    edit_currentcount_player1.setText(String.valueOf(zero));
                    game2();
                }
            }
        });

        btn_matchend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_matchend = new Intent(SetCount.this, Overview3.class);
                intent_matchend.putExtra("Player1", String.valueOf(player1.getText()));
                intent_matchend.putExtra("Player2", String.valueOf(player2.getText()));
                intent_matchend.putExtra("Player1_count", String.valueOf(edit_gamecount_player1.getText()));
                intent_matchend.putExtra("Player2_count", String.valueOf(edit_gamecount_player2.getText()));
                intent_matchend.putExtra("Player_won", player_won);
                intent_matchend.putExtra("serve", serve);
                startActivity(intent_matchend);
            }
        });
    }

    public void game1() {
        game_count1 = game_count1 + 1;
        if (game_count1 <= 6){
            edit_gamecount_player1.setText(String.valueOf(game_count1));
        }
        if (game_count1 == 5 && game_count2 == 5){
            System.out.println("test55");
            return;
        }
        if (game_count1 == 5 && game_count2 == 6){
            System.out.println("test56");
            edit_gamecount_player1.setText(String.valueOf(5));
            edit_gamecount_player2.setText(String.valueOf(6));
            return;
        }
        if (game_count1 == 5 && game_count2 == 7){
            System.out.println("test57");
            edit_gamecount_player1.setText(String.valueOf(5));
            edit_gamecount_player2.setText(String.valueOf(7));
            btn_point1.setEnabled(false);
            btn_point2.setEnabled(false);
            return;
        }
        if (game_count1 == 6 && game_count2 == 5){
            System.out.println("test65");
            edit_gamecount_player1.setText(String.valueOf(6));
            edit_gamecount_player2.setText(String.valueOf(5));
            return;
        }
        if (game_count1 == 7 && game_count2 == 5){
            System.out.println("test75");
            edit_gamecount_player1.setText(String.valueOf(7));
            edit_gamecount_player2.setText(String.valueOf(5));
            btn_point1.setEnabled(false);
            btn_point2.setEnabled(false);
            return;
        }
        if (game_count1 == 6 && game_count2 == 6){
            System.out.println("test66");
            edit_gamecount_player1.setText(String.valueOf(6));
            edit_gamecount_player2.setText(String.valueOf(6));
            return;
        }
        if (game_count1 == 7 && game_count2 == 6){
            System.out.println("test76");
            edit_gamecount_player1.setText(String.valueOf(7));
            edit_gamecount_player2.setText(String.valueOf(6));
            btn_point1.setEnabled(false);
            btn_point2.setEnabled(false);
            return;
        }
        if (game_count1 == 6 && game_count2 == 7){
            System.out.println("test67");
            edit_gamecount_player1.setText(String.valueOf(6));
            edit_gamecount_player2.setText(String.valueOf(7));
            btn_point1.setEnabled(false);
            btn_point2.setEnabled(false);
            return;
        }
        if (game_count1 == 6 || game_count2 == 6){
            btn_point1.setEnabled(false);
            btn_point2.setEnabled(false);
        }
    }

    public void game2() {
        game_count2 = game_count2 + 1;
        if (game_count2 <= 6){
            edit_gamecount_player2.setText(String.valueOf(game_count2));
        }
        if (game_count1 == 5 && game_count2 == 6){
            System.out.println("test56");
            edit_gamecount_player1.setText(String.valueOf(5));
            edit_gamecount_player2.setText(String.valueOf(6));
            return;
        }
        if (game_count1 == 5 && game_count2 == 7){
            System.out.println("test57");
            edit_gamecount_player1.setText(String.valueOf(5));
            edit_gamecount_player2.setText(String.valueOf(7));
            btn_point1.setEnabled(false);
            btn_point2.setEnabled(false);
            return;
        }
        if (game_count1 == 6 && game_count2 == 5){
            System.out.println("test65");
            edit_gamecount_player1.setText(String.valueOf(6));
            edit_gamecount_player2.setText(String.valueOf(5));
            return;
        }
        if (game_count1 == 7 && game_count2 == 5){
            System.out.println("test75");
            edit_gamecount_player1.setText(String.valueOf(7));
            edit_gamecount_player2.setText(String.valueOf(5));
            btn_point1.setEnabled(false);
            btn_point2.setEnabled(false);
            return;
        }
        if (game_count1 == 6 && game_count2 == 6){
            System.out.println("test66");
            edit_gamecount_player1.setText(String.valueOf(6));
            edit_gamecount_player2.setText(String.valueOf(6));
            return;
        }
        if (game_count1 == 7 && game_count2 == 6){
            System.out.println("test76");
            edit_gamecount_player1.setText(String.valueOf(7));
            edit_gamecount_player2.setText(String.valueOf(6));
            btn_point1.setEnabled(false);
            btn_point2.setEnabled(false);
            return;
        }
        if (game_count1 == 6 && game_count2 == 7){
            System.out.println("test67");
            edit_gamecount_player1.setText(String.valueOf(6));
            edit_gamecount_player2.setText(String.valueOf(7));
            btn_point1.setEnabled(false);
            btn_point2.setEnabled(false);
            return;
        }
        if (game_count1 == 6 || game_count2 == 6){
            btn_point1.setEnabled(false);
            btn_point2.setEnabled(false);
        }
    }
}


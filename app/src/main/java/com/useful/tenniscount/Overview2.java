package com.useful.tenniscount;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Overview2 extends AppCompatActivity {

    TextView player1_name;
    TextView player2_name;
    EditText player1_count_gameone;
    EditText player1_count_gametwo;
    EditText player1_count_gamethree;
    EditText player2_count_gameone;
    EditText player2_count_gametwo;
    EditText player2_count_gamethree;
    Button btn_startnextgame;
    Button btn_endmatch;

    Integer count_of_set = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview2_layout);

        //Load saved Data
        SharedPreferences settings = getSharedPreferences("prefs_count_of_set", 0);
        count_of_set = settings.getInt("count_of_set", count_of_set);

        player1_name = (TextView) findViewById(R.id.txt_player1_overview3);
        player2_name = (TextView) findViewById(R.id.txt_player2_overview);
        player1_count_gameone = (EditText) findViewById(R.id.overview3_gameone_player1);
        player1_count_gametwo = (EditText) findViewById(R.id.overview3_gamethree_player1);
        player1_count_gamethree = (EditText) findViewById(R.id.overview_gamethree_player1);
        player2_count_gameone = (EditText) findViewById(R.id.overview_gameone_player2);
        player2_count_gametwo = (EditText) findViewById(R.id.overview_gametwo_player2);
        player2_count_gamethree = (EditText) findViewById(R.id.overview_gamethree_player2);
        btn_startnextgame = (Button) findViewById(R.id.btn_startnextgame);
        btn_endmatch = (Button) findViewById(R.id.btn_endmatch);

        final int won = (Integer) getIntent().getSerializableExtra("Player_won");
        String player1_name_extra = (String) getIntent().getSerializableExtra("Player1");
        String player2_name_extra = (String) getIntent().getSerializableExtra("Player2");
        String player1_count_extra = (String) getIntent().getSerializableExtra("Player1_count");
        String player2_count_extra = (String) getIntent().getSerializableExtra("Player2_count");
        final Boolean serve= (Boolean) getIntent().getSerializableExtra("serve");

        //Load saved Data
        SharedPreferences overview = getSharedPreferences("prefs_for_overview", 0);
        if (overview.contains("player1_set2")) {
            System.out.println("into load 2");
            player1_count_gametwo.setText(overview.getString("player1_set2", ""));
            player2_count_gametwo.setText(overview.getString("player2_set2", ""));
            player1_count_gameone.setText(overview.getString("player1_set1", ""));
            player2_count_gameone.setText(overview.getString("player2_set1", ""));
        } else if (overview.contains("player1_set1")) {
            System.out.println("into load 1");
            player1_count_gameone.setText(overview.getString("player1_set1", ""));
            player2_count_gameone.setText(overview.getString("player2_set1", ""));
        } else {
            System.out.println("no results loaded");
        }

        player1_name.setText(player1_name_extra);
        player2_name.setText(player2_name_extra);

        if (count_of_set == 0){ //Set 1
            player1_count_gameone.setText(player1_count_extra);
            player2_count_gameone.setText(player2_count_extra);
            if (won == 1) {
                player1_count_gameone.setTypeface(null,Typeface.BOLD);
            } else {
                player2_count_gameone.setTypeface(null, Typeface.BOLD);
            }
            //Save Data
            overview = getSharedPreferences("prefs_for_overview", 0);
            SharedPreferences.Editor editor = overview.edit();
            editor.putString("player1_set1", player1_count_extra);
            editor.putString("player2_set1", player2_count_extra);
            // Commit the edits!
            editor.commit();
        }else if(count_of_set == 1){ //Set 2
            player1_count_gametwo.setText(player1_count_extra);
            player2_count_gametwo.setText(player2_count_extra);

            if (won == 1) {
                player1_count_gametwo.setTypeface(null,Typeface.BOLD);
            } else {
                player2_count_gametwo.setTypeface(null, Typeface.BOLD);
            }
            //Save Data
            overview = getSharedPreferences("prefs_for_overview", 0);
            SharedPreferences.Editor editor = overview.edit();
            editor.putString("player1_set2", player1_count_extra);
            editor.putString("player2_set2", player2_count_extra);
            // Commit the edits!
            editor.commit();
        }else if (count_of_set == 2){ // Set 3
            player1_count_gamethree.setText(player1_count_extra);
            player2_count_gamethree.setText(player2_count_extra);

            if (won == 1) {
                player1_count_gamethree.setTypeface(null,Typeface.BOLD);
            } else {
                player2_count_gamethree.setTypeface(null, Typeface.BOLD);
            }
            //Save Data
            overview = getSharedPreferences("prefs_for_overview", 0);
            SharedPreferences.Editor editor = overview.edit();
            editor.putString("player1_set3", player1_count_extra);
            editor.putString("player2_set3", player2_count_extra);
            // Commit the edits!
            editor.commit();
            btn_startnextgame.setEnabled(false);
        }else{
            System.out.println("Match End");
        }


        btn_startnextgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Save Data
                SharedPreferences settings = getSharedPreferences("prefs_count_of_set", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("count_of_set", count_of_set+1);
                // Commit the edits!
                editor.commit();
                System.out.println("count of set: " + count_of_set);
                Intent next_game = new Intent(Overview2.this, SetCount.class);
                next_game.putExtra("player1",  String.valueOf(player1_name.getText()));
                next_game.putExtra("player2", String.valueOf(player2_name.getText()));
                if (serve == true){
                    next_game.putExtra("first", false); //true = player1
                } else {
                    next_game.putExtra("first", true);
                }
                startActivity(next_game);
            }
        });

        btn_endmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_of_set = 0;
                SharedPreferences settings = getSharedPreferences("prefs_count_of_set", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.clear();
                editor.commit();
                SharedPreferences overview = getSharedPreferences("prefs_for_overview", 0);
                SharedPreferences.Editor editor1 = overview.edit();
                editor1.clear();
                editor1.commit();
                Intent start_over = new Intent(Overview2.this, StartUp.class);
                startActivity(start_over);
            }
        });
    }

    public void reset_count(){
        count_of_set = 0;
    }
}

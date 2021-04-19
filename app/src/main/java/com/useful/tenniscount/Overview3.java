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

public class Overview3 extends AppCompatActivity {

    TextView player1_name, player2_name;
    Button btn_start_next_match;
    Button btn_end_match;
    EditText player1_count_gameone, player1_count_gametwo, player1_count_gamethree, player1_count_gamefour, player1_count_gamefive;
    EditText player2_count_gameone, player2_count_gametwo, player2_count_gamethree, player2_count_gamefour, player2_count_gamefive;

    Integer count_of_set = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview3_layout);

        //Load saved Data
        SharedPreferences settings = getSharedPreferences("prefs_count_of_set3", 0);
        count_of_set = settings.getInt("count_of_set3", count_of_set);

        player1_name = (TextView) findViewById(R.id.txt_player1_overview3);
        player2_name = (TextView) findViewById(R.id.txt_player2_overview3);
        btn_start_next_match = (Button) findViewById(R.id.btn_startnextgame3);
        btn_end_match = (Button) findViewById(R.id.btn_endmatch3);
        player1_count_gameone = (EditText) findViewById(R.id.overview3_gameone_player1);
        player1_count_gametwo = (EditText) findViewById(R.id.overview3_gametwo_player1);
        player1_count_gamethree = (EditText) findViewById(R.id.overview3_gamethree_player1);
        player1_count_gamefour = (EditText) findViewById(R.id.overview3_gamefour_player1);
        player1_count_gamefive = (EditText) findViewById(R.id.overview3_gamefive_player1);
        player2_count_gameone = (EditText) findViewById(R.id.overview3_gameone_player2);
        player2_count_gametwo = (EditText) findViewById(R.id.overview3_gametwo_player2);
        player2_count_gamethree = (EditText) findViewById(R.id.overview3_gamethree_player2);
        player2_count_gamefour = (EditText) findViewById(R.id.overview3_gamefour_player2);
        player2_count_gamefive = (EditText) findViewById(R.id.overview3_gamefive_player2);

        final int won = (Integer) getIntent().getSerializableExtra("Player_won");
        String player1_name_extra = (String) getIntent().getSerializableExtra("Player1");
        String player2_name_extra = (String) getIntent().getSerializableExtra("Player2");
        String player1_count_extra = (String) getIntent().getSerializableExtra("Player1_count");
        String player2_count_extra = (String) getIntent().getSerializableExtra("Player2_count");
        final Boolean serve= (Boolean) getIntent().getSerializableExtra("serve");

        //Load saved Data
        SharedPreferences overview = getSharedPreferences("prefs_for_overview3", 0);
        if (overview.contains("player1_set4")) {
            System.out.println("into load 4");
            player1_count_gamefour.setText(overview.getString("player1_set4", ""));
            player2_count_gamefour.setText(overview.getString("player2_set4", ""));
            player1_count_gamethree.setText(overview.getString("player1_set3", ""));
            player2_count_gamethree.setText(overview.getString("player2_set3", ""));
            player1_count_gametwo.setText(overview.getString("player1_set2", ""));
            player2_count_gametwo.setText(overview.getString("player2_set2", ""));
            player1_count_gameone.setText(overview.getString("player1_set1", ""));
            player2_count_gameone.setText(overview.getString("player2_set1", ""));
        } else if (overview.contains("player1_set3")) {
            System.out.println("into load 3");
            player1_count_gamethree.setText(overview.getString("player1_set3", ""));
            player2_count_gamethree.setText(overview.getString("player2_set3", ""));
            player1_count_gametwo.setText(overview.getString("player1_set2", ""));
            player2_count_gametwo.setText(overview.getString("player2_set2", ""));
            player1_count_gameone.setText(overview.getString("player1_set1", ""));
            player2_count_gameone.setText(overview.getString("player2_set1", ""));
        } else if (overview.contains("player1_set2")) {
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
                player1_count_gameone.setTypeface(null, Typeface.BOLD);
            } else {
                player2_count_gameone.setTypeface(null, Typeface.BOLD);
            }
            //Save Data
            overview = getSharedPreferences("prefs_for_overview3", 0);
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
            overview = getSharedPreferences("prefs_for_overview3", 0);
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
            overview = getSharedPreferences("prefs_for_overview3", 0);
            SharedPreferences.Editor editor = overview.edit();
            editor.putString("player1_set3", player1_count_extra);
            editor.putString("player2_set3", player2_count_extra);
            // Commit the edits!
            editor.commit();
        }else if (count_of_set == 3){ // Set 4
            player1_count_gamefour.setText(player1_count_extra);
            player2_count_gamefour.setText(player2_count_extra);

            if (won == 1) {
                player1_count_gamefour.setTypeface(null,Typeface.BOLD);
            } else {
                player2_count_gamefour.setTypeface(null, Typeface.BOLD);
            }
            //Save Data
            overview = getSharedPreferences("prefs_for_overview3", 0);
            SharedPreferences.Editor editor = overview.edit();
            editor.putString("player1_set4", player1_count_extra);
            editor.putString("player2_set4", player2_count_extra);
            // Commit the edits!
            editor.commit();
        } else if (count_of_set == 4){ // Set5
            player1_count_gamefive.setText(player1_count_extra);
            player2_count_gamefive.setText(player2_count_extra);

            if (won == 1) {
                player1_count_gamefive.setTypeface(null,Typeface.BOLD);
            } else {
                player2_count_gamefive.setTypeface(null, Typeface.BOLD);
            }
            //Save Data
            overview = getSharedPreferences("prefs_for_overview3", 0);
            SharedPreferences.Editor editor = overview.edit();
            editor.putString("player1_set5", player1_count_extra);
            editor.putString("player2_set5", player2_count_extra);
            // Commit the edits!
            editor.commit();
            btn_start_next_match.setEnabled(false);
        }else{
            System.out.println("Match End");
        }


        btn_start_next_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Save Data
                SharedPreferences settings = getSharedPreferences("prefs_count_of_set3", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("count_of_set3", count_of_set+1);
                // Commit the edits!
                editor.commit();
                System.out.println("count of set: " + count_of_set);
                Intent next_game = new Intent(Overview3.this, SetCount.class);
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

        btn_end_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_of_set = 0;
                SharedPreferences settings = getSharedPreferences("prefs_count_of_set3", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.clear();
                editor.commit();
                SharedPreferences overview = getSharedPreferences("prefs_for_overview3", 0);
                SharedPreferences.Editor editor1 = overview.edit();
                editor1.clear();
                editor1.commit();
                Intent start_over = new Intent(Overview3.this, StartUp.class);
                startActivity(start_over);
            }
        });
    }

    public void reset_count(){
        count_of_set = 0;
    }
}

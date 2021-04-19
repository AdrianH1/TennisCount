package com.useful.tenniscount;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class StartUp extends AppCompatActivity {

    CheckBox player1_first;
    CheckBox player2_first;

    EditText player1;
    EditText player2;

    Button start;
    Button start_new;

    static final int START_SETCOUNT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_layout);

        player1_first = (CheckBox) findViewById(R.id.ckbox_player1);
        player2_first = (CheckBox) findViewById(R.id.ckbox_player2);

        player1 = (EditText) findViewById(R.id.edit_player1);
        player2 = (EditText) findViewById(R.id.edit_player2);

        start = (Button) findViewById(R.id.btn_start);
        start_new = (Button) findViewById(R.id.btn_startnew);

        player1_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player2_first.isChecked()){
                    player2_first.setChecked(false);
                }
            }
        });

        player2_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player1_first.isChecked()){
                    player1_first.setChecked(false);
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_set_count = new Intent(StartUp.this, SetCount.class);
                start_set_count.putExtra("player1",  String.valueOf(player1.getText()));
                start_set_count.putExtra("player2", String.valueOf(player2.getText()));
                start_set_count.putExtra("first", player1_first.isChecked());
                startActivity(start_set_count);
            }
        });

        start_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Overview2 overview_2_class = new Overview2();
                overview_2_class.reset_count();
                SharedPreferences settings = getSharedPreferences("prefs_count_of_set", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.clear();
                editor.commit();
                SharedPreferences overview = getSharedPreferences("prefs_for_overview", 0);
                SharedPreferences.Editor editor1 = overview.edit();
                editor1.clear();
                editor1.commit();

                Overview3 overview_3_class = new Overview3();
                overview_3_class.reset_count();
                SharedPreferences settings3 = getSharedPreferences("prefs_count_of_set3", 0);
                SharedPreferences.Editor editor2 = settings.edit();
                editor.clear();
                editor.commit();
                SharedPreferences overview3 = getSharedPreferences("prefs_for_overview3", 0);
                SharedPreferences.Editor editor3 = overview.edit();
                editor1.clear();
                editor1.commit();

                Intent start_over = new Intent(StartUp.this, StartUp.class);
                startActivity(start_over);
            }
        });
    }
}



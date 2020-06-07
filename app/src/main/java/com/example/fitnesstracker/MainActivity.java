package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText calorie;
    Button edit, save;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs=getSharedPreferences("CALORIES", MODE_PRIVATE);
        int calories=prefs.getInt("MY CALORIES", 0);

        calorie=findViewById(R.id.calories);
        edit=findViewById(R.id.edit);
        save=findViewById(R.id.save);

        //Set Default Value
        calorie.setText(calories+"");

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calorie.setEnabled(true);
                edit.setVisibility(View.GONE);
                save.setVisibility(View.VISIBLE);
                // saveData(v);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calorie.setEnabled(false);
                saveData(v);
            }
        });




    }

    private void saveData(View v){
        int caloriesValue=Integer.parseInt(calorie.getText().toString());

        //Save Data
        SharedPreferences.Editor editor=prefs.edit();
        editor.putInt("MY CALORIES", caloriesValue);
        editor.apply();
    }
}
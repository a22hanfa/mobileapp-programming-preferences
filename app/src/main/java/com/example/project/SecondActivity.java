package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String changingString = "Shared Preference";
    EditText editText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = (EditText) findViewById(R.id.edit_text_input);

        Button backButton = findViewById(R.id.button);
        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Button applyButton = findViewById(R.id.applyButton);
        applyButton.setOnClickListener(view -> {
            saveData();
        });

    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(changingString, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(changingString, editText.getText().toString()).apply();
    }

}

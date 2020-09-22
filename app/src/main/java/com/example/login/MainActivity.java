package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.login.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView userTextView = findViewById(R.id.textView);
        final Button logOutButton = findViewById(R.id.logOutButton);
        final Intent o = new Intent(MainActivity.this, LoginActivity.class);

        final SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        userTextView.setText("Welcome again " + preferences.getString("username", ""));

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                startActivity(o);
            }
        });


    }
}
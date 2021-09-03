package com.example.wk01hw02solo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    private Button login;
    private int finalid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         String[] usernames = {"Ivan","Steph", "Aundre", "Angie"};
         String[] passwords = {"123", "hello", "bye", "sandwich"};
         int[] ids = {1,2,3,4};
        userName = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);
        login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString();
                String pass = password.getText().toString();
                int pos_user = -1;
                for(int i = 0; i < usernames.length; i++)
                {
                    if(username.equals(usernames[i]))
                    {
                        userName.setBackgroundColor(0x00000000);
                        pos_user=i;
                        break;
                    }
                }
                if(pos_user==-1)
                {
                    password.clearFocus();
                    Toast.makeText(MainActivity.this, "User Not Found!", Toast.LENGTH_SHORT).show();
                    userName.setBackgroundColor(0xFFFF0000);
                    password.setBackgroundColor(0x00000000);
                }
                if(pos_user!=-1) {
                    if (pass.equals(passwords[pos_user]))
                    {
                        Intent newInt = new Intent(MainActivity.this, MainActivity2.class);
//                        Bundle welcomeBun = new Bundle();
//                        welcomeBun.putString("user", username);
//                        welcomeBun.putString("id", String.valueOf(finalid+1));
                        newInt.putExtra("user", username);
                        newInt.putExtra("id", String.valueOf(pos_user+1));
//                        newInt.putExtras(welcomeBun);
                        startActivity(newInt);
                   }
                    else{
                        userName.clearFocus();
                        Toast.makeText(MainActivity.this, "Incorrect Password!", Toast.LENGTH_SHORT).show();
                        password.setBackgroundColor(0xFFFF0000);
                    }
                }
            }
        });
    }
}

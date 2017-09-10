package com.example.a14512.nimd_douban.modules.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.modules.main.view.MainActivity;


public class LoginActivity extends AppCompatActivity {
    private EditText username = null;
    private EditText password = null;
    int counter = 3;
    private TextView attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final Button Button1;
        Button1 = (Button) findViewById(R.id.Login);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               username = (EditText)findViewById(R.id.username);
                password = (EditText)findViewById(R.id.password);
                if(username.getText().toString().equals("nimd")&&
                        password.getText().toString().equals("nimd")) {
                    Toast.makeText(getApplicationContext(), "登录成功.",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"账号或密码错误",
                            Toast.LENGTH_SHORT).show();
                    counter--;
                    if(counter==0){
                        Button1.setEnabled(false);
                    }
                }

            }
        });

    }

}
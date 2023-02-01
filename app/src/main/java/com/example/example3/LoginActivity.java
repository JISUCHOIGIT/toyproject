package com.example.example3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private EditText editId;
    private EditText editPw;
    private Button btn_login;
    private String id;
    private String pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editId = findViewById(R.id.idEditTextView);
        editPw = findViewById(R.id.pwEditTextView);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getId = editId.getText().toString();
                String getPw = editPw.getText().toString();

                if (getId.getBytes().length <= 0) {
                    Toast.makeText(LoginActivity.this, "ID를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (getPw.getBytes().length <= 0) {
                    Toast.makeText(LoginActivity.this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    id = editId.getText().toString();
                    pw = editPw.getText().toString();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("pw", pw);
                    startActivity(intent);

                }
            }

        });

    }
}
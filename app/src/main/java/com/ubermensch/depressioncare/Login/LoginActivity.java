package com.ubermensch.depressioncare.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ubermensch.depressioncare.MainActivity;
import com.ubermensch.depressioncare.R;

public class LoginActivity extends AppCompatActivity {

    private String email = "";
    private String password = "";
    private EditText ed_eamil, ed_password;
    private Button btn_login, btn_signup, bt_find;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        firebaseAuth = FirebaseAuth.getInstance();



        // Login Button Listener
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                email = ed_eamil.getText().toString();
                password = ed_password.getText().toString();
                if (isValidEmail() && isValidPasswd()) {
                    loginUser(email, password);
                }
            }
        });

        // SignUP Button Listener
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SignUpActivity.class);
                startActivity(intent);
            }
        });

        // Find Button Listener
        bt_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FindActivity.class);
                startActivity(intent);
            }
        });

    }







    // 로그인
    private void loginUser(String email, String password)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 로그인 성공
                            Toast.makeText(LoginActivity.this, R.string.success_login, Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // 로그인 실패
                            Toast.makeText(LoginActivity.this, "이메일/비밀번호를 확인해 주세요", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // 비밀번호 유효성 검사
    private boolean isValidPasswd() {
        if (password.isEmpty()) {
            // 비밀번호 공백
            Toast.makeText(LoginActivity.this,"패스워드가 공백입니다.",Toast.LENGTH_SHORT);
            return false;

        } else {
            return true;
        }
    }

    // 이메일 유효성 검사
    private boolean isValidEmail() {
        if (email.isEmpty()) {
            // 이메일 공백
            Toast.makeText(LoginActivity.this,"이메일이 공백입니다.",Toast.LENGTH_SHORT);
            return false;
        }
        else {
            return true;
        }
    }

    private void init(){
        ed_eamil = (EditText) findViewById(R.id.ed_email);
        ed_password = (EditText) findViewById(R.id.ed_password);
        btn_login = (Button) findViewById(R.id.bt_login);
        btn_signup = (Button) findViewById(R.id.bt_signup);
        bt_find = (Button) findViewById(R.id.bt_find);
    }
}

package com.ubermensch.depressioncare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ubermensch.depressioncare.Diagnosis.DiagnoseActivity;
import com.ubermensch.depressioncare.Diagnosis.RecommendActivity;
import com.ubermensch.depressioncare.Login.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private TextView tx_test;
    private Button bt_diagnose, bt_recommend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        // 유저가 로그인하지 않은 상태라면 LoginActivity 실행
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        else{

            FirebaseUser user = firebaseAuth.getCurrentUser();
            tx_test.setText("UserEmail : " + user.getEmail());
        }

        // 버튼 클릭 리스너
        bt_diagnose.setOnClickListener(this);
        bt_recommend.setOnClickListener(this);

    }

    public void init(){
        tx_test = (TextView)findViewById(R.id.tx_test);
        bt_diagnose = (Button)findViewById(R.id.bt_diagnose);
        bt_recommend = (Button)findViewById(R.id.bt_recommend);
    }

    @Override
    public void onClick(View view) {
        if(view == bt_diagnose){
            startActivity(new Intent(getApplicationContext(), DiagnoseActivity.class));
        }
        if(view == bt_recommend){
            startActivity(new Intent(getApplicationContext(), RecommendActivity.class));
        }
    }
}

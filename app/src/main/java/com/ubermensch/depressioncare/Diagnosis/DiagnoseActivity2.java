package com.ubermensch.depressioncare.Diagnosis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.ubermensch.depressioncare.R;

public class DiagnoseActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose2);

        Button button = (Button) findViewById(R.id.next_button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DiagnoseActivity3.class);
                startActivity(intent);
            }
        });
    }
}

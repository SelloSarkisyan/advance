package com.example.advance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText txtName;
    EditText txtAge;
    Button btnShow;
    Button btnEnter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnter = findViewById(R.id.enter);
        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
        btnShow = findViewById(R.id.btnShow);


        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model t = new model(txtName.getText().toString(), txtAge.getText().toString());
                t.save();


            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
              startActivity(intent);

            }
        });



    }


}

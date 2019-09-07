package edu.bluejack182.queueku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HospitalLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_login);
    }

    public void go_back(View view) {
        finish();
    }

    public void go_register(View view) {
        Intent i = new Intent(getApplicationContext(), HospitalRegister.class);
        startActivity(i);

    }
}

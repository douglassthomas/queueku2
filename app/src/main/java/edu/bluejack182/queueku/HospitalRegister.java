package edu.bluejack182.queueku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class HospitalRegister extends AppCompatActivity {

    Spinner roleSpinner;
    String[] listRole = {"dokter", "receptionist"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_register);

        roleSpinner = findViewById(R.id.roleSpinner);
        ArrayAdapter<CharSequence> spinnerAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, listRole);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(spinnerAdapter);




    }

    public void go_back(View view) {
        finish();
    }
}

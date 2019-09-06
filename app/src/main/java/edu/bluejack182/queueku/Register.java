package edu.bluejack182.queueku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

public class Register extends AppCompatActivity implements View.OnClickListener{

    FirebaseAuth auth;
    Button btnRegis;
    EditText regisEmail;
    EditText regisPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        btnRegis = findViewById(R.id.btnRegis);
        regisEmail = findViewById(R.id.regisEmail);
        regisPassword = findViewById(R.id.regisPassword);

        btnRegis.setOnClickListener(this);

    }

    public void go_back(View view) {
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegis:{
                String email = regisEmail.getText().toString();
                String password = regisPassword.getText().toString();


                firebaseRegis(email, password);
                break;
            }
        }
    }

    void firebaseRegis(String email, String password){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = task.getResult().getUser();

                    Gson gson = new Gson();
                    String json = gson.toJson(user);

                    Intent i = new Intent(getApplicationContext(), Home.class);
                    i.putExtra("user", json);
                    startActivity(i);

                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

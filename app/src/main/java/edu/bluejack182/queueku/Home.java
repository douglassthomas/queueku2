package edu.bluejack182.queueku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getIntent();
    }

    public void signout(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent i = new Intent(getApplicationContext(), Login.class);
        startActivity(i);
        finish();
    }
}

package com.sahilhans0605.bygbrains.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sahilhans0605.bygbrains.databinding.ActivityEmailRegistrationBinding;
import com.sahilhans0605.bygbrains.modelClass.User;

public class EmailRegistration extends AppCompatActivity {

    ActivityEmailRegistrationBinding binding;
    FirebaseAuth auth;
    String verificationId;
    ProgressDialog dialog2;
    ProgressDialog dialog3;
    private CountDownTimer countDownTimer;
    long timeLeftInMilliSeconds = 60000;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmailRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toast.makeText(this, "OTP is valid for 60 seconds!", Toast.LENGTH_SHORT).show();
        firebaseFirestore = FirebaseFirestore.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        dialog2 = new ProgressDialog(this);
        dialog2.setCanceledOnTouchOutside(false);
        dialog2.setMessage("Setting up your profile...");
        auth = FirebaseAuth.getInstance();
        String phoneNumber = getIntent().getStringExtra("phoneNumber");
        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        String gender = getIntent().getStringExtra("gender");
        verificationId = getIntent().getStringExtra("verificationId");


        User users = new User(name, age, gender, phoneNumber, FirebaseAuth.getInstance().getUid());

        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


}
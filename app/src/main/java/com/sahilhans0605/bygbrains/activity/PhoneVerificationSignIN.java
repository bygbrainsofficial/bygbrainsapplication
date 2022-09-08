package com.sahilhans0605.bygbrains.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sahilhans0605.bygbrains.databinding.ActivityPhoneVerificationSignInBinding;

public class PhoneVerificationSignIN extends AppCompatActivity {

    ActivityPhoneVerificationSignInBinding binding;
    FirebaseFirestore firebaseFirestore;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneVerificationSignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog = new ProgressDialog(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("Signing you in...");
        String verificationId = getIntent().getStringExtra("verificationId");
        String phoneNUmber = getIntent().getStringExtra("phoneNumber");
        firebaseFirestore = FirebaseFirestore.getInstance();
        binding.verifyPhone.setText("Verify + " + phoneNUmber);
        binding.verifybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.otpEnter.getText().toString().trim().length() < 6) {
                    binding.otpEnter.setError("Please enter a valid OTP!");
                } else {
                    dialog.show();
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId, binding.otpEnter.getText().toString().trim());
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            binding.verifybutton.setVisibility(View.INVISIBLE);
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(PhoneVerificationSignIN.this, HomePage.class);
                                dialog.dismiss();
                                startActivity(intent);
                                finishAffinity();
                            } else {
                                Toast.makeText(PhoneVerificationSignIN.this, "(Failed)Try again after 60 seconds!", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();

                            }
                        }
                    });
                }
            }
        });
    }
}
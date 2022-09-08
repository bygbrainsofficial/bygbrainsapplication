package com.sahilhans0605.bygbrains.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.ActivityOtpsignInBinding;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class OTPSignIn extends AppCompatActivity {

    ActivityOtpsignInBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore firebaseFirestore;
    String verificationId;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpsignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("Fetching OTP...");
        binding.getOTP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.phoneNumber2.getText().toString().equals("")) {
                    Toast.makeText(OTPSignIn.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if (binding.phoneNumber2.getText().toString().length() < 10) {
                    binding.phoneNumber2.setError("Invalid phone number");
                } else {
                    dialog.show();
                    PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                            .setPhoneNumber(binding.countryCodePicker.getSelectedCountryCodeWithPlus() + binding.phoneNumber2.getText().toString().trim())
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(OTPSignIn.this).setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {
                                    dialog.dismiss();
                                    Toast.makeText(OTPSignIn.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    dialog.dismiss();
                                    super.onCodeSent(s, forceResendingToken);
                                    Toast.makeText(OTPSignIn.this, "OTP Sent", Toast.LENGTH_SHORT).show();
                                    verificationId = s;

                                    Intent intent = new Intent(OTPSignIn.this, PhoneVerificationSignIN.class);
                                    intent.putExtra("verificationId", verificationId);
                                    intent.putExtra("phoneNumber", binding.countryCodePicker.getSelectedCountryCodeWithPlus() + binding.phoneNumber2.getText().toString().trim());
                                    startActivity(intent);
                                    finishAffinity();

                                }
                            }).build();
                    PhoneAuthProvider.verifyPhoneNumber(options);

                }

            }
        });
    }
}
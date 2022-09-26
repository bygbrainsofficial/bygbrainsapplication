package com.sahilhans0605.bygbrains.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.sahilhans0605.bygbrains.R;

public class UserDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ActivityUserDetailsBinding binding;
    String choice;
    FirebaseAuth auth;
    ProgressDialog dialog2;
    String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog2 = new ProgressDialog(this);
        dialog2.setCanceledOnTouchOutside(false);
        dialog2.setMessage("Fetching OTP...");
        auth = FirebaseAuth.getInstance();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(this);
        binding.continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.userName.getText().toString().equals("") || binding.userAge.getText().toString().equals("") || binding.spinner.toString().equals("Select Gender")) {
                    Toast.makeText(UserDetails.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    dialog2.show();

                    Intent intent = new Intent(UserDetails.this, EmailRegistration.class);
                    intent.putExtra("name", binding.userName.getText().toString().trim());
                    intent.putExtra("age", binding.userAge.getText().toString().trim());
                    intent.putExtra("gender", choice);
                    startActivity(intent);

                }
            }
        });

    }
        @Override
        public void onItemSelected (AdapterView < ? > adapterView, View view,int i, long l){
            choice = adapterView.getItemAtPosition(i).toString();
        }

        @Override
        public void onNothingSelected (AdapterView < ? > adapterView){

        }
    }
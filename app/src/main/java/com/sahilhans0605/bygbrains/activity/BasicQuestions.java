package com.sahilhans0605.bygbrains.activity;

import
        androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.ActivityBasicQuestionsBinding;
import com.sahilhans0605.bygbrains.modelClass.Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasicQuestions extends AppCompatActivity {
    ArrayList<Questions> questions;
    ActivityBasicQuestionsBinding binding;
    int currentQuestionIndex = 0;
    Questions question;
    FirebaseFirestore firebaseFirestore;
    FirebaseDatabase db;
    ProgressDialog dialog;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasicQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseFirestore = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("loading...");
        dialog.setCanceledOnTouchOutside(false);
        db = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        questions = new ArrayList<>();
        questions.add(new Questions("Most of the time you feel?", "Good", "Stressed", "Sad", "Indifferent", "Happy", "Alright!,Let's proceed", "BQ1"));
        questions.add(new Questions("What profession are you in?", "Student", "Job", "Self work", "HouseWife", "Other", ":) Awesome you are doing a great job!", "BQ2"));
        questions.add(new Questions("You want to improve in", "Anxiety", "Depression", "Sleep", "Other Disorder", "Be happy", "Be relaxed let's work on this!", "BQ3"));

        setNextQuestion();

    }

    void setNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            question = questions.get(currentQuestionIndex);
            binding.question.setText(question.getQuestion());
            binding.option1.setText(question.getOption1());
            binding.option2.setText(question.getOption2());
            binding.option3.setText(question.getOption3());
            binding.option4.setText(question.getOption4());
            binding.option5.setText(question.getOption5());
        }
    }

    String chosen = "";

    public void next(View view) {
        switch (view.getId()) {
            case R.id.option1:
                chosen = binding.option1.getText().toString();
                break;
            case R.id.option2:
                chosen = binding.option2.getText().toString();
                break;
            case R.id.option3:
                chosen = binding.option3.getText().toString();
                break;
            case R.id.option4:
                chosen = binding.option4.getText().toString();
                break;
            case R.id.option5:
                chosen = binding.option5.getText().toString();
                break;
        }

        switch (view.getId()) {

            case R.id.option1:
            case R.id.option2:
            case R.id.option3:
            case R.id.option4:
            case R.id.option5:

                binding.interaction.setVisibility(View.VISIBLE);
                binding.interaction.setText(question.getInteraction());
                binding.button.setVisibility(View.VISIBLE);
                break;


            case R.id.button:

                binding.button.setVisibility(View.INVISIBLE);
                binding.interaction.setVisibility(View.INVISIBLE);
                dialog.show();
                Map<String, String> map = new HashMap<>();
                map.put(question.getQuestion(), chosen);
                db.getReference().child("BasicQuestions").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(question.getId()).setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        dialog.dismiss();
//                        Toast.makeText(BasicQuestions.this, "Added!!!!", Toast.LENGTH_SHORT).show();
                        currentQuestionIndex++;
                        setNextQuestion();
                        if (currentQuestionIndex == questions.size()) {
                            Intent intent = new Intent(BasicQuestions.this, HomePage.class);
                            startActivity(intent);
                            finishAffinity();
                        }
                    }
                });


                break;
        }
    }
}
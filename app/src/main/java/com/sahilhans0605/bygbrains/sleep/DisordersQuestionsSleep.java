package com.sahilhans0605.bygbrains.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.ActivityDisordersQuestionsAngerBinding;
import com.sahilhans0605.bygbrains.databinding.ActivityDisordersQuestionsBinding;
import com.sahilhans0605.bygbrains.databinding.ActivityDisordersQuestionsSleepBinding;
import com.sahilhans0605.bygbrains.modelClass.DisordersQuestionsMOdel;

import java.util.ArrayList;

public class DisordersQuestionsSleep extends AppCompatActivity {

    ActivityDisordersQuestionsSleepBinding binding;
    int currentQuestionIndex = 0;
    ArrayList<DisordersQuestionsMOdel> questions;
    FirebaseFirestore firebaseFirestore;
    FirebaseDatabase db;
    ProgressDialog dialog;
    DisordersQuestionsMOdel question;
    FirebaseUser user;
    int yes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisordersQuestionsSleepBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseFirestore = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("loading...");
        dialog.setCanceledOnTouchOutside(false);
        db = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        questions = new ArrayList<>();
        questions.add(new DisordersQuestionsMOdel(" How long does it take you to fall asleep?", "0-15 minutes", "16-30minutes", "31-45 minutes", "46-60 minutes", ">60 minutes", ""));
        questions.add(new DisordersQuestionsMOdel("If you wake up one or more times during the night, estimate how long you are awake in total? (add up all the times you are awake.)", "0-15 minutes", "16-30minutes", "31-45 minutes", "46-60 minutes", ">60 minutes", ""));
        questions.add(new DisordersQuestionsMOdel("If your final wake-up time occurs before you intend to wake up, how much earlier is this", "I don’t wake up too early/up to 15 min. early", "16-30minutes", "31-45 minutes", "46-60 minutes", ">60 minutes", ""));
        questions.add(new DisordersQuestionsMOdel("How would you rate your sleep quality?", "Very Good", "Good", "Average", "Poor", "Very Poor", ""));
        questions.add(new DisordersQuestionsMOdel("How many nights a week do you have a problem with your sleep?", "0-1 ", "2", "3", "4", "5-7", ""));
        questions.add(new DisordersQuestionsMOdel("Consider the past month, to what extent has poor sleep….Affected your productivity, concentration, or ability to stay awake?", "Not at all", "A little", "Somewhat", "Much", "Very Much", ""));
        questions.add(new DisordersQuestionsMOdel("Affected energy, relationships, or mood?", "Not at all", "A little", "Somewhat", "Much", "Very Much", ""));
        questions.add(new DisordersQuestionsMOdel("Troubled you in general?", "Not at all", "A little", "Somewhat", "Much", "Very Much", ""));
        questions.add(new DisordersQuestionsMOdel("How long have you had a problem with your sleep?", "I don’t have a problem/<month", "1-2 Months", "3-6 months", "7-12 months", ">1 year", ""));

        setNextQuestion();
    }

    String chosen = "";

    public void next(View view) {
        switch (view.getId()) {
            case R.id.option1D:
                chosen = binding.option1D.getText().toString();

                yes += 0;
                setNextQuestion();
                break;
            case R.id.option2D:
                yes += 1;
                chosen = binding.option2D.getText().toString();
                setNextQuestion();

                break;
            case R.id.option3D:
                yes += 2;
                chosen = binding.option3D.getText().toString();
                setNextQuestion();
                break;
            case R.id.option4D:
                yes += 3;
                chosen = binding.option4D.getText().toString();
                setNextQuestion();

                break;
            case R.id.option5D:
                yes += 4;
                chosen = binding.option5D.getText().toString();
                setNextQuestion();

                break;
            case R.id.option6D:
                yes += 5;
                chosen = binding.option6D.getText().toString();
                setNextQuestion();
                break;


        }
    }

    void lastQuestion() {

        Intent intent = new Intent(DisordersQuestionsSleep.this, ResultPageSleep.class);
        intent.putExtra("yes", yes);
        startActivity(intent);
        finish();
    }


    void setNextQuestion() {
        binding.option1D.setVisibility(View.VISIBLE);
        binding.option2D.setVisibility(View.VISIBLE);
        binding.option3D.setVisibility(View.VISIBLE);
        binding.option4D.setVisibility(View.VISIBLE);
        binding.option5D.setVisibility(View.VISIBLE);
        binding.option6D.setVisibility(View.VISIBLE);

        if (currentQuestionIndex < questions.size()) {
            question = questions.get(currentQuestionIndex);
            binding.questionD.setText(question.getQuestion());
            binding.option1D.setText(question.getOption1());
            binding.option2D.setText(question.getOption2());
            binding.option3D.setText(question.getOption3());
            binding.option4D.setText(question.getOption4());
            binding.option5D.setText(question.getOption5());
            binding.option6D.setText(question.getOption6());
        }

        if (currentQuestionIndex == questions.size()) {
            binding.option1D.setVisibility(View.INVISIBLE);
            binding.option2D.setVisibility(View.INVISIBLE);
            binding.option3D.setVisibility(View.INVISIBLE);
            binding.option4D.setVisibility(View.INVISIBLE);
            binding.option5D.setVisibility(View.INVISIBLE);
            binding.option6D.setVisibility(View.INVISIBLE);
            lastQuestion();
        }
//                Map<String, String> map = new HashMap<>();
//                map.put(question.getQuestion(), chosen);
//                db.getReference().child("BasicQuestions").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(question.getId()).setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        Toast.makeText(BasicQuestions.this, "Added!!!!", Toast.LENGTH_SHORT).show();
        currentQuestionIndex++;


//                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();

//                        if (currentQuestionIndex == questions.size()) {
//                            Intent intent = new Intent(BasicQuestions.this, HomePage.class);
//                            startActivity(intent);
//                            finishAffinity();
//                        }
//                    }
//                });


        if (binding.option1D.getText().toString().equals("")) {
            binding.option1D.setVisibility(View.INVISIBLE);
        } else {
            binding.option1D.setVisibility(View.VISIBLE);
        }
        if (binding.option2D.getText().toString().equals("")) {
            binding.option2D.setVisibility(View.INVISIBLE);
        } else {
            binding.option1D.setVisibility(View.VISIBLE);
        }
        if (binding.option3D.getText().toString().equals("")) {
            binding.option3D.setVisibility(View.INVISIBLE);
        } else {
            binding.option1D.setVisibility(View.VISIBLE);
        }
        if (binding.option4D.getText().toString().equals("")) {
            binding.option4D.setVisibility(View.INVISIBLE);
        } else {
            binding.option4D.setVisibility(View.VISIBLE);
        }
        if (binding.option5D.getText().toString().equals("")) {
            binding.option5D.setVisibility(View.INVISIBLE);
        } else {
            binding.option5D.setVisibility(View.VISIBLE);
        }
        if (binding.option6D.getText().toString().equals("")) {
            binding.option6D.setVisibility(View.INVISIBLE);
        } else {
            binding.option6D.setVisibility(View.VISIBLE);
        }
    }
}
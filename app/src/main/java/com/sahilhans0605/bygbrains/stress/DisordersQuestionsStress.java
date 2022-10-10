package com.sahilhans0605.bygbrains.stress;

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
import com.sahilhans0605.bygbrains.modelClass.DisordersQuestionsMOdel;

import java.util.ArrayList;

public class DisordersQuestionsStress extends AppCompatActivity {

    ActivityDisordersQuestionsAngerBinding binding;
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
        binding = ActivityDisordersQuestionsAngerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseFirestore = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("loading...");
        dialog.setCanceledOnTouchOutside(false);
        db = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        questions = new ArrayList<>();
        questions.add(new DisordersQuestionsMOdel("In the last month, how often have you been upset because of something that happened unexpectedly?", "Never ", "Almost Never", "Sometimes", "Fairly Often", "Very Often", ""));
        questions.add(new DisordersQuestionsMOdel("In the last month, how often have you felt that you were unable to control the important things in your life?", "Never ", "Almost Never", "Sometimes", "Fairly Often", "Very Often", ""));
        questions.add(new DisordersQuestionsMOdel("In the last month, how often have you felt nervous and stressed?", "Never ", "Almost Never", "Sometimes", "Fairly Often", "Very Often", ""));
        questions.add(new DisordersQuestionsMOdel("In the last month, how often have you felt confident about your ability to handle your personal problems?", "Very Often","Fairly Often","Sometimes","Almost Never","never", ""));
        questions.add(new DisordersQuestionsMOdel("In the last month, how often have you felt that things were going your way?", "Very Often","Fairly Often","Sometimes","Almost Never","never", ""));
        questions.add(new DisordersQuestionsMOdel("In the last month, how often have you found that you could not cope with all the things that you had to do?", "Never ", "Almost Never", "Sometimes", "Fairly Often", "Very Often", ""));
        questions.add(new DisordersQuestionsMOdel("In the last month, how often have you been able to control irritations in your life?", "Very Often","Fairly Often","Sometimes","Almost Never","never", ""));
        questions.add(new DisordersQuestionsMOdel("In the last month, how often have you felt that you were on top of things?", "Very Often","Fairly Often","Sometimes","Almost Never","never", ""));
        questions.add(new DisordersQuestionsMOdel("In the last month, how often have you been angered because of things that happened that were outside of your control?", "Never ", "Almost Never", "Sometimes", "Fairly Often", "Very Often", ""));
        questions.add(new DisordersQuestionsMOdel("In the last month, how often have you felt difficulties were piling up so high that you could not overcome them?", "Never ", "Almost Never", "Sometimes", "Fairly Often", "Very Often", ""));

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

        Intent intent = new Intent(DisordersQuestionsStress.this, ResultPageStress.class);
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
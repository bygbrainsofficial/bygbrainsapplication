package com.sahilhans0605.bygbrains.depression;

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

public class DisordersQuestionsDepression extends AppCompatActivity {

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
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I don't feel particularly guilty", "I feel guilty a good part of the time.", "I feel quite guilty most of the time.", "I feel guilty all of the time.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I can sleep as well as usual.", "I don't sleep as well as I used to.", "I wake up 1-2 hours earlier than usual and find it hard to get back to sleep.", "I wake up several hours earlier than I used to and cannot get back to sleep.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I have not noticed any recent change in my interest in sex.", "I am less interested in sex than I used to be.", "I have almost no interest in sex.", "I have lost interest in sex completely.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I get as much satisfaction out of things as I used to.", "I don't enjoy things the way I used to.", "I don't get real satisfaction out of anything anymore.", "I am dissatisfied or bored with everything.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I don't cry any more than usual.", "I cry more now than I used to.", "I cry all the time now.", "I used to be able to cry, but now I can't cry even though I want to.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I don't have any thoughts of killing myself.", "I have thoughts of killing myself, but I would not carry them out.", "I would like to kill myself.", "I would kill myself if I had the chance.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I am no more irritated by things than I ever was.", "I am slightly more irritated now than usual.", "I am quite annoyed or irritated a good deal of the time.", "I feel irritated all the time.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I have not lost interest in other people.", "I am less interested in other people than I used to be.", "I have lost most of my interest in other people.", "I have lost all of my interest in other people.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I make decisions about as well as I ever could.", "I put off making decisions more than I used to.", "I have greater difficulty in making decisions more than I used to.", "I can't make decisions at all anymore.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I can work about as well as before.", "It takes an extra effort to get started at doing something.", "I have to push myself very hard to do anything.", "I can't do any work at all.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I don't get more tired than usual.", "I get tired more easily than I used to.", "I get tired from doing almost anything.", "I am too tired to do anything.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best", "I haven't lost much weight, if any, lately.", "I have lost more than 2.26796 kg.", "I have lost more than 4.53592 kg.", "I have lost more than 6.80389 kg", "", ""));



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

        Intent intent = new Intent(DisordersQuestionsDepression.this, ResultPageDepression.class);
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
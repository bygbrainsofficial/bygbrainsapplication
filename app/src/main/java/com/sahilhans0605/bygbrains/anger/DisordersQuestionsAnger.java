package com.sahilhans0605.bygbrains.anger;

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

public class DisordersQuestionsAnger extends AppCompatActivity {

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
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "I do not feel angry.", "I feel angry.", "I am angry most of the time now.", "I am so angry and hostile all the time that I can't stand it.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "I am not particularly angry about my future.", "When I think about my future, I feel angry.", "I feel angry about what I have to look forward to.", "I feel intensely angry about my future, since it cannot be improved.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "I don't feel that others are trying to annoy me.", "At times I think people are trying to annoy me.", "More people than usual are beginning to make me feel angry.", "I feel that others are constantly and intentionally making me angry", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "I don't feel angry when I think about myself.", "I feel more angry about myself these days than I used to.", "I feel angry about myself a good deal of the time.", "When I think about myself, I feel intense anger", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "I am not all that angry about things.", "I am becoming more hostile about things than I used to be.", "I am pretty angry about things these days.", "I am angry and hostile about everything.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "I don't feel angry enough to hurt someone.", "Sometimes I am so angry that I feel like hurting others, but I would not really do it.", "My anger is so intense that I sometimes feel like hurting others.", "I'm so angry that I would like to hurt someone.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "Things are not more irritating to me now than usual.", "I feel slightly more irritated now than usual.", "I feel irritated a good deal of the time.", "I'm irritated all the time now.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "I'm not so angry and hostile that others dislike me.", "People sometimes dislike being around me since I become angry.", "More often than not, people stay away from me because I'm so hostile and angry.", "People don't like me anymore because I'm constantly angry all the time.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "My feelings of anger do not interfere with my work.", "From time to time my feelings of anger interfere with my work.", "I feel so angry that it interferes with my capacity to work.", "My feelings of anger prevent me from doing any work at all.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "My anger does not interfere with my sleep.", "Sometimes I don't sleep very well because I'm feeling angry.", "My anger is so great that I stay awake 1—2 hours later than usual.", "I am so intensely angry that I can't get much sleep during the night.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "My ability to think clearly is unaffected by my feelings of anger.", "Sometimes my feelings of anger prevent me from thinking in a clear-headed way.", "My anger makes it hard for me to think of anything else.", "I'm so intensely angry and hostile that it completely interferes with my thinking.", "", ""));
        questions.add(new DisordersQuestionsMOdel("Choose the one that suits you the best!", "I don't feel so angry that it interferes with my interest in sex.", "My feelings of anger leave me less interested in sex than I used to be.", "My current feelings of anger undermine my interest in sex.", "I'm so angry about my life that I've completely lost interest in sex.", "", ""));

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

        Intent intent = new Intent(DisordersQuestionsAnger.this, ResultPageAnger.class);
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
package com.sahilhans0605.bygbrains.anxiety;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.ActivityDisordersQuestionsBinding;

import java.util.ArrayList;
import java.util.Objects;

public class DisordersQuestionsAnxiety extends AppCompatActivity {

    ActivityDisordersQuestionsBinding binding;
    int currentQuestionIndex = 0;
    ArrayList<DisordersQuestionsMOdel> questions;
    FirebaseFirestore firebaseFirestore;
    FirebaseDatabase db;
    ProgressDialog dialog;
    DisordersQuestionsMOdel question;
    FirebaseUser user;
    boolean hasAnxiety;
    boolean noAnxiety;
    String right[];
    String wrong[];
    int yes = 0;
    int no = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisordersQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseFirestore = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("loading...");
        dialog.setCanceledOnTouchOutside(false);
        db = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        questions = new ArrayList<>();
        questions.add(new DisordersQuestionsMOdel("What are the physical symptoms in your body.", "Dry Mouth", "Nausea", "Numbness or tingling in hands or feet", "Shortness of breath", "Feeling of choking", "Other/None", new String[]{"option2D", "option4D", "option5D"}, new String[]{"option1D", "option3D", "option6D"}, "Ok!, let's proceed"));
        questions.add(new DisordersQuestionsMOdel("What do you have phobia of?", "Heights", "Horror Movie", "Water", "None", "", "", new String[]{"option1D", "option3D", "option2D"}, new String[]{"option4D"}, "Ok fine!"));
        questions.add(new DisordersQuestionsMOdel("Are you sleeping well?", "Yes", "No", "Proper time", "", "", "", new String[]{"option2D", "option3D"}, new String[]{"option1D"}, "Ok fine!"));
        questions.add(new DisordersQuestionsMOdel("Do you use any drugs or drugs(addicted)?", "Alcohol", "Tobacco", "Heroin or chitta", "coffee", "Don't Do", "", new String[]{"option1D", "option3D", "option2D", "option4D"}, new String[]{"option5D"}, "Ok fine!"));
        questions.add(new DisordersQuestionsMOdel("How do you feel during the day ?", "Happy", "Alone", "Irritate", "Emotional", "Guilt", "", new String[]{"option3D", "option2D", "option4D", "option5D"}, new String[]{"option1D"}, "Ok fine!"));
        questions.add(new DisordersQuestionsMOdel("Any accidental case in your life ?", "Close Friend", "Life Partner", "Family Member", "Nobody", "", "", new String[]{"option1D", "option3D", "option2D"}, new String[]{"option4D"}, "Ok fine!"));

        setNextQuestion();
    }

    String chosen = "";

    public void next(View view) {
        switch (view.getId()) {
            case R.id.option1D:
                chosen = binding.option1D.getText().toString();
                for (int i = 0; i < right.length; i++) {
                    if (Objects.equals(right[i], "option1D")) {
                        System.out.println(right[i] + "option1D");
                        hasAnxiety = true;
                    } else {
                        noAnxiety = true;
                    }
                }

                binding.interactionD.setVisibility(View.VISIBLE);
                binding.interactionD.setText(question.getInteraction());
                binding.buttonD.setVisibility(View.VISIBLE);
                break;
            case R.id.option2D:
                chosen = binding.option2D.getText().toString();
                for (int i = 0; i < right.length; i++) {
                    if (Objects.equals(right[i], "option2D")) {
                        System.out.println(right[i] + "option2D");
                        hasAnxiety = true;
                    } else {
                        noAnxiety = true;
                    }
                }

                binding.interactionD.setVisibility(View.VISIBLE);
                binding.interactionD.setText(question.getInteraction());
                binding.buttonD.setVisibility(View.VISIBLE);
                break;
            case R.id.option3D:
                chosen = binding.option3D.getText().toString();
                for (int i = 0; i < right.length; i++) {
                    if (Objects.equals(right[i], "option3D")) {
                        System.out.println(right[i] + "option1D");
                        hasAnxiety = true;
                    } else {
                        noAnxiety = true;
                    }
                }

                binding.interactionD.setVisibility(View.VISIBLE);
                binding.interactionD.setText(question.getInteraction());
                binding.buttonD.setVisibility(View.VISIBLE);
                break;
            case R.id.option4D:
                chosen = binding.option4D.getText().toString();
                for (int i = 0; i < right.length; i++) {
                    if (Objects.equals(right[i], "option4D")) {
                        System.out.println(right[i] + "option1D");
                        hasAnxiety = true;
                    } else {
                        noAnxiety = true;
                    }
                }

                binding.interactionD.setVisibility(View.VISIBLE);
                binding.interactionD.setText(question.getInteraction());
                binding.buttonD.setVisibility(View.VISIBLE);
                break;
            case R.id.option5D:
                chosen = binding.option5D.getText().toString();
                for (int i = 0; i < right.length; i++) {
                    if (Objects.equals(right[i], "option5D")) {
                        System.out.println(right[i] + "option1D");
                        hasAnxiety = true;
                    } else {
                        noAnxiety = true;
                    }
                }

                binding.interactionD.setVisibility(View.VISIBLE);
                binding.interactionD.setText(question.getInteraction());
                binding.buttonD.setVisibility(View.VISIBLE);
                break;
            case R.id.option6D:
                chosen = binding.option6D.getText().toString();
                for (int i = 0; i < right.length; i++) {
                    if (Objects.equals(right[i], "option6D")) {
                        System.out.println(right[i] + "option1D");
                        hasAnxiety = true;
                    } else {
                        noAnxiety = true;
                    }

                    binding.interactionD.setVisibility(View.VISIBLE);
                    binding.interactionD.setText(question.getInteraction());
                    binding.buttonD.setVisibility(View.VISIBLE);
                    break;

                }

            case R.id.buttonD:
                if (hasAnxiety) {
                    yes++;
                    hasAnxiety = false;
                } else {
                    no++;
                    noAnxiety = false;
                }
                binding.buttonD.setVisibility(View.INVISIBLE);
                binding.interactionD.setVisibility(View.INVISIBLE);
                dialog.show();
                Toast.makeText(this, yes + " " + no, Toast.LENGTH_LONG).show();


                binding.option1D.setVisibility(View.VISIBLE);
                binding.option2D.setVisibility(View.VISIBLE);
                binding.option3D.setVisibility(View.VISIBLE);
                binding.option4D.setVisibility(View.VISIBLE);
                binding.option5D.setVisibility(View.VISIBLE);
                binding.option6D.setVisibility(View.VISIBLE);
//                Map<String, String> map = new HashMap<>();
//                map.put(question.getQuestion(), chosen);
//                db.getReference().child("BasicQuestions").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(question.getId()).setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
                dialog.dismiss();
//                        Toast.makeText(BasicQuestions.this, "Added!!!!", Toast.LENGTH_SHORT).show();
                currentQuestionIndex++;

                if (currentQuestionIndex == questions.size()) {
                    binding.option1D.setVisibility(View.INVISIBLE);
                    binding.option2D.setVisibility(View.INVISIBLE);
                    binding.option3D.setVisibility(View.INVISIBLE);
                    binding.option4D.setVisibility(View.INVISIBLE);
                    binding.option5D.setVisibility(View.INVISIBLE);
                    binding.option6D.setVisibility(View.INVISIBLE);
                    lastQuestion();
                    break;
                }

                setNextQuestion();
//                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();

//                        if (currentQuestionIndex == questions.size()) {
//                            Intent intent = new Intent(BasicQuestions.this, HomePage.class);
//                            startActivity(intent);
//                            finishAffinity();
//                        }
//                    }
//                });


                break;

        }
    }

    void lastQuestion() {
        Intent intent = new Intent(DisordersQuestionsAnxiety.this, ResultPageDisorders.class);
        intent.putExtra("yes", yes);

        startActivity(intent);

        finish();
    }


    void setNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            question = questions.get(currentQuestionIndex);
            binding.questionD.setText(question.getQuestion());
            binding.option1D.setText(question.getOption1());
            binding.option2D.setText(question.getOption2());
            binding.option3D.setText(question.getOption3());
            binding.option4D.setText(question.getOption4());
            binding.option5D.setText(question.getOption5());
            binding.option6D.setText(question.getOption6());
            right = question.getRight();
            wrong = question.getWrong();


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
                binding.option1D.setVisibility(View.VISIBLE);
            }
            if (binding.option5D.getText().toString().equals("")) {
                binding.option5D.setVisibility(View.INVISIBLE);
            } else {
                binding.option1D.setVisibility(View.VISIBLE);
            }
            if (binding.option6D.getText().toString().equals("")) {
                binding.option6D.setVisibility(View.INVISIBLE);
            } else {
                binding.option1D.setVisibility(View.VISIBLE);
            }
        }
    }

}
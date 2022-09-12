package com.sahilhans0605.bygbrains.modelClass;

public class Questions {
    String Question;
    String option1;
    String option2;
    String option3;
    String option4;
    String option5;
    String interaction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    public Questions() {
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String ans) {
        this.interaction = ans;
    }

    public Questions(String question, String option1, String option2, String option3, String option4, String option5, String interaction, String id) {
        Question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.interaction = interaction;
        this.id = id;
    }
}

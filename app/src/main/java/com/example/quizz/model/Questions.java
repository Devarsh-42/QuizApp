package com.example.quizz.model;

public class Questions {
    private int answerID;
    private boolean answerTrue;

    public Questions(int answerID, boolean answerTrue) {
        this.answerID = answerID;
        this.answerTrue = answerTrue;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public boolean getAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue)  {
      this.answerTrue = answerTrue;
       }
}

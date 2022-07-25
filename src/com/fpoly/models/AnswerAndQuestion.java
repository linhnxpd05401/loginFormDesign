/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.models;

/**
 *
 * @author bimzc
 */
public class AnswerAndQuestion {
        int QuestionID,TestID,Point;
        String Request,QuestionContent,Answer1,Answer2,Answer3,Answer4,RightAnswer;

    public AnswerAndQuestion() {
    }

    public AnswerAndQuestion(int QuestionID, int TestID, int Point, String Request, String QuestionContent, String Answer1, String Answer2, String Answer3, String Answer4, String RightAnswer) {
        this.QuestionID = QuestionID;
        this.TestID = TestID;
        this.Point = Point;
        this.Request = Request;
        this.QuestionContent = QuestionContent;
        this.Answer1 = Answer1;
        this.Answer2 = Answer2;
        this.Answer3 = Answer3;
        this.Answer4 = Answer4;
        this.RightAnswer = RightAnswer;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public int getTestID() {
        return TestID;
    }

    public void setTestID(int TestID) {
        this.TestID = TestID;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int Point) {
        this.Point = Point;
    }

    public String getRequest() {
        return Request;
    }

    public void setRequest(String Request) {
        this.Request = Request;
    }

    public String getQuestionContent() {
        return QuestionContent;
    }

    public void setQuestionContent(String QuestionContent) {
        this.QuestionContent = QuestionContent;
    }

    public String getAnswer1() {
        return Answer1;
    }

    public void setAnswer1(String Answer1) {
        this.Answer1 = Answer1;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public void setAnswer2(String Answer2) {
        this.Answer2 = Answer2;
    }

    public String getAnswer3() {
        return Answer3;
    }

    public void setAnswer3(String Answer3) {
        this.Answer3 = Answer3;
    }

    public String getAnswer4() {
        return Answer4;
    }

    public void setAnswer4(String Answer4) {
        this.Answer4 = Answer4;
    }

    public String getRightAnswer() {
        return RightAnswer;
    }

    public void setRightAnswer(String RightAnswer) {
        this.RightAnswer = RightAnswer;
    }
    
}

package com.example.assignment.service;

import com.example.assignment.entity.Answer;


public interface VerificationService {
    public String getVerificationQuestion();
    public String verifyAnswer(Answer answer);
}

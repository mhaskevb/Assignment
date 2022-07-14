package com.example.assignment.service;

import com.example.assignment.entity.Answer;
import com.example.assignment.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class VerificationServiceImpl implements VerificationService{
    @Autowired
    Question question;
    @Override
    public String getVerificationQuestion(){
        return generateQuestion();
    }

    private String generateQuestion(){
        Random random = new Random();
        question.setNo1(random.nextInt(100));
        question.setNo2(random.nextInt(100));
        question.setNo3(random.nextInt(100));
        question.setQuestionString("\"Please sum the numbers "+ question.getNo1()+" , "+ question.getNo2()+" , "+question.getNo3() +"\"");

        return question.getQuestionString();
    }

    @Override
    public String verifyAnswer(Answer answer) {
        if(Optional.ofNullable(answer).isPresent()
                && Optional.ofNullable(answer.getQuestion()).isPresent()
                && answer.getQuestion().equals(question.getQuestionString())){
            if(answer.getSum()== (question.getNo1()+ question.getNo2()+ question.getNo3()))
                return "That’s great";
        }
        throw new RuntimeException("That’s wrong. Please try again.");
    }
}

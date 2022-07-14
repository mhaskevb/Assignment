package com.example.assignment;

import com.example.assignment.entity.Answer;
import com.example.assignment.entity.Question;
import com.example.assignment.service.VerificationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VerificationServiceTest {
    @InjectMocks
    VerificationServiceImpl verificationService;

    @Mock
    Question question;

    @BeforeTestMethod
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getVerificationQuestion(){
        Mockito.when(question.getQuestionString()).thenReturn("\"Please sum the numbers 19 , 54 , 42\"");
        String str = verificationService.getVerificationQuestion();
        Assert.assertNotNull(str);
    }

    @Test
    public void verifyAnswer() {
        Answer answer = new Answer("\"Please sum the numbers 19 , 54 , 42\"", 115);
        Mockito.when(question.getQuestionString()).thenReturn("\"Please sum the numbers 19 , 54 , 42\"");
        Mockito.when(question.getNo1()).thenReturn(19);
        Mockito.when(question.getNo2()).thenReturn(54);
        Mockito.when(question.getNo3()).thenReturn(42);

        String result = verificationService.verifyAnswer(answer);
        Assert.assertNotNull(result);
        Assert.assertEquals(result, "That’s great");
    }
}

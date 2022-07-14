package com.example.assignment.controller;

import com.example.assignment.entity.Answer;
import com.example.assignment.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    @Autowired
    VerificationService verificationService;

    @GetMapping
    public ResponseEntity<String> getVerificationQuestion(){
        return new ResponseEntity<>(verificationService.getVerificationQuestion(), HttpStatus.OK);
    }

    @PostMapping("/answer")
    public ResponseEntity<String> verifyAnswer(@RequestBody Answer answer){
        String response = null;
        try {
            response = verificationService.verifyAnswer(answer);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

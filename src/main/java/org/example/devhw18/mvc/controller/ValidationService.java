package org.example.devhw18.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidationService {
    String titleValidation = "(^@)[A-Z][a-z]+";

    public boolean titelValidation(String titel) {
        if (titel.matches(titleValidation)) {
            return true;
        } else {
            return false;
        }
    }
}

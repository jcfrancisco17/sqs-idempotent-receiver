package com.jc.labs.sqsidempotentreceiver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Kontroller {
    
    @GetMapping("/{blah}")
    @ResponseStatus
    public String blahEndpoint(@PathVariable("blah") String pVar) {
    
        return pVar;
    }

}

package com.sebas.unifierresttemplate.controller.UnifierController;

import com.sebas.unifierresttemplate.dto.UnifierLoginDTO;
import com.sebas.unifierresttemplate.service.UnifierService.UnifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnifierLoginController {

    @Autowired
    private UnifierService unifierService;

    @GetMapping("/login")
    public ResponseEntity<UnifierLoginDTO> login() {
        return ResponseEntity.ok(unifierService.login());
    }
}

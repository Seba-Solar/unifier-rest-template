package com.sebas.unifierresttemplate.dto;

import lombok.Data;

@Data
public class UnifierLoginDTO {

    private String token;
    private String expiryTime;
}

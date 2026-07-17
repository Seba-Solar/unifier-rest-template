package com.sebas.unifierresttemplate.service.UnifierService;

import com.sebas.unifierresttemplate.dto.UnifierLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UnifierService {

    @Value("${unifier.base.url}")
    private String baseUrl;
    @Value("${unifier.login.url}")
    private String loginUrl;
    @Value("${unifier.user}")
    private String user;
    @Value("${unifier.pass}")
    private String password;
    @Value("${unifier.reportname.factura.upper}")
    private String reportUpper;

    @Autowired
    private RestTemplate restTemplate;

    public UnifierLoginDTO login() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(user, password);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<UnifierLoginDTO> response = restTemplate.exchange(
                baseUrl + loginUrl,
                HttpMethod.GET,
                request,
                UnifierLoginDTO.class
        );

        return response.getBody();
    }

}

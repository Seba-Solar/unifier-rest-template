package com.sebas.unifierresttemplate.service.UnifierService;

import com.sebas.unifierresttemplate.dto.PreFacturaRequest;
import com.sebas.unifierresttemplate.dto.UnifierLoginDTO;
import com.sebas.unifierresttemplate.dto.UnifierReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UnifierService {

    @Value("${unifier.base.url}")
    private String baseUrl;
    @Value("${unifier.login.url}")
    private String loginUrl;
    @Value("${unifier.udr.url}")
    private String udrUrl;
    @Value("${unifier.user}")
    private String user;
    @Value("${unifier.pass}")
    private String password;
    @Value("${unifier.reportname.factura.upper}")
    private String reportUpper;

    @Autowired
    private RestTemplate restTemplate;

    private String sessionToken;

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

        UnifierLoginDTO loginDTO = response.getBody();
        if (loginDTO != null) {
            this.sessionToken = loginDTO.getToken();
        }
        return loginDTO;
    }

    public PreFacturaRequest getInvoiceUpper() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(sessionToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        UnifierReportRequest reportRequest = new UnifierReportRequest();
        reportRequest.setReportname(reportUpper);

        HttpEntity<UnifierReportRequest> request = new HttpEntity<>(reportRequest, headers);

        ResponseEntity<PreFacturaRequest> response = restTemplate.exchange(
                baseUrl + udrUrl,
                HttpMethod.POST,
                request,
                PreFacturaRequest.class
        );

        return response.getBody();
    }

}

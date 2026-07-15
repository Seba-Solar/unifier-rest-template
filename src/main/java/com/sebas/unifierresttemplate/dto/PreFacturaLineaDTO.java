package com.sebas.unifierresttemplate.dto;

import lombok.Data;

@Data
public class PreFacturaLineaDTO {

    private String cont_monto_curr;
    private String fact_taxclasscode_tb60;
    private String cont_montotot_curr;
    private String pfr_cantidad_dec;
    private String art_idart_tb50;

}

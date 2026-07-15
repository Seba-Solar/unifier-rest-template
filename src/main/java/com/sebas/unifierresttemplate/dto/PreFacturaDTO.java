package com.sebas.unifierresttemplate.dto;

import lombok.Data;

import java.util.List;

@Data
public class PreFacturaDTO {

    private String record_no;
    private String shell_number;
    private String id_unifier;
    private String uuu_lse_pay_due_date;
    private String bp_name;
    private String fact_fpago_spd;
    private String fact_mpago_spd;
    private String fact_tipoexportacion_spd;
    private List<PreFacturaLineaDTO> lines;
}

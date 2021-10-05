package com.mercadolibre.cardpaymentjavasample.form;

import javax.validation.constraints.NotNull;

public class PayerForm {
    @NotNull
    private String email;

    @NotNull
    private PayerIdentificationForm identification;

    public PayerForm() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PayerIdentificationForm getIdentification() {
        return identification;
    }

    public void setIdentification(PayerIdentificationForm identification) {
        this.identification = identification;
    }
}

package com.mercadopago.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class CardPaymentDTO {
    @NotNull
    private String token;

    private String issuerId;

    @NotNull
    private String paymentMethodId;

    @NotNull
    private BigDecimal transactionAmount;

    @NotNull
    private Integer installments;

    @NotNull
    @JsonProperty("description")
    private String productDescription;

    @NotNull
    private PayerDTO payer;

    public CardPaymentDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public PayerDTO getPayer() {
        return payer;
    }

    public void setPayer(PayerDTO payer) {
        this.payer = payer;
    }
}

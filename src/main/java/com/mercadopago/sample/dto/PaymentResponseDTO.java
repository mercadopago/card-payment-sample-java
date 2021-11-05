package com.mercadopago.sample.dto;

public class PaymentResponseDTO {
    private String id;
    private String status;
    private String detail;

    public PaymentResponseDTO(String id, String status, String detail) {
        this.id = id;
        this.status = status;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

package com.mercadopago.sample.service;

import com.mercadopago.sample.dto.PaymentResponseDTO;
import com.mercadopago.sample.exception.MercadoPagoException;
import com.mercadopago.sample.dto.CardPaymentDTO;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Identification;
import com.mercadopago.resources.datastructures.payment.Payer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentService {
    @Value("${mercado_pago_sample_access_token}")
    private String mercadoPagoAccessToken;

    public PaymentResponseDTO processPayment(CardPaymentDTO cardPaymentDTO) {
        try {
            MercadoPago.SDK.setAccessToken(mercadoPagoAccessToken);

            Payment payment = new Payment();
            payment.setTransactionAmount(cardPaymentDTO.getTransactionAmount())
                    .setToken(cardPaymentDTO.getToken())
                    .setDescription(cardPaymentDTO.getProductDescription())
                    .setInstallments(cardPaymentDTO.getInstallments())
                    .setPaymentMethodId(cardPaymentDTO.getPaymentMethodId());

            Identification identification = new Identification();
            identification.setType(cardPaymentDTO.getPayer().getIdentification().getType())
                    .setNumber(cardPaymentDTO.getPayer().getIdentification().getNumber());

            Payer payer = new Payer();
            payer.setEmail(cardPaymentDTO.getPayer().getEmail());
            payer.setIdentification(identification);

            payment.setPayer(payer);

            Payment createdPayment = payment.save();

            this.validatePaymentResult(createdPayment);

            PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO(
                    createdPayment.getId(),
                    String.valueOf(createdPayment.getStatus()),
                    createdPayment.getStatusDetail()
            );

            return paymentResponseDTO;
        } catch (MPException exception) {
            System.out.println(exception.getMessage());
            throw new MercadoPagoException(exception.getMessage());
        }
    }

    private void validatePaymentResult(Payment createdPayment) throws MPException {
        if(createdPayment.getId() == null) {
            String errorMessage = "Unknown error cause";

            if(createdPayment.getLastApiResponse() != null) {
                String sdkErrorMessage = createdPayment.getLastApiResponse().getJsonElementResponse().getAsJsonObject().get("message").getAsString();
                errorMessage = sdkErrorMessage != null ? sdkErrorMessage : errorMessage;
            }

            throw new MPException(errorMessage);
        }
    }
}

package com.mercadolibre.cardpaymentjavasample.service;

import com.mercadolibre.cardpaymentjavasample.dto.PaymentResponseDTO;
import com.mercadolibre.cardpaymentjavasample.exception.MercadoPagoException;
import com.mercadolibre.cardpaymentjavasample.form.CardPaymentForm;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Identification;
import com.mercadopago.resources.datastructures.payment.Payer;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentService {
    private String mercadoPagoAccessToken = System.getProperty("access_token");

    public PaymentResponseDTO processPayment(CardPaymentForm cardPaymentForm) {
        try {
            MercadoPago.SDK.setAccessToken(mercadoPagoAccessToken);

            Payment payment = new Payment();
            payment.setTransactionAmount(cardPaymentForm.getTransactionAmount())
                    .setToken(cardPaymentForm.getToken())
                    .setDescription(cardPaymentForm.getProductDescription())
                    .setInstallments(cardPaymentForm.getInstallments())
                    .setPaymentMethodId(cardPaymentForm.getPaymentMethodId());

            Identification identification = new Identification();
            identification.setType(cardPaymentForm.getPayer().getIdentification().getType())
                    .setNumber(cardPaymentForm.getPayer().getIdentification().getNumber());

            Payer payer = new Payer();
            payer.setEmail(cardPaymentForm.getPayer().getEmail());
            payer.setIdentification(identification);

            payment.setPayer(payer);

            Payment createdPayment = payment.save();

            PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO(
                    createdPayment.getId(),
                    String.valueOf(createdPayment.getStatus()),
                    createdPayment.getStatusDetail()
            );

            return paymentResponseDTO;
        } catch (MPException exception) {
            throw new MercadoPagoException(exception.getMessage());
        }
    }
}

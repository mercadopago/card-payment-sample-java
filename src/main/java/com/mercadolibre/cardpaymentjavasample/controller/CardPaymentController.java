package com.mercadolibre.cardpaymentjavasample.controller;

import com.mercadolibre.cardpaymentjavasample.dto.PaymentResponseDTO;
import com.mercadolibre.cardpaymentjavasample.form.CardPaymentForm;
import com.mercadolibre.cardpaymentjavasample.service.CardPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/process_payment")
public class CardPaymentController {
    private CardPaymentService cardPaymentService;

    @Autowired
    public CardPaymentController(CardPaymentService cardPaymentService) {
        this.cardPaymentService = cardPaymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> processPayment(@RequestBody @Valid CardPaymentForm cardPaymentForm) {
        PaymentResponseDTO payment = cardPaymentService.processPayment(cardPaymentForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}

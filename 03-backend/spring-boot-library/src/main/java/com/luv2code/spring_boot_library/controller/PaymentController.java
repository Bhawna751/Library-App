package com.luv2code.spring_boot_library.controller;

import com.luv2code.spring_boot_library.requestmodels.PaymentInfoRequest;
import com.luv2code.spring_boot_library.service.PaymentService;
import com.luv2code.spring_boot_library.utils.ExtractJWT;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:3000")
@RestController
@RequestMapping("/api/payment/secure")
public class PaymentController {
    private PaymentService paymentService;
    @Autowired
    private PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoRequest paymentInfoRequest)
            throws StripeException {
        PaymentIntent paymentIntent = paymentService.createPaymentIntent(paymentInfoRequest);
        String paymentStr = paymentIntent.toJson();

        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }
    @PutMapping("/payment-complete")
    public ResponseEntity<String> stripePaymentComplete(@RequestHeader(value="Authorization") String token)
        throws Exception{
        String userEmail = ExtractJWT.payloadJwtExtraction(token,"\"sub\"");
        if(userEmail == null){
            throw new Exception("User Email is missing");
        }
        return paymentService.stringPayment(userEmail);
    }
}

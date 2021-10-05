package com.mercadolibre.cardpaymentjavasample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {
    @GetMapping
    public String renderMainPage(Model model) {
        model.addAttribute("publicKey", System.getProperty("public_key"));
        return "index";
    }
}

package com.groupeisi.controller;

import com.groupeisi.dto.DeclarantRequete;
import com.groupeisi.entities.Declarant;
import com.groupeisi.service.DeclarantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/declarant")

public class DeclarantController {
    private final DeclarantService service;

    public DeclarantController(DeclarantService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<?> enregistrer(@RequestBody @Valid DeclarantRequete requete, Errors errors) {
        log.info(requete.toString());
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldErrors());

        }
        return ResponseEntity.ok(
        service.save(requete));
    }
 /*   @PostMapping({"/creer", "/creer"})
    public String validerDeclarant(@Valid DeclarantRequete requete, Errors errors, Model model) {
        log.info(requete.toString());
        if (errors.hasErrors()) {
            model.addAttribute("declarantRequete", requete);
            return "declarant_creer";
        }
        service.save(requete);
        return "redirect:/declarant";
    }*/

        @GetMapping
        public ResponseEntity<List<Declarant>> lister (Model model){
            return ResponseEntity.ok(service.lister());
        }
    }

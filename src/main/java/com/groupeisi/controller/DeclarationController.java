package com.groupeisi.controller;

import com.groupeisi.dto.DeclarantRequete;
import com.groupeisi.dto.DeclarationReponse;
import com.groupeisi.dto.DeclarationRequete;
import com.groupeisi.entities.Declarant;
import com.groupeisi.service.DeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.groupeisi.entities.Declaration;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/declaration")
public class DeclarationController {
    private final DeclarationService service;

    public DeclarationController(DeclarationService declarationService) {
        this.service = declarationService;
    }

    @GetMapping
    public ResponseEntity<List<DeclarationReponse>> lister (){
        return ResponseEntity.ok(service.lister());
    }
    @GetMapping("/declarant/{id}")
    public ResponseEntity<List<DeclarationReponse>> listerByDeclarant (@PathVariable Long id){
        return ResponseEntity.ok(service.listerDeclarationsDeclarant(id));
    }
    @PostMapping
    public ResponseEntity<?> enregistrerDeclaration(@RequestBody @Valid DeclarationRequete requete, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldErrors());

        }
        return ResponseEntity.ok(
                service.save(requete));
    }
}



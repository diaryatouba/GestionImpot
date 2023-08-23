package com.groupeisi.controller;

import com.groupeisi.dto.PaiementReponse;
import com.groupeisi.dto.PaiementRequete;
import com.groupeisi.service.PaiementService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementController {
    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }



    @GetMapping
    public ResponseEntity<List<PaiementReponse>> lister (){
        return ResponseEntity.ok(paiementService.lister());
    }
    @GetMapping("/declaration/{id}")
    public ResponseEntity<List<String>> listerByDeclaration (@PathVariable Long id){
        return ResponseEntity.ok(paiementService.listerPaiementsDeclaration(id));
    }
    @PostMapping
    public ResponseEntity<?> validerPaiement(@RequestBody @Valid PaiementRequete requete, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldErrors());

        }
        return ResponseEntity.ok(
                paiementService.save(requete));
    }
}



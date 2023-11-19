package com.ProjetoIntegrador.DesenJobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ProjetoIntegrador.DesenJobs.Entity.Sugestoes;
import com.ProjetoIntegrador.DesenJobs.Service.SugestoesService;

@RestController
@RequestMapping("api/DJ/sugestoes")
public class SugestoesController {

    private final SugestoesService sugestoesService;

    @Autowired
    public SugestoesController(SugestoesService sugestoesService) {
        this.sugestoesService = sugestoesService;
    }

    @PostMapping
    public ResponseEntity<Sugestoes> create(@RequestBody Sugestoes sugestao) {
        Sugestoes novaSugestao = sugestoesService.salvar(sugestao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaSugestao);
    }
}

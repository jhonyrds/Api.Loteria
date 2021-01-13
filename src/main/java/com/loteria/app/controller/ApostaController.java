package com.loteria.app.controller;

import com.loteria.app.request.ApostaRequest;
import com.loteria.app.response.BaseResponse;
import com.loteria.app.response.ListApostaResponse;
import com.loteria.app.service.ApostaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apostas")
public class ApostaController extends BaseController{

    private final ApostaService apostaService;

    public ApostaController(ApostaService apostaService) {
        this.apostaService = apostaService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody ApostaRequest apostaRequest) {
        try {


            BaseResponse response = apostaService.salvar(apostaRequest);
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(errorBase.getStatusCode()).body(errorBase);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity listarApostas(@PathVariable Long id) {
        try {
            ListApostaResponse response = apostaService.listarApostas(id);
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro genérico");
        }
    }
}

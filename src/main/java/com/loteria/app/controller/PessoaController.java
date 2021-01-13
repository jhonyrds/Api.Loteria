package com.loteria.app.controller;

import com.loteria.app.model.Pessoa;
import com.loteria.app.request.PessoaRequest;
import com.loteria.app.response.BaseResponse;
import com.loteria.app.response.PessoaResponse;
import com.loteria.app.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController extends BaseController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody PessoaRequest pessoaRequest) {
        try {
            BaseResponse response = pessoaService.salvar(pessoaRequest);
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(errorBase.getStatusCode()).body(errorBase);
        }
    }
}

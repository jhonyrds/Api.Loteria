package com.loteria.app.service;

import com.loteria.app.model.Aposta;
import com.loteria.app.model.Pessoa;
import com.loteria.app.repository.ApostaRepository;
import com.loteria.app.repository.PessoaRepository;
import com.loteria.app.request.ApostaRequest;
import com.loteria.app.response.BaseResponse;
import com.loteria.app.response.ListApostaResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ApostaService {

    final ApostaRepository apostaRepository;

    public ApostaService(ApostaRepository apostaRepository, PessoaRepository pessoaRepository) {
        this.apostaRepository = apostaRepository;

    }


    public BaseResponse salvar(ApostaRequest apostaRequest) {
        Aposta aposta = new Aposta();
        Pessoa pessoa = new Pessoa(apostaRequest.getPessoaId());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(400);

        Random numSort = new Random();
        String valor = "";

        for (int i=0; i<12; i++){
            valor += Integer.toString(numSort.nextInt(10));
        }

        aposta.setPessoa(pessoa);
        aposta.setNumero(valor);
        apostaRepository.save(aposta);

        baseResponse.setStatusCode(201);
        baseResponse.setMessage("Aposta Realizada com sucesso!!");
        return baseResponse;
    }


    public ListApostaResponse listarApostas(Long id) {

        ListApostaResponse response = new ListApostaResponse();
        List<Aposta> lista = apostaRepository.findByPessoaId(id);

        response.setApostas(lista);
        response.setStatusCode(200);
        response.setMessage("Apostas obtidas com sucesso.");

        return response;
    }
}

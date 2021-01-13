package com.loteria.app.service;

import com.loteria.app.model.Pessoa;
import com.loteria.app.repository.PessoaRepository;
import com.loteria.app.request.PessoaRequest;
import com.loteria.app.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public BaseResponse salvar(PessoaRequest pessoaRequest) {
        Pessoa pessoa = new Pessoa();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(400);
        boolean emailDuplicado = pessoaRepository.existsByEmail(pessoaRequest.getEmail());

        if (pessoaRequest.getEmail().isEmpty()) {

            baseResponse.setMessage("Favor preencher com o e-mail!");
            return baseResponse;
        }
        if (emailDuplicado){
            baseResponse.setMessage("Este e-mail já está cadastrado!");
            return baseResponse;
        }

        pessoa.setEmail(pessoaRequest.getEmail());

        pessoaRepository.save(pessoa);

        baseResponse.setStatusCode(201);
        baseResponse.setMessage("Email cadastrado!!");
        return baseResponse;
    }

}

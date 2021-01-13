package com.loteria.app.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApostaResponse extends BaseResponse {
    private long id;
    private String numero;
    private long pessoaId;
}
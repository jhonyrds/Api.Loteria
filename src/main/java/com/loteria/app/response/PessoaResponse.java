package com.loteria.app.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaResponse extends BaseResponse{
    private String email;
    private long id;
}

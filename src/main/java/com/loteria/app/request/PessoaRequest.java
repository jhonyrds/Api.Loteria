package com.loteria.app.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PessoaRequest {

    @Email
    @NotNull
    private String email;
}

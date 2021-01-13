package com.loteria.app.response;

import com.loteria.app.model.Aposta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListApostaResponse extends BaseResponse{

    private List<Aposta> apostas;
}

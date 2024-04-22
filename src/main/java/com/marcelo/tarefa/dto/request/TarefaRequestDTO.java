package com.marcelo.tarefa.dto.request;

import lombok.Getter;

@Getter
public class TarefaRequestDTO {

    private String name;

    private String descricao;

    private String status;
    
    private String observacao;
    
    private String data_criacao;
    
    private String data_atualizacao;

}

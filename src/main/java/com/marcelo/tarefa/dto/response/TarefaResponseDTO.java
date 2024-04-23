package com.marcelo.tarefa.dto.response;


import com.marcelo.tarefa.entity.Tarefa;

import lombok.Getter;

@Getter
public class TarefaResponseDTO {

    private Long id;

    private String name;

    private String descricao;

    private String status;
    
    private String observacoes;

    private String data_criacao;

    private String data_atualizacao;

    public TarefaResponseDTO(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.name = tarefa.getNome();
        this.descricao = tarefa.getDescricao();
        this.status = tarefa.getStatus();
        this.observacoes = tarefa.getObservacoes();
        this.data_criacao = tarefa.getData_criacao();
        this.data_atualizacao = tarefa.getData_atualizacao();
    }


}

package com.marcelo.tarefa.util;

import org.springframework.stereotype.Component;

import com.marcelo.tarefa.dto.request.TarefaRequestDTO;
import com.marcelo.tarefa.dto.response.TarefaResponseDTO;
import com.marcelo.tarefa.entity.Tarefa;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TarefaMapper {

    public Tarefa toTarefa(TarefaRequestDTO tarefaDTO) {

        return Tarefa.builder()
                .nome(tarefaDTO.getNome())
                .descricao(tarefaDTO.getDescricao())
                .status(tarefaDTO.getStatus())
                .observacoes(tarefaDTO.getObservacoes())
                .data_criacao(tarefaDTO.getData_criacao())
                .data_atualizacao(tarefaDTO.getData_atualizacao())
                .build();

    }

    public TarefaResponseDTO toTarefaDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(tarefa);
    }

    public List<TarefaResponseDTO> toPeopleDTO(List<Tarefa> peopleList) {
        return peopleList.stream().map(TarefaResponseDTO::new).collect(Collectors.toList());
    }

    public void updateTarefaData(Tarefa tarefa, TarefaRequestDTO tarefaDTO) {

        tarefa.setNome(tarefaDTO.getNome());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setStatus(tarefaDTO.getStatus());
        tarefa.setObservacoes(tarefaDTO.getObservacoes());
        tarefa.setData_criacao(tarefaDTO.getData_criacao());
        tarefa.setData_atualizacao(tarefaDTO.getData_atualizacao());

    }


}

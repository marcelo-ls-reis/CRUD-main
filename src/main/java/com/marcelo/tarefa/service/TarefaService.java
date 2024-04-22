package com.marcelo.tarefa.service;


import java.util.List;

import com.marcelo.tarefa.dto.request.TarefaRequestDTO;
import com.marcelo.tarefa.dto.response.TarefaResponseDTO;

public interface TarefaService {

    TarefaResponseDTO findById(Long id);

    List<TarefaResponseDTO> findAll();

    TarefaResponseDTO register(TarefaRequestDTO personDTO);

    TarefaResponseDTO update(Long id, TarefaRequestDTO personDTO);

    String delete(Long id);

}

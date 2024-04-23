package com.marcelo.tarefa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.marcelo.tarefa.dto.request.TarefaRequestDTO;
import com.marcelo.tarefa.dto.response.TarefaResponseDTO;
import com.marcelo.tarefa.entity.Tarefa;
import com.marcelo.tarefa.repository.TarefaRepository;
import com.marcelo.tarefa.util.TarefaMapper;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;

    private final TarefaMapper tarefaMapper;


    @Override
    public TarefaResponseDTO findById(Long id) {
     return tarefaMapper.toTarefaDTO(returnTarefa(id));
    }

    @Override
    public List<TarefaResponseDTO> findAll() {
        return tarefaMapper.toPeopleDTO(tarefaRepository.findAll());
    }

    @Override
    public TarefaResponseDTO register(TarefaRequestDTO tarefaDTO) {

        Tarefa tarefa = tarefaMapper.toTarefa(tarefaDTO);

        return tarefaMapper.toTarefaDTO(tarefaRepository.save(tarefa));
    }

    @Override
    public TarefaResponseDTO update(Long id, TarefaRequestDTO tarefaDTO) {

        Tarefa tarefa = returnTarefa(id);

        tarefaMapper.updateTarefaData(tarefa,tarefaDTO);

        return tarefaMapper.toTarefaDTO(tarefaRepository.save(tarefa));
    }

    @Override
    public String delete(Long id) {
        tarefaRepository.deleteById(id);
        return "Tarefa id: "+id+" deleted";
    }

    private Tarefa returnTarefa(Long id) {
       return tarefaRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Tarefa não existe no database"));
    }

}

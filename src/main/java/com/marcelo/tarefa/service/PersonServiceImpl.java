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
public class PersonServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;

    private final TarefaMapper tarefaMapper;


    @Override
    public TarefaResponseDTO findById(Long id) {
     return tarefaMapper.toPersonDTO(returnPerson(id));
    }

    @Override
    public List<TarefaResponseDTO> findAll() {
        return tarefaMapper.toPeopleDTO(tarefaRepository.findAll());
    }

    @Override
    public TarefaResponseDTO register(TarefaRequestDTO personDTO) {

        Tarefa tarefa = tarefaMapper.toPerson(personDTO);

        return tarefaMapper.toPersonDTO(tarefaRepository.save(tarefa));
    }

    @Override
    public TarefaResponseDTO update(Long id, TarefaRequestDTO personDTO) {

        Tarefa tarefa = returnPerson(id);

        tarefaMapper.updatePersonData(tarefa,personDTO);

        return tarefaMapper.toPersonDTO(tarefaRepository.save(tarefa));
    }

    @Override
    public String delete(Long id) {
        tarefaRepository.deleteById(id);
        return "Tarefa id: "+id+" deleted";
    }

    private Tarefa returnPerson(Long id) {
       return tarefaRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Tarefa não existe no database"));
    }

}

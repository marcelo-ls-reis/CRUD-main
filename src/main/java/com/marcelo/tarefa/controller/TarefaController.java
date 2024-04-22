package com.marcelo.tarefa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.marcelo.tarefa.dto.request.TarefaRequestDTO;
import com.marcelo.tarefa.dto.response.TarefaResponseDTO;
import com.marcelo.tarefa.service.TarefaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/people")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TarefaResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(tarefaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> findAll() {
        return ResponseEntity.ok().body(tarefaService.findAll());
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> register(@RequestBody TarefaRequestDTO tarefaRequestDTO, UriComponentsBuilder uriBuilder) {

        TarefaResponseDTO tarefaResponseDTO = tarefaService.register(tarefaRequestDTO);

        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(tarefaResponseDTO.getId()).toUri();

      return ResponseEntity.created(uri).body(tarefaResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TarefaResponseDTO> update(@RequestBody TarefaRequestDTO personDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(tarefaService.update(id,personDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(tarefaService.delete(id));
    }

}

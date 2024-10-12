package br.com.fiap.faculdadeapi.controller;

import br.com.fiap.faculdadeapi.dto.DiplomaRequest;
import br.com.fiap.faculdadeapi.dto.DiplomaResponse;
import br.com.fiap.faculdadeapi.dto.TextoDTO;
import br.com.fiap.faculdadeapi.model.Curso;
import br.com.fiap.faculdadeapi.model.Diploma;
import br.com.fiap.faculdadeapi.model.Diplomado;
import br.com.fiap.faculdadeapi.repository.DiplomaRepository;
import br.com.fiap.faculdadeapi.repository.DiplomadoRepository;
import br.com.fiap.faculdadeapi.service.DiplomaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
//localhost:8080/diplomas
@RequestMapping(value = "/diplomas")
public class DiplomaController {
    @Autowired
    private DiplomaRepository diplomaRepository;
    @Autowired
    private DiplomaService diplomaService;

    @Autowired
    private DiplomadoRepository diplomadoRepository;

/*
    @PostMapping
    public ResponseEntity<DiplomaResponse> create(@Valid @RequestBody DiplomaRequest diplomaRequest) {
        Diploma diplomaConvertido = diplomaService.requestToDiploma(diplomaRequest);
        Diploma diplomaPersistido = diplomaRepository.save(diplomaConvertido);
        DiplomaResponse diplomaResponse = diplomaService.diplomaToResponse(diplomaPersistido);
        return new ResponseEntity<>(diplomaResponse, HttpStatus.CREATED);
    }
*/


    @PostMapping
    public ResponseEntity<DiplomaResponse> create(@Valid @RequestBody DiplomaRequest diplomaRequest) {
        DiplomaResponse diplomaResponse = diplomaService.createDiploma(diplomaRequest);
        return new ResponseEntity<>(diplomaResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DiplomaResponse>> read() {
        List<Diploma> listaDiplomas = diplomaRepository.findAll();
        if (listaDiplomas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<DiplomaResponse> listaDiplomasResponse = new ArrayList<>();
        for (Diploma diploma : listaDiplomas) {
            DiplomaResponse diplomaResponse = diplomaService.diplomaToResponse(diploma);
            listaDiplomasResponse.add(diplomaResponse);
        }
        return new ResponseEntity<>(listaDiplomasResponse, HttpStatus.OK);
    }
/*
    @GetMapping("/{id}")
    public ResponseEntity<DiplomaResponse> read(@PathVariable UUID id) {
        Optional<Diploma> diploma = diplomaRepository.findById(id);
        if (diploma.isPresent()) {
            DiplomaResponse diplomaResponse = diplomaService.diplomaToResponse(diploma.get());
            return new ResponseEntity<>(diplomaResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
*/
    @PutMapping("/{id}")
    public ResponseEntity<DiplomaResponse> update(@PathVariable UUID id, @Valid @RequestBody DiplomaRequest diplomaRequest) {
        Optional<Diploma> diplomaPersistido = diplomaRepository.findById(id);
        if (diplomaPersistido.isPresent()) {
            Diploma diploma = diplomaService.requestToDiploma(diplomaRequest);
            diploma.setId(id);
            Diploma diplomaAtualizado = diplomaRepository.save(diploma);
            DiplomaResponse diplomaResponse = diplomaService.diplomaToResponse(diplomaAtualizado);
            return new ResponseEntity<>(diplomaResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        Optional<Diploma> diploma = diplomaRepository.findById(id);
        if (diploma.isPresent()) {
            diplomaRepository.delete(diploma.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getDiploma(@PathVariable UUID id) {
        TextoDTO textoDTO = diplomaService.getTextoDiploma(id);

        String textoDiploma = diplomaService.gerarTextoDiploma(textoDTO);

        return ResponseEntity.ok(textoDiploma);
    }
}


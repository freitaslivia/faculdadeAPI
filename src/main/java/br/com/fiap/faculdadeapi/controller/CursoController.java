package br.com.fiap.faculdadeapi.controller;

import br.com.fiap.faculdadeapi.dto.CursoRequest;
import br.com.fiap.faculdadeapi.dto.CursoResponse;
import br.com.fiap.faculdadeapi.model.Curso;
import br.com.fiap.faculdadeapi.repository.CursoRepository;
import br.com.fiap.faculdadeapi.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
//localhost:8080/cursos
@RequestMapping(value = "/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoResponse> create(@Valid @RequestBody CursoRequest cursoRequest) {
        Curso cursoConvertido = cursoService.requestToCurso(cursoRequest);
        Curso cursoPersistido = cursoRepository.save(cursoConvertido);
        CursoResponse cursoResponse = cursoService.cursoToResponse(cursoPersistido);
        return new ResponseEntity<>(cursoResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CursoResponse>> read() {
        List<Curso> listaCursos = cursoRepository.findAll();
        if (listaCursos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<CursoResponse> listaCursosResponse = new ArrayList<>();
        for (Curso curso : listaCursos) {
            CursoResponse cursoResponse = cursoService.cursoToResponse(curso);
            listaCursosResponse.add(cursoResponse);
        }
        return new ResponseEntity<>(listaCursosResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> read(@PathVariable Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            CursoResponse cursoResponse = cursoService.cursoToResponse(curso.get());
            return new ResponseEntity<>(cursoResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> update(@PathVariable Long id, @Valid @RequestBody CursoRequest cursoRequest) {
        Optional<Curso> cursoPersistido = cursoRepository.findById(id);
        if (cursoPersistido.isPresent()) {
            Curso curso = cursoService.requestToCurso(cursoRequest);
            curso.setId(id);
            Curso cursoAtualizado = cursoRepository.save(curso);
            CursoResponse cursoResponse = cursoService.cursoToResponse(cursoAtualizado);
            return new ResponseEntity<>(cursoResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            cursoRepository.delete(curso.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

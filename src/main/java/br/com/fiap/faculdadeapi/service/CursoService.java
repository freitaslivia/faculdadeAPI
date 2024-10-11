package br.com.fiap.faculdadeapi.service;

import br.com.fiap.faculdadeapi.dto.CursoRequest;
import br.com.fiap.faculdadeapi.dto.CursoResponse;
import br.com.fiap.faculdadeapi.model.Curso;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    public Curso requestToCurso(CursoRequest cursoRequest) {
        Curso curso = new Curso();
        curso.setNome(cursoRequest.getNome());
        curso.setTipo(cursoRequest.getTipo());
        return curso;
    }

    public CursoResponse cursoToResponse(Curso curso) {
        CursoResponse cursoResponse = new CursoResponse();
        cursoResponse.setId(curso.getId());
        cursoResponse.setNome(curso.getNome());
        cursoResponse.setTipo(curso.getTipo());
        return cursoResponse;
    }

    public CursoRequest cursoToRequest(Curso curso) {
        CursoRequest cursoRequest = new CursoRequest();
        cursoRequest.setNome(curso.getNome());
        cursoRequest.setTipo(curso.getTipo());
        return cursoRequest;
    }
}

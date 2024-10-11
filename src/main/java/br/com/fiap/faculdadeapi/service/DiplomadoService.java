package br.com.fiap.faculdadeapi.service;

import br.com.fiap.faculdadeapi.dto.*;
import br.com.fiap.faculdadeapi.model.Curso;
import br.com.fiap.faculdadeapi.model.Diploma;
import br.com.fiap.faculdadeapi.model.Diplomado;
import org.springframework.stereotype.Service;

@Service
public class DiplomadoService {

    public Diplomado requestToDiplomado(DiplomadoRequest diplomadoRequest) {
        Diplomado diplomado = new Diplomado();
        diplomado.setNome(diplomadoRequest.getNome());
        diplomado.setRg(diplomadoRequest.getRg());
        diplomado.setNaturalidade(diplomadoRequest.getNaturalidade());
        diplomado.setNacionalidade(diplomadoRequest.getNacionalidade());
        return diplomado;
    }

    public DiplomadoResponse diplomadoToResponse(Diplomado diplomado) {
        DiplomadoResponse diplomadoResponse = new DiplomadoResponse();
        diplomadoResponse.setId(diplomado.getId());
        diplomadoResponse.setNome(diplomado.getNome());
        diplomadoResponse.setNacionalidade(diplomado.getNacionalidade());
        diplomadoResponse.setNaturalidade(diplomado.getNaturalidade());
        diplomadoResponse.setRg(diplomado.getRg());
        return diplomadoResponse;
    }

    public DiplomadoRequest diplomadoToRequest(Diplomado diplomado) {
        DiplomadoRequest diplomadoRequest = new DiplomadoRequest();
        diplomadoRequest.setNome(diplomado.getNome());
        diplomadoRequest.setNacionalidade(diplomado.getNacionalidade());
        diplomadoRequest.setNaturalidade(diplomado.getNaturalidade());
        diplomadoRequest.setRg(diplomado.getRg());
        return diplomadoRequest;
    }
}

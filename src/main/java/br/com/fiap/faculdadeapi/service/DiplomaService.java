package br.com.fiap.faculdadeapi.service;

import br.com.fiap.faculdadeapi.dto.DiplomaRequest;
import br.com.fiap.faculdadeapi.dto.DiplomaResponse;
import br.com.fiap.faculdadeapi.model.Diploma;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {
    
    public Diploma requestToDiploma(DiplomaRequest diplomaRequest) {
        Diploma diploma = new Diploma();
        diploma.setNome(diplomaRequest.getNome());
        diploma.setSexo(diplomaRequest.getSexo());
        return diploma;
    }

    public DiplomaResponse diplomaToResponse(Diploma diploma) {
        DiplomaResponse diplomaResponse = new DiplomaResponse();
        diplomaResponse.setId(diploma.getId());
        diplomaResponse.setNome(diploma.getNome());
        diplomaResponse.setSexo(diploma.getSexo());
        return diplomaResponse;
    }

    public DiplomaRequest diplomaToRequest(Diploma diploma) {
        DiplomaRequest diplomaRequest = new DiplomaRequest();
        diplomaRequest.setNome(diploma.getNome());
        diplomaRequest.setSexo(diploma.getSexo());
        return diplomaRequest;
    }
}

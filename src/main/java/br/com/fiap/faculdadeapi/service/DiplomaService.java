package br.com.fiap.faculdadeapi.service;

import br.com.fiap.faculdadeapi.dto.DiplomaRequest;
import br.com.fiap.faculdadeapi.dto.DiplomaResponse;
import br.com.fiap.faculdadeapi.dto.TextoDTO;
import br.com.fiap.faculdadeapi.model.Curso;
import br.com.fiap.faculdadeapi.model.Diploma;
import br.com.fiap.faculdadeapi.model.Diplomado;
import br.com.fiap.faculdadeapi.repository.CursoRepository;
import br.com.fiap.faculdadeapi.repository.DiplomaRepository;
import br.com.fiap.faculdadeapi.repository.DiplomadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class DiplomaService {
    @Autowired
    private DiplomaRepository diplomaRepository;

    @Autowired
    private DiplomadoRepository diplomadoRepository;

    @Autowired
    private CursoRepository cursoRepository;
    
    public Diploma requestToDiploma(DiplomaRequest diplomaRequest) {
        Diploma diploma = new Diploma();
        diploma.setNome(diplomaRequest.getNome());
        diploma.setSexo(diplomaRequest.getSexo());
        return diploma;
    }

    public DiplomaResponse createDiploma(DiplomaRequest diplomaRequest) {
        Diploma diploma = new Diploma();


        Diplomado diplomado = diplomadoRepository.findById(diplomaRequest.getDiplomado())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diplomado não encontrado"));
        diploma.setDiplomado(diplomado);


        Curso curso = cursoRepository.findById(diplomaRequest.getCurso())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));
        diploma.setCurso(curso);


        diploma.setSexo(diplomaRequest.getSexo());
        diploma.setNome(diplomaRequest.getNome());
        diploma.setDataConclusao(diplomaRequest.getDataConclusao());


        diploma = diplomaRepository.save(diploma);

        return diplomaToResponse(diploma);
    }

    public DiplomaResponse diplomaToResponse(Diploma diploma) {
        DiplomaResponse diplomaResponse = new DiplomaResponse();
        diplomaResponse.setId(diploma.getId().toString());
        diplomaResponse.setNome(diploma.getNome());
        diplomaResponse.setSexo(diploma.getSexo());
        diplomaResponse.setCurso(diploma.getCurso().getId());
        diplomaResponse.setDiplomado(diploma.getDiplomado().getId());

        return diplomaResponse;
    }
    public DiplomaRequest diplomaToRequest(Diploma diploma) {
        DiplomaRequest diplomaRequest = new DiplomaRequest();
        diplomaRequest.setNome(diploma.getNome());
        diplomaRequest.setSexo(diploma.getSexo());
        diplomaRequest.setCurso(diploma.getCurso().getId());
        diplomaRequest.setDiplomado(diploma.getDiplomado().getId());
        return diplomaRequest;
    }

    public String gerarTextoDiploma(TextoDTO textoDTO) {
        return String.format("%s, %s da Universidade Fake, no uso de suas atribuições, confere a %s, de nacionalidade %s, natural de %s, portador do rg %s, o presente diploma de %s, do curso de %s, por ter concluído seus estudos nesta instituição de ensino no dia %s.",
                textoDTO.getTituloReitor(),
                textoDTO.getCargoReitor(),
                textoDTO.getNomeDiplomado(),
                textoDTO.getNacionalidade(),
                textoDTO.getNaturalidade(),
                textoDTO.getRg(),
                textoDTO.getTipoCurso(),
                textoDTO.getNomeCurso(),
                textoDTO.getDataConclusao()
        );
    }

    public TextoDTO getTextoDiploma(UUID id) {

        Diploma diploma = diplomaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diploma não encontrado"));

        Diplomado diplomado = diploma.getDiplomado();
        Curso curso = diploma.getCurso();

        TextoDTO textoDTO = new TextoDTO();
        textoDTO.setNomeDiplomado(diplomado.getNome().toUpperCase());
        textoDTO.setNacionalidade(diplomado.getNacionalidade().toUpperCase());
        textoDTO.setNaturalidade(diplomado.getNaturalidade().toUpperCase());
        textoDTO.setRg(diplomado.getRg().toUpperCase());
        textoDTO.setTipoCurso(curso.getTipo().toString());
        textoDTO.setNomeCurso(curso.getNome().toUpperCase());
        textoDTO.setDataConclusao(diploma.getDataConclusao().toString().toUpperCase());


        String sexoReitor = diploma.getSexo().toString().toUpperCase();
        String nomeReitor = diploma.getNome().toUpperCase();

        if (sexoReitor.equals("M")) {
            textoDTO.setTituloReitor("O Prof. Dr. " + nomeReitor);
            textoDTO.setCargoReitor("reitor");
        } else {
            textoDTO.setTituloReitor("A Profa. Dra. " + nomeReitor);
            textoDTO.setCargoReitor("reitora");
        }

        return textoDTO;
    }

}

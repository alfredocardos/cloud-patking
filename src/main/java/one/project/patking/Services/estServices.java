package one.project.patking.Services;

import one.project.patking.Model.Estacionamento;
import one.project.patking.Model.dto.estacionamentoDTO;
import one.project.patking.Repository.estacRepository;
import one.project.patking.exception.BadRequesttatusException;
import one.project.patking.mapper.EstacionamenoMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class estServices {

    public estServices(estacRepository estRepository) {
        this.estRepository = estRepository;
    }

    private final estacRepository estRepository;


    public List<Estacionamento> listAll() {
        return estRepository.findAll();
    }

    public List<Estacionamento> listlicensa(String licenca) {
        return estRepository.findByLicenca(licenca);
    }

    public Estacionamento FindBYidOrThrowBadRequestException(Long id) {
        return estRepository.findById(id)
                .orElseThrow(() -> new BadRequesttatusException("Veiculo nao encontrado"));
    }

    @Transactional
    public Estacionamento create(estacionamentoDTO es) {
        return estRepository.save(EstacionamenoMapper.INSTANCE.toestacionamento(es));
    }

    public void delete(Long id) {
        estRepository.delete(FindBYidOrThrowBadRequestException(id));
    }

    //public void replace(estacionamentoPutDTO estacionamentoPutDTO) {
    //    Estacionamento estacionamento = EstacionamenoMapper.INSTANCE.toestacionamentoPUT(estacionamentoPutDTO);
    //    Estacionamento estacionamentoSaved = FindBYidOrThrowBadRequestException(estacionamento.getId());
    //    estacionamento.setId(estacionamentoSaved.getId());
    //    estRepository.save(estacionamento);
    //}
}

package br.espm.canoafurada.cabin;

import br.espm.canoafurada.cabin.interfaces.ICabinService;
import br.espm.canoafurada.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Service
public class CabinService implements ICabinService {

    @Autowired
    private CabinRepository cabinRepository;

    @Override
    public List<CabinDto> getAllCabins() {
        return StreamSupport
                .stream(cabinRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(CabinEntity::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CabinDto saveCabin(CabinEntity cabin) {
        return cabinRepository.save(cabin).toDTO();
    }

    @Override
    public CabinDto getById(UUID id) {
        Optional<CabinEntity> cabin = Optional.ofNullable(cabinRepository.findById(id)).orElseThrow();

        if(cabin == null) throw new RecordNotFoundException(id.toString());

        return cabin.get().toDTO();
    }

    @Override
    public void deleteCabin(UUID id) {
        cabinRepository.deleteById(id);
    }
}

package br.espm.canoafurada.cabin;

import br.espm.canoafurada.cabin.interfaces.ICabinController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CabinController implements ICabinController {

    @Autowired
    private CabinService cabinService;

    @Override
    public List<CabinDto> getAllCabins() {
        return cabinService.getAllCabins();
    }

    @Override
    public CabinDto createCabin(CabinDto cabin) {
        return cabinService.saveCabin(new CabinEntity(cabin));
    }

    @Override
    public CabinDto updateCabin(UUID id, CabinDto cabin) {
        var existingCabin = cabinService.getById(id);
        existingCabin.setPricePerson(cabin.getPricePerson());
        existingCabin.setMaxPeople(cabin.getMaxPeople());

        return cabinService.saveCabin(existingCabin);
    }

    @Override
    public void deleteCabin(UUID id) {
        cabinService.deleteCabin(id);
    }
}

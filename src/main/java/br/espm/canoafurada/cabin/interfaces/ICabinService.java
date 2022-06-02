package br.espm.canoafurada.cabin.interfaces;

import br.espm.canoafurada.cabin.CabinDto;
import br.espm.canoafurada.cabin.CabinEntity;

import java.util.List;
import java.util.UUID;

public interface ICabinService {
    public List<CabinDto> getAllCabins();
    public CabinDto saveCabin(CabinEntity cabin);
    public CabinDto getById(UUID id);
    public void deleteCabin(UUID id);
}

package br.espm.canoafurada.cabin.interfaces;

import br.espm.canoafurada.cabin.CabinDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


public interface ICabinController {
    @GetMapping("/cabin")
    public List<CabinDto> getAllCabins();

    @GetMapping("/cabin/{id}")
    public CabinDto getCabinById(@PathVariable UUID id);

    @PostMapping("/cabin")
    public CabinDto createCabin(@RequestBody CabinDto cabin);

    @PutMapping("/cabin/{id}")
    public CabinDto updateCabin(@PathVariable UUID id, @RequestBody CabinDto cabin);

    @DeleteMapping("/cabin/{id}")
    public void deleteCabin(@PathVariable UUID id);
}

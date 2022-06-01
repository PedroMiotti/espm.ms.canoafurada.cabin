package br.espm.canoafurada.cabin;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CabinRepository extends CrudRepository<CabinEntity, UUID> {
    @Override
    CabinEntity save(CabinEntity user);

    @Override
    List<CabinEntity> findAll();

    @Override
    Optional<CabinEntity> findById(UUID id);

    @Override
    void deleteById(UUID id);
}

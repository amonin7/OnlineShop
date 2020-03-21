package main.repositories;

import main.entities.GoodEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface GoodsRepository extends CrudRepository<GoodEntity, Long> {

    Optional<GoodEntity> findFirstByCategory(String name);
    Optional<GoodEntity> findById(Long id);
    Optional<GoodEntity> findFirstByCode(BigInteger code);
    Optional<GoodEntity> findFirstByName(String name);

}

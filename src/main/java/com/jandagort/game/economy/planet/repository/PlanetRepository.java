package com.jandagort.game.economy.planet.repository;

import com.jandagort.user.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends CrudRepository<PlanetEntity, Long> {
    PlanetEntity findOneByOwner(UserEntity owner);
}

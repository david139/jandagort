package com.jandagort.game.economy.planet.repository;

import com.jandagort.game.economy.planet.PlanetEntity;
import com.jandagort.user.domain.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlanetService {

    private PlanetRepository planetRepository;

    public PlanetEntity getByOwner(UserEntity owner) {
        return planetRepository.findOneByOwner(owner);
    }

    public PlanetEntity save(PlanetEntity planetEntity) {
        return planetRepository.save(planetEntity);
    }

    public Iterable<PlanetEntity> findAll(){
        return planetRepository.findAll();
    }

}

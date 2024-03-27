package me.dio.sdw24.domain.model.ports;

import java.util.List;
import java.util.Optional;

import me.dio.sdw24.domain.model.Champions;

public interface ChampionsRepository {
    
    List<Champions> findAll();

    Optional<Champions> findOne(Long id);

}

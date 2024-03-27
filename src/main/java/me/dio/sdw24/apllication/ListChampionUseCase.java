package me.dio.sdw24.apllication;

import java.util.List;

import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.domain.model.ports.ChampionsRepository;

public record ListChampionUseCase(ChampionsRepository repository) {

    public List<Champions> findAll() {
        return repository.findAll();
    }


}

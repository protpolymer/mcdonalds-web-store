package ru.itpark.mcdonaldsweb.service;

import org.springframework.stereotype.Service;
import ru.itpark.mcdonaldsweb.domain.Goods;
import ru.itpark.mcdonaldsweb.exception.GoodsNotFoundException;
import ru.itpark.mcdonaldsweb.repository.GoodsRepository;

import java.util.List;

@Service
public class GoodsService {
    private final GoodsRepository repository;

    public GoodsService(GoodsRepository repository) {
        this.repository = repository;
    }

    public List<Goods> getAll() {
        return repository.getAll();
    }

    public Goods getById(int id) {
        return repository.getById(id);
    }
}

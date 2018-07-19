package com.brainmatic.pos.core.entity.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RepositoryNonSpring<E>  {

    int getCount();
    void save(E Entity);
    int remove(int id);
    E getById(int id);
    List<E> getAll();
}

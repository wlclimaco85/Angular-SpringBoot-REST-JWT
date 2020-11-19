package com.app.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.dicionario.Tela;

public interface DicionarioRepo extends JpaRepository<Tela, Integer> {
    public List<Tela> findAll();
    public Page<Tela> findAll(Pageable p);
    Tela save(Tela c);
    void delete(Tela c);
    void delete(Integer id);
    boolean exists( Integer id);


}


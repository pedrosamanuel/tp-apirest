package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import com.example.inicial1.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseService <E extends Base,
        ID extends Serializable> {
    protected BaseRepository<E, ID> baseRepository;
    public BaseService(BaseRepository<E, ID> baseRepository){
        this.baseRepository = baseRepository;
    }


    @Transactional
    public List<E> findAll() throws Exception{
        try {
            return baseRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public E findById(ID id) throws Exception{
        try {
            return baseRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public E save(E entity) throws Exception{
        try {
            return baseRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public E update(ID id, E updatedEntity) throws Exception{
        try {
            Optional<E> optional = baseRepository.findById(id);
            E entity = optional.get();
            entity = baseRepository.save(updatedEntity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    public boolean delete(ID id) throws Exception{
        try {
            Optional<E> optional = baseRepository.findById(id);
            if (optional.isPresent()) {
                baseRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Page<E> findAll(Pageable p) throws Exception {
        try {
            return baseRepository.findAll(p);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

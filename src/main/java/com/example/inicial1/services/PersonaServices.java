package com.example.inicial1.services;

import com.example.inicial1.dtos.PersonaDto;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PersonaServices extends BaseService<Persona, Long>{
    @Autowired
    private PersonaRepository personaRepository;
    public PersonaServices(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }

    public Page<Persona> search(String filter, Pageable p) throws Exception {
        try {
            //Page<Persona> personas = pr.findByNombreContainingOrApellidoContaining(filter, filter);
            //Page<Persona> personas = pr.search(filter);
            Page<Persona> personas = personaRepository.nativeSearch(filter, p);

            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

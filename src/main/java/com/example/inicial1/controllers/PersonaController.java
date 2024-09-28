package com.example.inicial1.controllers;

import com.example.inicial1.dtos.PersonaDto;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.services.PersonaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/personas")
public class PersonaController extends BaseController<Persona, Long, PersonaServices>{
    //@GetMapping("/search")
    //public ResponseEntity<?> search(@RequestParam String filter) {
    //    try {
    //        return ResponseEntity.status(HttpStatus.OK).body(service.search(filter));
    //    } catch (Exception e) {
    //        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
    //    }
    //}

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filter, Pageable p) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter, p));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
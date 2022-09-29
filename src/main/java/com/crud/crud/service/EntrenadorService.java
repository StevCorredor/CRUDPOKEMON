package com.crud.crud.service;

import com.crud.crud.entity.Entrenador;
import com.crud.crud.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    EntrenadorRepository entrenadorRepository;

    public void crearYActualizarEntrenador(Entrenador Entrenador){
        entrenadorRepository.save(Entrenador);
    }

    public List<Entrenador> verEntrenador(){
        List<Entrenador> entrenadors = new ArrayList<>();
        entrenadors.addAll(entrenadorRepository.findAll());
        return entrenadors;
    }

    public void eliminarEntrenador(Long id){
        entrenadorRepository.deleteById(id);
    }
}

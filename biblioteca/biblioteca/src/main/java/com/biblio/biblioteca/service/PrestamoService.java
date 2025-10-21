package com.biblio.biblioteca.service;

import com.biblio.biblioteca.model.Prestamo;
import com.biblio.biblioteca.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;


    public List<Prestamo> getAll(){
        return prestamoRepository.findAll();
    }


    public List<Prestamo> getAllByUser(Long id_usuario){
        //OPCION 1
       // List<Prestamo> prestamos = prestamoRepository.findAll();
       //return prestamos.stream().filter(p->p.getUsuario().getId()==id_usuario).toList();

       //OPCION 2 Y MEJOR
        return  prestamoRepository.findAllByUsuario(id_usuario);
    }

    public void create(Prestamo prestamo){
        prestamoRepository.save(prestamo);
    }



}

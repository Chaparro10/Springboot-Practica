package com.biblio.biblioteca.controller;

import com.biblio.biblioteca.model.Categoria;
import com.biblio.biblioteca.service.CategoriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private  CategoriaService categoriaService;

    @GetMapping("")
    public List<Categoria> getAll(){
        return  categoriaService.getAll();
    }


    //localhost:8080/categorias/1
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id) {
        Categoria data = categoriaService.getCategoriaByID(id);
       // System.out.println(data.getLibros().size());
        System.out.println("la data "+data);
        if (data == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    //localhost:8080/categorias/id?id=1
    @GetMapping("/query")
    public Categoria getByIdQuery(@RequestParam String id){
        Long idCast=Long.parseLong(id);
        return  categoriaService.getCategoriaByID(idCast);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        categoriaService.deleteByID(id);
    }

    @PostMapping()
    public  Categoria save(@RequestBody Categoria categoria){
        return categoriaService.create(categoria);
    }


}

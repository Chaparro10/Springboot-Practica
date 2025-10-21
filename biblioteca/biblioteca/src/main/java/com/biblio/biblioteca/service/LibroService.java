package com.biblio.biblioteca.service;


import com.biblio.biblioteca.dto.LibroDTO;
import com.biblio.biblioteca.dto.LibroRequestDTO;
import com.biblio.biblioteca.dto.mapper.LibroMapper;
import com.biblio.biblioteca.model.Libro;
import com.biblio.biblioteca.repository.AutorRepository;
import com.biblio.biblioteca.repository.CategoriaRepository;
import com.biblio.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LibroMapper libroMapper;


    /*
    public List<Libro> getAll(){
        return libroRepository.findAll();
    }*/

    /*
    public List<LibroDTO> getAll(){
        return libroRepository.findAll().stream().map(this::convertToDTO).toList();
    }
*/

    //Utilizando dependencia para hacer el mapeo
    public List<LibroDTO> getAll(){
        return libroRepository.findAll().stream().map(libroMapper::libroToLibroDTO).toList();
    }

    public Libro getById(Long id){
        return  libroRepository.findById(id).orElse(null);
    }

    public void add(LibroRequestDTO libroRequestDTO){

        Libro libro = libroMapper.libroDtoToLibro(libroRequestDTO);

        libro.setAutor(
                autorRepository.findById(libroRequestDTO.getId_autor())
                        .orElseThrow(() -> new RuntimeException("Autor no encontrado"))
        );

        libro.setCategoria(
                categoriaRepository.findById(libroRequestDTO.getId_categoria())
                        .orElseThrow(() -> new RuntimeException("Categoría no encontrada"))
        );
        libroRepository.save(libro);
        System.out.println("Libro agregado correctamente");
    }

    public  void deleteById(Long id){
        libroRepository.deleteById(id);
        System.out.println("Libro eliminado correctamente");
    }


    //servicios para trabajar con DTO de forma manual
  //  private LibroDTO convertToDTO(Libro libro) {
//        LibroDTO dto = new LibroDTO();
//        dto.setId(libro.getId());
//        dto.setTitulo(libro.getTitulo());
//        dto.setIsbn(libro.getIsbn());
//        dto.setAnioPublicacion(libro.getAnioPublicacion());
//        dto.setNombreAutor(libro.getAutor().getNombre() + " " + libro.getAutor().getApellido());
//        dto.setNombreCategoria(libro.getCategoria().getNombre());
//        return dto;
 //   }

 //   public Libro convertToEntity(LibroRequestDTO dto) {
//        Libro libro = new Libro();
//        libro.setTitulo(dto.getTitulo());
//        libro.setIsbn(dto.getIsbn());
//        libro.setAnioPublicacion(dto.getAnioPublicacion());
//        libro.setAutor(autorRepository.findById(dto.getId_autor()).orElseThrow());
//        libro.setCategoria(categoriaRepository.findById(dto.getId_categoria()).orElseThrow());
       // return libro;
  //  }
}

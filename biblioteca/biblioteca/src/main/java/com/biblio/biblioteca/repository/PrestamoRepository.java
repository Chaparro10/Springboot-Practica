package com.biblio.biblioteca.repository;

import com.biblio.biblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository  extends JpaRepository<Prestamo,Long> {


    /*QUERY METHOD*/
    List<Prestamo> findAllByUsuario_Id(Long id);


    /*QUERY SQL NATIVOS*/
    @Query(value = "SELECT * FROM prestamos where usuario_id =:id",nativeQuery = true)
    List<Prestamo> findAllByUsuario(@Param("id") Long usuarioId);
}

package com.kmlch.BACKEND.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //la anotacion indica que es una entidad
@Data //para no escribir los get y los set
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empleado {

    //Valores de nuestra tabla
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Integer idEmpleado;
String nombre;
String Departamento;
Double sueldo;
}

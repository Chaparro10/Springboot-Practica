package com.kmlch.BACKEND.servicio;

import com.kmlch.BACKEND.modelo.Empleado;
import java.util.List;
public interface IEmpleadoServicio {

    public List<Empleado> listarEmpleados();

    public Empleado buscarEmpleadoPorId(Integer idEmpleado);

    public Empleado guardarEmpleado(Empleado empleado);

    public List<Empleado> buscarEmpleadoPorNombre(String Nombre);
    public void eliminarEmpleado(Empleado empleado);
}

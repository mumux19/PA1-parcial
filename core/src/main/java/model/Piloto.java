package model;

import exception.ExceptionPiloto;

import java.time.LocalDateTime;

public class Piloto {
    private long id;
    private String nombre;
    private String documento;
    private LocalDateTime fecha_Nacimiento;

    private Piloto(long id,String nombre,String documento,LocalDateTime fecha_Nacimiento){
        this.id=id;
        this.nombre=nombre;
        this.documento=documento;
        this.fecha_Nacimiento=fecha_Nacimiento;

    }

    public static Piloto intancia(long id,String nombre,String documento,LocalDateTime fecha_Nacimiento) throws ExceptionPiloto {
        if(nombre==null|| nombre.isBlank()){
            throw new ExceptionPiloto("El nombre no puede ser nulo ni vacio");
        }

        if(documento==null || documento.isBlank()){
            throw new ExceptionPiloto("El documento no puede ser nulo ni vacio");
        }

        if(fecha_Nacimiento==null ){
            throw new ExceptionPiloto("La fecha de nacimiento no puede ser nula ni futura");
        }

        if(getEdad(fecha_Nacimiento) < 18) {
            throw new ExceptionPiloto("El piloto debe ser mayor de edad (18 años)");
        }

        return new Piloto(id, nombre, documento, fecha_Nacimiento);
    }

    private static int getEdad(LocalDateTime fechaNacimiento) {

        int edad;
        LocalDateTime fechaActual = LocalDateTime.now();
        edad = fechaActual.getYear() - fechaNacimiento.getYear();
        if (fechaActual.getMonthValue() < fechaNacimiento.getMonthValue() ||
                (fechaActual.getMonthValue() == fechaNacimiento.getMonthValue() && fechaActual.getDayOfMonth() < fechaNacimiento.getDayOfMonth())) {
            edad--;
        }
        return edad;
    }
}

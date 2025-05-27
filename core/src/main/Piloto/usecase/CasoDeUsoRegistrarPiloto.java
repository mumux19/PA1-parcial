package usecase;

import exception.ExceptionRegistrarPiloto;
import input.IRegistrarPilotoInput;
import model.Piloto;
import output.IRepositorio;

import java.time.LocalDateTime;
import java.util.UUID;

public class CasoDeUsoRegistrarPiloto implements IRegistrarPilotoInput {

    IRepositorio repositorio;
    public CasoDeUsoRegistrarPiloto(IRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    @Override
    public UUID registrarPilotoInput(UUID id, String nombre, String documento, LocalDateTime fecha_Nacimiento) throws Exception {
        Piloto piloto= Piloto.intancia(id, nombre,documento, fecha_Nacimiento);
        if(repositorio.existePilotoOutput(piloto.getDocumento())){

            throw new ExceptionRegistrarPiloto("El piloto ya existe");
        }else{

            repositorio.registrarPilotoOutput(piloto);
        }

        return piloto.getId();

    }
}

package input;

import exception.ExceptionRegistrarPiloto;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IRegistrarPilotoInput {
    public UUID registrarPilotoInput(UUID id, String nombre, String documento, LocalDateTime fecha_Nacimiento) throws Exception;
}

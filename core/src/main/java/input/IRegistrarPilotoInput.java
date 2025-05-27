package input;

import java.util.UUID;

public interface IRegistrarPilotoInput {
    public UUID registrarPiloto(UUID id, String nombre, String documento, String fechaNacimiento);
}

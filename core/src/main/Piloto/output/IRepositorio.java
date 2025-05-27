package output;

import model.Piloto;

import java.util.UUID;

public interface IRepositorio {
    public boolean registrarPilotoOutput(Piloto piloto);
    public boolean existePilotoOutput(String Documento);
}

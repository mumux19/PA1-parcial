package usecase;

import exception.ExceptionPiloto;
import input.IRegistrarPilotoInput;
import model.Piloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.IRepositorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CasoDeUsoRegistrarPilotoTest {

    CasoDeUsoRegistrarPiloto casoDeUsoRegistrarPiloto;
    @Mock
    IRepositorio repositorio;

    @BeforeEach
    void setup() {

        casoDeUsoRegistrarPiloto = new CasoDeUsoRegistrarPiloto(repositorio);
    }


    @Test
    public void testGuardarPiloto() throws Exception {
        Piloto piloto=Piloto.intancia(UUID.randomUUID(),"Franco Colapinto","123456789", LocalDateTime.MIN);

        when(repositorio.existePilotoOutput(piloto.getDocumento())).thenReturn(false);

        when(repositorio.registrarPilotoOutput(piloto)).thenReturn(true);

        UUID resultado= casoDeUsoRegistrarPiloto.registrarPilotoInput(piloto.getId(), "franco Colapinto ", piloto.getDocumento(), LocalDateTime.MIN);

        Assertions.assertEquals(piloto.getId(), resultado);
    }


    @Test
    public void testGuardarPilotoExiste() throws Exception {
        Piloto piloto=Piloto.intancia(UUID.randomUUID(),"Franco Colapinto","123456789", LocalDateTime.MIN);

        when(repositorio.existePilotoOutput("123456789")).thenReturn(true);

        Assertions.assertThrows(Exception.class, () -> {casoDeUsoRegistrarPiloto.registrarPilotoInput(piloto.getId(), "franco Colapinto ", piloto.getDocumento(), LocalDateTime.MIN);} ,"El piloto ya existe");



    }


}

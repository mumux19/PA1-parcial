package model;

import exception.ExceptionPiloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

public class PilotoTest {

    @Test
    public void testRegistrarPilotoExito() {
        // Arrange

        Piloto piloto=Piloto.intancia(UUID.randomUUID(),"Franco Colapinto","123456ABC",LocalDateTime.MIN);

        Assertions.assertNotNull(piloto);

    }

    @Test
    public void testRegistrarPilotoSinExisto1(){

        Assertions.assertThrows(ExceptionPiloto.class,()-> {Piloto.intancia(UUID.randomUUID(),"","123456789ABC", LocalDateTime.MIN);}, "El nombre no puede ser nulo ni vacio");

    }
    @Test
    public void testRegistrarPilotoSinExisto2(){

        Assertions.assertThrows(ExceptionPiloto.class,()-> {Piloto.intancia(UUID.randomUUID(),null,"123456789ABC", LocalDateTime.MIN);}, "El nombre no puede ser nulo ni vacio");

    }
    @Test
    public void testRegistrarPilotoSinExisto3(){

        Assertions.assertThrows(ExceptionPiloto.class,()-> {Piloto.intancia(UUID.randomUUID(),"Franco Colapinto","  ", LocalDateTime.MIN);}, "El documento no puede ser nulo ni vacio");

    }
    @Test
    public void testRegistrarPilotoSinExisto4(){

        Assertions.assertThrows(ExceptionPiloto.class,()-> {Piloto.intancia(UUID.randomUUID(),"Franco Colapinto",null, LocalDateTime.MIN);}, "El documento no puede ser nulo ni vacio");

    }
    @Test
    public void testRegistrarPilotoSinExisto5(){

        Assertions.assertThrows(ExceptionPiloto.class,()-> {Piloto.intancia(UUID.randomUUID(),"Franco Colapinto","123456789ABC", null);}, "La fecha de nacimiento no puede ser nula");

    }
    @Test
    public void testRegistrarPilotoSinExisto6(){

        Assertions.assertThrows(ExceptionPiloto.class,()-> {Piloto.intancia(UUID.randomUUID(),"Franco Colapinto","123456789ABC", LocalDateTime.MAX);}, "El piloto debe ser mayor de edad (18 años)");

    }

}

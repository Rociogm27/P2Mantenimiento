package org.example;//Rocio Gomez Mancebo

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


/*
EXPLICACION DE PUEBAS REALIZADAS:
    1. PrimerLadoIgualACero, SegundoLadoIgualACero, TercerLadoIgualACero,TodosLadosIgualACero : Lanzará una excepción para aquellos casos en los que algun lado es igual a cero.
    2. PrimerLadoNegativo, SegundoLadoNegativo,TercerLadoNegativo, TodosLadosNegativo : Lanzará una excepción para aquellos casos en los que algun lado es negativo.
    3. SumaDosLadosMenorQueElTercero, SumaDosLadosMenorQueElSegundo, SumaDosLadosMenorQueElPrimero: Lanzará una excepción para aquellos casos en los que la suma de cualquiera de
        dos de sus lados sea menor que otro.
    4. SumaDosLadosIgualQueElTercero, SumaDosLadosIgualQueElSegundo, SumaDosLadosIgualQueElPrimero: Lanzará una excepción para aquellos casos en los que la suma de cualquiera de
        dos de sus lados sea igual que otro.
    5. SaleEquilateroSiSonTresLadosIguales: Comprueba que si los tres lados son iguales detecte que es un equilatero.
    6. IsoscelesSiDosPrimerosIguales, IsoscelesSiDosUltimosIguales, IsoscelesSiPrimeroYUltimoIguales: Comprueba que si dos lados son iguales y uno no entones es isosceles.
    7. SaleEscalenoTodosLadosDistintos: Comprueba que si todos los lados son distintos entones es escaleno.
 */

public class TriangleTest {
    Triangle ejemplo;

    @BeforeEach
    void setup(){
        //creamos siempre un triangulo antes de las pruebas
        ejemplo = new Triangle();
    }

    @AfterEach
    void vaciar(){
        //limpiamos el objeto triangulo
        ejemplo = null;
    }

    @Test
    public void PrimerLadoIgualACero(){
        //vamos a comprobar que si detecta un lado con long 0 salte excepcion

        assertThrows(RuntimeException.class,()->ejemplo.getType(0,6,7));
    }
    @Test
    public void SegundoLadoIgualACero(){
        //vamos a comprobar que si detecta un lado con long 0 salte excepcion
        assertThrows(RuntimeException.class,()->ejemplo.getType(6,0,7));
    }
    @Test
    public void TercerLadoIgualACero(){
        //vamos a comprobar que si detecta un lado con long 0 salte excepcion
        assertThrows(RuntimeException.class,()->ejemplo.getType(7,6,0));
    }
    @Test
    public void TodosLadosIgualACero(){
        //vamos a comprobar que si detecta un lado con long 0 salte excepcion

        assertThrows(RuntimeException.class,()->ejemplo.getType(0,0,0));

    }

    @Test
    public void PrimerLadoNegativo(){
        //vamos a comprobar que si detecta un lado negativo lance excepcion
        assertThrows(RuntimeException.class,()->ejemplo.getType(-4,6,7));
    }
    @Test
    public void SegundoLadoNegativo(){
        //vamos a comprobar que si detecta un lado negativo lance excepcion
        assertThrows(RuntimeException.class,()->ejemplo.getType(4,-6,7));
    }
    @Test
    public void TercerLadoNegativo(){
        //vamos a comprobar que si detecta un lado negativo lance excepcion
        assertThrows(RuntimeException.class,()->ejemplo.getType(4,6,-7));
    }
    @Test
    public void TodosLadosNegativo(){
        //vamos a comprobar que si detecta un lado negativo lance excepcion
        assertThrows(RuntimeException.class,()->ejemplo.getType(-4,-6,-7));
    }

    @Test
    public void SumaDosLadosMenorQueElTercero(){
        //comprobamos que lance excepcion si suman menos que el tercer lado
        assertThrows(RuntimeException.class,()->ejemplo.getType(1,1,4));
    }
    @Test
    public void SumaDosLadosMenorQueElSegundo(){
        //comprobamos que lance excepcion si suman menos que el tercer lado
        assertThrows(RuntimeException.class,()->ejemplo.getType(1,4,1));
    }
    @Test
    public void SumaDosLadosMenorQueElPrimero(){
        //comprobamos que lance excepcion si suman menos que el tercer lado
        assertThrows(RuntimeException.class,()->ejemplo.getType(4,1,1));
    }

    @Test
    public void SumaDosLadosIgualQueElTercero() {
        //comprobamos que lance excepcion si suman menos que el tercer lado
        assertThrows(RuntimeException.class, () -> ejemplo.getType(1, 1, 2));
    }
    @Test
    public void SumaDosLadosIgualQueElSegundo() {
        //comprobamos que lance excepcion si suman menos que el tercer lado
        assertThrows(RuntimeException.class, () -> ejemplo.getType(1, 2, 1));
    }
    @Test
    public void SumaDosLadosIgualQueElPrimero() {
        //comprobamos que lance excepcion si suman menos que el tercer lado
        assertThrows(RuntimeException.class, () -> ejemplo.getType(2, 1, 1));
    }

        @Test
    public void SaleEquilateroSiSonTresLadosIguales(){
        //comprueba que sale equilatero
       Triangle.TriangleType tipo = ejemplo.getType(4,4,4);

       assertEquals(Triangle.TriangleType.EQUILATERAL,tipo);
}

@Test
    public void IsoscelesSiDosPrimerosIguales(){
        //comprueba que sale equilatero
    Triangle.TriangleType tipo1 = ejemplo.getType(4,4,6);

    assertEquals(Triangle.TriangleType.ISOSCELES,tipo1);

}
    @Test
    public void IsoscelesSiDosUltimosIguales(){
        //comprueba que sale equilatero
        Triangle.TriangleType tipo2 = ejemplo.getType(6,4,4);

        assertEquals(Triangle.TriangleType.ISOSCELES,tipo2);
    }
    @Test
    public void IsoscelesSiPrimeroYUltimoIguales(){
        //comprueba que sale equilatero
        Triangle.TriangleType tipo3 = ejemplo.getType(4,6,4);

        assertEquals(Triangle.TriangleType.ISOSCELES,tipo3);
    }


@Test
    public void SaleEscalenoTodosLadosDistintos(){
    //comprueba que sale escaleno
    Triangle.TriangleType tipo = ejemplo.getType(4,5,6);
    assertEquals(Triangle.TriangleType.SCALENE,tipo);
}

}

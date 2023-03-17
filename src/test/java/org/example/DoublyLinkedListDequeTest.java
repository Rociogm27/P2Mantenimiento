package org.example;
import org.junit.jupiter.api.*;
import org.mps.deque.DequeNode;
import org.mps.deque.DoubleEndedQueueException;
import org.mps.deque.DoublyLinkedListDeque;
import java.util.Collections;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListDequeTest {

    DoublyLinkedListDeque<Object> prueba;

    @Test
    @DisplayName("es inicializado con new DoublyLinkedListDeque()")
    void isInstantiatedWithNew() {
        new DoublyLinkedListDeque<>();
    }

    @Nested
    @DisplayName("Cuando new")
    class WhenNew {
        @BeforeEach
        void createNewListAntes() {
            prueba = new DoublyLinkedListDeque<>();
        }

        @AfterEach
        void createNewListDespues() {
            prueba = new DoublyLinkedListDeque<>();
        }

        @Test
        @DisplayName("Comprueba que el primero es correcto")
        void encuentraPrimero(){
            DequeNode<Object> nodoEjemplo = new DequeNode<>(null,null,null);
            prueba.append(nodoEjemplo);
            assertTrue(prueba.first()==nodoEjemplo);
        }

        @Test
        @DisplayName("Comprueba que el ultimo es correcto")
        void encuentraUltimo(){
            DequeNode<Object> nodoEjemplo = new DequeNode<>(null,null,null);
            prueba.append(nodoEjemplo);
            assertTrue(prueba.last()==nodoEjemplo);
        }

        @Test
        @DisplayName("Comprueba que el tamaño es correcto")
        void encuentraTam(){
            DequeNode<Object> nodoEjemplo = new DequeNode<>(null,null,null);
            prueba.append(nodoEjemplo);
            assertTrue(prueba.size()==1);
        }
        @Test
        @DisplayName("Comprueba que el tamaño es cero si no se añade nada")
        void tamCeroSiNoSeAñade(){
            assertTrue(prueba.size()==0);
        }

    }
    @Nested
    @DisplayName("Cuando añadimos")
    class WhenAdd{
        @BeforeEach
        void createNewListAntes() {
            prueba = new DoublyLinkedListDeque<>();
        }

        @AfterEach
        void createNewListDespues() {
            prueba = new DoublyLinkedListDeque<>();
        }
        @Test
        @DisplayName("Añadimos al principio y estaba vacio, es el primero")
        void anadePrincipioEstandoVacio(){
            DequeNode<Object> nodoEjemplo = new DequeNode<>(null,null,null);
            prueba.prepend(nodoEjemplo);
            assertTrue(prueba.first()==nodoEjemplo);
        }
        @Test
        @DisplayName("Añadimos al principio y tenia ya un nodo que pasa a ser segundo")
        void anadePrincipioTeniendoNodos(){
            DequeNode<Object> nodoEjemplo = new DequeNode<>("4",null,null);
            DequeNode<Object> nodoEjemplo2 = new DequeNode<>("5",null,null);
            prueba.prepend(nodoEjemplo);
            prueba.prepend(nodoEjemplo2);
            assertTrue(prueba.first()==nodoEjemplo2);
        }

        @Test
        @DisplayName("Añadimos al final y estaba vacio, es el primero y el ultimo")
        void anadefinalEstandoVacio(){
            DequeNode<Object> nodoEjemplo = new DequeNode<>(null,null,null);
            prueba.append(nodoEjemplo);
            assertTrue(prueba.last() == nodoEjemplo);
            assertTrue(prueba.first()==nodoEjemplo);
        }
        @Test
        @DisplayName("Añadimos al final y tenia ya un nodo que pasa a no ser ultimo")
        void anadeFinalTeniendoNodos(){
            DequeNode<Object> nodoEjemplo = new DequeNode<>("4",null,null);
            DequeNode<Object> nodoEjemplo2 = new DequeNode<>("5",null,null);
            prueba.append(nodoEjemplo);
            prueba.append(nodoEjemplo2);
            assertTrue(prueba.last()==nodoEjemplo2);
        }
    }

    @Nested
    @DisplayName("Cuando borramos")
    class WhenDelete {
        @BeforeEach
        void createNewListAntes() {
            prueba = new DoublyLinkedListDeque<>();
        }

        @AfterEach
        void createNewListDespues() {
            prueba = new DoublyLinkedListDeque<>();
        }

        @Test
        @DisplayName("Borramos al principio sin haber nodos, salta excepcion")
        void borraPrincipioEstandoVacioSaltaExcepcion(){
            assertThrows(DoubleEndedQueueException.class,()->prueba.deleteFirst());
        }
        @Test
        @DisplayName("Borramos al final sin haber nodos, salta excepcion")
        void borraFinalEstandoVacioSaltaExcepcion(){
            assertThrows(DoubleEndedQueueException.class,()->prueba.deleteLast());
        }

        @Test
        @DisplayName("Borramos al principio y tenia valores")
        void borraPrincipioTeniendoDosValor(){
            DequeNode<Object> nodoEjemplo = new DequeNode<>(null,null,null);
            DequeNode<Object> nodoEjemplo2 = new DequeNode<>(null,null,null);
            prueba.prepend(nodoEjemplo);
            prueba.prepend(nodoEjemplo2);
            prueba.deleteFirst();
            assertTrue(prueba.first.getPrevious() == null);
            prueba.deleteFirst();
            assertTrue(prueba.last == null);

        }
        @Test
        @DisplayName("Borramos al final y tenia valores")
        void borraFinalTeniendoDosValor() {
            DequeNode<Object> nodoEjemplo = new DequeNode<>(null, null, null);
            DequeNode<Object> nodoEjemplo2 = new DequeNode<>(null, null, null);
            prueba.prepend(nodoEjemplo);
            prueba.prepend(nodoEjemplo2);
            prueba.deleteLast();
            assertTrue(prueba.first.getPrevious() == null);
            prueba.deleteLast();
            assertTrue(prueba.last == null);
        }
    }


        //INICIO DE PRACTICA LAB 2
        @Nested
        @DisplayName("Cuando buscamos o contiene")
        class WhenWeLookFor {
            @BeforeEach
            void createNewListAntes() {
                prueba = new DoublyLinkedListDeque<>();
            }

            @AfterEach
            void createNewListDespues() {
                prueba = new DoublyLinkedListDeque<>();
            }

            @Test
            @DisplayName("Lanza excepcion si el indice buscado no existe")
            void IndiceIncorrectoLanzaExcepcion(){
                prueba.append(1);
                assertThrows(DoubleEndedQueueException.class,()->prueba.get(3));
            }

            @Test
            @DisplayName("Devuelve el item correcto al indice pedido")
            void DevuelveItemCorrectoDelIndex(){
                prueba.append(1);
                prueba.append(2);
                prueba.append(3);
                assertTrue(prueba.get(0).equals(prueba.first()));
                assertTrue(prueba.get(2).equals(prueba.last()));
                assertTrue(prueba.get(1).equals(2));
            }

            @Test
            @DisplayName("Detecta correctamente si el elemento esta contenido")
            void DetectaElemDentroDeLista(){
                prueba.append(1);
                prueba.append(2);
                assertTrue(prueba.contains(1) == true);
            }

            @Test
            @DisplayName("Detecta correctamente si el elemento no esta contenido")
            void DetectaElemNoEstaDentroDeLista(){
                prueba.append(1);
                prueba.append(2);
                assertTrue(prueba.contains(4) == false);
            }

        }

        @Nested
        @DisplayName("Cuando borramos sin importar orden")
        class WhenWeDelete {
            @BeforeEach
            void createNewListAntes() {
                prueba = new DoublyLinkedListDeque<>();
            }

            @AfterEach
            void createNewListDespues() {
                prueba = new DoublyLinkedListDeque<>();
            }

            @Test
            @DisplayName("Lanza excepcion si el indice a borrar no existe")
            void IndiceIncorrectoParaBorrarLanzaExcepcion(){
                prueba.append(1);
                assertThrows(DoubleEndedQueueException.class,()->prueba.remove(3));
            }


            @Test
            @DisplayName("Borra correctamente si es primero")
            void BorraBienPrimero(){
                prueba.append(1);
                prueba.append(2);
                prueba.append(3);
                prueba.remove(1);
                assertTrue(prueba.first().equals(2));
            }
            @Test
            @DisplayName("Borra correctamente si es ultimo")
            void BorraBienUltimo(){
                prueba.append(1);
                prueba.append(2);
                prueba.append(3);
                prueba.remove(3);
                assertTrue(prueba.last().equals(2));
            }

            @Test
            @DisplayName("Borra correctamente si se encuentra en medio")
            void BorraBienMitad(){
                prueba.append(1);
                prueba.append(2);
                prueba.append(3);
                prueba.append(4);
                prueba.remove(3);
                assertTrue(prueba.contains(3) == false);
            }

        }


        @Nested
        @DisplayName("Cuando ordenamos")
        class WhenWeOrder {

            DoublyLinkedListDeque<Integer> lista;
            @BeforeEach
            void createNewListAntes() {
                lista = new DoublyLinkedListDeque<Integer>();
            }

            @AfterEach
            void createNewListDespues() {
                lista = new DoublyLinkedListDeque<Integer>();
            }

            @Test
            @DisplayName("Lanza excepcion si se intenta ordenar lista vacia")
            void OrdenaListaVaciaYLanzaExcepcion(){
                lista.append(1);
                assertThrows(DoubleEndedQueueException.class, () ->  lista.sort(Integer::compareTo));
            }
            @Test
            @DisplayName("Cuando la lista esta desordenada la ordena")
            public void listaDesordenadaSeOrdena() {
                lista.append(3);
                lista.append(2);
                lista.append(1);
                lista.sort(Integer::compareTo);


                assertEquals(1,lista.first());
                assertEquals(2,lista.first.getNext().getItem());
                assertEquals(3,lista.last());
            }

 @Test
            @DisplayName("Cuando la lista esta ordenada la deja igual")
            public void sortListOrdered() {
                lista.append(1);
                lista.append(2);
                lista.append(3);
                lista.sort(Integer::compareTo);
                 assertEquals(1,lista.first());
                 assertEquals(2,lista.first.getNext().getItem());
                 assertEquals(3,lista.last());
            }
        }
    }






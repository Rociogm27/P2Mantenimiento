package org.example;

import org.junit.jupiter.api.*;
import org.mps.deque.DequeNode;
import org.mps.deque.DoubleEndedQueueException;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {
    DequeNode<Object> prueba;

    @Test
    @DisplayName("es inicializado con new DequeNode()")
    void isInstantiatedWithNew() {
        new DequeNode<>(null,null,null);
    }

    @Nested
    @DisplayName("Cuando new")
    class WhenNew {
        @BeforeEach
        void createNewNodoAntes() {
            prueba = new DequeNode<>(null,null,null);
        }
        @AfterEach
        void createNewNodoDespues() {
            prueba = new DequeNode<>(null,null,null);
        }
        @Test
        @DisplayName("Está vacío")
        void isEmpty() {
            assertTrue(prueba.getItem()==null);
        }

        @Test
        @DisplayName("No tiene previo")
        void noTienePrevio() {
            assertTrue(prueba.getPrevious()==null);
        }
        @Test
        @DisplayName("No tiene siguiente")
        void noTieneSiguiente() {
            assertTrue(prueba.getNext()==null);
        }

        @Test
        @DisplayName("Es el primero")
        void esPrimerNodo() {
            assertTrue(prueba.isFirstNode());
        }

        @Test
        @DisplayName("Es el ultimo")
        void esUltimoNodo() {
            DequeNode<Object> ejemplo = new DequeNode<>("4",null,null);
            assertTrue(prueba.isLastNode());
            prueba.setNext(ejemplo);
            assertFalse(prueba.isLastNode());
        }
        @Test
        @DisplayName("No es un nodo terminal")
        void noEsTerminalNodo() {
            assertFalse(prueba.isNotATerminalNode());
        }
        @Test
        @DisplayName("No es un nodo terminal porque tiene previo o siguiente")
        void noEsTerminalNodoTienePrevio() {
            DequeNode<Object> ejemplo = new DequeNode<>("4",null,null);
            prueba.setNext(ejemplo);
            prueba.setPrevious(ejemplo);
            assertTrue(prueba.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("Cambios de valores")
    class cambios {
        @BeforeEach
        void createNewStack() {
            prueba = new DequeNode<>(null,null,null);
        }
        @Test
        @DisplayName("Item cambiado")
        void itemCambiado() {
            prueba.setItem("4");
            assertTrue(prueba.getItem()=="4");
        }
        @Test
        @DisplayName("Previo cambiado")
        void previoCambiado() {
            DequeNode<Object> nuevo = new DequeNode<>("3",null,null);
            prueba.setPrevious(nuevo);
            assertTrue(prueba.getPrevious()==nuevo);
        }
        @Test
        @DisplayName("Posterior cambiado")
        void posteriorCambiado() {
            DequeNode<Object> nuevo = new DequeNode<>("3",null,null);
            prueba.setNext(nuevo);
            assertTrue(prueba.getNext()==nuevo);
        }
    }

}
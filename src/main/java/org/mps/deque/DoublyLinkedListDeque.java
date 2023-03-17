package org.mps.deque;

import java.util.Comparator;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    public DequeNode<T> first;
    public DequeNode<T> last;
    public int size;

    public DoublyLinkedListDeque() {
        // TODO
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        // TODO
        DequeNode<T> newNode = new DequeNode<>(value, null, first);
        if (first != null) {
            first.setPrevious(newNode);
        } else {
            last = newNode;
        }
        first = newNode;
        size++;
    }

    @Override
    public void append(T value) {
        // TODO
        DequeNode<T> newNode = new DequeNode<>(value, last, null);
        if (last != null) {
            last.setNext(newNode);
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if (first == null) {
            throw new DoubleEndedQueueException("Lista vacia");
        }
        T value = first.getItem();
        first = first.getNext();
        if (first != null) {
            first.setPrevious(null);
            size--;
        } else {
            last = null;
        }
    }

    @Override
    public void deleteLast() {
        // TODO
        if (last == null) {
            throw new DoubleEndedQueueException("Lista vacia");
        }
        T value = last.getItem();
        last = last.getPrevious();
        if (last != null) {
            last.setNext(null);
            size--;
        } else {
            first = null;
        }

    }

    @Override
    public T first() {
        // TODO
        return first.getItem();
    }

    @Override
    public T last() {
        // TODO
        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return size;
    }

    //metodo de prueba
 /*
    public void mostrarLista() {
        DequeNode<T> actual = first;
        while (actual != null) {
            System.out.print(actual.getItem() + " ");
            actual = actual.getNext();
        }
        System.out.println();
    }
*/

    public T get(int index) {
        int contador = 0;
        if (index >= size) {
            throw new DoubleEndedQueueException("Se pide un indice inexistente");
        }
        DequeNode<T> actual = first;
        while (contador != index) {
            actual = actual.getNext();
            contador++;
        }
        return actual.getItem();
    }

    public boolean contains(T value) {
        int cont = 0;
        DequeNode<T> ej = first;
        boolean res = false;
        while (cont <= size-1) {
            if (ej.getItem().equals(value)) {
                res = true;
            } else {
                ej = ej.getNext();
            }
            cont++;
        }
        return res;
    }

    @Override
    public void remove(T value) {
        if (!contains(value)){
            throw new DoubleEndedQueueException("El elemento no se encuentra en la cola");
        }
        DequeNode<T> node = first;
        while(!node.getItem().equals(value)){
            node = node.getNext();
        }

        // Is first
        if(node.getPrevious() == null){
            deleteFirst();
        }

        // Is last
        else if (node.getNext() == null){
            deleteLast();
        }

        else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            size--;
        }
    }

    public void sort(Comparator<? super T> comparator) throws DoubleEndedQueueException {
        if (size < 2) {
            throw new DoubleEndedQueueException("No se puede ordenar una lista de 1 elemento");
        }

        boolean cambiado;
        do {
            cambiado = false;
            DequeNode<T> actual = first;
            while (actual.getNext() != null) {
                DequeNode<T> next = actual.getNext();
                if (comparator.compare(actual.getItem(), next.getItem()) > 0) {
                    cambiado = true;
                    cambiarNodos(actual, next);
                } else {
                    actual = actual.getNext();
                }
            }
        } while (cambiado);
    }
    private void cambiarNodos(DequeNode<T> node1, DequeNode<T> node2) {
        T temp = node1.getItem();
        node1.setItem(node2.getItem());
        node2.setItem(temp);
    }


}


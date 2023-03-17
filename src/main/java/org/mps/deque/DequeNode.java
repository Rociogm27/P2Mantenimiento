package org.mps.deque;

/**
 * Class representing a node of a double-ended queue (deque). Each node has references to
 * the next and previous nodes.
 * The previous and next of the first and last node of the deque is {@code null}.
 *
 * @param <T> the type of elements held in the deque.
 */
public class DequeNode<T>{
    private T item;
    private DequeNode<T> previous;
    private DequeNode<T> next;

    public DequeNode(T item, DequeNode<T> previous, DequeNode<T> next) {
        this.item = item;
        this.previous = previous;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public DequeNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DequeNode<T> previous) {
        this.previous = previous;
    }

    public DequeNode<T> getNext() {
        return next;
    }

    public void setNext(DequeNode<T> next) {
        this.next = next;
    }

    public boolean isFirstNode() {
        return previous == null;
    }

    public boolean isLastNode() {
        return next == null;
    }

    public boolean isNotATerminalNode() {
        return !(isFirstNode() || isLastNode());
    }


}

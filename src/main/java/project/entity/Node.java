package project.entity;

import java.util.Map;

/**
 * This class provides an object of HashMap implementation.
 */
public class Node<K, V> implements Map.Entry<K, V> {
    private final K key;
    private V value;
    private Node<K, V> nextNode;

    public Node(final K key, final V value, final Node<K, V> nextNode) {
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(final V value) {
        final V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    public Node<K, V> getNextNode() {
        return nextNode;
    }

    public void setNextNode(final Node<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    public boolean containsKey(final Object key) {
        if (this.key == null) {
            return key == null;
        }
        return (this.key.hashCode() == key.hashCode() && this.key.equals(key));
    }

    @Override
    public String toString() {
        return "Node{" + key + ":" + value + '}';
    }
}

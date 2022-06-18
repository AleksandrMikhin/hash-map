package project.entity;

/**
 * This class provides an object that represents a HashMap implementation for trainee.
 * <p>
 * Implemented methods of {@link MyMap} interface.
 */
public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEFAULT_START_CAPACITY = 16;

    private int currentSize;
    private int numberOfBuckets;
    private Node<K, V>[] buckets;

    /**
     * Constructs an empty MyHashMap.
     */
    @SuppressWarnings("unchecked")
    public MyHashMap() {
        numberOfBuckets = DEFAULT_START_CAPACITY;
        this.buckets = new Node[DEFAULT_START_CAPACITY];
    }

    /**
     * Number of key-value pairs contained in this map.
     */
    @Override
    public int size() {
        return currentSize;
    }

    /**
     * Returns {@code true} if this map doesn't contain any key-value pairs.
     */
    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Puts a key-value pair in the map. If the map previously contained a mapping for the key,
     * the old value is replaced with the new value.
     *
     * @return the previous value if it's been changed, or {@code null} otherwise
     */
    @Override
    public V put(final K key, final V value) {
        final int bucketId = index(key, numberOfBuckets);
        Node<K, V> currentNode;
        if ((currentNode = buckets[bucketId]) != null) {
            while (true) {
                if (currentNode.containsKey(key)) {
                    return currentNode.setValue(value);
                }
                if (currentNode.getNextNode() == null) {
                    break;
                }
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(new Node<>(key, value, null));
        } else {
            buckets[bucketId] = new Node<>(key, value, null);
        }
        currentSize++;
        return null;
    }

    /**
     * Returns {@code true} if this map contains a key-value pair with the key.
     */
    @Override
    public boolean containsKey(final Object key) {
        final int bucketId = index(key, numberOfBuckets);
        Node<K, V> currentNode = buckets[bucketId];
        while (currentNode != null) {
            if (currentNode.containsKey(key)) {
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    /**
     * Returns the value mapped with the specified key,
     * or {@code null} if this map contains no mapping for the key.
     */
    @Override
    public V get(final Object key) {
        final int bucketId = index(key, numberOfBuckets);
        Node<K, V> currentNode = buckets[bucketId];
        while (currentNode != null) {
            if (currentNode.containsKey(key)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    /**
     * Removes the key-value pair with the specified key, returns this pair value
     * or {@code null} if this map contains no mapping for the key.
     */
    @Override
    public V remove(final Object key) {
        if (currentSize > 0) {
            final int bucketId = index(key, numberOfBuckets);

            Node<K, V> currentNode = buckets[bucketId];
            if (currentNode != null) {
                if (currentNode.containsKey(key)) {
                    final V value = currentNode.getValue();
                    buckets[bucketId] = currentNode.getNextNode();
                    currentSize--;
                    return value;
                }

                Node<K, V> nextNode;
                while ((nextNode = currentNode.getNextNode()) != null) {
                    if (nextNode.containsKey(key)) {
                        currentNode.setNextNode(nextNode.getNextNode());
                        currentSize--;
                        return nextNode.getValue();
                    }
                    currentNode = nextNode;
                }
            }
        }
        return null;
    }

    private static int index(final Object key, final int capacity) {
        return (key == null) ? 0 : key.hashCode() % capacity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
                .append("MyHashMap{size=").append(currentSize)
                .append(", capacity=").append(numberOfBuckets)
                .append(", buckets=");
        for (int i = 0; i < numberOfBuckets; i++) {
            sb.append("bucket[").append(i).append("]{");
            Node<K, V> node;
            if ((node = buckets[i]) != null) {
                sb.append(node);
                while ((node = node.getNextNode()) != null) {
                    sb.append(", ").append(node);
                }
            }
            sb.append('}');
        }
        return sb.append('}').toString();
    }
}

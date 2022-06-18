package project.entity;

/**
 * An object that maps keys to values. A map cannot contain duplicate keys.
 *
 * @param <K> the key values class
 * @param <V> the values class
 */
public interface MyMap<K, V> {

    /**
     * Returns the number of key-value pairs placed in this map.
     */
    int size();

    /**
     * Returns {@code true} if this map doesn't contain any key-value pairs.
     */
    boolean isEmpty();

    /**
     * Puts a key-value pair in the map. If the map previously contained a mapping for the key,
     * the old value is replaced with the new value.
     *
     * @return the previous value if it's been changed, or {@code null} otherwise
     */
    V put(K key, V value);

    /**
     * Returns {@code true} if this map contains a key-value pair with the key.
     */
    boolean containsKey(Object key);

    /**
     * Returns the value mapped with the specified key,
     * or {@code null} if this map contains no mapping for the key.
     */
    V get(Object key);

    /**
     * Removes the key-value pair with the specified key, returns this pair value
     * or {@code null} if this map contains no mapping for the key.
     */
    V remove(Object key);

}

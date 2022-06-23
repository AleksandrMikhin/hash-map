package project.proxy;

import project.entity.MyMap;

/**
 * This class provides an object that represents a proxy-pattern implementation for trainee.
 * <p>
 * Implemented methods of {@link MyMap} interface.
 */
public class ProxyMyMap<K, V> implements MyMap<K, V> {

    private final MyMap<K, V> realMyHashMap;

    /**
     * Constructor
     *
     * @param realMyHashMap a real proxied object
     */
    public ProxyMyMap(final MyMap<K, V> realMyHashMap) {
        this.realMyHashMap = realMyHashMap;
    }

     @Override
    public int size() {
        return realMyHashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return realMyHashMap.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        return realMyHashMap.put(key, value);
    }

    @Override
    public boolean containsKey(Object key) {
        return realMyHashMap.containsKey(key);
    }

    @Override
    public V get(Object key) {
        return realMyHashMap.get(key);
    }

    @Override
    public V remove(Object key) {
        return realMyHashMap.remove(key);
    }
}

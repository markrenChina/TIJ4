package Ex;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterMap <K,V> {
    private HashMap<K,V> hashMap;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public ReaderWriterMap( K[] key,V[] value) {
        this.hashMap = new HashMap<>(key.length);
        for (int i = 0; i < key.length; i++) {
            hashMap.put(key[i],value[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        new ReaderWriterMapTest(30,1);
    }

    public V set(K key, V value){
        Lock wlock = lock.writeLock();
        wlock.lock();
        try {
            return hashMap.put(key, value);
        } finally {
            wlock.unlock();
        }
    }

    public V get(K key) {
        Lock rlock = lock.readLock();
        rlock.lock();
        try {
            //Show that multiple readers
            //may acquire the read lock
            if (lock.getReadLockCount() > 1) {
                System.out.println(lock.getReadLockCount());
            }
            return hashMap.get(key);
        }finally {
            rlock.unlock();
        }
    }
}

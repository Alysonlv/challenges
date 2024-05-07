package corp.alv.challenges.general;

public class CustomHashMap<K, V> {
    private MapEntry<K, V>[] buckets;
    private int capacity; // 16

    private int size = 0;

    private double lf = 0.75;

    public CustomHashMap() {
        this(16);
    }

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new MapEntry[this.capacity];
    }

    public void put(K key, V value) {
        if (size == lf * capacity) {
            // rehash
            MapEntry<K, V>[] old = buckets;

            capacity *= 2;
            size = 0;
            buckets = new MapEntry[capacity];

            for (MapEntry<K,V> e : old) {
                while (e != null) {
                    put(e.key, e.value);
                    e = e.next;
                }
            }
        }
        MapEntry<K, V> mapEntry = new MapEntry<>(key, value, null);

        int bucket = getHash(key) % getBucketSize();
        MapEntry<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = mapEntry;
            size++;
        } else {
            // compare the keys see if key already exists
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = mapEntry;
                size++;
            }
        }
    }

    public V get(K key) {
        MapEntry<K, V> bucket = buckets[getHash(key) % getBucketSize()];

        while (bucket != null) {
            if (key == bucket.key) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int getBucketSize() {
        return buckets.length;
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MapEntry mapEntry : buckets) {
            sb.append("[");
            while (mapEntry != null) {
                sb.append(mapEntry);
                if (mapEntry.next != null) {
                    sb.append(", ");
                }
                mapEntry = mapEntry.next;
            }
            sb.append("]");
        }
        return "{" + sb.toString() + "}";
    }

    static class MapEntry<K, V> {
        final K key;
        V value;
        MapEntry<K, V> next;

        public MapEntry(K key, V value, MapEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public MapEntry<K, V> getNext() {
            return next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;

            if (obj instanceof CustomHashMap.MapEntry) {
                MapEntry mapEntry = (MapEntry) obj;

                return key.equals(mapEntry.getKey()) &&
                        value.equals(mapEntry.getValue());
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 13;
            hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
            hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
            return hash;
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }
}

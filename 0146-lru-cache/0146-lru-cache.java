class LRUCache {
    class CacheUnit {
        CacheUnit prev, next;
        int key, value;

        CacheUnit(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    CacheUnit head, tail;
    HashMap<Integer, CacheUnit> map;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        head = new CacheUnit(0, 0);
        tail = new CacheUnit(0, 0);
        head.next = tail;
        tail.prev = head;

        map = new HashMap();

        this.capacity = capacity;
        size = 0;
    }
    
    void detach(CacheUnit cacheUnit) {
        cacheUnit.prev.next = cacheUnit.next;
        cacheUnit.next.prev = cacheUnit.prev;
    }

    void prepend(CacheUnit cacheUnit) {
        head.next.prev = cacheUnit;
        cacheUnit.next = head.next;
        head.next = cacheUnit;
        cacheUnit.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        CacheUnit cacheUnit = map.get(key);
        if (head.next != cacheUnit) {
            detach(cacheUnit);
            prepend(cacheUnit);
        }

        return cacheUnit.value;
    }
    
    public void put(int key, int value) {
        CacheUnit cacheUnit;
        if (map.containsKey(key)) {
            cacheUnit = map.get(key);
            cacheUnit.value = value;
            
            if (head.next != cacheUnit) {
                detach(cacheUnit);
                prepend(cacheUnit);
            }
        } else {
            if (capacity > size) {
                cacheUnit = new CacheUnit(key, value);
                prepend(cacheUnit);
                size++;
            } else {
                cacheUnit = tail.prev;
                map.remove(cacheUnit.key);
                cacheUnit.key = key;
                cacheUnit.value = value;

                if (head.next != cacheUnit) {
                    detach(cacheUnit);
                    prepend(cacheUnit);
                }
            }
            
            map.put(key, cacheUnit);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
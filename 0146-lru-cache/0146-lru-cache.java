class LRUCache {
    class DLLNode {
        DLLNode prev, next;
        int key, val;

        DLLNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

    DLLNode head; 
    DLLNode tail;
    HashMap<Integer, DLLNode> mpp;
    int capacity;

    public LRUCache(int capacity) { //just used to instiantiate the values
        head = new DLLNode(-1,-1);
        tail = new DLLNode(-1,-1); 
        head.next = tail;
        tail.prev = head;

        mpp = new HashMap<>();

        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!mpp.containsKey(key)) return -1;
        DLLNode node = mpp.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) { 
        if(mpp.containsKey(key)) {
            DLLNode node = mpp.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
            mpp.put(key,node);
        }
        else{
            if(mpp.size() == capacity) {
                //DLLNode node = mpp.get(tail.prev.val);
                mpp.remove(tail.prev.key);
                deleteNode(tail.prev); 
            }
            DLLNode newNode = new DLLNode(key,value);
            insertAfterHead(newNode);
            mpp.put(key,newNode);
        }
    }

    public void deleteNode(DLLNode node) {
        DLLNode prevNode = node.prev;
        prevNode.next = node.next;
        node.next.prev = prevNode;
    }

    public void insertAfterHead(DLLNode node) { 
        DLLNode afterNode = head.next;
        head.next = node;
        node.prev = head;
        afterNode.prev = node;
        node.next = afterNode;
    }
}
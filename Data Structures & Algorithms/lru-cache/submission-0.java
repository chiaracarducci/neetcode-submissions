class LRUCache {

    int cap;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node n){
        map.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void insert(Node n){
        map.put(n.key, n);
        n.prev = tail.prev;
        tail.prev.next = n;
        tail.prev = n;
        n.next = tail;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node n = map.get(key);
        remove(n);
        insert(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.value = value;
            remove(n);
            insert(n);
            return;
        }
        if(map.size()>=cap){
            Node rem = head.next;
            remove(rem);
        }
        insert(new Node(key, value));
        
    }
}

public class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int k, int v){
        key=k;
        value=v;
    }
}

package ProblemSolving.Arrays.Cache;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static int capacity = 5;
    Map<String, Node> cacheMap;
    private Node head;
    private Node tail;

    public LRUCache() {
        cacheMap = new HashMap<>();
        head = new Node("head", "", 0L);
        tail = new Node("tail", "", 0L);
        head.next = tail;
        tail.prev = head;
    }

    public void put(String key, String value, int ttl) {
        if (cacheMap.size() >= capacity)
            evict();
        Node node = cacheMap.get(key);
        if (node != null) {
            if (isExpired(node.expiryTime)) {
                cacheMap.remove(key);
                removeNode(node);
            } else {
                node.expiryTime = System.currentTimeMillis() + (ttl * 60 * 1000);
                node.value = value;
                moveToHead(node);
                cacheMap.put(key, node);
            }
        } else {
            Node newNode = new Node(key, value, System.currentTimeMillis() + (ttl * 60 * 1000));
            cacheMap.put(key, newNode);
            addToHead(newNode);
        }
    }

    public void evict() {
        Node lru = tail.prev;
        if (lru != head) {
            cacheMap.remove(lru.key);
            removeNode(lru);
        }
    }

    public String get(String key) {
        moveToHead(cacheMap.get(key));
        return cacheMap.get(key).value;
    }

    private boolean isExpired(Long time) {
        return System.currentTimeMillis() > time;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public void display() {
        for (Map.Entry<String, Node> entry : cacheMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().value);
        }
        System.out.println("Displaying linked-list");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.key + "-> " );
            temp = temp.next;
        }
        System.out.println("null");
    }
}


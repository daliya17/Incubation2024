package ProblemSolving.Arrays.Cache;

import java.time.LocalDateTime;

public class Node {
    public String key;
    public String value;
    public Long expiryTime;
    public Node next;
    public Node prev;

    public Node(String key, String value, Long expiryTime) {
        this.key = key;
        this.value = value;
        this.expiryTime = expiryTime;
        this.next = null;
        this.prev = null;
    }
}

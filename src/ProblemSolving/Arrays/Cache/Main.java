package ProblemSolving.Arrays.Cache;

public class Main {
    public static void main(String[] args) {
//      LFUCache lfuCache = new LFUCache();
//      lfuCache.put("Hi","hi");
//      lfuCache.put("Hello","hello");
//      lfuCache.get("Hi");
//      lfuCache.get("Hi");
//      lfuCache.get("Hello");
//      lfuCache.put("My","my");
//      lfuCache.put("Hey","hey");
//      lfuCache.put("Ja","ja");
//      lfuCache.put("Cache","cca");
//      lfuCache.get("Ja");
//      lfuCache.display();
        LRUCache lruCache = new LRUCache();
        lruCache.put("Hi", "hi", 1);
        lruCache.put("Hello", "hello", 1);
        lruCache.get("Hi");
        lruCache.get("Hi");
        lruCache.get("Hello");
        lruCache.put("My", "my", 1);
        lruCache.put("Hey", "hey", 1);
        lruCache.put("Ja", "ja", 1);
        lruCache.put("Cache", "cca", 1);
        lruCache.get("Hello");
        lruCache.put("Put","put",1);
        lruCache.get("Hey");
        lruCache.display();
    }
}

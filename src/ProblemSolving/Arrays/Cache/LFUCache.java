package ProblemSolving.Arrays.Cache;

import java.util.*;

public class LFUCache {

    public static int capacity = 5;
    public static Map<String, CacheFreq> cacheFrequencyMap;
    public static Map<Integer, HashSet<String>> freqKeyMap;
    public int minFreq = 0;

    public LFUCache() {
        cacheFrequencyMap = new HashMap<>();
        freqKeyMap = new HashMap<>();
    }

    public void put(String key, String value) {
        if (cacheFrequencyMap.size() >= capacity)
            evict();
        if (!cacheFrequencyMap.containsKey(key)) {
            cacheFrequencyMap.put(key, new CacheFreq(value, 1));
            freqKeyMap.computeIfAbsent(1, k -> new HashSet<>()).add(key);
            minFreq = 1;
        } else {
            if (minFreq == cacheFrequencyMap.get(key).frequency)
                minFreq += 1;
            cacheFrequencyMap.compute(key, (k, cacheFrq) -> {
                cacheFrq.value = value;
                cacheFrq.frequency += 1;
                return cacheFrq;
            });
            freqKeyMap.computeIfAbsent(cacheFrequencyMap.get(key).frequency, k -> new HashSet<>()).add(key);
        }
    }

    public void evict() {
        String keyToRemove = freqKeyMap.get(minFreq).iterator().next();
        if (freqKeyMap.get(minFreq).size() == 0) {
            freqKeyMap.remove(minFreq);
            minFreq++;
        }
        cacheFrequencyMap.remove(keyToRemove);
    }

    public String get(String key) {
        if(!cacheFrequencyMap.containsKey(key))
           return null;
        increaseFrequency(key);
        return cacheFrequencyMap.get(key).value;
    }

    private void increaseFrequency(String key) {
        int oldFreq = cacheFrequencyMap.get(key).frequency;
        cacheFrequencyMap.computeIfPresent(key, (k, cache) -> {
            cache.frequency += 1;
            return cache;
        });
        int newFrq = oldFreq + 1;
        freqKeyMap.computeIfAbsent(newFrq, k -> new HashSet<>()).add(key);
        freqKeyMap.computeIfPresent(oldFreq, (k, set) -> {
            set.remove(key);
            return set;
        });
        if (freqKeyMap.get(oldFreq).size() <= 0){
            freqKeyMap.remove(oldFreq);
            if(minFreq==oldFreq)
                minFreq++;
        }
    }

    public void display() {
        for (Map.Entry<String, CacheFreq> entry : cacheFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().value + " Frequency " + entry.getValue().frequency);
        }
        System.out.println("Minimum Frq: " + minFreq);
        for (Map.Entry<Integer, HashSet<String>> entry : freqKeyMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }


}

package org.example;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
    private final int maxRequests;
    private final long windowSizeInMillis;
    private final Map<String, Deque<Long>> userRequests;

    public RateLimiter(int maxRequests, long windowSizeInSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInSeconds*1000;
        this.userRequests = new ConcurrentHashMap<>();
    }

    public synchronized boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();

        //Atomically create Deque if Absent
        Deque<Long> requests = userRequests.computeIfAbsent(userId, k -> new ArrayDeque<>());

        //lock only this user's queue
        synchronized (requests) {
            //Remove expired time stamps
            while (!requests.isEmpty() && now - requests.peekFirst() >= windowSizeInMillis) {
                requests.pollFirst();
            }
            if (requests.size() < maxRequests) {
                requests.offerLast(now);
                return true; // allowed
            }
            return false; // rate limited
        }
    }
}

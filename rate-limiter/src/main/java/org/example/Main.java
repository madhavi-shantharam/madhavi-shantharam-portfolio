package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(3, 5);
        String user = "user01";

        for(int i=1; i<=5; i++) {
            System.out.println("Request " + i + ": " + limiter.allowRequest(user));
            Thread.sleep(1000);
        }
    }
}

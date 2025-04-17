package school.sorokin.javacore.multithreading.lesson5;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ChatRoom {
    private final Queue<String> messages = new ConcurrentLinkedQueue<>();

    public void postMessage(String user, String text){
        System.out.println(user + " posted message: " + text);
        messages.add(text);
    }

    public List<String> getRecentMessages(int count){
        if (count > messages.size()) count = messages.size();
        return messages.stream().skip(messages.size() - count).peek((e) -> System.out.println("Reading message: " + e)).toList();
    }
}

package school.sorokin.javacore.multithreading.lesson5;



public class Client {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        for (int i = 1; i < 5; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> chatRoom.postMessage("User" + finalI, "Message" + finalI));
            thread.start();
        }

        Thread thread = new Thread(() -> chatRoom.getRecentMessages(2));
        thread.start();


    }
}

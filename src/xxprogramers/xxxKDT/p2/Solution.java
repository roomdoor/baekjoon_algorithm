package xxprogramers.xxxKDT.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static String[] solution(String[] records) {
        String[] answer = {};

        Stack<Message> notification = new Stack<>();
        ArrayList<String> saveCase = new ArrayList<>();

        for (String record : records) {
            if (record.equals("check notification")) {
                Message message = notification.pop();

                if (message.names.size() == 1) {
                    if (message.action.equals("share")) {
                        saveCase.add(message.names.get(0) + " shared your post");
                    } else {
                        saveCase.add(message.names.get(0) + " commented on your post");
                    }
                } else if (message.names.size() == 2) {
                    if (message.action.equals("share")) {
                        saveCase.add(message.names.get(0) + " and " + message.names.get(1) + " shared your post");
                    } else {
                        saveCase.add(message.names.get(0) + " and " + message.names.get(1) + " commented on your post");
                    }
                } else {
                    if (message.action.equals("share")) {
                        saveCase.add(message.names.get(0) + " and " + (message.names.size() - 1) + " others shared your post");
                    } else {
                        saveCase.add(message.names.get(0) + " and " + (message.names.size() - 1) + " others commented on your post");
                    }
                }

            } else {
                String[] split = record.split(" ");
                String name = split[0];
                String action = split[1];

                if (!notification.isEmpty() && notification.peek().action.equals(action)) {
                    Message message = notification.peek();
                    message.names.add(name);
                } else {
                    notification.push(new Message(name, action));
                }
            }
        }
        return saveCase.toArray(new String[0]);
    }

    private static class Message {
        List<String> names = new ArrayList<>();
        String action;

        public Message(String name, String action) {
            this.names.add(name);
            this.action = action;
        }
    }

    public static void main(String[] args) {
        String[] s = new String[]{"john share", "mary comment", "jay share", "check notification", "check notification", "sally comment", "james share", "check notification", "lee share", "laura share", "will share", "check notification", "alice comment", "check notification"};

        System.out.println(Arrays.toString(solution(s)));
    }
}

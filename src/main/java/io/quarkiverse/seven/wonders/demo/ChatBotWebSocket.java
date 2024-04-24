package io.quarkiverse.seven.wonders.demo;

import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;

@WebSocket(path = "/chatbot")
public class ChatBotWebSocket {

    private final ChatBot bot;


    public ChatBotWebSocket(ChatBot bot) {
        this.bot = bot;
    }

    @OnOpen
    public String onOpen() {
        return "Hello, I'm Voithos, how can I help you?";
    }

    @OnTextMessage
    public String onMessage(String message) {
        return bot.chat(message);
    }

}

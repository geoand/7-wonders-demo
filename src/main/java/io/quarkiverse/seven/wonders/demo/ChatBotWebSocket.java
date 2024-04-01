package io.quarkiverse.seven.wonders.demo;

import io.quarkiverse.langchain4j.ChatMemoryRemover;
import io.quarkus.websockets.next.OnClose;
import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;
import io.quarkus.websockets.next.WebSocketConnection;

@WebSocket(path = "/chatbot")
public class ChatBotWebSocket {

    private final ChatBot bot;
    private final WebSocketConnection connection;


    public ChatBotWebSocket(ChatBot bot, WebSocketConnection connection) {
        this.bot = bot;
        this.connection = connection;
    }

    @OnOpen
    public String onOpen() {
        return bot.chat(connection.id(), "hello");
    }

    @OnClose
    void onClose() {
        ChatMemoryRemover.remove(bot, connection.id());
    }

    @OnTextMessage
    public String onMessage(String message) {
        return bot.chat(connection.id(), message);
    }

}

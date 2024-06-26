package io.quarkiverse.seven.wonders.demo;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.SessionScoped;

@RegisterAiService
@SessionScoped
public interface ChatBot {

    @SystemMessage("""
            You are a useful AI chatbot that knows the rules of the board game 7 Wonders and is prepared to answer any user questions.
            Your response must be polite, use the same language as the question, and be relevant to the question.

            When you don't know, respond that you don't know the answer and point to the game's official documentation.
            """)
    String chat(@UserMessage String question);
    
}

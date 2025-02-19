package com.ai.SpringAiDemo.Service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service  // Ensure this annotation is present
public class ChatService {
    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt) {
        return chatModel.call(prompt);
    }

    public String getResponseOption(String prompt) {
        OpenAiChatOptions options = OpenAiChatOptions.builder()
                .model("gpt-4o")
                .temperature(0.4)
                .build();
        Prompt aiPrompt = new Prompt(prompt, options);

        return chatModel.call(aiPrompt).getResult().getOutput().getText();
    }
}

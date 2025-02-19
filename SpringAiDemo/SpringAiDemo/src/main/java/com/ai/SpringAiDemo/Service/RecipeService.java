package com.ai.SpringAiDemo.Service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class RecipeService {
    private final ChatModel chatModel;

    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String createRecipe(String ingredients,String cuisine,String dietaryRestrictions){
        var template = """
                I want to create a recipe using the following ingredients :{ingredients},
                The cuisine type i prefere is {cuisine}.
                Please consider the following dietary Restrictions: {dietaryRestrictions}.
                Please provide me with a detailed step by step recipe with list of ingredients and cooking instructions. 
                """;
        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, String> params = Map.of("ingredients",ingredients,
                "cuisine",cuisine,
                "dieateryRestrictions",dietaryRestrictions);
        Prompt prompt = promptTemplate.create((ChatOptions) params);
        return chatModel.call(prompt).getResult().getOutput().getText();
    }
}

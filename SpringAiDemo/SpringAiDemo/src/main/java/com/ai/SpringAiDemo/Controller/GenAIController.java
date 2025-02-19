package com.ai.SpringAiDemo.Controller; // Update this based on your actual package

import com.ai.SpringAiDemo.Service.ChatService;
import com.ai.SpringAiDemo.Service.ImageService;
import com.ai.SpringAiDemo.Service.RecipeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/genAi")  // Ensure this path starts with "/"
public class GenAIController {
    private final ChatService chatService;
    private final ImageService imageService;
    private final RecipeService recipeService;

    @Autowired
    public GenAIController(ChatService chatService,ImageService imageService,RecipeService recipeService){
        this.chatService = chatService;
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("/ask-ai")  // Ensure slash is used properly
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("/ask-ai-options")  // Ensure slash is used properly
    public String getResponseOption(@RequestParam String prompt){
        return chatService.getResponseOption(prompt);
    }

    /*@GetMapping("/ask-ai-options")  // Ensure slash is used properly
    public void getImageResponse(HttpServletResponse response, @RequestParam String prompt) throws IOException {
        ImageResponse imageResponse = imageService.generateImage(prompt);
        String imageUrl = imageResponse.getResult().getOutput().getUrl();
        response.sendRedirect(imageUrl);
    }*/

    @GetMapping("/generate-image")  // Ensure slash is used properly
    public List<String> generateImages(HttpServletResponse response,
                                       @RequestParam String prompt,
                                       @RequestParam(defaultValue = "hd") String quality,
                                       @RequestParam(defaultValue = "1") int n,
                                       @RequestParam(defaultValue = "1024") int width,
                                       @RequestParam(defaultValue = "1024") int height) throws IOException {
        ImageResponse imageResponse = imageService.generateImage(prompt, quality, n, width, height);
        List<String> urlList = imageResponse.getResults().stream().map(result -> result.getOutput().getUrl())
                .toList();
        return urlList;
    }

    @GetMapping("/create-recipe")  // Ensure slash is used properly
    public String recipeCreator(@RequestParam String ingredients,
                                @RequestParam(defaultValue = "any") String cuisine,
                                @RequestParam(defaultValue = "") String dietaryRestriction){
        return recipeService.createRecipe(ingredients,cuisine,dietaryRestriction);
    }
}


package com.ai.SpringAiDemo.Service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;

public class ImageService {
    private final OpenAiImageModel openAiImageModel;

    public ImageService(OpenAiImageModel openAiImageModel){
        this.openAiImageModel = openAiImageModel;
    }

    public ImageResponse generateImage(String prompt,String quality,int n,int width,int height){
        ImageResponse response = openAiImageModel.call(
                new ImagePrompt(prompt,
                        OpenAiImageOptions.builder()
                                .quality(quality)
                                .N(n)
                                .height(height)
                                .width(width).build()));
        return response;
    }
}

package com.ninad.llms;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;
import dev.langchain4j.model.output.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class OllamaStreamingChatExample {

    private static final Logger log = LoggerFactory.getLogger(OllamaStreamingChatExample.class);

    static final String GEMMA_MODEL = "gemma";


    public static void main(String[] args) {
        // Initialize Ollama model hosted locally
        OllamaStreamingChatModel model = OllamaStreamingChatModel.builder()
                .baseUrl("http://localhost:11434") // Default Ollama API endpoint
                .modelName(GEMMA_MODEL) // Use the pulled model
                .temperature(0.1) // Set the temperature
                .logRequests(true) // Enable request logging
                .logResponses(true) // Enable response logging
                .build();

        // Define the prompt
        String prompt = "Provide best practices for optimizing Java performance.";


        // Stream the AI-generated response
        CompletableFuture<Response<AiMessage>> futureResponse = new CompletableFuture<>();
        model.generate(prompt, new StreamingResponseHandler<AiMessage>() {
            @Override
            public void onNext(String token) {
                System.out.print(token);
            }
            @Override
            public void onComplete(Response<AiMessage> response) {
                futureResponse.complete(response);
            }
            @Override
            public void onError(Throwable error) {
                futureResponse.completeExceptionally(error);
            }

        });

    }
}

package com.ninad.llms;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.chain.ConversationalChain;
import dev.langchain4j.data.message.ChatMessage;

public class PromptEngineeringExample {
    public static void main(String[] args) {
        // Initialize OpenAI model with API key
        OpenAiChatModel model = OpenAiChatModel.withApiKey("<REPLACE_ME>");

        // Define a structured prompt
        String prompt = "As a senior Java developer, generate a well-optimized method to reverse a string efficiently.";

        // Get AI-generated response
        String response = model.generate(prompt);

        // Print the AI's response
        System.out.println("AI Response:\n" + response);
    }
}

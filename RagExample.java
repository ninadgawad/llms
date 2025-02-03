package com.ninad.llms;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.memory.InMemoryRetrievalAugmentedMemory;
import dev.langchain4j.memory.RetrievalAugmentedMemory;

public class RagExample {
    public static void main(String[] args) {
        // Initialize AI model
        OpenAiChatModel model = OpenAiChatModel.withApiKey("<REPLACE_ME>");
        
        // Create retrieval-augmented memory
        RetrievalAugmentedMemory memory = new InMemoryRetrievalAugmentedMemory();
        
        // Add contextual knowledge
        memory.add(new Document("Java best practices include using meaningful variable names and writing unit tests."));
        memory.add(new Document("To optimize SQL queries, use indexes and avoid SELECT *."));
        
        // Define a structured prompt with RAG
        String prompt = "How can I improve my Java code quality?";
        
        // Get AI-generated response
        String response = model.generate(prompt);
        
        // Print response
        System.out.println("AI Response:\n" + response);
    }
}

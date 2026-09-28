package org.ninad.router;

ChatClient chatClient;

public String ask(String message) {

    return chatClient.prompt()
            .user(message)
            .tools(orderTools)
            .call()
            .content();
}

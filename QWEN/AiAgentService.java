package org.ninad.router;
@Service
public class AiAgentService {

    private final ChatModel chatModel;

    public AiAgentService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String ask(String request) {

        String systemPrompt = """
            You are a Java software engineering assistant.
            Provide concise, production-oriented answers.
            Prefer Spring Boot and modern Java practices.
            """;

        Prompt prompt = new Prompt(List.of(
            new SystemMessage(systemPrompt),
            new UserMessage(request)
        ));

        return chatModel.call(prompt)
                .getResult()
                .getOutput()
                .getText();
    }
}

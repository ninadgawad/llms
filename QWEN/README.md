## Qwen3.5-9B
This a highly efficient, 9-billion parameter multimodal AI model released by Alibaba Cloud in March 2026.
It is designed to deliver frontier-class performance while remaining small enough to run locally on consumer hardware like a standard laptop or a single GPU. 

## Key FeaturesNative Multimodality: 
- Built using an "early fusion" approach, meaning it was trained on text, images, and video simultaneously from day one. - It natively understands documents, screenshots, and video clips.
- Advanced Architecture: Combines Gated Delta Networks (GDN) and hybrid attention. This unique layout provides exceptionally high-throughput speeds while keeping VRAM usage low.
- Massive Context Window: Supports a native 262,144-token context length (extensible up to 1 million+ tokens), allowing it to process entire books or large code repositories at once.
- Agentic Coding & Reasoning: Features an explicit "thinking mode" that writes out its chain of thought before answering. It punches well above its weight class, heavily outperforming much larger models on tool-calling, agent workflows, and coding tasks.
- Global Language Support: Features expanded capabilities covering 201 different languages and regional dialects.
- Open Source: Released under the Apache 2.0 license, making it entirely free for personal, research, or commercial self-hosting.

 ```
ollama --version
# ollama version is 0.34.2

ollama pull qwen3.5:9b
or
ollama run qwen3.5:9b
```

### Sample Prompt
```
Act as a Principal Staff Software Engineer and System Architect. 

I need to design a high-throughput, fault-tolerant Rate Limiter system distributed across multiple regions. It must support multiple strategy algorithms (Token Bucket, Leaky Bucket, and Sliding Window Log) configurable per API route via a YAML file. 

Provide a complete production-grade implementation in Python or Go. Your response must include:
1. System Architecture: Briefly state how you handle distributed state synchronization and race conditions (e.g., Redis Lua scripts vs. cell-rate algorithms).
2. The Code: A clean, modular, and highly concurrent implementation of the requested algorithms without skipping logic or using placeholders.
3. Thread Safety: Explicitly use mutexes, atomic operations, or connection pools safely.
4. Edge Cases & Unit Tests: Write a test suite that simulates a concurrent high-concurrency DDOS spike to prove the sliding window does not suffer from boundary race conditions.

Activate your deepest step-by-step thinking mode before outputting the code.

```

### Ollama exposes its API locally at:
```
http://localhost:11434
```

### Add Spring AI
```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-model-ollama</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

#### Configure Qwen3.5
application.yml:
```yml

spring:
  ai:
    ollama:
      base-url: http://localhost:11434
      chat:
        options:
          model: qwen3.5:9b
          temperature: 0.2

```


#### Expose a Java API

The key idea is that your REST API doesn't talk directly to Ollama.

```
Client
   ↓
REST API
   ↓
Agent Service
   ↓
Spring AI
   ↓
Ollama
   ↓
Qwen3.5 9B
```

#### Create an agent service:

```java
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

```

#### Spring AI's ChatModel abstraction means your application code isn't tightly coupled to Ollama.

```java

@RestController
@RequestMapping("/api/agent")
public class AgentController {

    private final AiAgentService agentService;

    public AgentController(AiAgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping
    public Map<String, String> ask(@RequestBody AgentRequest request) {

        String answer = agentService.ask(request.message());

        return Map.of("answer", answer);
    }
}
```

DTO:
```java
public record AgentRequest(String message) {
}
```


Now call:
```
curl -X POST http://localhost:8080/api/agent \
  -H "Content-Type: application/json" \
  -d '{"message":"Explain Java virtual threads in 3 bullet points"}'
```
### You have now built:
```
REST → AI Agent → Spring AI → Ollama → Qwen3.5 9B
```

### But this isn't really an Agent yet

This distinction is important.

A simple LLM call:
```
User → LLM → Response
```
is AI-assisted application logic.

An agent becomes interesting when the model can decide:
```
User
 ↓
Agent
 ↓
Reason about task
 ↓
Select Tool
 ↓
Execute Tool
 ↓
Observe result
 ↓
Decide next action
 ↓
Final response

```


#### Spring AI's Ollama integration supports tool calling, where the model requests a tool and Spring AI handles the tool execution.

A simple tool can look like:

```java
@Component
public class OrderTools {

    @Tool(description = "Get the current status of an order")
    public String getOrderStatus(String orderId) {

        // Call database/service
        return "Order " + orderId + " is SHIPPED";
    }
}
```

Then expose the tool through the Spring AI ChatClient:

```java
ChatClient chatClient;

public String ask(String message) {

    return chatClient.prompt()
            .user(message)
            .tools(orderTools)
            .call()
            .content();
}
```

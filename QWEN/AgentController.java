package org.ninad.router;

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

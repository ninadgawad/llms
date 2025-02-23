## Running llama3.2:latest locally command line

**Step1:** Download the Llama model
```shell
ollama pull llama3.2:latest
```

**Step2:** Create Modelfile with system prompt and temperature setting
```shell
ollama create nice -f ./Modelfile
```

**Step3:** Run the custom nice model
```
ollama run nice
```

**Sample Question:**
```
>>> What is your name ?
>>> My name is Nice. I'm here to help answer your questions!
```


## Running llama3.2:latest locally API

## Various Endpoints
**Tags:**
http://localhost:11432/api/tags

**Generate:**
http://localhost:11432/api/generate

**Chat:**
http://localhost:11432/api/chat







**Reference:**
***
Ollama Docs: https://github.com/ollama/ollama/blob/main/docs/api.md

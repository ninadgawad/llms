## Running llama3.2:latest locally

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

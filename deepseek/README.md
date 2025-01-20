## DeepSeek R1 

### Install on Ollama
```
ollama run deepseek-r1
```

## Start the OpenUI
```
docker run -d -p 3000:8080 --add-host=host.docker.internal:host-gateway -v open-webui:/app/backend/data --name open-webui --restart always ghcr.io/open-webui/open-webui:main
```

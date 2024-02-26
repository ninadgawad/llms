## LLaMA
LLaMA stands for Large Language Model Meta AI. 
It is a family of autoregressive large language models released by Meta AI, with the first version introduced in February 2023. 
LLaMA models come in different sizes, with the initial release including models with 7, 13, 33, and 65 billion parameters. 
These models are based on the transformer architecture and have some architectural differences compared to other large language models like GPT-3. 
LLaMA focuses on scaling performance by increasing the volume of training data rather than just the number of parameters. 
The dataset used for training LLaMA contains approximately 1.2 trillion tokens


### How to install LLaMA

**Step1:** Install Miniconda - [Link](https://docs.anaconda.com/free/miniconda/)
```
curl https://repo.anaconda.com/miniconda/Miniconda3-latest-Windows-x86_64.exe -o miniconda.exe
start /wait "" miniconda.exe /S
del miniconda.exe
```

**Step2:** Create conda envrionment 
```
conda create -n myenv python=3.12
conda active myenv
```

**Step3:** Install pytorch
```
pip3 install torch torchvisiontorchaudio
```

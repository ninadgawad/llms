# Large Language Models (LLMs)
LLMs typically stand for Large Language Models. These are advanced natural language processing models that use deep learning techniques, particularly variants of the transformer architecture, to understand and generate human-like text. 
LLMs are capable of a wide range of language-related tasks, including language translation, text summarization, question answering, sentiment analysis, and more. Examples of LLMs include OpenAI's GPT (Generative Pre-trained Transformer) series, Google's BERT (Bidirectional Encoder Representations from Transformers), and Facebook's RoBERTa (Robustly optimized BERT approach). 
These models are trained on vast amounts of text data and can generate coherent and contextually relevant responses to a variety of prompts.


## Top 5 LLMs currently
1. GPT-3 (Generative Pre-trained Transformer 3) by OpenAI
2. BERT (Bidirectional Encoder Representations from Transformers) by Google
3. RoBERTa (Robustly optimized BERT approach) by Facebook
4. T5 (Text-To-Text Transfer Transformer) by Google
5. XLNet by Google/CMU



## Prompt Engineering 
Prompt engineering is the practice of designing and refining prompts, which are questions or instructions, to draw out specific responses from generative AI models. 
This involves crafting the right questions or instructions to guide AI models, especially Large Language Models (LLMs), to produce desired outcomes
The process combines elements of logic, coding, art, and special modifiers, and the prompts can include natural language text, images, or other types of input data
Prompt engineering is crucial for creating better AI-powered services and getting better results from existing generative AI tools


## Prompt Crafting 
Prompt crafting is the process of creating and refining inputs or instructions (prompts) to guide AI systems, particularly language models like GPT, in generating specific and relevant responses or outputs.
It involves understanding the user's expectations, the constraints of the environment, and the context in which the prompt is being used
Effective prompt crafting is crucial for harnessing the full potential of AI-generated content and can lead to more accurate and useful responses, helping achieve goals more efficiently

### Few Examples of well-crafted prompts:
1. Task: Define Purpose
2. Context: Provide Relevant Information
3. Query: Frame Question
4. Constraints: Guide the Response
5. Format: Structure Your Prompt


### Google's Whitepaper on Agents [Link to Google's Whitepaper on LLM Agents](https://www.kaggle.com/whitepaper-agents?trk=public_post_comment-text)
This whitepaper explores the concept of Generative AI agents, detailing their core components and applications. ​ 
It explains how agents extend the capabilities of language models by using tools to access real-time information and perform complex tasks autonomously. ​ 
Key components include the model (language model), tools (extensions, functions, data stores), and the orchestration layer (decision-making process). ​ 
The document also covers various reasoning frameworks and techniques to enhance model performance. ​ Practical examples using LangChain and Vertex AI are provided to illustrate the implementation and deployment of these agents.

The main components of an agent are:
- The Model
- The Tools
- The Orchestration Layer


## Key Protocol Differences at a Glance

| **Aspect**            | **MCP**                                                                 | **ACP (BeeAI + IBM)**                                                            | **A2A**                                                                                   |
|-----------------------|------------------------------------------------------------------------|----------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| **Primary Focus**     | Providing data/tools context to LLMs                                   | Communicating across multiple BeeAI agents in a local-first setting             | Enabling agent-to-agent interoperability across frameworks                                |
| **Typical Deployment**| Multiple servers, each exposing data, integrated by an MCP host        | BeeAI Server orchestrates open-source agents in a single environment            | Agents on separate frameworks discover & connect via HTTP endpoints                       |
| **Key Feature**       | Standard “port” for hooking up data and external services to LLMs      | Easy multiagent setups, agent discovery, plus deep telemetry in BeeAI           | “Agent card” discovery, tasks with streaming updates, multi-agent synergy                 |
| **Most Common Use**   | Single or multiple LLMs that need consistent ways to ingest context    | Spin up a variety of AI agents behind BeeAI’s local-first approach              | Linking disparate agent vendors so they can share tasks & capabilities                    |




# AI Tools
![AI Tools](https://github.com/ninadgawad/llms/blob/main/images/AI%20Tools.drawio.png)



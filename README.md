# SeniorSmart

## Ideia do Projeto

*O nosso projeto é focado em pessoas a partir de 50 anos que possuem dificuldade em utilizar computadores, smartphones e outros eletroeletrônicos. Ele consiste em um aplicativo que utiliza um chatbot com inteligência artificial, capaz de responder perguntas personalizadas para cada problema ou dúvida do usuário.*

<br>

## Ilustração de funcionamento do aplicativo *SeniorSmart*

<br>

<img src="image/Digital Business - SeniorSmart.png" width="auto">

<br>

### [Video da Solução](https://www.youtube.com/watch?v=ls8f8prUG8E&feature=youyu.be)

<hr>

<br>

## Existe diferença entre o projeto atual e a proposta da sprint 1?

Diferente da primeira entrega nós optamos por não utilizar IoT na nossa solução, pois vimos que grande parte das tarefas a serem feitas não teria a necessidade de abordar essa tecnologia.

<br>
<br>

## Bibliotecas utilizadas

 - Realizaçao da comunicação entre o chatbot e a API do ChatGPT optamos por utilizar a biblioteca [lilittlecat](https://mvnrepository.com/artifact/com.lilittlecat/chatgpt).  
 ```
    ChatGPT chatGPT = new ChatGPT("SUA API DO CHATGPT");
    String resp = chatGPT.ask(configuration + novaPergunta.getPergunta());
    System.out.println(resp);
 ```
<br>

 - Conversão da lista de resposta foi utilizada a biblioteca [GSON](https://mvnrepository.com/artifact/com.google.code.gson/gson) da Google.  

 ```
    List<Resposta> respostas = respostaRepository.findAll();
    Gson gson = new GsonBuilder().create();
    String respostaJson = gson.toJson(respostas);
    System.out.println(respostaJson);
 ```
<br>

 - Configurar o servidor HTTP utilizamos a biblioteca [Spark](https://mvnrepository.com/artifact/com.sparkjava/spark-core).  

 ```
    Spark.port(8080); // definir a porta para 8080
    Spark.get("/", (req, res) -> {
        res.type("application/json"); // definir o tipo de conteúdo como JSON
        return respostaJson; // enviar a resposta JSON
    });
 ```
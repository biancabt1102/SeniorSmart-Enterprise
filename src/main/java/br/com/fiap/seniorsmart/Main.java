package br.com.fiap.seniorsmart;

import br.com.fiap.seniorsmart.models.Pergunta;
import br.com.fiap.seniorsmart.models.Resposta;
import br.com.fiap.seniorsmart.repositories.PerguntaRepository;
import br.com.fiap.seniorsmart.repositories.RespostaRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.lilittlecat.chatgpt.offical.ChatGPT;
import spark.Spark;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = entityManagerFactory.
                createEntityManager();

        PerguntaRepository perguntaRepository = new PerguntaRepository(entityManager);

        String configuration = "Sou um idoso, me responda de uma forma fácil de entender, a pergunta: ";

        Pergunta novaPergunta = new Pergunta();
        novaPergunta.setPergunta("O que é virus de computador?");
        perguntaRepository.save(novaPergunta);

        ChatGPT chatGPT = new ChatGPT("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");
        String resp = chatGPT.ask(configuration + novaPergunta.getPergunta());
        System.out.println(resp);

        RespostaRepository respostaRepository = new RespostaRepository(entityManager);
        Resposta novaResposta = new Resposta();
        novaResposta.setResposta(resp);
        novaResposta.setPergunta(novaPergunta);
        respostaRepository.save(novaResposta);

        List<Resposta> respostas = respostaRepository.findAll();
        Gson gson = new GsonBuilder().create();
        String respostaJson = gson.toJson(respostas);
        System.out.println(respostaJson);

        // configurar o servidor HTTP
        Spark.port(8080); // definir a porta para 8080
        Spark.get("/", (req, res) -> {
            res.type("application/json"); // definir o tipo de conteúdo como JSON
            return respostaJson; // enviar a resposta JSON
        });

        entityManager.close();
        entityManagerFactory.close();
    }
}

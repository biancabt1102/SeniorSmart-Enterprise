package br.com.fiap.seniorsmart.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_SS_RESPOSTA")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_resposta")
    private long id;

    @Column(name = "ds_resposta", nullable = false, length = 2049)
    private String resposta;

    @OneToOne
    @JoinColumn(name = "cd_pergunta")
    private Pergunta pergunta;
}

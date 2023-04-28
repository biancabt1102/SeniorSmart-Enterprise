package br.com.fiap.seniorsmart.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_SS_PERGUNTAS")
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_pergunta")
    private Long id;

    @Column(name = "ds_pergunta", nullable = false, length = 2049)
    private String pergunta;
}

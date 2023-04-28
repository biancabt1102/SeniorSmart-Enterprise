package br.com.fiap.seniorsmart.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_SS_USUARIO_PERGUNTAS")
public class UsuarioPergunta {
    
    @EmbeddedId
    @ManyToOne @JoinColumn(name = "cd_usuario")
    private Usuario usuario;

    @EmbeddedId
    @ManyToOne @JoinColumn(name = "cd_pergunta")
    private Pergunta pergunta;
}

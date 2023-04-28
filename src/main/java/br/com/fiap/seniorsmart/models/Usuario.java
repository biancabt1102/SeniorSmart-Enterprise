package br.com.fiap.seniorsmart.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_SS_USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_usuario")
    private Long id;

    @Column(name = "nm_usuario", nullable = false)
    private String nome;

    @Column(name = "ds_email", nullable = false)
    private String email;

    @Column(name = "ds_senha", nullable = false)
    private String senha;

    @Transient
    private String confirmarSenha;

    @Column(name = "dt_nascimento", nullable = false)
    private Date data;

    @Column(name = "nr_telefone", nullable = false)
    private String telefone;

    @ManyToOne @JoinColumn(name = "cd_plano")
    private Plano plano;
}

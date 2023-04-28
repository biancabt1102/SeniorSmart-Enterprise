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
@Table(name = "T_SS_FORMA_DE_PAGAMENTO")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_cartao")
    private Long id;

    @Column(name = "nm_cartao", nullable = false)
    private String nomeNoCartao;

    @Column(name = "nr_cartao", nullable = false)
    private String numeroDoCartao;

    @Column(name = "dt_vencimento", nullable = false)
    private Date validadeDoCartao;

    @Column(name = "nr_cvv", nullable = false)
    private String codigoDoCartao;

    @ManyToOne
    @JoinColumn(name = "cd_plano")
    private Plano plano;
}

package br.com.fiap.seniorsmart.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_SS_PLANO")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_plano")
    private Long id;

    @Column(name = "ds_plano", nullable = false)
    private String tipoPlano;

    @Column(name = "vl_plano_mensal", nullable = false)
    private BigDecimal planoMensal;

    @Column(name = "vl_plano_anual", nullable = false)
    private BigDecimal planoAnual;
}

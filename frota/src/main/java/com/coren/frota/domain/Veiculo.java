package com.coren.frota.domain;

import com.coren.frota.domain.enums.StatusVeiculo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "veiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String placa;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Column(nullable = false, length = 50)
    private String marca;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusVeiculo status = StatusVeiculo.DISPONIVEL;

    @Column(nullable = false)
    private Integer quilometragemAtual;
}
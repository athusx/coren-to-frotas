package com.coren.frota.domain;

import com.coren.frota.domain.enums.StatusViagem;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "viagens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamentos com Usuário e Veículo
    @ManyToOne(optional = false)
    @JoinColumn(name = "solicitante_id")
    private Usuario solicitante;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    // Dados do Formulário de Solicitação
    @Column(nullable = false, length = 255)
    private String nomesPassageiros;

    @Column(nullable = false, length = 1000)
    private String objetivo;

    @Column(nullable = false)
    private LocalDateTime dataHoraSaidaPrevista;

    @Column(nullable = false)
    private LocalDateTime dataHoraRetornoPrevista;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusViagem status = StatusViagem.PENDENTE_APROVACAO;

    // Dados Reais (Preenchidos no momento da saída/chegada - Formulários I e V)
    private LocalDateTime dataHoraSaidaReal;
    private Integer kmSaida;

    private LocalDateTime dataHoraRetornoReal;
    private Integer kmChegada;

    // Checklist de devolução
    private Boolean limpezaInternaOk;
    private Boolean limpezaExternaOk;
    private Boolean tanqueCheio; // Regra obrigatória do Manual 222

    @Column(length = 1000)
    private String observacoesAvarias;
}
package com.dash.raquel.dto;

import com.dash.raquel.model.Pedido;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class DashboardDTO {
    private BigDecimal receitaTotal;
    private long totalPedidos;
    private BigDecimal ticketMedio;
    private long clientesNovos;
    private List<Pedido> ultimosPedidos;
    private Map<String, BigDecimal> receitaPorMes; //mapeia as receitas em mes
    private Map<String, Long> vendasPorCategoria; //mapeia as vendas por categoria
    private Map<String, Long> vendasPorRegiao;
}

package com.dash.raquel.service;

import com.dash.raquel.dto.DashboardDTO;
import com.dash.raquel.model.Pedido;
import com.dash.raquel.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class VendasService {

    @Autowired
    private PedidoRepository repository;

    public DashboardDTO getDashboard() {
        DashboardDTO dto = new DashboardDTO();

        BigDecimal receita = repository.calcularReceitaTotal();
        dto.setReceitaTotal(receita != null ? receita : BigDecimal.ZERO);

        BigDecimal ticket = repository.calcularTicketMedio();
        dto.setTicketMedio(ticket != null ? ticket : BigDecimal.ZERO);

        dto.setTotalPedidos(repository.count());
        dto.setClientesNovos(repository.contarClientesNoMes());
        dto.setUltimosPedidos(repository.findTop10ByOrderByDataDesc());

        // Receita por mês
        Map<String, BigDecimal> receitaMes = new LinkedHashMap<>();
        String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
        for (Object[] row : repository.receitaPorMes()) {
            int mes = ((Number) row[0]).intValue();
            BigDecimal total = (BigDecimal) row[1];
            receitaMes.put(meses[mes - 1], total);
        }
        dto.setReceitaPorMes(receitaMes);

        // Vendas por categoria
        Map<String, Long> categorias = new LinkedHashMap<>();
        for (Object[] row : repository.vendasPorCategoria()) {
            String nomeCategoria = (row[0] != null) ? String.valueOf(row[0]) : "Outros";
            Long qtdCategoria = (row[1] != null && row[1] instanceof Number) ? ((Number) row[1]).longValue() : 0L;
            categorias.put(nomeCategoria, qtdCategoria);
        }
        dto.setVendasPorCategoria(categorias);

        Map<String, Long> regiao = new LinkedHashMap<>(); // Corrigido a falta da vírgula
        for (Object[] row : repository.vendasPorRegiao()) {
            String nomeRegiao = (row[0] != null) ? String.valueOf(row[0]) : "Desconhecido";
            Long qtdRegiao = (row[1] != null && row[1] instanceof Number) ? ((Number) row[1]).longValue() : 0L;
            regiao.put(nomeRegiao, qtdRegiao);
        }
        dto.setVendasPorRegiao(regiao);

        return dto;

    }

    public List<Pedido> listarPedidos() {

        return repository.findAll();
    }

    public Pedido salvarPedido(Pedido pedido) {
        return repository.save(pedido);
    }

    public void deletarPedido(Long id) {
        repository.deleteById(id);
    }



}
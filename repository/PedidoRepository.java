package com.dash.raquel.repository;

import com.dash.raquel.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findTop10ByOrderByDataDesc();

    @Query ("SELECT SUM(p.valor) FROM Pedido p")
    BigDecimal calcularReceitaTotal();

    @Query("SELECT AVG(p.valor) FROM Pedido p")
    BigDecimal calcularTicketMedio();

    @Query("SELECT COUNT(DISTINCT p.cliente) FROM Pedido p WHERE MONTH(p.data) = MONTH(CURRENT_DATE) AND YEAR(p.data) = YEAR(CURRENT_DATE)")
    long contarClientesNoMes();

    @Query("SELECT MONTH(p.data) as mes, SUM(p.valor) as total FROM Pedido p WHERE YEAR(p.data) = YEAR(CURRENT_DATE) GROUP BY MONTH(p.data) ORDER BY mes")
    List<Object[]> receitaPorMes();

    @Query("SELECT p.categoria, COUNT(p) FROM Pedido p GROUP BY p.categoria")
    List<Object[]> vendasPorCategoria();
}

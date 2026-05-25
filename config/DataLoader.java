package com.dash.raquel.config;

import com.dash.raquel.model.Pedido;
import com.dash.raquel.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PedidoRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() > 0) return; // só insere se estiver vazio

        String[][] dados = {
            {"Ana Souza",      "Notebook Pro",     "Eletrônicos", "3200.00", "Entregue",    "2025-01-15"},
            {"Maria Oliveira", "Smart TV 50\"",    "Eletrônicos", "2890.00", "Entregue",    "2025-02-05"},
            {"João Santos",    "Cafeteira",        "Casa",        "310.00",  "Processando", "2025-02-10"},
            {"Lucia Ferreira", "iPhone 15",        "Eletrônicos", "4500.00", "Entregue",    "2025-02-18"},
            {"Bruno Mendes",   "Tablet Samsung",   "Eletrônicos", "1200.00", "Entregue",    "2025-03-22"},
            {"Camila Rocha",   "Vestido Floral",   "Roupas",      "220.00",  "Processando", "2026-04-01"},
            {"Julia Pinto",    "Sofá 3 lugares",   "Casa",        "2100.00", "Entregue",    "2025-04-15"},
            {"Diego Souza",    "Smartwatch",       "Eletrônicos", "980.00",  "Em trânsito", "2025-05-03"},
            {"Amanda Lima",    "Blusa Moletom",    "Roupas",      "120.00",  "Entregue",    "2025-05-10"},
            {"Isabela Melo",   "MacBook Air",      "Eletrônicos", "7200.00", "Processando", "2025-05-22"},
                {"Raquel Barros", "Notebook Acer", "Eletrônicos", "4000.00", "Entregue",    "2026-01-20"},
        };

        for (String[] d : dados) {
            Pedido p = new Pedido();
            p.setCliente(d[0]);
            p.setProduto(d[1]);
            p.setCategoria(d[2]);
            p.setValor(new BigDecimal(d[3]));
            p.setStatus(d[4]);
            p.setData(LocalDate.parse(d[5]));
            repository.save(p);
        }

        System.out.println("Dados fictícios inseridos com sucesso!");
    }
}

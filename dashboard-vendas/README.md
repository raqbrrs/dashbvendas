# Dashboard de Vendas — Raquel

## Estrutura do projeto

```
dashboard-vendas/
├── backend/          ← Projeto Spring Boot (Java)
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/dash/raquel/
│       │   ├── DashboardVendasApplication.java  ← classe principal
│       │   ├── controller/VendasController.java
│       │   ├── service/VendasService.java
│       │   ├── repository/PedidoRepository.java
│       │   ├── model/Pedido.java
│       │   ├── dto/DashboardDTO.java
│       │   └── config/DataLoader.java           ← insere dados de exemplo
│       └── resources/
│           └── application.properties
└── frontend/
    └── index.html    ← abra no navegador
```



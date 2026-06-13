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

---

## Passo a passo para rodar

### 1. Criar o banco no MySQL

Abra o MySQL Workbench ou terminal e rode:

```sql
CREATE DATABASE vendas_db;
```

### 2. Configurar a senha no backend

Edite o arquivo `backend/src/main/resources/application.properties`:

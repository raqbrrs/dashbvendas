# 📈 Dashboard de Vendas com Spring Boot & Chart.js 
# Status: Trabalhando no Projeto (incompleto)

Este é um projeto prático e minimalista de um **Dashboard Web** que exibe relatórios gráficos de faturamento mensal. A aplicação utiliza uma arquitetura separada, onde o **Java (Spring Boot)** atua como uma API REST fornecendo os dados e o **Frontend (HTML/JavaScript)** renderiza os gráficos de forma dinâmica.

---

## 🛠️ Tecnologias Utilizadas

### **Backend**
* **Java 21**
* **Spring Boot**
* **Spring Data JPA** (Persistência de dados)
* **H2 Database** (Banco de dados em memória para testes rápidos)

### **Frontend**
* **HTML5 & CSS3** (Estrutura e estilização)
* **JavaScript (Vanilla)** (Consumo da API via Fetch)
* **Chart.js** (Biblioteca para renderização de gráficos interativos)

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


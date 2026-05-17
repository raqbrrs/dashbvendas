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

---

## 📂 Estrutura Principal de Arquivos

```text
meu-projeto-dashboard/
├── src/
│   ├── main/
│   │   ├── java/com/exemplo/dashboard/
│   │   │   ├── Venda.java               # Entidade que mapeia os dados
│   │   │   ├── VendaRepository.java     # Comunicação com o banco de dados
│   │   │   └── VendaController.java     # Endpoint API que disponibiliza o JSON
│   │   └── resources/
│   │       └── static/                  # Pasta pública do Frontend
│   │           ├── index.html           # Interface estrutural do Dashboard
│   │           └── app.js               # Lógica que consome a API e gera o gráfico
└── README.md

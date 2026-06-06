# 📊 Dashboard de Vendas - Análise de Faturamento

<div align="center">

![Status do Projeto](https://img.shields.io/badge/status-em%20desenvolvimento-F7B801?style=for-the-badge&logo=github&logoColor=white)
![Java](https://img.shields.io/badge/Java-21-F89820?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Chart.js](https://img.shields.io/badge/Chart.js-4.4.0-FF6384?style=for-the-badge&logo=chartdotjs&logoColor=white)
![Licença](https://img.shields.io/badge/licença-MIT-2563EB?style=for-the-badge&logo=open-source-initiative&logoColor=white)

**Transforme dados brutos em insights visuais poderosos para tomada de decisão**

[Funcionalidades](#-funcionalidades) • [Instalação](#-guia-de-instalação) • [API](#-documentação-da-api) • [Contribuição](#-contribuição)

</div>

---

## 📋 Visão Geral

Solução completa para visualização de métricas de vendas, combinando a robustez do ecossistema Spring com a elegância da visualização de dados moderna. O sistema oferece uma experiência fluida de análise de faturamento através de gráficos interativos e responsivos.

### 🎯 Objetivo do Projeto

Fornecer uma ferramenta intuitiva e visual para gestores acompanharem o desempenho de vendas, identificarem tendências e tomarem decisões baseadas em dados em tempo real.

---

## ✨ Funcionalidades

### Dashboard Principal
- **Gráfico de Faturamento Mensal** - Visualização temporal com suavização de curvas
- **Distribuição por Categoria** - Gráfico de rosca interativo com legendas
- **Métricas de Performance** - Cards com indicadores-chave de negócio
- **Filtro por Período** - Seletor de intervalo de datas personalizado

### Backend (API REST)
- Arquitetura em camadas (Controller → Service → Repository)
- DTOs otimizados para redução de payload
- Validação de dados com Bean Validation
- Migrations automáticas com JPA/Hibernate
- Tratamento global de exceções

---

## 🛠️ Stack Tecnológica

<div align="center">

<table>
<tr>
<td align="center" width="50%">

### ⚙️ Backend

<img src="https://skillicons.dev/icons?i=java,spring,maven" />

<br><br>

<img src="https://img.shields.io/badge/Spring_Data_JPA-59666C?style=for-the-badge&logo=spring&logoColor=white"/>

</td>

<td align="center" width="50%">

### 🎨 Frontend

<img src="https://skillicons.dev/icons?i=html,css,js" />

<br><br>

<img src="https://img.shields.io/badge/Chart.js-FF6384?style=for-the-badge&logo=chartdotjs&logoColor=white"/>

</td>
</tr>
</table>

</div>

---

## 📁 Estrutura do Projeto

```bash
dashboard-vendas/
│
├── backend/                              # Aplicação Spring Boot
│   ├── pom.xml                           # Dependências Maven
│   └── src/main/
│       ├── java/com/dash/raquel/
│       │   ├── DashboardVendasApplication.java
│       │   ├── config/
│       │   │   ├── DataLoader.java       # Seed do banco
│       │   │   └── CorsConfig.java       # Configuração CORS
│       │   ├── controller/
│       │   │   └── VendasController.java # Endpoints REST
│       │   ├── dto/
│       │   │   ├── DashboardDTO.java     # DTO principal
│       │   │   └── PedidoRequestDTO.java # DTO de entrada
│       │   ├── exception/
│       │   │   └── GlobalExceptionHandler.java
│       │   ├── model/
│       │   │   └── Pedido.java           # Entidade JPA
│       │   ├── repository/
│       │   │   └── PedidoRepository.java
│       │   └── service/
│       │       └── VendasService.java    # Lógica de negócio
│       └── resources/
│           └── application.properties   # Configurações
│
└── frontend/
    ├── index.html                       # Dashboard completo
    ├── css/
    │   └── style.css                    # Estilos responsivos
    └── js/
        └── dashboard.js                 # Lógica dos gráficos
```

---

## 📡 Documentação da API

### Endpoints Disponíveis

| Método | Endpoint | Descrição | Status Codes |
|--------|----------|-----------|--------------|
| `GET` | `/api/dashboard` | Retorna métricas consolidadas | `200 OK` |
| `GET` | `/api/pedidos` | Lista todos os pedidos | `200 OK` |
| `POST` | `/api/pedidos` | Cria um novo pedido | `201 Created` / `400 Bad Request` |
| `DELETE` | `/api/pedidos/{id}` | Remove um pedido | `204 No Content` / `404 Not Found` |

### Exemplo de Resposta - `/api/dashboard`

```json
{
  "faturamentoTotal": 45678.90,
  "totalPedidos": 142,
  "ticketMedio": 321.68,
  "faturamentoPorMes": {
    "Janeiro": 15230.50,
    "Fevereiro": 13890.75,
    "Março": 16557.65
  },
  "categorias": {
    "Eletrônicos": 35.5,
    "Vestuário": 28.3,
    "Alimentos": 22.1,
    "Outros": 14.1
  }
}
```

### Exemplo de Requisição - `POST /api/pedidos`

```json
{
  "valor": 299.90,
  "categoria": "Eletrônicos",
  "data": "2024-03-15",
  "cliente": "João Silva"
}
```

---

## 🧪 Testando a API

### Usando cURL

```bash
# Obter dashboard
curl http://localhost:8080/api/dashboard

# Criar pedido
curl -X POST http://localhost:8080/api/pedidos \
  -H "Content-Type: application/json" \
  -d '{"valor": 199.90, "categoria": "Eletrônicos", "data": "2024-03-20", "cliente": "Maria Souza"}'

# Listar pedidos
curl http://localhost:8080/api/pedidos
```

---

## 🏗️ Arquitetura do Sistema

```bash
┌─────────────────────────────────────────────────────────┐
│                     NAVEGADOR                           │
│  ┌───────────────────────────────────────────────────┐  │
│  │              Chart.js + Fetch API                 │  │
│  └───────────────────┬───────────────────────────────┘  │
└──────────────────────┼──────────────────────────────────┘
                       │ HTTP/REST
┌──────────────────────┼──────────────────────────────────┐
│                 SPRING BOOT                             │
│  ┌───────────────────┴───────────────────────────────┐  │
│  │            VendasController.java                  │  │
│  └───────────────────┬───────────────────────────────┘  │
│  ┌───────────────────┴───────────────────────────────┐  │
│  │             VendasService.java                    │  │
│  └───────────────────┬───────────────────────────────┘  │
│  ┌───────────────────┴───────────────────────────────┐  │
│  │          PedidoRepository.java                    │  │
│  └───────────────────┬───────────────────────────────┘  │
│                      │                                   │
│  ┌───────────────────┴───────────────────────────────┐  │
│  │              H2 Database (Memória)                │  │
│  └───────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────┘
```

---

## 🎯 Roadmap

- [x] CRUD básico de pedidos
- [x] Dashboard com Chart.js
- [x] Filtro por período
- [x] Autenticação JWT
- [x] Exportação CSV/PDF
- [x] Testes unitários (JUnit + Mockito)
- [ ] Deploy em nuvem (Railway/Heroku)
- [ ] Comparativo ano vs ano
- [ ] Front - End

---

## 👩‍💻 Autor

<div align="center">

### Desenvolvido por Raquel

<a href="https://github.com/raqbrrs">
  <img src="https://skillicons.dev/icons?i=github" height="50"/>
</a>

<a href="https://linkedin.com/in/raquel-barros-828b68334">
  <img src="https://skillicons.dev/icons?i=linkedin" height="50"/>
</a>

</div>

---

<div align="center">

### 💜

</div>

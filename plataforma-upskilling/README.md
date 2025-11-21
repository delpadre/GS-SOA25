Plataforma de Upskilling e Reskilling — API RESTful (ENTREGA FINAL)
    Integrantes

Rafael Jorge Del Padre - rm552765

1. Contexto — O Futuro do Trabalho

O mercado de trabalho está mudando rapidamente devido a tecnologias como:

Inteligência Artificial

Automação

Análise de Dados

Ambientes híbridos

Computação em Nuvem

Essas mudanças criam novas exigências para os profissionais, que precisam aprender continuamente, fazer upskilling (aprimorar habilidades atuais) e reskilling (migrar para novas áreas).

Segundo a ONU e OIT:
➡ Milhões de trabalhadores precisarão se requalificar até 2030.
➡ As empresas enfrentarão falta de mão de obra qualificada se não adotarem estratégias de aprendizado contínuo.

Por isso, este projeto entrega uma Plataforma de Upskilling e Reskilling, totalmente alinhada à Global Solution.

🎯 2. Objetivo do Projeto

Esta API RESTful permite:

✔ Cadastrar usuários
✔ Criar e listar trilhas de aprendizagem
✔ Associar competências essenciais
✔ Matricular usuários em trilhas
✔ Impedir matrículas duplicadas (regra obrigatória do enunciado)

Tudo seguindo:

Arquitetura em camadas

DTOs

Validações

Flyway

Seeds

Tratamento centralizado de exceções

Banco H2 (memória)

🧩 3. Domínio do Sistema
Usuário

nome

email

áreaAtuacao

nivelCarreira

dataCadastro

Trilha

nome

descricao

cargaHoraria

nivel (INICIANTE, INTERMEDIARIO, AVANCADO)

focoPrincipal

Competência

nome

categoria

descricao

Matrícula

usuarioId

trilhaId

status

dataInscricao

##Regra de negócio obrigatória:

Um usuário não pode ser matriculado duas vezes na mesma trilha.
Se ocorrer → lançar UsuarioNaoElegivelParaTrilhaException (HTTP 422).


4. Arquitetura do Projeto

src/main/java/com/example/upskilling/
│
├── controller/        → Endpoints REST
├── dto/               → Objetos trafegados na API
├── model/             → Entidades JPA
├── repository/        → Interfaces do Spring Data
├── service/           → Interfaces de serviços
├── service/impl/      → Implementações da regra de negócio
├── exception/         → Exceções + Handler global
└── config/            → Classe principal

5. Banco de Dados + Migrações

Banco utilizado: H2
Ferramenta de migração: Flyway

Migrações:

- V1__create_tables.sql
Cria todas as tabelas conforme o enunciado da GS.

- V2__insert_seeds.sql
Insere:

- 5 competências iniciais

- 3 trilhas

relações trilha ↔ competências

6. Como Rodar o Projeto
Requisitos

Java 21

Maven 3.8+

IDE (IntelliJ recomendado)

Instalar dependências:
- mvn clean install

Rodar o projeto:
- mvn spring-boot:run

A API estará em:
http://localhost:808

Acessar banco H2:
http://localhost:8080/h2-console

Configurações:
URL: jdbc:h2:mem:testdb
User: sa
Password: (vazio)

Swagger
http://localhost:8080/swagger-ui.html


7. Endpoints
👤 Usuários — /usuarios
POST /usuarios
{
  "nome": "Rafael",
  "email": "rafael@email.com",
  "areaAtuacao": "Tecnologia",
  "nivelCarreira": "Pleno"
}


Listar
GET /usuarios

Buscar por ID
GET /usuarios/{id}

Atualizar
PUT /usuarios/{id}

Deletar
DELETE /usuarios/{id}

Trilhas — /trilhas
Criar
POST /trilhas

{
  "nome": "Fundamentos de IA",
  "descricao": "Introdução à IA",
  "nivel": "INICIANTE",
  "cargaHoraria": 40,
  "focoPrincipal": "IA"
}

Competências — /competencias
CRUD completo (vale ponto de bônus).

Matrículas — /matriculas
Criar matrícula
POST /matriculas
{
  "usuarioId": 1,
  "trilhaId": 1,
  "status": "ATIVA"
}

Listar matrículas do usuário
GET /matriculas/usuario/{usuarioId}

8. Tratamento de Exceções

| Exceção                                 | Status | Quando ocorre       |
| --------------------------------------- | ------ | ------------------- |
| `ResourceNotFoundException`             | 404    | Recurso não existe  |
| `UsuarioNaoElegivelParaTrilhaException` | 422    | Matrícula duplicada |
| `MethodArgumentNotValidException`       | 400    | Validações falharam |
| `Exception`                             | 500    | Erro inesperado     |

9. Conexão com os ODS

Este projeto está alinhado aos seguintes Objetivos de Desenvolvimento Sustentável:

- ODS 4 – Educação de qualidade
- ODS 8 – Trabalho decente
- ODS 9 – Inovação
- ODS 10 – Redução das desigualdades

Promovendo:

- Educação acessível
- Inclusão digital
- Oportunidades profissionais para 2030+
- Requalificação em massa para o futuro

10. Documento Base

O PDF oficial usado como referência está no repositório:

- futuro_do_trabalho_Upskilling_Reskilling-3ESPR.pdf
# Plataforma GS-SOA25 - API de Upskilling/Reskilling 2030+

## Descrição do Projeto
API RESTful para uma plataforma de Upskilling/Reskilling voltada ao Futuro do Trabalho (2030+), permitindo que profissionais se cadastrem, acessem trilhas de aprendizagem focadas em competências do futuro e se inscrevam para requalificação profissional.

**Conexão com ODS:**
- **ODS 4** - Educação de Qualidade
- **ODS 8** - Trabalho Decente e Crescimento Econômico
- **ODS 9** - Indústria, Inovação e Infraestrutura
- **ODS 10** - Redução das Desigualdades

---

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (em memória)
- Flyway (Migrações de banco)
- Springdoc OpenAPI (Documentação Swagger)
- Bean Validation
- Maven

---

## Modelo de Dados

### Entidades Principais:
- **Usuário**: Profissionais da plataforma
- **Trilha**: Cursos de upskilling/reskilling
- **Competência**: Habilidades do futuro
- **Matrícula**: Inscrição de usuários em trilhas

---

## Como Executar o Projeto

### Pré-requisitos:
- Java 17 ou superior
- Maven 3.6+
- Git

### Passo a Passo:
1. Clone o repositório:
```bash
git clone https://github.com/delpadre/GS-SOA25.git
cd GS-SOA25
```

Execute a aplicação:

bash
mvn spring-boot:run
Acesse os endpoints:

API Base: http://localhost:8080

📚 Swagger UI: http://localhost:8080/swagger-ui.html

🗄️ H2 Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:upskillingdb

Username: sa

Password: (vazio)

Funcionalidades
🛡️ Validações Implementadas
Campos obrigatórios com mensagens customizadas

Formato de email válido

Níveis válidos (INICIANTE, INTERMEDIARIO, AVANCADO)

Impedir matrícula duplicada na mesma trilha

🚨 Tratamento de Exceções
404 NOT FOUND - Recurso não encontrado

422 UNPROCESSABLE ENTITY - Regra de negócio violada

400 BAD REQUEST - Erro de validação

500 INTERNAL SERVER ERROR - Erro interno

📊 Migrações Flyway
O banco é automaticamente populado com:

✅ Tabelas estruturadas

✅ Dados de teste iniciais

✅ Relacionamentos configurados

🎯 Regras de Negócio
Validação de Nível: Apenas níveis pré-definidos são aceitos

Matrícula Única: Usuário não pode se matricular duas vezes na mesma trilha

Data Automática: Data de cadastro e inscrição são geradas automaticamente

Status Controlado: Matrículas com status (ATIVA, CONCLUIDA, CANCELADA)

🧪 Testando a API
Via Swagger UI (Recomendado)
Acesse: http://localhost:8080/swagger-ui.html

Explore todos os endpoints

Execute requisições diretamente pela interface


Estrutura
src/main/java/com/example/upskilling/
├── controller/          # Controladores REST
├── service/            # Lógica de negócio
├── repository/         # Acesso a dados
├── model/              # Entidades JPA
├── dto/               # Objetos de transferência
├── exception/          # Tratamento de erros
└── config/            # Configurações

src/main/resources/
├── db/migration/       # Scripts Flyway (V1-V6)
└── application.properties


Scripts de Migração
V1__create_usuarios.sql - Tabela de usuários

V2__create_trilhas.sql - Tabela de trilhas

V3__create_matriculas.sql - Tabela de matrículas

V4__insert_test_data.sql - Dados iniciais

V5__add_status_column.sql - Coluna status

V6__add_carga_horaria_trilhas.sql - Coluna carga horária

Desenvolvedores
Rafael Jorge Del Padre - RM 552765


📄 Licença
Este projeto é desenvolvido para fins educacionais como parte da Global Solution - O Futuro do Trabalho.


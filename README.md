# 🚗 Auto Workshop Pro: Sistema de Gestão de Oficina de Automóveis 🔧

## 🌟 Visão Geral do Projeto

Bem-vindo ao Auto Workshop Pro, a solução definitiva para gerenciamento de oficinas mecânicas! Este projeto é uma API robusta desenvolvida para simplificar e otimizar a gestão de serviços automotivos.

## 📋 Funcionalidades Principais

- 🔍 Gerenciamento completo de ordens de serviço
- 👥 Cadastro detalhado de clientes e veículos
- 💸 Controle financeiro preciso
- 🛠️ Registro de serviços e peças

## 🖥️ Pré-requisitos

### Sistemas Operacionais Compatíveis
- Linux (Ubuntu/Debian)
- Windows 10/11

### Ferramentas Necessárias
- Java JDK 21+
- IntelliJ IDEA
- Maven
- Git

## 🛠️ Instalação no Linux

### 1. Instalando o Java
```bash
# Atualizar repositórios
sudo apt update

# Instalar Java 21
sudo apt install openjdk-21-jdk -y

# Verificar instalação
java --version
```

### 2. Instalando IntelliJ IDEA
```bash
# Método via Snap
sudo snap install intellij-idea-community --classic

# Método manual
# Baixar do site oficial JetBrains
wget https://download.jetbrains.com/idea/ideaIC-2023.2.2.tar.gz
tar -xzf ideaIC-2023.2.2.tar.gz
mv idea-IC-232.9921.47 /opt/intellij
/opt/intellij/bin/idea.sh
```

### 3. Instalando Maven
```bash
sudo apt install maven -y

# Verificar instalação
mvn --version
```

## 🖥️ Instalação no Windows

### 1. Instalando Java JDK
- Baixe o JDK 21 do site oficial da Oracle
- Execute o instalador
- Configure a variável de ambiente JAVA_HOME

### 2. Instalando IntelliJ IDEA
- Visite [JetBrains Download](https://www.jetbrains.com/idea/download/#section=windows)
- Baixe a versão Community
- Execute o instalador
- Marque "Create Desktop Shortcut"

### 3. Instalando Maven
- Baixe o Maven do site oficial Apache
- Extraia para `C:\Program Files\Maven`
- Adicione ao PATH do sistema

## 🚀 Configurando o Projeto

### Clonar o Repositório
```bash
# Via HTTPS
git clone https://github.com/wedleycso/sistema-de-gestao-de-oficina-de-automoveis-api.git

# Via SSH
git clone git@github.com:wedleycso/sistema-de-gestao-de-oficina-de-automoveis-api.git
```

### Configurar Dependências
```bash
# Navegar para o diretório do projeto
cd sistema-de-gestao-de-oficina-de-automoveis-api

# Instalar dependências
mvn clean install
```

## 🔧 Configuração do Banco de Dados

### Requisitos
- MySQL 12+
- Criar banco de dados: `oficina_db`

### Configuração application.properties
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/oficina_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

## 🚀 Executando a Aplicação

### Via IntelliJ
- Abra o projeto
- Navegue até `src/main/java/[pacote]/Application.java`
- Clique em "Run"

### Via Terminal
```bash
# No Linux/MacOS
./mvnw spring-boot:run

# No Windows
mvnw.cmd spring-boot:run
```

## 🧪 Testes

```bash
# Executar testes unitários
mvn test

# Executar testes de integração
mvn verify
```

## 📦 Empacotando para Produção

```bash
# Gerar JAR executável
mvn clean package

# Localização do JAR
target/sistema-oficina-1.0.0.jar
```

## 🛠️ Tecnologias Utilizadas

- **Backend**: Spring Boot
- **Banco de Dados**: MySQL
- **Gerenciamento de Dependências**: Maven
- **Autenticação**: Spring Security
- **Documentação**: Swagger/OpenAPI

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie sua feature branch (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas mudanças (`git commit -m 'Adicionar nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 📄 Licença

Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

## 📞 Contato

Wédley C. Oliveira <br>
Nicolas Pires

Link do Projeto: [https://github.com/wedleycso/sistema-de-gestao-de-oficina-de-automoveis-api](https://github.com/seu-usuario/sistema-de-gestao-de-oficina-de-automoveis-api)

---

**Desenvolvido com 👨‍💻 e muita graxa de motor** 🚗🔧
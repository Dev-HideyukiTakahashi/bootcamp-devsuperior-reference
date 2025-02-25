# 📌 Configurando Variáveis de Ambiente no Java (VS Code)

### 1️⃣ Adicione a pasta `.vscode` ao `.gitignore`

      ✅ Isso evita que suas configurações locais sejam enviadas para o repositório.

### 2️⃣ Configure o arquivo `.vscode/launch.json`

      ✅ No VS Code, crie ou edite o arquivo `.vscode/launch.json` e adicione suas variáveis de ambiente:

```json
{
  "env": {
    "DB_URL": "localhost:3306",
    "DB_USERNAME": "postgres",
    "DB_PASSWORD": "123456",
    "MAIL_CONSUMER_KEY": "a4das7dsad34mjfisadasd",
    "MAIL_CONSUMER_SECRET": "asd4asd542llfgk33"
  }
}
```

### 3️⃣ Configuração no `application.properties`

      ✅ No arquivo `application.properties`, referencie as variáveis de ambiente:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

mail.consumer.key=${MAIL_CONSUMER_KEY}
mail.consumer.secret=${MAIL_CONSUMER_SECRET}
```

---

## 🎨 Configuração de Saída Colorida no Console VS Code

Para habilitar a exibição colorida dos logs no console, adicione a seguinte configuração no `application.properties`:

```properties
spring.output.ansi.enabled=always
```

🔹 **Opções disponíveis:**

- **`ALWAYS`** → Sempre habilita cores no console.
- **`DETECT`** (padrão) → Habilita cores apenas se o terminal suportar.
- **`NEVER`** → Desativa cores no console.

---

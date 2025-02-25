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

# Documentação de API com Swagger e OpenAPI 3.0 no Spring Boot com Java


### Passo 1: Dependência maven

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.1.0</version>
</dependency>
```
Referência: https://springdoc.org/

### Passo 2: Classe de configuração

- Incluir a classe OpenAPIConfig no pacote config:

```java
@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI dsmovieAPI() {
        return new OpenAPI()
           .info(new Info()
           .title("DSMovie API")
           .description("DSMovie Reference Project")
           .version("v0.0.1")
           .license(new License()
           .name("Apache 2.0")
           .url("https://github.com/devsuperior/dsmovie-ref")));
    }
}
```
### Passo 3: Acessar documentação

- Link: http://localhost:8080/swagger-ui.html

## Tópicos avançados - Recursos no Swagger

### Passo 1: Personalizar o swagger

- Anotações nos recursos (controllers)

```java
@Tag(name = "Movies", description = "Controller for Movie")
public class MovieController {
```

- Anotações nos endpoints REST

```java
@Operation(
    description = "Create a new movie",
    summary = "Create a new movie",
    responses = {
         @ApiResponse(description = "Created", responseCode = "201"),
         @ApiResponse(description = "Bad Request", responseCode = "400"),
         @ApiResponse(description = "Unauthorized", responseCode = "401"),
         @ApiResponse(description = "Forbidden", responseCode = "403"),
         @ApiResponse(description = "Unprocessable Entity", responseCode = "422")
    }
)
@PreAuthorize("hasRole('ROLE_ADMIN')")
@PostMapping
public ResponseEntity<MovieDTO> insert(@RequestBody MovieDTO dto) {
```
```java
@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public MovieDTO findById(@PathVariable Long id) {
```

- Anotações model

```java
public class MovieDTO {

	@Schema(description = "Database generated movie ID")
	private Long id;
	
	@Schema(description = "Movie title")
	private String title;
```
## Tópicos avançados: 

### Configurações com Spring Security

- Incluir anotação @SecurityScheme na classe de configuração

```java
@OpenAPIDefinition
@Configuration
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer")
public class OpenApiConfig {

    @Bean
    public OpenAPI dsmovieAPI() {
        return new OpenAPI()
           .info(new Info()
           .title("DSMovie API")
           .description("DSMovie Reference Project")
           .version("v0.0.1")
           .license(new License()
           .name("Apache 2.0")
           .url("https://github.com/devsuperior/dsmovie-ref")));
    }
}
```
- Inclcuir anotação @SecurityRequirement nos endpoints protegidos
```java
@SecurityRequirement(name = "bearerAuth")
@DeleteMapping(value = "/{id}")
public ResponseEntity<MovieDTO> delete(@PathVariable Long id) {
```
### Gerar especificação OpenAPI da API

- Specify the path of the OpenAPI documentation
```xml
springdoc.api-docs.path=/api-docs
```
- Acessar especificação: http://localhost:8080/api-docs
  


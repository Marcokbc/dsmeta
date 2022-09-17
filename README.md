# Sale 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/devsuperior/sds1-wmazoni/blob/master/LICENSE) 

# Sobre o projeto

https://dsmeta-marcodev.netlify.app/

Big Game Survey é uma aplicação full stack web construída durante a **Semana DevSuperior**, evento organizado pela [DevSuperior](https://devsuperior.com "Site da DevSuperior").

A aplicação consiste em site onde se tem um controle de vendas, contendo a quantidade vendida, o vendedor, a data, a quantidade de visitas e as vendas. Além disso, o projeto se dispõe a enviar uma notificação via SMS, com a ferramenta Twilio, contendos informações sobre a venda realizada. 
Entretanto, o projeto acabou por ter novos horizontes. (nome do projeto) Ainda está em desenvolvimento, visto que o front-end ainda necessita requisitar os outros metodos HTTP que a API produzida disponibliza.

## Layout mobile
![Mobile 1](https://github.com/acenelio/assets/raw/main/sds1/mobile1.png) ![Mobile 2](https://github.com/acenelio/assets/raw/main/sds1/mobile2.png)

## Layout web
![Web 1](https://github.com/acenelio/assets/raw/main/sds1/web1.png)

![Web 2](https://github.com/acenelio/assets/raw/main/sds1/web2.png)

## Modelo conceitual
![Modelo Conceitual](https://github.com/acenelio/assets/raw/main/sds1/modelo-conceitual.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
## Front end
- HTML / CSS / JS / TypeScript
- ReactJS
## Implantação em produção
- Back end: Heroku
- Front end web: Netlify
- Banco de dados: H2

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/Marcokbc/dsmeta

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```

## Front end web
Pré-requisitos: npm / yarn

```bash
# clonar repositório
git clone https://github.com/Marcokbc/dsmeta

# entrar na pasta do projeto front end web
cd frontend

# instalar dependências
yarn install

# executar o projeto
yarn start
```

# Autor

Marco Antônio Meira de Lima

https://www.linkedin.com/in/wmazoni

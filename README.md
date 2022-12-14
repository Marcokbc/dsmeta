# Sales System
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/devsuperior/sds1-wmazoni/blob/master/LICENSE) 

# Sobre o projeto

https://dsmeta-marcodev.netlify.app/

Sales System é uma aplicação full stack web construída durante a **Semana DevSuperior**, evento organizado pela [DevSuperior](https://devsuperior.com "Site da DevSuperior").

A aplicação consiste em um site onde se tem um controle de vendas, contendo a quantidade vendida, o vendedor, a data, a quantidade de visitas e as vendas. Além disso, o projeto se dispõe a enviar uma notificação via SMS, com a ferramenta Twilio, contendo informações sobre a venda realizada. 
Entretanto, o projeto acabou por ter novos horizontes. Sales System ainda está em desenvolvimento, visto que o front-end ainda necessita requisitar os outros metodos HTTP que a API produzida disponibliza.

## Layout web
![layout](https://user-images.githubusercontent.com/88397083/190874993-2b1f59fc-e824-4afe-a67c-f14e2dba4fe1.png)


## Modelo conceitual
![Marco](https://user-images.githubusercontent.com/88397083/191740956-cbc7a8ad-9604-4bf0-b14a-3ef14df481fd.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Lombok
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

https://www.linkedin.com/in/marco-ant%C3%B4nio-meira-7a35bb234/

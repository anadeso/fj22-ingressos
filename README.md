# 🎞 Aplicação - Venda de Ingressos
Desenvolvi essa aplicação no curso realizado na Caelum [CURSO DESENVOLVENDO NA PRÁTICA COM SPRING E TESTES](https://www.caelum.com.br/curso-java-testes-spring-web-services-design-patterns?id=9233 "CURSO DESENVOLVENDO NA PRÁTICA COM SPRING E TESTES") no qual teve boas práticas de programação.

Principais funcionalidades implementadas:

- Formulário para criação da sessão.
- Gerenciamento de sessão, no qual validamos se a sessão a ser adicionada pode ou não estar em conflito com as sessões existentes, para esse processo utilizamos API de data do Java 8.
- Salvando a sessão após preenchimento da sessão, aplicando Hibernate.
- Atribuindo preço na sala e filme, utilizando a classe Bigdecimal.
- Criando desconto dos ingressos aplicando Design Pattern - Strategy no qual cada desconto tenha sua própria regra de negócio, sendo estudante, bancos ou outras promoções .
- Utilizando RestTemplate para consumir API [https://omdb-fj22.herokuapp.com/movie?title=1997](https://omdb-fj22.herokuapp.com/movie?title=1997) para obter informações sobre filmes, todo o conteúdo e imagens.
- Lógica para seleção de lugares.
- Tela de compras.
- Desabilitando a seleção do lugar que está no carrinho.
- Desenvolvendo segurança da aplicação.


# 💼 Bibliotecas e tecnologias utilizadas:
- Java 
- Maven
- Spring MVC
- Hibernate
- JPA
- JSP com Bootstrap
- jUnit

![](https://i.imgur.com/CqAYBkp.png)

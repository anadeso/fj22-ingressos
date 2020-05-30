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


# 🧰 Bibliotecas e tecnologias utilizadas:
- Java 
- Maven
- Spring MVC
- Hibernate
- JPA
- MySQL
- JSP com Bootstrap
- jetty
- jUnit

# 🚀 Começando do zero
1. Download e Instalação do JAVA 8 (JDK)
	- [Windows][Windows]
	- [MackOS][MackOS]
	- Linux
		1. [Ubuntu, Debian, Mint][Ubuntu, Debian, Mint]
		1. [Fedora, CentOS][Fedora, CentOS]
		
1. Download e Instalação do MySQL Server 5.7
	- [Windows][Windows]
	- [MackOS][MackOS]
	- Linux
		1. [Ubuntu, Debian, Mint][Ubuntu, Debian, Mint]
		1. [Fedora, CentOS][Fedora, CentOS]

1. Download e Instalação de uma [IDE][IDE] 

# ⚙️ Gerenciando as dependências/build e executando aplicação

1. Vá no diretório do projeto, baixe as dependências e liste-as
	- cd fj22-ingressos
	- mvn dependency:resolve
	- mvn dependency:tree

1. Empacote e rode (com jetty) a aplicação 
	- mvn package
	- mvn jetty:run
	Caso queira rodar os dois comandos acima de uma única vez faça **mvn package jetty:run** 👌

1. No navegador, acesse http://localhost:8080 e aproveite o sistema.

1. E agora..como faço para parar o jetty 😳
	- No terminal, pressione CTRL + C para interromper a execução do jetty
	- Caso queira limpar o terminal digite clean e enter 

1. E uma coisa bem importante, não esqueça de alterar para o seu usuário e senha do banco de dados lá no nosso spring-context.xml.xml

```xml
<bean id="mysqlDS" class="org.apache.commons.dbcp.BasicDataSource">
	<property name="username" value="seu-usuario"/>
	<property name="password" value="sua-senha"/>
	<property name="url" value="jdbc:mysql://localhost/ingresso?createDatabaseIfNotExist=true
"/>
	<property name="driverClassName" value="com.mysql.jdbc.Driver"/>
</bean>
```





Obs: Caso precise de um auxílio com os comandos para o terminal, isso [aqui][aqui] pode ajudar 😁

# 😻 Aplicação
![](https://i.imgur.com/CqAYBkp.png)

[IDE]: https://www.techemportugues.com/2016/06/16/java-os-5-melhores-ides-programar/ "IDE"
[Windows]: https://www.oracle.com/webapps/redirect/signon?nexturl=https://download.oracle.com/otn/java/jdk/8u241-b07/1f5b5a70bf22433b84d0e960903adac8/jdk-8u241-windows-x64.exe "Windows"
[MackOS]: https://www.oracle.com/webapps/redirect/signon?nexturl=https://download.oracle.com/otn/java/jdk/8u241-b07/1f5b5a70bf22433b84d0e960903adac8/jdk-8u241-macosx-x64.dmg "MacOS"
[Ubuntu, Debian, Mint]: https://www.oracle.com/webapps/redirect/signon?nexturl=https://download.oracle.com/otn/java/jdk/8u241-b07/1f5b5a70bf22433b84d0e960903adac8/jdk-8u241-linux-x64.tar.gz "Ubuntu, Debian, Mint"
[Fedora, CentOS]: https://www.oracle.com/webapps/redirect/signon?nexturl=https://download.oracle.com/otn/java/jdk/8u241-b07/1f5b5a70bf22433b84d0e960903adac8/jdk-8u241-linux-x64.rpm "Fedora, CentOS"

[Windows]: https://downloads.mysql.com/archives/get/p/25/file/mysql-installer-community-5.7.28.0.msi "Windows"
[aqui]: https://www.lucascaton.com.br/2018/01/07/comandos-para-o-terminal-windows-macos-e-linux/ "aqui"

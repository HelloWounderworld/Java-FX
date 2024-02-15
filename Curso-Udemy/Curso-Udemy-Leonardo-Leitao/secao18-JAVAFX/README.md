# Seção 18: JAVAFX

## Aula 01 - Configuração do Ambiente:
Vamos preparar o nosso ambiente de desenvolvimento, pois o JavaFX é um recurso que não vem junto com o pacote Java, quando é instalado.

Para isso, vamos precisar baixar as dependências para configurarmos isso no eclipse. Para isso, vamos seguir os seguintes passos

- 1: Acessamos o seguinte site

    https://openjfx.io/

Scrollando para baixo, iremos encontrar a opção para Download. E clicamos nela.

- 2: Vamos baixar a versão LTS, pode pegar a última versão, do pacote, conforme o seu sistema operacional, do tipo SDK. E isso irá baixar um arquivo .zip. Podemos descompactar esse arquivo .zip e recomendamos deixar essa pasta em algum arquivo home, ou application ou Disco local C:, pois iremos realizar um apontamento sobre essa pasta pelo eclipse.

- 3: Note que, acessando a pasta descompactada e acessando o lib, dentro dela, haverá muitos arquivos .jar. Vamos ter que enviar esses arquivos no eclipse.

    No caso, como o meu sistema operacional é Linux, na minha será realizado da seguinte forma no eclipse

        Windows -> Preferences -> Na aba da busca digite "User Lib" -> Selecionamos o "User Libraries" -> New -> Colocamos o nome "JavaFX21" -> Ok -> Add External Jars... -> Vai até a pasta onde foi descompactado e entra até a pasta lib -> Seleciona todos os arquivos .jar -> Ok -> Em "javafx.base.jar" selecionamos o "Source attachment" -> Edit -> External Location -> External file -> Dentro da pasta que foi descompactada, procure pelo "src.zip" -> Ok e, realizamos o mesmo processo para os "Source attachment" restantes. -> Apply and Close

    Bom, agora, temos todas as bibliotecas de JavaFX configurada apontando para a pasta que foi descompactada.

Na próxima aula, vamos criar um projeto e associar esse projeto sobre essa biblioteca JavaFX que conseguimos configurar no eclipse.

## Aula 02 - Configuração do Projeto:
Bom, configurado a nossa biblioteca, Java FX, vamos, agora, criar um novo projeto para implementarmos o Java FX nela.

Vamos criar um novo projeto java "exercicios-javaFx" da seguinte forma

    New -> Java Project -> Porject Name: exercicios-javaFx -> Create module-info.java file, Module name: exerciciosfx -> Finish

Agora, vamos configurar a biblioteca do JavaFX, dentro dela. Então, realizamos o seguinte passo a passo

    Build Path -> Configure Build Path... -> Librarires -> Seleciona "Modulepath" -> Add Library -> User Library -> Next -> JavaFX21 -> Finish -> Apply and Close

Bom, agora, vamos criar um novo pacote chamado "basico" e, dentro desse pacote, criamos uma nova classe "PrimeiroFX". Agora, vamos querer que essa classe herde uma outra classe que não está ainda relacionado com o projeto. Para isso, vamos precisar fazer um requires do "javafx.controls" dentro do arquivo, module-info, da seguinte forma

    module exerciciosfx {
        requires javafx.controls;
    }

Daí, na classe, PrimeiroFX, que acabamos de criar, nela inserimos o seguinte

    package basico;

    import javafx.application.Application;
    import javafx.stage.Stage;

    public class PrimeiroFX extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
        }
    }

Podemos acessar o código fonte das classes que pegamos de integrações externas colocando a seta do mouse em cima do nome da classe e aparecerá uma opção "Open Declaration". Clicando nela conseguimos acessar como é o código dessa classe.

Agora, vamos realizar a seguinte complementação dentro da classe, PrimeiroFX, da seguinte forma

    package basico;

    import javafx.application.Application;
    import javafx.stage.Stage;

    public class PrimeiroFX extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Ao executar o código acima, vamos ver que, no console, será exibido muitos erros relacionado ao reflection.

Para isso, vamos ter que abrir alguns pacotes pelo módulo. Então, realizamos o seguinte

    module exerciciosfx {
        requires javafx.controls;
        
        opens basico;
    }

Feito isso, ao rodarmos, novamente, a classe, PrimeiroFX, vamos ver que, desta vez, ira abrir um modal com a tela tudo em preto, ou em branco para algumas pessoas, dendendo do sistema operacional.

Bom, vamos realizar mais algumas implementações em cima dessa classe. No caso vamos colocar um botão nela da seguinte maneira

    package basico;

    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class PrimeiroFX extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Button botaoA = new Button("A");
            Button botaoB = new Button("B");
            Button botaoC = new Button("C");
            
            VBox box = new VBox();
            box.getChildren().add(botaoA);
            box.getChildren().add(botaoB);
            box.getChildren().add(botaoC);
            
            Scene unicaCena = new Scene(box);
            
            primaryStage.setScene(unicaCena);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Ao rodarmos o código acima, vamos ver que irá aparecer uma modal com os três botões, A, B e C configurados.

Vamos melhorar a visualização do layout da seguinte forma

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class PrimeiroFX extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Button botaoA = new Button("A");
            Button botaoB = new Button("B");
            Button botaoC = new Button("C");
            
            VBox box = new VBox();
            box.setAlignment(Pos.CENTER);
            box.setSpacing(10);
            box.getChildren().add(botaoA);
            box.getChildren().add(botaoB);
            box.getChildren().add(botaoC);
            
            Scene unicaCena = new Scene(box, 200, 400);
            
            primaryStage.setScene(unicaCena);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Assim, vamos conseguir obter uma visualização melhorada dos botões A, B e C com mais espaçamento.

Podemos tornar a caiba de forma horizontal, mudando o "VBox" para "HBox" e colocando as escalas de "Scene" para 150 e 100

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.layout.HBox;
    //import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class PrimeiroFX extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Button botaoA = new Button("A");
            Button botaoB = new Button("B");
            Button botaoC = new Button("C");
            
    //		VBox box = new VBox();
            HBox box = new HBox();
            box.setAlignment(Pos.CENTER);
            box.setSpacing(10);
            box.getChildren().add(botaoA);
            box.getChildren().add(botaoB);
            box.getChildren().add(botaoC);
            
    //		Scene unicaCena = new Scene(box, 100, 150);
            Scene unicaCena = new Scene(box, 150, 100);
            
            primaryStage.setScene(unicaCena);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Bom, até agora, só colocamos os botões, como se estivessemos realizando uma marcação das tags. Porém, vamos colocar uma ação de cada botão

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.layout.HBox;
    //import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class PrimeiroFX extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Button botaoA = new Button("A");
            Button botaoB = new Button("B");
            Button botaoC = new Button("C");
            
            botaoA.setOnAction(e -> System.out.println("A"));
            botaoB.setOnAction(e -> System.out.println("B"));
            botaoC.setOnAction(e -> System.exit(0));
            
    //		VBox box = new VBox();
            HBox box = new HBox();
            box.setAlignment(Pos.CENTER);
            box.setSpacing(10);
            box.getChildren().add(botaoA);
            box.getChildren().add(botaoB);
            box.getChildren().add(botaoC);
            
    //		Scene unicaCena = new Scene(box, 100, 150);
            Scene unicaCena = new Scene(box, 150, 100);
            
            primaryStage.setScene(unicaCena);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

No caso, com as ações definidas para os botões acima, conseguimos ver que para o botão A e B, será printado os alfabeto A e B no console e, o botão C, irá fechar a tela, saindo da aplicação.

## Aula 03 - Contador #01:
Vamos, agora, realizar o nosso segundo exercícios de contagem.

Bom, o exercício em sí será algo bem simples, visto que iremos criar um botão e em cima disso configurar o processo de contagem. Vamos conhecer os estilos do Java FX que difere, para quem já conhece outros framworks voltados para o Front-End que tem como base JavaScript, de muitos outros estilos de frameworks voltados para front-end.

bom, por começo, dentro do pacote, basico, vamos criar uma classe, Contador, e nela inserimos o seguinte

    package basico;

    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class Contador extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Label labelTitulo = new Label("Contador");
            Label labelNumero = new Label("0");
            
            Button botaoDecremento = new Button("-");
            Button botaoIncremento = new Button("+");
            
            VBox boxPrincipal = new VBox();
            boxPrincipal.getChildren().add(labelTitulo);
            boxPrincipal.getChildren().add(labelNumero);
            boxPrincipal.getChildren().add(botaoDecremento);
            boxPrincipal.getChildren().add(botaoIncremento);
            
            Scene cenaPrincipal = new Scene(boxPrincipal);
            
            primaryStage.setScene(cenaPrincipal);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Bom, vamos ver como o layout ficou configurado rodando o código acima. Vemos que os elementos que queremos acionar estão todas elas contido, porém, bem apertados.

Vamos, agora, ajustar os tamanhos e os espaçamentos da seguinte forma

    package basico;

    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class Contador extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Label labelTitulo = new Label("Contador");
            Label labelNumero = new Label("0");
            
            Button botaoDecremento = new Button("-");
            Button botaoIncremento = new Button("+");
            
            HBox boxBotoes = new HBox();
            boxBotoes.getChildren().add(botaoDecremento);
            boxBotoes.getChildren().add(botaoIncremento);
            
            VBox boxPrincipal = new VBox();
            boxPrincipal.getChildren().add(labelTitulo);
            boxPrincipal.getChildren().add(labelNumero);
            boxPrincipal.getChildren().add(boxBotoes);
            
            Scene cenaPrincipal = new Scene(boxPrincipal, 400, 400);
            
            primaryStage.setScene(cenaPrincipal);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Bom, ao rodarmos o código acima, veremos que o tamanho da aplicação e os espaçamentos melhoraram.

Vamos dar mais alguns retoques de melhorias

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class Contador extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Label labelTitulo = new Label("Contador");
            Label labelNumero = new Label("0");
            
            Button botaoDecremento = new Button("-");
            Button botaoIncremento = new Button("+");
            
            HBox boxBotoes = new HBox();
            boxBotoes.setAlignment(Pos.CENTER);
            boxBotoes.setSpacing(10);
            boxBotoes.getChildren().add(botaoDecremento);
            boxBotoes.getChildren().add(botaoIncremento);
            
            VBox boxPrincipal = new VBox();
            boxPrincipal.setAlignment(Pos.CENTER);
            boxPrincipal.setSpacing(10);
            boxPrincipal.getChildren().add(labelTitulo);
            boxPrincipal.getChildren().add(labelNumero);
            boxPrincipal.getChildren().add(boxBotoes);
            
            Scene cenaPrincipal = new Scene(boxPrincipal, 400, 400);
            
            primaryStage.setScene(cenaPrincipal);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Bom, rodando, agora, o código acima, vamos ver que o layout melhorou. Claro, no sentido de configurarmos algo bem básico.

Do ponto de vista de layout, ainda temos muitas implementações que podemos realizar para melhorar o visual, porém, na próxima aula, iremos focar, primeiro, no âmbito da funcionalidade dos botões para depois nos preocuparmos com a qualidade visual da aplicação.

## Aula 04 - Contador #02:
Vamos, agora, implementar sobre os botões as funcionalidades de contagens.

Bom, na classe, Contador, do pacote, basico, vamos aplicar as ações sobre os botões que definimos, da seguinte forma

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class Contador extends Application {
        
        private int contador = 0;

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Label labelTitulo = new Label("Contador");
            Label labelNumero = new Label("0");
            
            Button botaoDecremento = new Button("-");
            botaoDecremento.setOnAction(e -> {
                contador--;
                labelNumero.setText(Integer.toString(contador));
            });
            
            Button botaoIncremento = new Button("+");
            botaoIncremento.setOnAction(e -> {
                contador++;
                labelNumero.setText(Integer.toString(contador));
            });
            
            HBox boxBotoes = new HBox();
            boxBotoes.setAlignment(Pos.CENTER);
            boxBotoes.setSpacing(10);
            boxBotoes.getChildren().add(botaoDecremento);
            boxBotoes.getChildren().add(botaoIncremento);
            
            VBox boxPrincipal = new VBox();
            boxPrincipal.setAlignment(Pos.CENTER);
            boxPrincipal.setSpacing(10);
            boxPrincipal.getChildren().add(labelTitulo);
            boxPrincipal.getChildren().add(labelNumero);
            boxPrincipal.getChildren().add(boxBotoes);
            
            Scene cenaPrincipal = new Scene(boxPrincipal, 400, 400);
            
            primaryStage.setScene(cenaPrincipal);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Executando o código acima, agora, vamos ver que a cada click que realizamos sobre os botões de incremento e decremento, vamos conseguir acrescentar e subtrair de um em um.

## Aula 05 - Contador #03:
Vamos, agora, focar na parte melhoria da qualidade visual do Contador.

Para isso, iremos utilizar os recursos de CSS.

Vamos, então, criar um novo arquivo fazendo o seguinte passo a passo

    sobre o pacote "basico" clicamos com o botão direito -> New -> File -> File name: Contador.css -> Finish

Dentro desse arquivo .css, vamos inserir o seguinte

    .conteudo {
        -fx-background-color: red; 
    }

Como um começo, definimos o plano de fundo na cor vermelha para ficar nítido que foi implementado com sucesso o css.

Agora, vamos mostrar como conseguimos considerar esse arquivo css dentro da nossa classe, Contador, do pacote, basico

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class Contador extends Application {
        
        private int contador = 0;

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Label labelTitulo = new Label("Contador");
            Label labelNumero = new Label("0");
            
            Button botaoDecremento = new Button("-");
            botaoDecremento.setOnAction(e -> {
                contador--;
                labelNumero.setText(Integer.toString(contador));
            });
            
            Button botaoIncremento = new Button("+");
            botaoIncremento.setOnAction(e -> {
                contador++;
                labelNumero.setText(Integer.toString(contador));
            });
            
            HBox boxBotoes = new HBox();
            boxBotoes.setAlignment(Pos.CENTER);
            boxBotoes.setSpacing(10);
            boxBotoes.getChildren().add(botaoDecremento);
            boxBotoes.getChildren().add(botaoIncremento);
            
            VBox boxPrincipal = new VBox();
            boxPrincipal.setAlignment(Pos.CENTER);
            boxPrincipal.setSpacing(10);
            boxPrincipal.getChildren().add(labelTitulo);
            boxPrincipal.getChildren().add(labelNumero);
            boxPrincipal.getChildren().add(boxBotoes);
            
            String caminhoDoCss = getClass()
                    .getResource("/basico/Contador.css")
                    .toExternalForm();
            
            Scene cenaPrincipal = new Scene(boxPrincipal, 400, 400);
            cenaPrincipal.getStylesheets().add(caminhoDoCss);
            
            primaryStage.setScene(cenaPrincipal);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

No caso, utilizamos o getStylesheets e nela definimos um caminho onde se encontra o arquivo "Contador.css" para verificarmos se a classe está conseguindo identificar esse arquivo .css. Ao executarmos o código acima, se não tivemos nenhum problema e o modal apareceu normalmente, então significa que o arquivo foi identificado de foma bem sucedida.

Porém, note que, a customização da cor que colocamos dentro do arquivo, Contador.css, não foi considerado, pois o processo acima, só funcionou para identificarmos o arquivo. Agora, falta, conseguirmos aplicar o que foi configurado dentro do arquivo .css. No caso, realizamos o seguinte

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class Contador extends Application {
        
        private int contador = 0;

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Label labelTitulo = new Label("Contador");
            Label labelNumero = new Label("0");
            
            Button botaoDecremento = new Button("-");
            botaoDecremento.setOnAction(e -> {
                contador--;
                labelNumero.setText(Integer.toString(contador));
            });
            
            Button botaoIncremento = new Button("+");
            botaoIncremento.setOnAction(e -> {
                contador++;
                labelNumero.setText(Integer.toString(contador));
            });
            
            HBox boxBotoes = new HBox();
            boxBotoes.setAlignment(Pos.CENTER);
            boxBotoes.setSpacing(10);
            boxBotoes.getChildren().add(botaoDecremento);
            boxBotoes.getChildren().add(botaoIncremento);
            
            VBox boxConteudo = new VBox();
            boxConteudo.getStyleClass().add("conteudo");
            boxConteudo.setAlignment(Pos.CENTER);
            boxConteudo.setSpacing(10);
            boxConteudo.getChildren().add(labelTitulo);
            boxConteudo.getChildren().add(labelNumero);
            boxConteudo.getChildren().add(boxBotoes);
            
            String caminhoDoCss = getClass()
                    .getResource("/basico/Contador.css")
                    .toExternalForm();
            
            Scene cenaPrincipal = new Scene(boxConteudo, 400, 400);
            cenaPrincipal.getStylesheets().add(caminhoDoCss);
            
            primaryStage.setScene(cenaPrincipal);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

No caso, no boxConteudo, aplicamos o getStyleClass, e colocamos o nome do css que definimos a customização que queremos. Rodando o código acima, vamos ver que teremos a cor vermelha de fundo na aplicação, como havíamos definido. Mas queremos que a cor do fundo seja preto, então mudamos o nome de "red" para "black", no arquivo, Contador.css.

Bom, além da cor de fundo, vamos precisar definir as fontes para isso tbm. No caso, existe uma fonte que é muito útil para tais finalidades de layout de páginas

    https://fonts.google.com/

Nela, conseguimos escolher as fontes e pegar o código css que nos permite aplicar a tal fonte. No caso, por exemplo peguei a seguinte fonte

    https://fonts.googleapis.com/css2?family=Smooch+Sans:wght@100..900&display=swap

Então, para aplicarmos essa fonte, podemos realizar o seguinte na classe, Contador, inserindo

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class Contador extends Application {
        
        private int contador = 0;

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Label labelTitulo = new Label("Contador");
            Label labelNumero = new Label("0");
            
            Button botaoDecremento = new Button("-");
            botaoDecremento.setOnAction(e -> {
                contador--;
                labelNumero.setText(Integer.toString(contador));
            });
            
            Button botaoIncremento = new Button("+");
            botaoIncremento.setOnAction(e -> {
                contador++;
                labelNumero.setText(Integer.toString(contador));
            });
            
            HBox boxBotoes = new HBox();
            boxBotoes.setAlignment(Pos.CENTER);
            boxBotoes.setSpacing(10);
            boxBotoes.getChildren().add(botaoDecremento);
            boxBotoes.getChildren().add(botaoIncremento);
            
            VBox boxConteudo = new VBox();
            boxConteudo.getStyleClass().add("conteudo");
            boxConteudo.setAlignment(Pos.CENTER);
            boxConteudo.setSpacing(10);
            boxConteudo.getChildren().add(labelTitulo);
            boxConteudo.getChildren().add(labelNumero);
            boxConteudo.getChildren().add(boxBotoes);
            
            String caminhoDoCss = getClass()
                    .getResource("/basico/Contador.css")
                    .toExternalForm();
            
            Scene cenaPrincipal = new Scene(boxConteudo, 400, 400);
            cenaPrincipal.getStylesheets().add(caminhoDoCss);
            cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css2?family=Smooch+Sans:wght@100..900&display=swap");
            
            primaryStage.setScene(cenaPrincipal);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

No caso, ao compilarmos o programa, ela irá buscar, usando a internet, essa fonte para ser aplicado.

Mas, claro, uma boa prática seria que a tal personalização seja configurado dentro do arquivo .css, do que depender da internet. No caso, no arquivo, Contador.css, podemos realizar a seguinte customização

    .conteudo {
        -fx-background-color: #000;
    }

    .numero {
        -fx-font-family: Oswald;
        -fx-text-fill: #fff;
    }

Agora, falta, aplicarmos tais fontes da seguinte forma

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class Contador extends Application {
        
        private int contador = 0;

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Label labelTitulo = new Label("Contador");
            labelTitulo.getStyleClass().add("numero");
            
            Label labelNumero = new Label("0");
            labelNumero.getStyleClass().add("numero");
            
            Button botaoDecremento = new Button("-");
            botaoDecremento.setOnAction(e -> {
                contador--;
                labelNumero.setText(Integer.toString(contador));
            });
            
            Button botaoIncremento = new Button("+");
            botaoIncremento.setOnAction(e -> {
                contador++;
                labelNumero.setText(Integer.toString(contador));
            });
            
            HBox boxBotoes = new HBox();
            boxBotoes.setAlignment(Pos.CENTER);
            boxBotoes.setSpacing(10);
            boxBotoes.getChildren().add(botaoDecremento);
            boxBotoes.getChildren().add(botaoIncremento);
            
            VBox boxConteudo = new VBox();
            boxConteudo.getStyleClass().add("conteudo");
            boxConteudo.setAlignment(Pos.CENTER);
            boxConteudo.setSpacing(10);
            boxConteudo.getChildren().add(labelTitulo);
            boxConteudo.getChildren().add(labelNumero);
            boxConteudo.getChildren().add(boxBotoes);
            
            String caminhoDoCss = getClass()
                    .getResource("/basico/Contador.css")
                    .toExternalForm();
            
            Scene cenaPrincipal = new Scene(boxConteudo, 400, 400);
            cenaPrincipal.getStylesheets().add(caminhoDoCss);
            
            primaryStage.setScene(cenaPrincipal);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Rodando o código acima, vamos ver que o css, numero, que definimos pegou no título e no valor da contagem.

Podemos, claro, manipular, o tamanho da fonte tbm, colocando o seguinte no css, numero, que foi definido

    .conteudo {
        -fx-background-color: #000;
    }

    .numero {
        -fx-font-family: Oswald;
        -fx-text-fill: #fff;
        -fx-font-size: 22px;
    }

Vamos criar uma outra classe css para título da seguinte forma

    .conteudo {
        -fx-background-color: #000;
        -fx-font-family: Oswald;
    }

    .titulo {
        -fx-text-fill: #48b2ee;
        -fx-font-size: 32px;
    }

    .numero {
        -fx-text-fill: #fff;
        -fx-font-size: 22px;
    }

Aplicando, na classe, Contador.java, da seguinte forma

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class Contador extends Application {
        
        private int contador = 0;

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Label labelTitulo = new Label("Contador");
            labelTitulo.getStyleClass().add("titulo");
            
            Label labelNumero = new Label("0");
            labelNumero.getStyleClass().add("numero");
            
            Button botaoDecremento = new Button("-");
            botaoDecremento.setOnAction(e -> {
                contador--;
                labelNumero.setText(Integer.toString(contador));
            });
            
            Button botaoIncremento = new Button("+");
            botaoIncremento.setOnAction(e -> {
                contador++;
                labelNumero.setText(Integer.toString(contador));
            });
            
            HBox boxBotoes = new HBox();
            boxBotoes.setAlignment(Pos.CENTER);
            boxBotoes.setSpacing(10);
            boxBotoes.getChildren().add(botaoDecremento);
            boxBotoes.getChildren().add(botaoIncremento);
            
            VBox boxConteudo = new VBox();
            boxConteudo.getStyleClass().add("conteudo");
            boxConteudo.setAlignment(Pos.CENTER);
            boxConteudo.setSpacing(10);
            boxConteudo.getChildren().add(labelTitulo);
            boxConteudo.getChildren().add(labelNumero);
            boxConteudo.getChildren().add(boxBotoes);
            
            String caminhoDoCss = getClass()
                    .getResource("/basico/Contador.css")
                    .toExternalForm();
            
            Scene cenaPrincipal = new Scene(boxConteudo, 400, 400);
            cenaPrincipal.getStylesheets().add(caminhoDoCss);
            
            primaryStage.setScene(cenaPrincipal);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Rodando o código acima, vamos ver que as customizações que foi definida no arquivo, Contador.css, surtiu efeito.

## Aula 06 - Contador #04:
Vamos, agora, agora dinamizar os estilos.

Ou seja, iremos utilizar as condicionais de forma a definir que tipo de customização seja atribuida para aquela classe de acordo com o tipo de resulado que tivermos nas ações dos botões.

No caso, no arquivo, Contador.css, iremos complementar com a seguinte classe para personalizarmos os botões

    .conteudo {
        -fx-background-color: #000;
        -fx-font-family: Oswald;
    }

    .titulo {
        -fx-text-fill: #48b2ee;
        -fx-font-size: 32px;
    }

    .numero {
        -fx-text-fill: #fff;
        -fx-font-size: 22px;
    }

    .botoes {
        -fx-background-color: #fff;
        -fx-text-fill: #48b2ee;
        -fx-font-size: 24px;
        -fx-min-width: 60px;
        -fx-min-height: 60px;
        -fx-background-radius: 30px;
    }

Agora, implementamos essa classe css, botoes, na nossa classe, Contador.java, da seguinte forma

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class Contador extends Application {
        
        private int contador = 0;

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Label labelTitulo = new Label("Contador");
            labelTitulo.getStyleClass().add("titulo");
            
            Label labelNumero = new Label("0");
            labelNumero.getStyleClass().add("numero");
            
            Button botaoDecremento = new Button("-");
            botaoDecremento.getStyleClass().add("botoes");
            botaoDecremento.setOnAction(e -> {
                contador--;
                labelNumero.setText(Integer.toString(contador));
            });
            
            Button botaoIncremento = new Button("+");
            botaoIncremento.getStyleClass().add("botoes");
            botaoIncremento.setOnAction(e -> {
                contador++;
                labelNumero.setText(Integer.toString(contador));
            });
            
            HBox boxBotoes = new HBox();
            boxBotoes.setAlignment(Pos.CENTER);
            boxBotoes.setSpacing(10);
            boxBotoes.getChildren().add(botaoDecremento);
            boxBotoes.getChildren().add(botaoIncremento);
            
            VBox boxConteudo = new VBox();
            boxConteudo.getStyleClass().add("conteudo");
            boxConteudo.setAlignment(Pos.CENTER);
            boxConteudo.setSpacing(10);
            boxConteudo.getChildren().add(labelTitulo);
            boxConteudo.getChildren().add(labelNumero);
            boxConteudo.getChildren().add(boxBotoes);
            
            String caminhoDoCss = getClass()
                    .getResource("/basico/Contador.css")
                    .toExternalForm();
            
            Scene cenaPrincipal = new Scene(boxConteudo, 400, 400);
            cenaPrincipal.getStylesheets().add(caminhoDoCss);
            
            primaryStage.setScene(cenaPrincipal);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Rodando o código acima, vamos ver que conseguimos realizar customizações sobre os dois botões.

Agora, falta, implementarmos uma customização condicional, mas deixarei isso como um desafio onde irei colocar a resposta na próxima aula.

Basicamente, quando a contagem do número for negativo, queremos que a cor do número fique vermelho e, quando a contagem for positiva, que fique verde. Além disso, se for zero, que não seja nenhuma das cores acima, e que seja a cor original.

## Aula 07 - Contador #05:
Vamos resolver o desafio de colocar condicional nas personalizações de cada cores.

Bom, basta seguir a resolução que fiz seguinte

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class Contador extends Application {
        
        private int contador = 0;
        
        private void changeColor(Button btn, Label label) {
            label.getStyleClass().remove("verde");
            label.getStyleClass().remove("vermelha");
            
            if(contador < 0) {
                label.getStyleClass().add("vermelha");
            } else if(contador > 0) {
                label.getStyleClass().add("verde");
            }
            label.setText(Integer.toString(contador));
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            Label labelTitulo = new Label("Contador");
            labelTitulo.getStyleClass().add("titulo");
            
            Label labelNumero = new Label("0");
            labelNumero.getStyleClass().add("numero");
            
            Button botaoDecremento = new Button("-");
            botaoDecremento.getStyleClass().add("botoes");
            botaoDecremento.setOnAction(e -> {
                contador--;
                changeColor(botaoDecremento, labelNumero);
            });
            
            Button botaoIncremento = new Button("+");
            botaoIncremento.getStyleClass().add("botoes");
            botaoIncremento.setOnAction(e -> {
                contador++;
                changeColor(botaoIncremento, labelNumero);
            });
            
            HBox boxBotoes = new HBox();
            boxBotoes.setAlignment(Pos.CENTER);
            boxBotoes.setSpacing(10);
            boxBotoes.getChildren().add(botaoDecremento);
            boxBotoes.getChildren().add(botaoIncremento);
            
            VBox boxConteudo = new VBox();
            boxConteudo.getStyleClass().add("conteudo");
            boxConteudo.setAlignment(Pos.CENTER);
            boxConteudo.setSpacing(10);
            boxConteudo.getChildren().add(labelTitulo);
            boxConteudo.getChildren().add(labelNumero);
            boxConteudo.getChildren().add(boxBotoes);
            
            String caminhoDoCss = getClass()
                    .getResource("/basico/Contador.css")
                    .toExternalForm();
            
            Scene cenaPrincipal = new Scene(boxConteudo, 400, 400);
            cenaPrincipal.getStylesheets().add(caminhoDoCss);
            
            primaryStage.setScene(cenaPrincipal);
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Obs: Durante a resolução desse problema, percebi que existe uma hierarquia entre cores. Ou seja, se num Label, estiver adicionado duas cores diferentes, será considerado aquela cor com a maior hierarquia. Por isso a necessidade de remover todas as classes de cores primeiro, para depois acrescentar.

## Aula 08 - Trocando Scenes - Alternando Telas:
Vamos, agora, realizar um estudo de troca de telas. Ou seja, bom base de alguma ação, ocorre uma troca de tela da aplicação.

Por começo, no pacote, basico, vamos criar uma classe chamado "Wizard" e ne la inserimos o seguinte

    package basico;

    import javafx.application.Application;
    import javafx.stage.Stage;

    public class Wizard extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Bom, em seguida complementamos com o seguinte código

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.layout.HBox;
    import javafx.stage.Stage;

    public class Wizard extends Application {
        
        private Stage janela;
        private Scene passo1;
        private Scene passo2;
        private Scene passo3;

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            janela = primaryStage;
            
            criarPasso1();
            
            primaryStage.setScene(passo1);
            primaryStage.setTitle("Wizard");
            primaryStage.show();
        }
        
        private void criarPasso1() {
            Button proximoPasso = new Button("Ir p/ Passo 2 >>");
            
            HBox box = new HBox();
            box.setAlignment(Pos.CENTER);
            box.getChildren().add(proximoPasso);
            
            passo1 = new Scene(box, 400, 400);
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Rodando o código acima, se nada estiver errado, irá aparecer um modal com o botão "Ir p/ Passo 2 >>", da forma como definimos acima.

Visto que a situação acima está funcionando, vamos repetir um processo análogo para os passos adiante

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.layout.HBox;
    import javafx.stage.Stage;

    public class Wizard extends Application {
        
        private Stage janela;
        private Scene passo1;
        private Scene passo2;
        private Scene passo3;

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            janela = primaryStage;
            
            criarPasso1();
            criarPasso2();
            
            janela.setScene(passo1);
            janela.setTitle("Wizard");
            janela.show();
        }
        
        private void criarPasso1() {
            Button proximoPasso = new Button("Ir p/ Passo 2 >>");
            proximoPasso.setOnAction( e -> {
                janela.setScene(passo2);
            });
            
            HBox box = new HBox();
            box.setAlignment(Pos.CENTER);
            box.getChildren().add(proximoPasso);
            
            passo1 = new Scene(box, 400, 400);
        }
        
        private void criarPasso2() {
            Button passoAnterior = new Button("<< Voltar p/ Passo 1");
            Button proximoPasso = new Button("Ir p/ Passo 3 >>");
            
            HBox box = new HBox();
            box.setAlignment(Pos.CENTER);
            box.getChildren().add(passoAnterior);
            box.getChildren().add(proximoPasso);
            
            passo2 = new Scene(box, 400, 400);
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Rodando o código acima, se nada estiver errado, clicando no botão "Ir p/ Passo 2>>" vamos conseguir ir para a outra janela onde haverá dois botões "<< Voltar p/ Passo 1" e "Ir p/ Passo 3 >>". No caso, configuramos uma ação sobre o botão "Ir p/ Passo 2". Vamos realizar a mesma coisa para os outros botões para coneguirmos controlar a ida e a volta da janela.

    package basico;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.layout.HBox;
    import javafx.stage.Stage;

    public class Wizard extends Application {
        
        private Stage janela;
        private Scene passo1;
        private Scene passo2;
        private Scene passo3;

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            janela = primaryStage;
            
            criarPasso1();
            criarPasso2();
            criarPasso3();
            
            janela.setScene(passo1);
            janela.setTitle("Wizard :: Passo 01");
            janela.show();
        }
        
        private void criarPasso1() {
            Button proximoPasso = new Button("Ir p/ Passo 2 >>");
            proximoPasso.setOnAction( e -> {
                janela.setScene(passo2);
                janela.setTitle("Wizard :: Passo 02");
            });
            
            HBox box = new HBox();
            box.setAlignment(Pos.CENTER);
            box.getChildren().add(proximoPasso);
            
            passo1 = new Scene(box, 400, 400);
        }
        
        private void criarPasso2() {
            Button passoAnterior = new Button("<< Voltar p/ Passo 1");
            passoAnterior.setOnAction( e -> {
                janela.setScene(passo1);
                janela.setTitle("Wizard :: Passo 01");
            });
            
            Button proximoPasso = new Button("Ir p/ Passo 3 >>");
            proximoPasso.setOnAction(e -> {
                janela.setScene(passo3);
                janela.setTitle("Wizard :: Passo 03");
            });
            
            HBox box = new HBox();
            box.setAlignment(Pos.CENTER);
            box.getChildren().add(passoAnterior);
            box.getChildren().add(proximoPasso);
            
            passo2 = new Scene(box, 400, 400);
        }
        
        private void criarPasso3() {
            Button passoAnterior = new Button("<< Voltar p/ Passo 2");
            passoAnterior.setOnAction( e -> {
                janela.setScene(passo2);
                janela.setTitle("Wizard :: Passo 02");
            });
            
            Button proximoPasso = new Button("Finalizar!");
            proximoPasso.setOnAction(e -> {
                System.exit(0);
            });
            
            HBox box = new HBox();
            box.setAlignment(Pos.CENTER);
            box.getChildren().add(passoAnterior);
            box.getChildren().add(proximoPasso);
            
            passo3 = new Scene(box, 400, 400);
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Rodando o código acima, vamos conseguir, agora, alternar entre as telas e na tela que estiver escrito, Passo 03, no título, teremos o botão "Finalizar!" para conseguirmos fechar a aplicação.

## Aula 09 - Gerenciadores de Layout:
Bom, uma das coisas que vc precisa prestar atenção quando se trabalha com alguma biblioteca que esteja relacionada à interfaces gráficas é entender como o Layout ela é aplicado dentro dessa tecnologia, pois isso tem total relação com a forma como vc organizará os componentes visuais na tela.

No caso, o Java FX, existe uma séria de gerenciadores de Layout que te ajudarão a construir as suas interfaces gráficas e é exatamente sobre isso que iremos trabalhar nessa aula.

Vamos criar um novo pacote "layout" e, dentro dele, criamos uma nova classe chamado "AppLayout".

No módulo do desse projeto, vamos precisar tornar esse pacote aberto para nos permitir realizar a reflection. Então, realizamos o seguinte

    module exerciciosfx {
        requires javafx.controls;
        
        opens basico;
        opens layout;
    }

Agora, na classe, AppLayout, coom começo, vamos realizar a seguinte inserção

    package layout;

    import javafx.application.Application;
    import javafx.stage.Stage;

    public class AppLayout extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            primaryStage.setTitle("Gerenciadores de Layout");
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

A situação acima, no caso, tem como o passo inicial para verificarmos se modal está aparecendo de forma correta.

Vamos criar duas classes, agora, no mesmo pacote, donde usaremos para nos facilitar na visualização dos gerenciadores de Layouts. Criamos então as classes "Quadrado" e "Caixa".

Na classe, Quadrado, vamos herdar a classe "Rectangle", uma dos gerenciadores de Layout, do Java Fx da seguinte forma

    package layout;

    import javafx.scene.shape.Rectangle;

    public class Quadrado extends Rectangle {

    }

E na classe, Caixa, vamos herdar a classe "HBox", um dos gerenciadores de Layout, do Java FX da seguinte forma

    package layout;

    import javafx.scene.layout.HBox;

    public class Caixa extends HBox {

    }

Agora, na classe, Caixa, vamos construir os construtores padrões, bom, fazer uns preparativos, da seguinte forma

    package layout;

    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.control.Label;
    import javafx.scene.layout.Background;
    import javafx.scene.layout.BackgroundFill;
    import javafx.scene.layout.CornerRadii;
    import javafx.scene.layout.HBox;
    import javafx.scene.paint.Color;

    public class Caixa extends HBox {
        
        private static int i = 0;
        
        private String[] cores = {
            "#c33c5e", "#39aac6", "#28d79a",
            "#fb750e", "#6657a8", "#f9060e"
        };

        public Caixa() {
            // Definimos as larguras e alturas de forma padrão
            this(100, 100);
        }
        
        public Caixa(int largura, int altura) {
            setAlignment(Pos.CENTER);
            
            setMinWidth(largura);
            setMinHeight(altura);
            
            BackgroundFill fill = new BackgroundFill(Color.web(cores[i]), CornerRadii.EMPTY, Insets.EMPTY);
            setBackground(new Background(fill));
            
            i++;
            if(i == 6) i = 0;
        }
        
        public Caixa comTexto(String texto) {
            Label label = new Label(texto);
            getChildren().add(label);
            return this;
        }
    }

Agora, na classe, AppLayout, vamos realizar a seguinte implementação

    package layout;

    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class AppLayout extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            VBox temp = new VBox();
            temp.getChildren().add(new Caixa().comTexto("1"));
            temp.getChildren().add(new Caixa().comTexto("2"));
            temp.getChildren().add(new Caixa().comTexto("3"));
            temp.getChildren().add(new Caixa().comTexto("4"));
            
            Scene principal = new Scene(temp, 800, 600);
            
            primaryStage.setScene(principal);
            primaryStage.setTitle("Gerenciadores de Layout");
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Agora, rodando o código acima, vamos ver que a classe, Caixa, irá rodar os seus métodos e será exibido 4 caixa com cores diferentes no modal que será exibido.

Agora, na classe, Quadrado, vamos realizar algo análogo com a classe, Caixa, da seguinte forma

    package layout;

    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.control.Label;
    import javafx.scene.layout.Background;
    import javafx.scene.layout.BackgroundFill;
    import javafx.scene.layout.CornerRadii;
    import javafx.scene.paint.Color;
    import javafx.scene.shape.Rectangle;

    public class Quadrado extends Rectangle {

        private static int i = 0;
        
        private String[] cores = {
            "#c33c5e", "#39aac6", "#28d79a",
            "#fb750e", "#6657a8", "#f9060e"
        };

        public Quadrado() {
            // Definimos as larguras e alturas de forma padrão
            this(100, 100);
        }
        
        public Quadrado(int largura, int altura) {
            
            setWidth(largura);
            setHeight(altura);
            
            setFill(Color.web(cores[i]));
            
            i++;
            if(i == 6) i = 0;
        }
    }

Agora,  na classe, AppLayout, vamos realizar o seguinte para testar se conseguimos instanciar direito a classe, Quadrado, da seguinte forma

    package layout;

    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class AppLayout extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            // TODO Auto-generated method stub
            
            VBox temp = new VBox();
    //		temp.getChildren().add(new Caixa().comTexto("1"));
    //		temp.getChildren().add(new Caixa().comTexto("2"));
    //		temp.getChildren().add(new Caixa().comTexto("3"));
    //		temp.getChildren().add(new Caixa().comTexto("4"));
    //		temp.getChildren().add(new Caixa().comTexto("5"));
    //		temp.getChildren().add(new Caixa().comTexto("6"));
    //		temp.getChildren().add(new Caixa().comTexto("7"));
            
            temp.getChildren().add(new Quadrado());
            temp.getChildren().add(new Quadrado());
            temp.getChildren().add(new Quadrado());
            temp.getChildren().add(new Quadrado());
            temp.getChildren().add(new Quadrado());
            temp.getChildren().add(new Quadrado());
            temp.getChildren().add(new Quadrado());
            
            Scene principal = new Scene(temp, 800, 600);
            
            primaryStage.setScene(principal);
            primaryStage.setTitle("Gerenciadores de Layout");
            primaryStage.show();
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    }

Bom, até agora, só construímos apenas os preparativos. Nas próximas aulas, iremos entrar contudo na abordagem sobre gerenciamento de layout.

## Aula 10 - AnchorPane:


## Aula 11 - BorderPane:

## Aula 12 - FlowPane:

## Aula 13 - GridPane:

## Aula 14 - StackPane #01:

## Aula 15 - StackPane #02:

## Aula 16 - TilePane:

## Aula 17 - FXML Config:

## Aula 18 - Adicionar Controles:

## Aula 19 - Login Controller:

## Aula 20 - Usando CSS com FXML:

## Aula 21 - Ajustando Layout:

## Aula 22 - Adicionando Margens:

## Aula 23 - Usando ControlsFX:

## Aula 24 - Calculadora:

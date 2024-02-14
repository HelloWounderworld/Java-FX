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

## Aula 06 - Contador #04:

## Aula 07 - Contador #05:

## Aula 08 - Trocando Scenes:

## Aula 09 - Gerenciadores de Layout:

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

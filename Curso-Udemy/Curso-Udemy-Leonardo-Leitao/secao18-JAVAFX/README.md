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

## Aula 03 - Contador #01:

## Aula 04 - Contador #02:

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

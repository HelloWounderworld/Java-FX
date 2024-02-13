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

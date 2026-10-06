# Lista de Filmes

Aplicativo Android desenvolvido em Kotlin utilizando Jetpack Compose.

## Tema escolhido

O tema escolhido para o projeto foi uma **Lista de Filmes**.

O aplicativo permite visualizar filmes, acessar informações individuais de cada filme, acompanhar filmes concluídos e navegar entre diferentes telas do aplicativo.

## Telas implementadas

O projeto possui as seguintes telas:

### Splash Screen
Tela inicial exibida ao abrir o aplicativo.

Ela verifica se o usuário já está logado e direciona para a tela correspondente.

### Login
Tela utilizada para realizar a entrada no aplicativo.

Após o login, o usuário é direcionado para a lista principal de filmes.

### Lista de Filmes
Tela principal do aplicativo, responsável por exibir os filmes disponíveis.

A partir dessa tela, é possível selecionar um filme para visualizar seus detalhes.

### Detalhes do Filme
Tela responsável por apresentar informações específicas sobre o filme selecionado.

Também permite alterar o estado de conclusão do filme.

### Perfil
Tela destinada às informações e opções relacionadas ao usuário.

## Tecnologias utilizadas

- Kotlin
- Android Studio
- Jetpack Compose
- Navigation Compose
- ViewModel
- Kotlin Serialization
- Material Design 3

## Estrutura do projeto

O projeto foi organizado separando as principais responsabilidades da aplicação.

- `model`: contém os modelos e as rotas utilizadas no aplicativo.
- `userinterface`: contém as telas e componentes da interface.
- `viewmodel`: contém a lógica e o gerenciamento dos dados utilizados pelas telas.
- `MainActivity`: responsável por iniciar a aplicação e carregar a navegação principal.

## Como rodar o projeto no Android Studio

1. Faça o download ou clone este repositório.

2. Abra o **Android Studio**.

3. Selecione a opção:

   `Open`

4. Escolha a pasta do projeto.

5. Aguarde o Android Studio finalizar a sincronização do Gradle e baixar as dependências necessárias.

6. Configure um dispositivo para executar o aplicativo. É possível utilizar:

   - Um emulador Android criado pelo Device Manager.
   - Um dispositivo Android físico com a Depuração USB ativada.

7. Selecione o dispositivo desejado na parte superior do Android Studio.

8. Clique no botão **Run** ou utilize o atalho:

   `Shift + F10`

9. Aguarde a compilação e instalação do aplicativo.

Após a inicialização, a Splash Screen será exibida e o aplicativo seguirá para a tela de Login ou para a Lista de Filmes, dependendo do estado do usuário.

## Requisitos

Para executar o projeto é recomendado possuir:

- Android Studio atualizado.
- JDK compatível com a versão utilizada pelo projeto.
- Android SDK instalado.
- Emulador Android ou dispositivo físico.
- Conexão com a internet para o primeiro download das dependências do Gradle.

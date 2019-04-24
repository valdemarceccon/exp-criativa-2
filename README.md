# Experiência criativa - Navegando na computação. Projeto 2

Projeto multimídia utilizando [Processing](https://processing.org/). 

Deverá contemplar imagem, som ou vídeo.

## Descrição do projeto

Projeto didático, para visualização e explicação da idéia por trás diferentes algoritmos de ordenação.

### Funcionalidades da aplicação

1. Selecionar o algoritmo para visualização, entre os disponíveis:
   * Bubble sort
   * Merge sort
   * Insertion sort
   * Quick sort
   * Heap sort

2. Iniciar playback.
    * Inicia a demonstração do algoritimo selecionado.
    * Controles de playback:
        * Pausar
        * Voltar
        * Diminuir velocidade
        * Aumentar velocidade
        * Avançar passo (quando pausado)
        * Retroceder passo (quando pausado)

3. Exportar vídeos do playback
    * Criar um arquivo de vídeo, a partir do playback.
    * A velocidade de exibição do vídeo será a normal
    * Configurações de velocidades, dos controles de playback, não terão efeitos no vídeo final.



## Getting Started


### Pré requisitos

Projeto java, com gerenciamento de dependencias através do maven.

O mínimo para execução do binário, é ter java 8 ou posterior instalado instalado.

Para compilar o projeto é necessário ter maven instalado.

### Instalação

Não é necessário. O jar disponível na página de releases é standalone.

### Execução

Se o sistema operacional não estiver configurado para abrir o arquivo **.jar** com um duplo clique,
será necessário executar através do terminal (linux/mac) ou Prompt de comando/Powershell no Windows.

```
java -jar nomedojar.jar
```

## Compilar

Abrir um terminal na pasta raiz do projeto.

Para compilação o projeto

```
mvn compile
```

Para gerar o binário para distribuição

```
mvn package
```

## Feito com

* [Processing](https://processing.org/) - Software para criação de sketch e uma linguagem de programação para aprender a programar.
* [Maven](https://maven.apache.org/) - Gerenciamento de dependências

## Autores

* **Valdemar Ceccon**


## Licença

Este projeto é licenciado através da licença MIT - mais informações em [LICENSE.md](LICENSE.md).

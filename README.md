# Desafio Números de Série de Veículos

Solução desenvolvida em **Java 21** para processamento de números de série de veículos, contemplando geração e validação de dígitos verificadores, leitura e escrita de arquivos texto e geração de relatórios estatísticos por país.

O projeto foi desenvolvido seguindo boas práticas de orientação a objetos e inclui testes unitários utilizando **JUnit 5**.

---

## Sobre o projeto

Este projeto foi desenvolvido como solução para um desafio técnico com o objetivo de processar números de série de veículos de acordo com regras de negócio previamente definidas.

A aplicação é responsável por:

* Gerar dígitos verificadores para números de série;
* Validar números de série existentes;
* Processar arquivos de entrada e saída;
* Gerar relatórios estatísticos por país;
* Garantir a confiabilidade das regras através de testes unitários.

---

## Regras de negócio

O número de série é composto pelos seguintes blocos:

| Campo                | Tamanho |
| -------------------- | ------- |
| Ano de fabricação    | 2       |
| Ano do modelo        | 2       |
| Código do país       | 3       |
| Campo reservado (XX) | 2       |
| Tipo do veículo      | 1       |
| Sequencial           | 4       |
| Dígito verificador   | 1       |

### Exemplo

```text
2122BRAXXA3348-F
```

Onde:

* 21 → Ano de fabricação
* 22 → Ano do modelo
* BRA → Brasil
* XX → Campo reservado
* A → Automóvel
* 3348 → Sequencial
* F → Dígito verificador

---

## Funcionalidades implementadas

### 1. Geração de Dígito Verificador

Leitura do arquivo:

```text
serieSemDV.txt
```

Geração do arquivo:

```text
serieComDV.txt
```

Calculando automaticamente o dígito verificador conforme especificação do desafio.

---

### 2. Validação de Números de Série

Leitura do arquivo:

```text
serieParaVerificar.txt
```

Geração do arquivo:

```text
serieVerificada.txt
```

Informando para cada registro se o dígito verificador informado está correto ou não.

Exemplo:

```text
1920ROUXXA2578-9 verdadeiro
0505MEXXXM5282-4 falso
```

---

### 3. Relatório de Automóveis por País

Leitura dos arquivos:

```text
serieParaRelatorio.txt
paises.txt
```

Geração do arquivo:

```text
listaTotais.txt
```

O relatório:

* Considera apenas veículos do tipo Automóvel (A);
* Agrupa os registros por país;
* Ordena alfabeticamente pelo nome do país;
* Exibe a quantidade total produzida.

---

## Tecnologias Utilizadas

* Java 21
* Eclipse IDE
* JUnit 5
* Java NIO (manipulação de arquivos)
* Collections Framework

---

## Estrutura do Projeto

```text
src/
│
├── model/
├── service/
├── util/
├── exception/
├── test/
└── Main.java
```

> A estrutura pode variar de acordo com a organização adotada durante o desenvolvimento.

---

## Cálculo do Dígito Verificador

O dígito verificador é calculado através da soma dos códigos ASCII dos primeiros 14 caracteres do número de série.

### Exemplo

```text
2122BRAXXA3348
```

Soma dos códigos ASCII:

```text
863
```

Cálculo:

```text
863 % 16 = 15
```

Representação hexadecimal:

```text
F
```

Resultado final:

```text
2122BRAXXA3348-F
```

---

## Testes Unitários

Foram desenvolvidos testes unitários utilizando **JUnit 5** para garantir a confiabilidade das regras implementadas.

### Cenários testados

* Cálculo correto do dígito verificador;
* Validação de números de série válidos;
* Validação de números de série inválidos;
* Processamento dos arquivos de entrada;
* Geração correta dos relatórios;
* Tratamento de entradas inválidas.

## Como Executar

### Pré-requisitos

* Java 21 instalado
* Eclipse IDE (opcional)

### Executando pelo Eclipse

1. Importe o projeto como **Java Project**.
2. Configure a JDK 21.
3. Execute a classe principal da aplicação.

### Executando via terminal

```bash
javac *.java
java Main
```

---

## Boas Práticas Aplicadas

* Programação Orientada a Objetos (POO);
* Princípio da Responsabilidade Única (SRP);
* Encapsulamento;
* Separação entre regras de negócio e manipulação de arquivos;
* Código limpo e legível;
* Testes unitários automatizados;
* Uso de constantes para evitar valores mágicos.

---

## Possíveis Melhorias

* Utilização de Maven ou Gradle;
* Geração de logs da aplicação;
* Exportação de relatórios em CSV;
* Integração contínua (CI/CD);
* Interface gráfica para execução das operações;
* Ampliação da cobertura de testes.

---

## Autor

**Dalmo Facuri**

Projeto desenvolvido em Java 21 como solução para desafio técnico de processamento e validação de números de série de veículos, com foco em boas práticas de desenvolvimento e testes unitários.

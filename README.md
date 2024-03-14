# Sumário

- [Sumário](#sumário)
  - [Definição do Projeto](#definição-do-projeto)
    - [Descrição](#descrição)
    - [Perfil do Usuário](#perfil-do-usuário)
  - [Documento de Requisitos](#documento-de-requisitos)
    - [Introdução](#introdução)
    - [Requisitos Funcionais](#requisitos-funcionais)
      - [Cadastro de Usuário](#cadastro-de-usuário)
      - [Login](#login)
      - [Perfil do Usuário](#perfil-do-usuário-1)
      - [Edição/Exclusão do Perfil do Usuário](#ediçãoexclusão-do-perfil-do-usuário)
      - [Listagem de Livros](#listagem-de-livros)
      - [Busca e Filtros](#busca-e-filtros)
      - [Solicitação de Troca](#solicitação-de-troca)
      - [Avaliações e Comentários](#avaliações-e-comentários)
      - [Notificações e Alertas](#notificações-e-alertas)
      - [Gerenciamento de Biblioteca Pessoal](#gerenciamento-de-biblioteca-pessoal)
    - [Requisitos de Qualidade](#requisitos-de-qualidade)
      - [Usabilidade](#usabilidade)
      - [Acessibilidade](#acessibilidade)
      - [Comunicabilidade](#comunicabilidade)
      - [Testes e Garantia de Qualidade](#testes-e-garantia-de-qualidade)
      - [Suporte ao Cliente](#suporte-ao-cliente)
    - [Considerações Finais](#considerações-finais)
  - [Diagrama de classes](#diagrama-de-classes)
  - [Diagrama de casos de uso](#diagrama-de-casos-de-uso)
  - [Atividades de teste a serem empregadas](#atividades-de-teste-a-serem-empregadas)
  - [Desenvolvedores](#desenvolvedores)
  - [Licença](#licença)

## Definição do Projeto  

### Descrição 

O **BookSwap Universitário** é um aplicativo digital desenvolvido em `java` pelo time composto por Jhoan, Caue e Dayverson, projetado para facilitar o compartilhamento de conhecimento entre estudantes universitários no Brasil. O objetivo principal é resolver um desafio comum enfrentado pelos alunos: a gestão econômica e eficiente dos materiais didáticos. A plataforma permite que os usuários troquem livros ociosos por livros que lhes interessem, promovendo não apenas a economia entre os estudantes, mas também uma comunidade de aprendizado colaborativo.

### Perfil do Usuário

O público-alvo da BookSwap Universitário é composto por estudantes universitários entre 18 e 35 anos, independentemente do gênero, localização geográfica ou área de estudo. Esses usuários possuem um nível moderado a avançado de proficiência tecnológica, estão familiarizados com aplicativos móveis e plataformas _on-line_, e são ativos em redes sociais. Eles enfrentam desafios financeiros durante sua jornada acadêmica e buscam soluções econômicas para otimizar seus recursos.

## Documento de Requisitos 

### Introdução

O Documento de Requisitos descreve os requisitos funcionais e de qualidade para o desenvolvimento do **BookSwap Universitário**, uma plataforma digital projetada para facilitar o compartilhamento de livros entre estudantes universitários.

### Requisitos Funcionais

#### Cadastro de Usuário

- Os usuários devem poder se cadastrar na plataforma fornecendo informações básicas como nome, e-mail, instituição de ensino, localização, senha.
  
#### Login

- Os usuários devem poder fazer login na plataforma fornecendo seu e-mail e senha previamente cadastrados para acessar suas contas e funcionalidades personalizadas.

#### Perfil do Usuário

- Cada usuário terá um perfil pessoal onde poderá listar os livros disponíveis para troca, acompanhar suas transações passadas e receber feedback.

#### Edição/Exclusão do Perfil do Usuário

- Os usuários devem poder editar ou excluir suas informações de perfil, garantindo controle sobre suas informações pessoais na plataforma.

#### Listagem de Livros

- Os usuários devem poder adicionar livros à sua lista de troca, incluindo detalhes como título, autor, edição e estado de conservação.

#### Busca e Filtros

- Os usuários devem poder buscar livros específicos por título, autor ou área de estudo, além de utilizar filtros para refinar os resultados.

#### Solicitação de Troca

- Deve existir um mecanismo que permita aos usuários solicitar a troca de livros com outros usuários, incluindo um sistema de notificações para informar sobre novas solicitações.

#### Avaliações e Comentários

- Os usuários podem avaliar e deixar comentários sobre os livros trocados, proporcionando feedback útil para outros membros da comunidade.

#### Notificações e Alertas

- A plataforma deve enviar notificações para informar sobre novas mensagens, solicitações de troca, feedback recebido e eventos importantes na plataforma.

#### Gerenciamento de Biblioteca Pessoal

- Funcionalidade que permite aos usuários organizar e manter registros de sua biblioteca pessoal, incluindo livros emprestados e trocados.

### Requisitos de Qualidade

#### Usabilidade

- Interface para todos os usuários.

#### Acessibilidade

- Plataforma adequada para usuários com diferentes necessidades.

#### Comunicabilidade

- Sistema de comunicação entre usuários, incluindo mensagens diretas e notificações.

#### Testes e Garantia de Qualidade

- Realização de testes para identificar e corrigir bugs, garantindo estabilidade e confiabilidade.

#### Suporte ao Cliente

- Oferecimento de suporte ao cliente, incluindo recursos de ajuda online e resposta rápida a consultas.


### Considerações Finais

Este Documento de Requisitos delineia os requisitos funcionais e de qualidade para o desenvolvimento do BookSwap Universitário. Esses requisitos devem ser considerados durante todo o processo de desenvolvimento para garantir que a plataforma atenda às necessidades dos usuários e ofereça uma experiência satisfatória.

## Diagrama de classes

![DiagramaDeClasses](https://github.com/JhoanDev/BookSwap/blob/main/DiagramaDeClasses.png)

## Diagrama de casos de uso

![DiagramaDeCasosDeUso](https://github.com/JhoanDev/BookSwap/blob/main/DiagramaDeCasosDeUso.png)

## Atividades de teste a serem empregadas

**Teste de Unidade:**
- Verificar individualmente cada componente do sistema para garantir que eles funcionem conforme o esperado.

**Teste de Integração:**
- Testar a integração entre os diferentes módulos do sistema para garantir que funcionem harmoniosamente junto.

**Teste de Aceitação:**
- Iremos usar o sistema como usuários reais para testar o sistema e fornecer feedback sobre a usabilidade, a fim de garantir que atenda às suas necessidades e expectativa.

**Teste de Sistema:**
- Testar o sistema como um todo para verificar se todas as partes integradas funcionam corretamente e atendem aos requisitos do sistema.

**Análise do Valor Limite:**
- Identificar e testar os valores limites dentro das faixas permitidas para entrada de dados, a fim de verificar se o sistema se comporta corretamente próximo aos limites de suas especificações.

**Tabela de Decisão:**
- Desenvolver uma tabela de decisão que identifique todas as possíveis combinações de condições de entrada e seus resultados esperados, a fim de garantir que todas as condições sejam testadas adequadamente.

**Error Guessing:**
- Utilizar experiência, intuição e conhecimento geral para antecipar e testar cenários de erro que podem ocorrer durante a execução do sistema.

## Desenvolvedores

- Jhoan Fernandes de Oliveira
- Claudio Caueh Oliveira Xavier
- Dayvison Eryc de Moura Silva

## Licença

Este projeto é distribuído sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

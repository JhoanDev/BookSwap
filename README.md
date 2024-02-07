# Sumário

1. [Definição do Projeto](#definição-do-projeto)
   - [Descrição](#descrição)
   - [Perfil do Usuário](#perfil-do-usuário)
2. [Documento de Requisitos](#documento-de-requisitos)
   - [Introdução](#introdução)
   - [Requisitos Funcionais](#requisitos-funcionais)
     - [Cadastro de Usuário](#cadastro-de-usuário)
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
3. [Diagrama de Classes](#diagrama-de-classes)
4. [Desenvolvedores](#desenvolvedores)
5. [Licença](#licença)

## Definição do Projeto  

### Descrição 

O **BookSwap Universitário** é um aplicativo digital desenvolvido em `java` pelo time composto por Jhoan, Caue e Dayverson, projetado para facilitar o compartilhamento de conhecimento entre estudantes universitários no Brasil. O objetivo principal é resolver um desafio comum enfrentado pelos alunos: a gestão econômica e eficiente dos materiais didáticos. A plataforma permite que os usuários troquem livros ociosos por livros que lhes interessem, promovendo não apenas a economia entre os estudantes, mas também uma comunidade de aprendizado colaborativo.

### Perfil do Usuário

O público-alvo da BookSwap Universitário é composto por estudantes universitários entre 18 e 35 anos, independentemente do gênero, localização geográfica ou área de estudo. Esses usuários possuem um nível moderado a avançado de proficiência tecnológica, estão familiarizados com aplicativos móveis e plataformas online, e são ativos em redes sociais. Eles enfrentam desafios financeiros durante sua jornada acadêmica e buscam soluções econômicas para otimizar seus recursos.

## Documento de Requisitos 

### Introdução

O Documento de Requisitos descreve os requisitos funcionais e de qualidade para o desenvolvimento do **BookSwap Universitário**, uma plataforma digital projetada para facilitar o compartilhamento de livros entre estudantes universitários.

### Requisitos Funcionais

#### Cadastro de Usuário

- Os usuários devem poder se cadastrar na plataforma fornecendo informações básicas como nome, e-mail, instituição de ensino, localização, senha.

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

- A interface deve ser intuitiva e fácil de usar, garantindo uma experiência amigável para usuários de diferentes níveis de habilidade tecnológica.

#### Acessibilidade

- A plataforma deve ser acessível a usuários com diferentes necessidades, seguindo padrões de acessibilidade e permitindo o uso por pessoas com deficiências.

#### Comunicabilidade

- Sistema eficiente de comunicação entre usuários, incluindo mensagens diretas, notificações claras e informações concisas sobre trocas e eventos.


#### Testes e Garantia de Qualidade

- Realização de testes rigorosos para identificar e corrigir bugs, garantindo a estabilidade e confiabilidade da plataforma.

#### Suporte ao Cliente

- Oferecimento de suporte ao cliente eficaz, incluindo recursos de ajuda online, chat ao vivo e resposta rápida a consultas.

### Considerações Finais

Este Documento de Requisitos delineia os requisitos funcionais e de qualidade para o desenvolvimento do BookSwap Universitário. Esses requisitos devem ser considerados durante todo o processo de desenvolvimento para garantir que a plataforma atenda às necessidades dos usuários e ofereça uma experiência satisfatória.

## Diagrama de classes

![DiagramaDeClasses](https://github.com/JhoanDev/BookSwap/blob/main/BookSwap.png)

## Desenvolvedores

- Jhoan Fernandes de Oliveira
- Claudio Caueh Oliveira Xavier
- Dayvison Eryc de Moura Silva

## Licença

Este projeto é distribuído sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

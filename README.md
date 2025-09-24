# 📱 Delici'art Sabores

O **Delici’art Sabores** é um aplicativo móvel desenvolvido para a empresa **Delici’art Sabores**, especializada na produção de doces e salgados.  
O app tem como objetivo **facilitar o gerenciamento de pedidos**, trazendo organização, rapidez e eficiência no atendimento e controle das encomendas.

---

## 🚀 1) Definição do Projeto

- **Nome:** Delici’art Sabores  
- **Plataforma:** Mobile (Android no MVP)  
- **Descrição:**  
  Com o aumento da demanda, o processo manual de registro de pedidos tornou-se inviável.  
  O aplicativo foi criado para **padronizar e automatizar**:

  - Cadastro de clientes e itens  
  - Criação e atualização de pedidos  
  - Configuração de entrega/retirada  
  - Acompanhamento do ciclo do pedido por status  

  O **MVP é exclusivamente mobile**, priorizando simplicidade, registros consistentes e agilidade.

---

## 📋 2) Regras de Negócio

1. Cliente único por telefone (CPF e e-mail opcionais).  
2. Itens com variantes (tamanho/sabor) e preço por variante.  
3. Status do pedido: **Aberto → Confirmado → Em Produção → Pronto → Entregue/Retirado → Concluído**; Cancelado (com motivo).  
4. Pedido só entra em produção após **confirmação manual**.  
5. Prazo do dia (aceite até horário de corte configurável).  
6. **Entrega:** endereço + taxa + horário | **Retirada:** loja + horário.  
7. Registro de pagamento: dinheiro, PIX ou cartão (sem integração online no MVP).  
8. Descontos aplicados manualmente (% ou valor fixo).  
9. Lista do dia exibe apenas **pedidos confirmados** do dia.  
10. Histórico registra todas alterações de status e valores.  

---

## ⚙️ 3) Requisitos Funcionais (RF)

- **RF01**: Login simples (PIN/senha).  
- **RF02**: Cadastro/edição de **clientes** (nome, telefone\*, CPF, e-mail, endereço).  
- **RF03**: Cadastro/edição de **itens** (nome, categoria, variantes, preço, disponibilidade).  
- **RF04**: **Pedidos** (cliente, itens, observações, entrega/retirada, taxa, desconto, total).  
- **RF05**: **Status** do pedido e mudança manual.  
- **RF06**: **Histórico de pedidos** com filtros (período/cliente/status).  
- **RF07**: **Lista do dia** com opção de impressão/compartilhamento.  
- **RF08**: Busca rápida (cliente, pedido, item).  
- **RF09**: Exportação simples (CSV) de pedidos.  

---

## 🛡️ 4) Requisitos Não Funcionais (RNF)

- **RNF01 Usabilidade:** telas diretas, otimizadas para smartphone.  
- **RNF02 Desempenho:** cadastro/atualização de pedido em < 2s.  
- **RNF03 Confiabilidade:** salvamento automático + feedback visual.  
- **RNF04 Segurança:** PIN/senha + backup criptografado local.  
- **RNF05 Plataforma:** Android (MVP); iOS em fase futura.  
- **RNF06 Offline-first:** funcionamento sem internet; dados locais.  
- **RNF07 LGPD:** mínimo de dados (telefone obrigatório); edição/remoção permitida.  

---

## 🖼️ 5) Telas do MVP

1. **Login**  
2. **Cadastro inicial** (primeira execução)  
3. **Home** (atalhos: Novo Pedido, Lista do Dia, Clientes, Itens)  
4. **Cadastro de Pedidos**  
5. **Cadastro de Itens**  
6. **Cadastro de Clientes**  
7. **Histórico de Pedidos**  
8. **Lista de Pedidos do Dia**  

---

## 📂 Estruturação do Projeto

O projeto foi estruturado no **GitLab**, garantindo versionamento, organização e colaboração entre os envolvidos.  

🔗 Link do repositório: [GitLab - Delici’art Sabores](https://gitlab.com/joao08chiarello08/DeliciartSabores)  

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Kotlin  
- **Framework:** Jetpack Compose  
- **Banco de Dados Local:** Room  
- **Arquitetura:** MVVM  
- **Controle de Versão:** Git + GitHub/GitLab  

---

## 📌 Status do Projeto

📍 Em desenvolvimento – versão **MVP Mobile Android**  

---

## 👥 Autores

- Desenvolvido por: **João Gabriel, João Henrique Ampeze, Gabriela Cristina Becker e Amanda Henz**  
- Empresa parceira: **Delici’art Sabores**  

---

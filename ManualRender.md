
### **Manual de Recriação do Banco no Render**

## **1: Limpar o Banco Antigo (No Painel do Render)**
O Render só permite **um banco de dados gratuito por conta**. Deletar o portifolio-db-v2:

1. Acessar o painel do Render.
1. Clicar em cima do seu banco de dados antigo que está suspenso (portifolio-db-v2).
1. No menu lateral, cliquar em **Settings** (Configurações).
1. Rolar a página até o final clicar botão vermelho **Delete Database**.
1. Digitar o nome do banco para confirmar a exclusão.

## **2: Criar o Novo Banco (portifolio-db-v3)**
1. No topo do painel do Render, clicar no botão **New +** e escolha **PostgreSQL**.
1. Preencher os campos exatamente:
   1. **Name:** portifolio-db-v3
   1. **Database:** portfolio\_db
   1. **User:** eder
   1. **Region:** Escolher a **mesma região** onde está o projeto Java portfolioapi-eder (geralmente *Ohio - us-east-2* ou *Oregon*).
   1. **Instance Type:** Selecione a opção **Free**.
1. Botão: **Create Database**.

## **3: Copiar as Novas Credenciais**
1 minuto até o status do novo banco mudar para **Available**.

1. Na mesma página do novo banco, rolar até a seção **Connections**.
1. Copiar 4 informações de lá:
   1. **Hostname** (Internal ou External Host)
   1. **Database** (Nome do banco)
   1. **Username** (Usuário)
   1. **Password** (Senha)
   
## **4: Atualizar o Web Service (portfolioapi-eder)**
Colar esses dados na sua aplicação Java para ela voltar à vida:
1. No topo do painel do Render, clicar em **Dashboard** e selecione o seu Web Service **portfolioapi-eder**.
1. No menu lateral esquerdo, clique em **Environment**.
1. Na tabela de **Environment Variables**, altere os valores das chaves existentes colocando os dados novos:
   1. RENDER\_POSTGRES\_HOST -> **Hostname**.
   1. RENDER\_POSTGRES\_DB -> **Database**.
   1. RENDER\_POSTGRES\_USER -> **Username**.
   1. RENDER\_POSTGRES\_PASSWORD -> **Password**.
1. **Save Changes**.
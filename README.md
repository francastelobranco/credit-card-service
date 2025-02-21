# credit-card

O **Credit Card Service** é um serviço backend desenvolvido em **Java 17**, utilizando o **Spring Boot** para gerenciamento de cartões de crédito, permitindo cadastro, ativação e consulta de cartões físicos e virtuais.

## 📡 Endpoints da API

### Cliente:

#### Endpoint
- **URL:** `/cliente`
- **Método:** `POST`
- **Descrição:** Registra um novo cliente no sistema.

##### Corpo da Requisição (JSON)
```json
{
  "nomeCliente": "Exemplo",
  "cpf": "00000000000",
  "email": "exemplo@email.com",
  "telefone": "11999999999",
  "endereco": {
    "cep": "01001000",
    "logradouro": "Avenida Paulista",
    "numero": "1000",
    "complemento": "Apto 101",
    "bairro": "Bela Vista"
  }
}
```
---
### Conta:
#### Endpoint
- **URL:** `/conta`
- **Método:** `POST`
- **Descrição:** Registra uma nova conta no sistema.

##### Corpo da Requisição (JSON)
```json
{
    "agencia": "0000",
    "conta": "000000",
    "cliente": {
        "id": 1
    }
}
```
---
#### Endpoint
- **URL:** `/conta/buscarPorId/{id}`
- **Método:** `GET`
- **Descrição:** Busca por um cliente no sistema através do ID.

---
#### Endpoint
- **URL:** `/conta/buscaPorCpf/{cpf}`
- **Método:** `GET`
- **Descrição:** Busca por um cliente no sistema através do CPF.
---
#### Endpoint
- **URL:** `/conta/inativarPorId/{id}`
- **Método:** `PUT`
- **Descrição:** Inativa um cliente do sistema através do ID.
---

### Cartão:
#### Endpoint
- **URL:** `/cartao/cadastrarCartao`
- **Método:** `POST`
- **Descrição:** Cria um novo cartão no sistema.

##### Corpo da Requisição (JSON)
```json
{
  "numero": "1234123412341234",
  "bandeira": "VISA",
  "conta": {
    "id": 1
  }
}
```
---
#### Endpoint
- **URL:** `/cartao/cadastrarCartao/virtual/{id_conta}`
- **Método:** `POST`
- **Descrição:** Cria um novo cartão virtual no sistema através do id da conta.

##### Corpo da Requisição (JSON)
```json
{
  "numero": "1234123412341200",
  "nomeTitular": "exemplo",
  "bandeira": "VISA",
  "conta": {
    "id": 1
  }
}
```
---
#### Endpoint
- **URL:** `/cartao/enviarCartaoFisico/{id_cartao}`
- **Método:** `PUT`
- **Descrição:** Envia o cartão do cliente para seu endereço.
- ---
#### Endpoint
- **URL:** `/cartao/confirmarRecebimentoCartaoFisico/{id_cartao}`
- **Método:** `PUT`
- **Descrição:** Confirma recebimento do cartão do cliente em seu endereço.
- ---
#### Endpoint
- **URL:** `/cartao/ativarPorId/{id_cartao}`
- **Método:** `PUT`
- **Descrição:** Ativa o cartão do cliente após seu recebimento.# credit-card-service

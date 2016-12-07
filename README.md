# jsnack

## Instruções de Execução

Para executar a aplicação, basta executar o comando

	mvn wildlfy-swarm:run

a partir do diretório raiz, onde está o arquivo pom.xml.

A aplicação estará disponível a partir do endereço 

	http://localhost:8081/rest



## Endpoints da API REST

### GET /rest/snacks
  - retorna lanches disponíveis no cardápio


### GET /rest/snacks/ingredients
  - retorna ingredientes disponíveis para a composição de lanches personalizados


### POST /rest/orders/placeOrder
  - espera um payload JSON no formato

	{
		"snackId": Integer
	}
  
  - sendo "snackId" o ID de um lanche já cadastrado.

ex.:

	{
		"snackId": 1
	}


### POST /rest/orders/placeCustomOrder
  - espera um payload JSON no formato

	{
		"ingredientIds": [Integer]
	}

  - sendo "ingredientIds" um array de IDs de ingredientes disponíveis para a composição de lanches personalizados. Obs.: O array pode conter IDs repetidos para representar a quantidade do respectivo ingrediente.

ex.:

	{
		"ingredientIds": [1, 1, 2]
	}

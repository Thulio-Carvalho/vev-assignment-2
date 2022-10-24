# VeV Assignment #2

> Aplicação que processa boletos. Este app deve ser desenvolvido de acordo com padrões de Test Driven Development.

## Especificação

A aplicação é um processador de boletos. O processador deve verificar todos os boletos e, caso o valor da soma de todos os boletos seja maior que o valor da fatura, então essa fatura deverá ser considerada como paga.

Uma fatura contém:
 - Data 
 - Valor total
 - Nome do cliente. 

Um boleto contém:
 - Código do boleto
 - Data
 - Valor pago.

O processador de boletos, ao receber uma lista de boletos, deve então, para cada boleto, criar um "pagamento" associado a essa fatura. Esse pagamento contém o valor pago, a data, e o tipo do pagamento efetuado (que nesse caso é "BOLETO").

Como dito anteriormente, caso a soma de todos os boletos ultrapasse o valor da fatura, a mesma deve ser marcada como "PAGA".

**Exemplo**: Fatura de 1.500,00 com 3 boletos no valor de 500,00, 400,00 e 600,00: fatura marcada como PAGA, e três pagamentos do tipo BOLETO criados.



## Como Usar [WIP]


## Desenvolvimento [WIP]


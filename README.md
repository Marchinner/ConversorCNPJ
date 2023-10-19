# Conversor CNPJ
Este simples programa tem o objetivo de resolver um problema pontual
em um dos setores da empresa que lida diariamente com CNPJs de clientes.
O problema é que quando o usuário vai copiar o CNPJ no sistema, o mesmo
vem para a área de transferência no formato XX.XXX.XXX/0001-XX, porém
ao reutilizar o CNPJ como informação em outra parte do sistema, o mesmo
subentende que o usuário irá digitar e não colar um texto, pois insere
automaticamente os pontos, barras e traços nos locais corretos, portanto,
quando o usuário vai colar o CNPJ no formato acima, o campo de entrada de
texto do sistema acaba 'comendo' parte do CNPJ informado, pois ultrapassa
a quantidade correta de caracteres, necessitando então que o usuário 
manualmente remova os pontos, barras e traços para ficar somente os números.

## Funcionamento
O usuário informa no primeiro campo o CNPJ no formato XX.XXX.XXX/0001-XX e clica
no botão 'Converter'. O CNPJ convertido somente em números será automaticamente 
copiado para a área de transferência, ficando disponível no 'CTRL+V'.
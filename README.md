# gesplan-back-end

Para a aplicação rodar:

1) Subir o banco em docker: docker run --name postgres_hibernate -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=product-db -p 5432:5432 -d postgres

2) No seguinte caminho: "gesplan_back_end\src\main\java\com\patrick\gesplanbakend\configuration\WebConfigCors.java"
Nesta classe esta definido o seguinte conteudo ".allowedOrigins("http://localhost:5173")" 
Ao subir a aplicação front-end  trocar o "http://localhost:5173" para o endereço respctivo que subiu sua aplicação.
Caso contrario a sua aplicação front-end não ira conseguir se comunicar com esta aplicação back-end por conta das 
politicas de CORS

------------------------------------------------

Na pasta do projeto tem o arquivo requisicoes_api.json
Caso queiram testar a api fora do front-end.

Basta importar este arquivo no insomnia.
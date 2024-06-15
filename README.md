# gesplan-back-end

Para a aplicação rodar:

1) Subir o banco em docker

docker run --name postgres_hibernate -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=product-db -p 5432:5432 -d postgres
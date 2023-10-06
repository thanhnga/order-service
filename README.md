# HOW TO RUN
- clone source code: `git clone https://github.com/thanhnga/order-service.git`
- cd to source code folder: cd `./order-service`
- run docker compose: `docker-compose up -d`

# HOW TO TEST
- follow the `Order service design.docx` for testing steps.

# OTHERS
- when application init running, it insert the sample data from `/db/changelog/data-0.0.1.sql` file

# HOW TO GENERATE PRIVATE KEY/PUBLIC KEY
- run: `./gradlew test --tests io.digital101.RSAKeyPairGenerator.generateKeyPair` at terminal. It write key to `app.key` and `app.key.pub`

# HOW TO TEST
- get token: `export TOKEN='curl -XPOST user:password@localhost:8080/token'` 
- get request by token: `curl -H "Authorization: Bearer $TOKEN" localhost:8080 && echo`

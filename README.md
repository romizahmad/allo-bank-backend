# Setup / Run Instructions

###### clone:

#### git clone https://github.com/romizahmad/allo-bank-backend.git
#### cd allo-bank-backend

###### build:

#### mvn clean install

###### run:

#### mvn spring-boot:run

# Endpoint Usage

###### Latest IDR rates:

curl http://localhost:8080/api/finance/data/latest_idr_rates

###### Historical:

curl http://localhost:8080/api/finance/data/historical_idr_usd

###### Supported currencies:

curl http://localhost:8080/api/finance/data/supported_currencies

# Personalization Note

#### gitHub username: romizahmad
#### spread factor: 0.00068

---------------------------------------------------------------

# Architectural Rationale

Strategy Pattern: each resource has its own class to keep code clean and easy to extend.

FactoryBean: creates a configurable WebClient in one place, cleaner than a normal @Bean.

ApplicationRunner: loads all data at startup so the API serves cached data safely.
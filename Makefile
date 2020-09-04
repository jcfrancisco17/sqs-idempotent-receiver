.RECIPEPREFIX +=

.env:
  cp .env.example .env

.PHONY: test
test:
  sh gradlew test

.PHONY: build
build:
  ./gradlew assemble

.PHONY: run
run: .env
  docker-compose up

.PHONY: logs
logs:
  docker logs -f sqs-idempotent-receiver

.PHONY: start
start:
  $(MAKE) build
  $(MAKE) run

# Use this if you want to run the app via IDE, make sure env is passed properly
.PHONY: start-no-app
start-no-app:
  $(MAKE) build
  docker-compose up -d postgres
  docker-compose up -d localstack

.PHONY: stop
stop:
  docker-compose down

.PHONY: restart
restart:
  $(MAKE) stop
  $(MAKE) start

# .PHONY: testInt
# testInt: .env
#   docker-compose up -d postgres
#   docker-compose up -d localstack
#   sh gradlew testInt
#   docker-compose down
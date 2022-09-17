# POC - OpenTelemetry

## TECNOLOGIAS

- OTEL (Open Telemetry)
- DOCKER
- DOCKER COMPOSE
- JAEGER
- PROMETHEUS
- JAVA (Spring)
- MAVEN
- GIT


## INSTALAÇÃO & CONFIGURAÇÃO

### DOCKER

#### AMBIENTE LOCAL - MAC

Instalar hyperkit e minikube
    
    brew install hyperkit
    brew install minikube

Instalar Docker CLI
    
    brew install docker
    brew install docker-compose


## EXECUÇÃO

### AMBIENTE LOCAL - MAC

#### ATIVAR OS COMANDOS DOCKER

Iniciar o Minikube
    
    minikube start

Configurar o Docker CLI para se comunicar com a VM do Minikube
    
    eval $(minikube docker-env)

Salvar o IP do Minikube à um hostname
    
    echo "`minikube ip` docker.local" | sudo tee -a /etc/hosts > /dev/null

### CONSTRUIR IMAGENS DOS CONTAINERS

Os módulos do projeto precisam ser construídos antes de executar o docker compose.

Executar os comandos abaixo a partir do diretório raíz do projeto.

    Ex: docker build -t <NOME DA IMAGEM> <DIRETÓRIO DO DOCKERFILE>

    docker build -t server-api ./server-api
    docker build -t location-api ./location-api
    docker build -t otel-collector ./otel-collector
    docker build -t prometheus ./prometheus

### SUBIR O AMBIENTE

    docker-compose up


## ENDPOINTS

### API's
A POC possui duas aplicações que "conversam" entre elas para poder simular o rastreio das chamadas

- Server

  <IP DO SERVIDOR>:8080/cities/{id}

- Location

  <IP DO SERVIDOR>:8081/cities/{id}

OBSERVAÇÃO -> A aplicação só possui 5 (id's de 1 a 5) cidades cadastradas

### VENDORS

- Jaeger

  <IP DO SERVIDOR>:16686

- Prometheus

  <IP DO SERVIDOR>:9090


## VALIDAÇÃO

Após subir o ambiente, espere em torno de 30 segundos, para que todos serviços estejam em execução.
Depois disso, execute uma chamada à API do Server, no endpoint indicado acima.

    EX: http://localhost:8080/cities/1

Você obter uma resposta parecida com essa:

    {"id":1,"name":"São Paulo","state":"SP"}

Agora entre no Jaeger, através do endpoint da interface apresentada acima.
Na parte esquerda da interface, na aba "Search", procure em "Service" pela aplicação "server-api" e clique em "Find Traces".
A direita da interface deve aparecer o trace da chamada. Clicando nela você poderá verificar todo o ciclo da requisição.

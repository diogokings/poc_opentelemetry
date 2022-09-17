# LOCATION-API

## DOCKER

### INSTALL & CONFIGURATION

#### MAC

Install hyperkit and minikube
    
    brew install hyperkit
    brew install minikube

Install Docker CLI
    
    brew install docker
    brew install docker-compose

#### WINDOWS

TODO: Colocar em ingles

Para conseguir criar a imagem do docker localmente, tive que rodar o comando abaixo no Windows, para que o tamanho do log pudesse ser maior que 1MB

    docker info --format '{{.LoggingDriver}}'

### STARTING DOCKER

#### MAC

Start minikube
    
    minikube start

Tell Docker CLI to talk to minikube's VM
    
    eval $(minikube docker-env)

Save IP to a hostname
    
    echo "`minikube ip` docker.local" | sudo tee -a /etc/hosts > /dev/null


## RUNNING THE APPLICATION LOCALLY

Comando para executar o build
    
    docker build -t realms .

Comando para rodar a aplicação
    
    docker run -p 8081:8080 realms-service
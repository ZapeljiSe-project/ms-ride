# RSO: Microservice Ride for ZapeljiSe app

## Prerequisites

```bash
docker run -d --name pg-image-metadata -e POSTGRES_USER=dbuser -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=image-metadata -p 5432:5432 postgres:13

docker run -d --name pg-ride -e POSTGRES_USER=wvgniptg -e POSTGRES_PASSWORD=pqJ1wX3BPdwlvTBWEEnSM2klLIbZufyx -e POSTGRES_DB=msride -p 5432:5432 
postgres:13
```

## Build and run commands
```bash
mvn clean package
cd api/target
java -jar ms-ride-api-1.0.0-SNAPSHOT.jar
```
Available at: localhost:8080/v1/images

## Docker commands
```bash
docker build -t novaslika .   
docker images
docker run novaslika    
docker tag novaslika prporso/novaslika   
docker push prporso/novaslika  
```
```bash
docker network ls  
docker network rm rso
docker network create rso
docker run -d --name pg-image-metadata -e POSTGRES_USER=dbuser -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=image-metadata -p 5432:5432 --network rso postgres:13
docker inspect pg-image-metadata
docker run -p 8080:8080 --network rso -e KUMULUZEE_DATASOURCES0_CONNECTIONURL=jdbc:postgresql://pg-image-metadata:5432/image-metadata prporso/ms-ride:2022-11-14-12-45-13
```

## Kubernetes
```bash
kubectl version
kubectl --help
kubectl get nodes
kubectl create -f ms-ride-deployment.yaml 
kubectl apply -f ms-ride-deployment.yaml 
kubectl get services 
kubectl get deployments
kubectl get pods
kubectl logs ms-ride-deployment-6f59c5d96c-rjz46
kubectl delete pod ms-ride-deployment-6f59c5d96c-rjz46
```

Kubernetes secrets configuration: https://kubernetes.io/docs/tasks/configmap-secret/managing-secret-using-kubectl/

```bash
kubectl create secret generic pg-pass --from-literal=password=mypassword
kubectl get secrets
kubectl describe secret pg-pass
```

-----
## Other notes
**Basic commands:**
```bash
docker run -d --name pg-ride -e POSTGRES_USER=wvgniptg -e POSTGRES_PASSWORD=pqJ1wX3BPdwlvTBWEEnSM2klLIbZufyx -e POSTGRES_DB=msride -p 5432:5432 
postgres:13

docker build -t gh6987/rso:msride .  ((tale 'msride' je iz config.yaml))
docker push gh6987/rso:msride
docker run -d --name pg-ride -e POSTGRES_USER=dbuser_Diagnoses7782 -e POSTGRES_PASSWORD=T3Bo32fu7yW#Gj^%r!%^ -e POSTGRES_DB=msride -p 5432:5432 postgres:13
mvn clean package...
```

-----
**Body of POST endpoint for adding new ride:**
```
{
"active": true,
"car": "Renault Megane",
"date": "2023-12-19T23:00:00Z[UTC]",
"driver": "Testni Janez",
"fromTown": "Ljubljana-Brezovica",
"insurance": true,
"notes": "Direktno po avtocesti, tankam na počivališču Lukovica.",
"phone": "040505404",
"pick": true,
"price": 10,
"space": 2,
"timeHours": 11,
"timeMinutes": 30,
"toTown": "Slovenj Gradec"
}
```

-----
**Local URL's:**
- Backend API available at: http://localhost:8080/v1/rides
- Swagger OpenAPI: http://localhost:8080/api-specs/ui
- Health Check (liveness): http://localhost:8080/health/live
- Health Check (readiness): http://localhost:8080/health/ready
- POST call to demonstrate unhealthy service: http://localhost:8080/v1/demo/break
- POST call to demonstrate healthy service: http://localhost:8080/v1/demo/repair
- Metrics: http://localhost:8080/metrics/

-----
**Metrics** (.../services/.../RideDataBean.java):
- Measures the total amount of time a method has spent executing **(.../v1/rides)**.
```
@SimplyTimed(name = "getRideDataFilter_timed_method")
```
- Increments a counter on every invocation and thus count total invocations of the method **(.../v1/rides/1)**.
```
@Counted(name = "getRideData_invocation_counter", absolute = true)
```

-----
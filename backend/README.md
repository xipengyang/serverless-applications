### build-->test--deploy Microservices on AWS

Related AWS components: 
Amazon ECS, Amazon EKS, Amazon ECR, Amazon Fargate, Lambda

#### Design Principles for microservice (1) ####

    Model around business domain
    Automation
    Decentralize
    Polyglot or technology-agnostic
    Independently Deployable
    Failure Isolation
    Observable

AWS has two popular approaches of building microservices: Docker container and AWS Lambda


### container java microservice ###

#### Build & upload the Docker image to Amazon ECR ####

##### Prerequisite #####
Create a ECR repository
```bash
$(aws ecr get-login --no-include-email --region <<REPLACE_WITH_REGION>>)

aws ecr create-repository \
    --repository-name coffeeshop/order-service
```
then run
```bash
mvn pakcage
```



#### Run and test locally ####

```bash
docker run -p 8080:8080 --rm coffeeshop/order-service
```

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


### Container java microservice ###

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

#### TDD and BDD within Java Microservice development ####

cucumber-java in used to define the expectation of a consumer on a service. 

### Lambda microservice ###

#### Use AWS SAM to package the application by using AWS CloudFormation ####

```bash
aws cloudformation package --template template.yml --s3-bucket $S3_BUCKET --output-template template-export.yml
```

#### Saving resources names to SSM ####
SSM parameters allow you to share application resource attributes across stack templates and within your Lambda function code. You should prefer SSM parameter Store over Lambda Env variable if you intend to share config values across functions or to implement find-grained access to sensitive data.  

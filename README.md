# serverless-applications
## Introduction ##
A collection of case studies covering components, features, approaches of developing, testing and operating serverless applications. Below is a brief overview of the folder structure

```bash
.
├── backend                     <-- Source code for Generic backend services 
│   ├── aws-container-java-microservice
│   ├── aws-lambda-node-microservice
├── ops                         <-- Cloudformation templates
└── README.md                   <-- The instruction
```

## Scenario Example ##
Due to the COVID-19 lock down, our imaginary coffee shop has offered a Click & Collect service to our customer.

    In a sunny morning, John wakes up and wants to order a flat white. At the website, he found there is a wide variety of beverage to choose from. John placed an order for two flat white. He is asked to pay by his credit card and he gets a notification to let him know when the coffee will be ready. Later John walked into the cafe and was immediately greeted by the staff, the Barista received the coffee order which John ordered a while ago and also his details and what kind of milk does he want. John walked away with the coffee and a smile on his face. 

### Domain Driven Design ###
At the start, we will define business domains and discover bounded context. We then can in turn modelling around these contexts and create communication models shared between these contexts .

A quick and fast context definition to our business problem
```bash
.
event
├── payment-service  (payment gateway)
├── data-store-service (catalog / menu) 
├── order-process-service 
├── customer-manager
├── event-aggregator
├── analytics
```
Mapping these contexts to our solution space on AWS.
```bash
.
event - EventBridge, Fanout, Queue, Streaming
├── payment-service - A microservice running on Lambda
├── data-store-service - JSON object stored on S3. A simple DB service providing query capability.
├── order-process-service - A microservice. Live orders stored in Redis to enable live update retieval.
├── customer-manager - can be using managed service like Cognito.
├── event-aggregator 
├── analytics - Using Athena data source connectors and federated query.
```

## Related Technical Domains ##

### Scaling ###

    Vertical Scaling: SQS, SNS, Load balancer, Cloudwatch, DynamoDB Table, Spot fleet
    
    Horizontal Scaling: Docker, Kubernetes, ECS, EKS, Fargate, Lambda

    Splitting workloads : Fan out, Pub Sub messaging
    
    Load balancing: ELBs SQS
    
    Scaling for reads: Caching, Replica
    
    Scaling for writes: Sharding
    
    
### Process Parallelism ###

    Independent process
    Failure Isolation
    Atomic
    Non-compliant
    Limitations: Account Qutoas ( Lambda concurrency)
    
    Fan out : 
    
### Events Aggregation ###


# serverless-applications
A collection of case studies covering components, features, approaches of developing, testing and operating serverless applications. Below is a brief overview of the folder structure

```bash
.
├── backend                     <-- Source code for Generic backend services 
│   ├── aws-container-java-microservice
├── ops                         <-- Cloudformation templates
└── README.md                   <-- The instruction
```



### Scaling ###

    Vertical Scaling: SQS, SNS, Load balancer, Cloudwatch, DynamoDB Table, Spot fleet
    
    Horizontal Scaling: Docker, Kubernetes, ECS, EKS, Fargate, Lambda

    Splitting workloads : Fan out, Pub Sub messaging
    
    Load balancing: ELBs SQS
    
    Scaling for reads: Caching, Replica
    
    Scaling for writes: Sharding
    
    
### Parallelism ###

    Independent process
    Failure Isolation
    Atomic
    Non-compliant
    Limitations: Account Qutoas ( Lambda concurrency)
    
    Fan out : 


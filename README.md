# serverless-applications
A collection of case studies covering components, features, approaches of developing, testing and operating serverless applications. Below is a brief overview of the folder structure

```bash
.
├── backend                     <-- Source code for Generic backend services 
│   ├── aws-container-java-microservice
├── ops                         <-- Cloudformation templates
└── README.md                   <-- The instruction
```


##### Scaling #####

    Vertical Scaling: EC2, Automatic Scaling, Spot fleet
    
    Horizontal Scaling: Docker, Kubernetes, ECS, EKS, Fargate, Lambda

    Splitting workloads : Fan out, Pub Sub messaging
    
    Load balancing: ELBs SQS
    
    Scaling for reads: Caching, Replica
    
    Scaling for writes: Sharding

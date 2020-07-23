## Operations ##

#### Setup network infrastructure in a separate stack ####
Network Infrastructure like VPC, subnets are setup in a separate stack from the backend services infrastructure. This keeps deployment of infrastructure decoupled from deployment of backend services. 

Create a cloudformation stack
```bash
aws cloudformation create-stack --stack-name <<STACK_NAME>> --template-body file://network.template.yaml
```

Use following command to retrieve output resource id or arn. For example:
```bash
aws cloudformation describe-stacks \
    --stack-name coffeeshop-2020-7 \
    --query 'Stacks[].Outputs[?OutputKey==`StackVPC`]' \
    --output table
```

#### Sharing cross stack resource attributes ####
AWS provides a number of tools for referencing resource attributes within templates or services.

Attributes can be exported to the other templates via template outputs. Lambda environment variables can be used to pass resource attributes to the function.

SSM parameter stores can be used to share common resources across a specific application.

Cloud Map allows you to register any application resources, such as databases, queues, microservices, and other cloud resources, with custom names.

AWS also supports other third party key value stores such as Consul, Zookeeper etc.


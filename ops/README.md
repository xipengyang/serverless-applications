## Operations ##

#### Setup infrastructure in a separate stack ####
Infrastructure like VPC, subnets are setup in a separate stack from the backend services infrastructure. This keeps deployment of infrastructure decoupled from deployment of backend services. 

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


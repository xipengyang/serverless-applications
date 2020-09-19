include ../make/aws.mk

.PHONY: all deploy

all: deploy

deploy:
	@echo "Deploying cloudformation template"; \
	aws cloudformation create-stack --stack-name MY_STACK --capabilities CAPABILITY_NAMED_IAM --template-body file://shared.template.yaml; \
	echo " Deploy successful";
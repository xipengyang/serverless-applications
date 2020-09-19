# AWS utility


# cloudformation
define deploy_cfn
	template_file=$(1); \
	stack_name=$(2)
	@echo " :aws deploy_cfn: -- deploying template $(1) stack name $(2)" \
	@aws cloudformation create-stack --stack-name $$stack_name \
	--capabilities CAPABILITY_NAMED_IAM \
	--template $$template_file; \
	# if ["$$?" != "0"]; then \
	# 	echo " cloudformation command failed" \
	# fi;
endef
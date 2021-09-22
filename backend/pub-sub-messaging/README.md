### Encrypting messages published to Aamazon SNS with AWS KMS

Amazon SNS uses customer master keys (CMK) to encrypt messages.  

To enable cross account message encryption and decryption. It is slightly more complicated as you need to create key policy to allow the SNS service principal to have access permission to execute the AWS KMS operation `GenerateDataKey`, `Encrypt` and `Decrypt`.

```
    {
      "Sid": "Allow access for Key User (SNS Service Principal)",
      "Effect": "Allow",
      "Principal": {"Service": "sns.amazonaws.com"},
      "Action": [
        "kms:GenerateDataKey*",
        "kms:Decrypt"
      ],
      "Resource": "*"
    }
```

You also need to allow KMS admin access for Cloudformation service pricinpal role to execute the deploy operations. Note do not give encrypt/decrypt access to CFN role.

For Retrieving messages from encrypted topics, your subscriber needs access to perform AWS KMS operations GenerateDataKey and Decrypt on the configured CMK. For example in the SQS queue policy that allows SNS to send message, you can specify `KmsMasterKeyId` to the alias for the configured CMK

```

KmsMasterKeyId: 'alias/to/key'

```



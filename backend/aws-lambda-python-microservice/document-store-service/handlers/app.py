import json
import boto3

s3 = boto3.resource('s3')
ssm = boto3.client('ssm')

def lambda_handler(event, context):

    method = event['httpMethod']
    S3bucket = ssm.get_parameter(
      Name='/document/s3/data-bucket/S3bucket',
      WithDecryption=False
    )

    if method == 'GET':
        S3ObjectKey = event['queryStringParameters']
        print(S3ObjectKey)
        obj = s3.Object(S3bucket, S3ObjectKey)
        data = obj.get()['Body'].read().decode('utf-8')
        return {
                "statusCode": 200,
                "body": json.dumps({
                    "file_contents": data
                }),
            }
    else:
        print("Implement Write through")

import json
import boto3
import os

s3 = boto3.resource('s3')

BUCKET_NAME = os.environ['BUCKET_NAME']

def lambda_handler(event, context):
    method = event['httpMethod']

    if method == 'GET':
        S3bucket=BUCKET_NAME
        S3ObjectKey = event['queryStringParameters']['resourceKey']
        print(S3ObjectKey)
        bucket = s3.Bucket(S3bucket)
        for obj in bucket.objects.all():
            print(obj.key)
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

'use strict';

const ConfigFile = require('config');
const AWS = require('aws-sdk');
const dynamodb = require('aws-sdk/clients/dynamodb');
const docClient = new dynamodb.DocumentClient();

exports.handler = async (event, context) => {
    const requestContextStage =
        event.requestContext
        ? event.requestContext.stage
        : 'test';

      const ssm = new AWS.SSM({region: 'ap-southeast-2'});

      const tableName = await ssm.getParameter({
        Name: "/payment/ddb/payment-table/TableName",
        WithDecryption: false
      }).promise();

      const params = {
        TableName : tableName,
        Item: { paymentId : id, status: 'initiated' }
       };

     const result = await docClient.put(params).promise();
      console.info(JSON.stringify(event));

      const stripeApiKey =
        requestContextStage === 'test'
        ? ConfigFile.stripe.test_sk
        : ConfigFile.stripe.live_sk;
      const stripe = require('stripe')(stripeApiKey); // eslint-disable-line

      // Logic to Request Stripe Payment API
}

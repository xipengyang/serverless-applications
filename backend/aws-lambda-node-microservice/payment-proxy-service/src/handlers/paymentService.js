/**
 * A Lambda function that logs the payload received from SQS.
 */
exports.handler = async (event, context) => {
    // All log statements are written to CloudWatch by default. For more information, see
    // https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-logging.html
    const requestContextStage =
        event.requestContext
        ? event.requestContext.stage
        : 'test';
      const stripeApiKey =
        requestContextStage === 'test'
        ? ConfigFile.stripe.test_sk
        : ConfigFile.stripe.live_sk;
      const stripe = require('stripe')(stripeApiKey); // eslint-disable-line

    console.info(JSON.stringify(event));
}

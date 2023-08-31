package com.brianeno.aws.handler;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.serverless.proxy.spring.SpringBootProxyHandlerBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.brianeno.aws.Application;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamLambdaHandler implements RequestStreamHandler {
    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    static {
        try {
            // handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(Application.class);
            // we use the SpringBootProxyHandlerBuilder to init Spring Boot as a proxy to the underlying container
            handler = new SpringBootProxyHandlerBuilder<AwsProxyRequest>()
                    .defaultProxy()
                    .asyncInit()
                    .springBootApplication(Application.class)
                    .buildAndInitialize();
        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Spring framework", e);
        }
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
        LambdaLogger logger = context.getLogger();
        logger.log("Processing incoming request in " + context.getFunctionName());
        if (inputStream != null) {
            logger.log("Size of stream " + inputStream.available());
            String value = IOUtils.toString(inputStream, "UTF-8");
            logger.log("Passed in value to Lamdba handler is " + value);
        }
        handler.proxyStream(inputStream, outputStream, context);
    }
}

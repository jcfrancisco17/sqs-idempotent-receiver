package com.jc.labs.sqsidempotentreceiver;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.cloud.aws.messaging.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.aws.inbound.SqsMessageDrivenChannelAdapter;
import org.springframework.integration.aws.outbound.SqsMessageHandler;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.PollableChannel;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.aws.inbound.SqsMessageDrivenChannelAdapter;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.messaging.PollableChannel;

@SpringBootApplication(exclude = {
	org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
	org.springframework.cloud.aws.autoconfigure.context.ContextCredentialsAutoConfiguration.class,
	org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class,
	org.springframework.cloud.aws.autoconfigure.context.ContextResourceLoaderAutoConfiguration.class,
	org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
	org.springframework.cloud.aws.autoconfigure.mail.MailSenderAutoConfiguration.class,
	org.springframework.cloud.aws.autoconfigure.cache.ElastiCacheAutoConfiguration.class,
	org.springframework.cloud.aws.autoconfigure.messaging.MessagingAutoConfiguration.class,
	org.springframework.cloud.aws.autoconfigure.jdbc.AmazonRdsDatabaseAutoConfiguration.class,
	org.springframework.cloud.aws.autoconfigure.metrics.CloudWatchExportAutoConfiguration.class
	})
// @SpringBootApplication
public class SqsIdempotentReceiverApplication {


	// @Bean
	// public AmazonSQSAsync amazonSqs() {
	// 	AwsClientBuilder.EndpointConfiguration endpoint = new AwsClientBuilder.EndpointConfiguration(
	// "http://123.456:4576", "us-east-1");


	// ClientConfiguration cc = new ClientConfiguration();
	// cc.setProtocol(Protocol.HTTP);

	// return AmazonSQSAsyncClientBuilder.standard()
	// 	.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("foo", "bar")))
	// 	.withEndpointConfiguration(endpoint)
	// 	.withClientConfiguration(cc)
	// 	.build();
	// }

	// @Bean
	// public PollableChannel inputChannel() {
	// 	return new QueueChannel();
	// }

	// @Bean
	// public MessageProducer sqsMessageDrivenChannelAdapter() {
	// 	SqsMessageDrivenChannelAdapter adapter = new SqsMessageDrivenChannelAdapter(this.amazonSqs(), "test-queue");
	// 	adapter.setOutputChannel(inputChannel());
	// 	return adapter;
	// }

	// @Bean
	// public SimpleMessageListenerContainer simpleMessageListenerContainer() {
	// 	SimpleMessageListenerContainerFactory factory = new SimpleMessageListenerContainerFactory();
	// 	factory.setAmazonSqs(this.amazonSqs());
	// 	return factory.createSimpleMessageListenerContainer();
	// }

	// @ServiceActivator(inputChannel = "inputChannel")
	// @Bean
	// public BlahService blahService() {
	// 	return new BlahService();
	// }

	public static void main(String[] args) {
		SpringApplication.run(SqsIdempotentReceiverApplication.class, args);
	}

}

package com.biz_united.rabbitmqMaven;

import java.io.IOException;
import com.rabbitmq.client.*;

public class ChattingRoomSetup {
	
	private Connection connection = null;
	private Channel channel = null;
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public ChattingRoomSetup(String userName) {
		
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			factory.setPort(5672);
			factory.setUsername("rabbitmq_consumer");
			factory.setPassword("123456");
			factory.setVirtualHost("test_vhosts");
			this.connection = factory.newConnection();
			this.channel = connection.createChannel();

			String queueSet = userName + "MessageQueue";
			channel.queueDeclare(queueSet, true, false, false, null);
			channel.queueBind(queueSet, "chattingRoomExchange", "");
			String message = userName + " has joined the chattingroom";
			channel.basicPublish("chattingRoomExchange", userName, null, message.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void sendMessage(Channel channel, String message) throws IOException {
		channel.basicPublish("chattingRoomExchange", "", null, message.getBytes());
	}

	public void receiveMessage(Channel channel, String userName) throws IOException {
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" Consumer have received '" + message + "'");
			}
		};
		channel.basicConsume(userName + "MessageQueue", true, consumer);
		//System.out.println(channel.basicConsume(userName + "MessageQueue", true, consumer));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChattingRoomSetup chattingRoomSetup = new ChattingRoomSetup("King");
		chattingRoomSetup.receiveMessage(chattingRoomSetup.getChannel(), "King");
		//chattingRoomSetup.sendMessage(chattingRoomSetup.getChannel(), "King");
		chattingRoomSetup.receiveMessage(chattingRoomSetup.getChannel(), "King");
	}

}

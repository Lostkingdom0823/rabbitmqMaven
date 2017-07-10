package com.biz_united.rabbitmqMaven;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.*;

public class ProducerApp {
	public static void main(String[] args) throws IOException, TimeoutException {  
        Connection connection = null;  
        Channel channel = null;  
        try  
        {  
            ConnectionFactory factory = new ConnectionFactory();  
            factory.setHost("localhost");  
            factory.setPort(5672);  
            factory.setUsername("rabbitmq_producer");  
            factory.setPassword("123456");  
            factory.setVirtualHost("test_vhosts");  
   
            //创建与RabbitMQ服务器的TCP连接  
            connection  = factory.newConnection();  
            channel = connection.createChannel();  
            channel.queueDeclare("firstQueue", true, false, false, null);  
            String message = "First Message";             
            channel.basicPublish("", "firstQueue", null, message.getBytes());  
            System.out.println("Send Message is:'" + message + "'");              
        }  
        catch(Exception ex)  
        {  
            ex.printStackTrace();  
        }  
        finally  
        {  
            if(channel != null)  
            {  
                channel.close();  
            }  
            if(connection != null)  
            {  
                connection.close();  
            }  
        }  
	}
}
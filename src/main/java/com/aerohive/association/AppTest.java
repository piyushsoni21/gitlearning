package com.aerohive.association;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.aerohive.association.domain.DeviceStatus;

	

/**
 * @author GS-1044
 *
 * @param <T>
 */

public class AppTest<T> {

	
	
	@Autowired
	private RedisTemplate<String,T> redisTemplate;

	public RedisTemplate<String, T> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, DeviceStatus> redisTemplate) {
		this.redisTemplate = (RedisTemplate<String, T>) redisTemplate;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-test.xml");
		AppTest obj = (AppTest) context.getBean("appTest");
		//obj.getServiceCall();
		//obj.addDeviceDetails();
	    obj.reddisTest();
	}

	/**
	 * 
	 */
	private void reddisTest() {

		   DeviceStatus deviceInfo = new DeviceStatus();
		   // Start a transaction
		   
		   deviceInfo.setHiveAgentSerialNumber("12786");
		   deviceInfo.setHaPollFreq(10);
		   deviceInfo.setHiveAgentState(1);
		   deviceInfo.setMessageRetryCount(4);
		   deviceInfo.setHmngHTTPSServerPollURL("http://hostname:portname/HiveManager/process/pollRequest");
		   // Persisting Inside the Hash User object
		   getRedisTemplate().opsForHash().put("deviceinfo", deviceInfo.hashCode(),deviceInfo);
			// Retrieving the User object from the Redis by using the suggested key
			DeviceStatus x = (DeviceStatus)getRedisTemplate().opsForHash().get("deviceinfo", deviceInfo.hashCode());
			System.out.println(x.getHiveAgentSerialNumber());
		
	}
	
	

}

package com.consumer.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.consumer.springboot.entity.WikimediaData;
import com.consumer.springboot.repository.WikimediaRepository;

@Service
public class KafkaDatabaseConsumer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	
	private WikimediaRepository wikimediaRepository;
	
	
	public KafkaDatabaseConsumer(WikimediaRepository wikimediaRepository) {
		this.wikimediaRepository = wikimediaRepository;
	}


	@KafkaListener(topics="wikimedia_recentchange",groupId="myGroup")
	public void consume(String eventMessage) {
		
		LOGGER.info(String.format("Event message received -> %s",eventMessage));
		
		WikimediaData wikimediaData=new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		wikimediaRepository.save(wikimediaData);
		
	}

}

package com.codelounge.springboot.kafka;

import com.codelounge.springboot.kafka.entity.WikimediaData;
import com.codelounge.springboot.kafka.repository.WikimediaDataRepo;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDbConsumer {


    private WikimediaDataRepo dataRepo;

    public KafkaDbConsumer(WikimediaDataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    private static final Logger LOGGER= LoggerFactory.getLogger((KafkaDbConsumer.class));

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMsg){

        LOGGER.info(String.format("Events msg received"+eventMsg,eventMsg.toString()));
        WikimediaData wikimediaData=new WikimediaData();
        wikimediaData.setWikiEventData(eventMsg);

        dataRepo.save(wikimediaData);


    }

}

package com.oscar.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

  private CountDownLatch latch = new CountDownLatch(1);

  @KafkaListener(topics = "${kafka.topic.helloworld}")
  public void receive(String message) {
    LOGGER.info("received message='{}'", message);
    latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }
}
package com.tutorial.data;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component // register bean ke configuration container spring
public class HelloAsync {

    @SneakyThrows
    public void helloNonAsync(){
        Thread.sleep(Duration.ofSeconds(2));
        log.info("run hello after 2 seconds");
    }

    @Async // menandai method ini harus berjalan secara asynchronouse (blocking) // secara default menggunakan arsitektur Thread Pool
    @SneakyThrows // akan di buatkan exception otomatis oleh lombok
    public void helloAsync() {
        Thread.sleep(Duration.ofSeconds(2));
        log.info("run hello after 2 seconds");
    }

}

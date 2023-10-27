package com.tutorial.testasync;

import com.tutorial.data.HelloAsync;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@Slf4j
@SpringBootTest
public class AsynchoronouseTest {

    @Autowired
    private HelloAsync helloAsync;

    @Test
    void HelloAsync() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            helloAsync.helloAsync(); // task yang akan di jalankan setelah sleep 2 detik
        }

        log.info("after call hello async"); // task yang pertama kali di jalankan
        Thread.sleep(Duration.ofSeconds(4)); // menunggu 4 detik // dari proses HelloAsync.hello() sleep 2 detik

        /**
         * result:
         * 2023-10-27T10:44:43.313+07:00  INFO 5500 --- [           main] c.tutorial.testasync.AsynchoronouseTest  : after call hello async
         * 2023-10-27T10:44:45.319+07:00  INFO 5500 --- [         task-6] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:44:45.319+07:00  INFO 5500 --- [         task-7] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:44:45.319+07:00  INFO 5500 --- [         task-2] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:44:45.319+07:00  INFO 5500 --- [         task-8] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:44:45.319+07:00  INFO 5500 --- [         task-4] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:44:45.319+07:00  INFO 5500 --- [         task-1] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:44:45.319+07:00  INFO 5500 --- [         task-5] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:44:45.319+07:00  INFO 5500 --- [         task-3] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:44:47.334+07:00  INFO 5500 --- [         task-7] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:44:47.334+07:00  INFO 5500 --- [         task-8] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         */

    }

    @Test
    void helloNonAsync() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            helloAsync.helloNonAsync(); // task yang akan di jalankan setelah sleep 2 detik
        }

        log.info("after call hello async"); // task yang pertama kali di jalankan
        Thread.sleep(Duration.ofSeconds(3)); // menunggu 3 detik // dari proses HelloAsync.hello() sleep 2 detik

        /**
         * result:
         * 2023-10-27T10:48:04.038+07:00  INFO 3896 --- [           main] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:48:06.043+07:00  INFO 3896 --- [           main] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:48:08.044+07:00  INFO 3896 --- [           main] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:48:10.057+07:00  INFO 3896 --- [           main] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:48:12.065+07:00  INFO 3896 --- [           main] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:48:14.068+07:00  INFO 3896 --- [           main] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:48:16.084+07:00  INFO 3896 --- [           main] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:48:18.086+07:00  INFO 3896 --- [           main] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:48:20.089+07:00  INFO 3896 --- [           main] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:48:22.096+07:00  INFO 3896 --- [           main] com.tutorial.data.HelloAsync             : run hello after 2 seconds
         * 2023-10-27T10:48:22.096+07:00  INFO 3896 --- [           main] c.tutorial.testasync.AsynchoronouseTest  : after call hello async
         */

    }


}
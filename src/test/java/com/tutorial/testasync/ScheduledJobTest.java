package com.tutorial.testasync;

import com.tutorial.data.Job;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest
public class ScheduledJobTest {

    @Autowired
    private Job job;

    @Test
    void testScheduledJob() throws InterruptedException {

        Thread.sleep(Duration.ofSeconds(5));
        Assertions.assertEquals(2L, job.getJob());

        /**
         * result:
         * 2023-10-27T16:00:59.932+07:00  INFO 18364 --- [   scheduling-1] com.tutorial.data.Job                    : 1 Run Job scheduling-1
         * 2023-10-27T16:01:01.952+07:00  INFO 18364 --- [   scheduling-1] com.tutorial.data.Job                    : 2 Run Job scheduling-1
         * 2023-10-27T16:01:03.961+07:00  INFO 18364 --- [   scheduling-1] com.tutorial.data.Job                    : 3 Run Job scheduling-1
         */

    }


}

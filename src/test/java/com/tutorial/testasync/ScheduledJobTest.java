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

    @Test
    void testScheduledJobWithCustomDefault() throws InterruptedException {

        Thread.sleep(Duration.ofSeconds(5));
        Assertions.assertEquals(2L, job.getJob());

        /**
         * result:
         * 2023-10-27T23:01:22.781+07:00  INFO 10404 --- [  my-schedule-1] com.tutorial.data.Job                    : 1 Run Job my-schedule-1
         * 2023-10-27T23:01:24.788+07:00  INFO 10404 --- [  my-schedule-1] com.tutorial.data.Job                    : 2 Run Job my-schedule-1
         */

    }

    @Test
    void testScheduledJobWithCustom() throws InterruptedException {

        Thread.sleep(Duration.ofSeconds(5));
        Assertions.assertEquals(2L, job.getJob());

        /**
         * result:
         * 2023-10-27T23:15:23.703+07:00  INFO 12680 --- [pool-3-thread-1] com.tutorial.data.Job                    : 1 Run Job pool-3-thread-1
         * 2023-10-27T23:15:25.722+07:00  INFO 12680 --- [pool-3-thread-1] com.tutorial.data.Job                    : 2 Run Job pool-3-thread-1
         */

    }


}

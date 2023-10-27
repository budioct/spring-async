package com.tutorial.testasync;

import com.tutorial.data.HelloAsync;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@SpringBootTest
public class AsynchoronouseTest {

    @Autowired
    private HelloAsync helloAsync;

    @Test
    void testHelloAsync() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            helloAsync.helloAsync(); // task yang akan di jalankan setelah sleep 2 detik
        }

        log.info("after call helloAsync() async"); // task yang pertama kali di jalankan
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
    void testHelloNonAsync() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            helloAsync.helloNonAsync(); // task yang akan di jalankan setelah sleep 2 detik
        }

        log.info("after call helloNonAsync() async"); // task yang pertama kali di jalankan
        Thread.sleep(Duration.ofSeconds(3)); // menunggu 3 detik // dari proses HelloAsync.hello() sleep 2 detik

        /**
         * result :
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

    @Test
    void HelloAsyncWithCostumeExecutorService() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            helloAsync.helloAsyncWithCostumeExecutorService(); // task yang akan di jalankan setelah sleep 2 detik
        }

        log.info("after call helloAsyncWithCostumeExecutorService() async"); // task yang pertama kali di jalankan
        Thread.sleep(Duration.ofSeconds(4)); // menunggu 4 detik // dari proses HelloAsync.hello() sleep 2 detik

        /**
         * result:
         * 2023-10-27T14:42:15.716+07:00  INFO 9604 --- [           main] c.tutorial.testasync.AsynchoronouseTest  : after call helloAsync() async
         * 2023-10-27T14:42:17.722+07:00  INFO 9604 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncWithCostumeExecutorService() after 2 seconds VirtualThread[#44]/runnable@ForkJoinPool-1-worker-4
         * 2023-10-27T14:42:17.722+07:00  INFO 9604 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncWithCostumeExecutorService() after 2 seconds VirtualThread[#37]/runnable@ForkJoinPool-1-worker-3
         * 2023-10-27T14:42:17.722+07:00  INFO 9604 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncWithCostumeExecutorService() after 2 seconds VirtualThread[#36]/runnable@ForkJoinPool-1-worker-8
         * 2023-10-27T14:42:17.722+07:00  INFO 9604 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncWithCostumeExecutorService() after 2 seconds VirtualThread[#34]/runnable@ForkJoinPool-1-worker-7
         * 2023-10-27T14:42:17.722+07:00  INFO 9604 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncWithCostumeExecutorService() after 2 seconds VirtualThread[#42]/runnable@ForkJoinPool-1-worker-1
         * 2023-10-27T14:42:17.722+07:00  INFO 9604 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncWithCostumeExecutorService() after 2 seconds VirtualThread[#39]/runnable@ForkJoinPool-1-worker-5
         * 2023-10-27T14:42:17.728+07:00  INFO 9604 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncWithCostumeExecutorService() after 2 seconds VirtualThread[#43]/runnable@ForkJoinPool-1-worker-3
         * 2023-10-27T14:42:17.722+07:00  INFO 9604 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncWithCostumeExecutorService() after 2 seconds VirtualThread[#38]/runnable@ForkJoinPool-1-worker-6
         * 2023-10-27T14:42:17.722+07:00  INFO 9604 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncWithCostumeExecutorService() after 2 seconds VirtualThread[#41]/runnable@ForkJoinPool-1-worker-2
         * 2023-10-27T14:42:17.728+07:00  INFO 9604 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncWithCostumeExecutorService() after 2 seconds VirtualThread[#40]/runnable@ForkJoinPool-1-worker-8
         */

    }

    @Test
    void testHelloAsyncWithFutureTest() throws InterruptedException, ExecutionException {

        // interinsic lock pada completablefuture mirip dengan method ThreadCommunication
        // get() --> await()
        // complete() --> notify()

        Future<String> future = helloAsync.helloAsyncWithFuture("Budhi");
        String response = future.get();
        log.info("data: {}", response);

        /**
         * result: future<T> callable<T> --> completablefuture
         * 2023-10-27T15:12:09.155+07:00  INFO 16640 --- [           main] c.tutorial.testasync.AsynchoronouseTest  : data: Hello Budhi from Thread VirtualThread[#34]/runnable@ForkJoinPool-1-worker-1
         */

    }

    @Test
    void testHelloAsyncWithDynamicExecutor1() throws InterruptedException, ExecutionException {

        Future<String> future = helloAsync.helloAsyncWithFutureExecutionSingleThread("Budhi");
        String response = future.get();
        log.info("data: {}", response);

        /**
         * result: future<T> callable<T> --> completablefuture
         * 2023-10-27T15:42:22.392+07:00  INFO 2640 --- [           main] c.tutorial.testasync.AsynchoronouseTest  : data: Hello Budhi from Thread Thread[#34,pool-2-thread-1,5,main]
         */

    }

    @Test
    void testHelloAsyncWithDynamicExecutor2() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            helloAsync.helloAsyncExecutionVirtualThread(); // task yang akan di jalankan setelah sleep 2 detik
        }

        log.info("after call testHelloAsyncWithDynamicExecutor2() async"); // task yang pertama kali di jalankan
        Thread.sleep(Duration.ofSeconds(4)); // menunggu 4 detik // dari proses HelloAsync.hello() sleep 2 detik

        /**
         * result:
         * 2023-10-27T15:46:57.631+07:00  INFO 12672 --- [           main] c.tutorial.testasync.AsynchoronouseTest  : after call testHelloAsyncWithDynamicExecutor2() async
         * 2023-10-27T15:46:59.633+07:00  INFO 12672 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncExecutionVirtualThread() after 2 seconds VirtualThread[#37]/runnable@ForkJoinPool-1-worker-2
         * 2023-10-27T15:46:59.632+07:00  INFO 12672 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncExecutionVirtualThread() after 2 seconds VirtualThread[#38]/runnable@ForkJoinPool-1-worker-8
         * 2023-10-27T15:46:59.632+07:00  INFO 12672 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncExecutionVirtualThread() after 2 seconds VirtualThread[#36]/runnable@ForkJoinPool-1-worker-6
         * 2023-10-27T15:46:59.633+07:00  INFO 12672 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncExecutionVirtualThread() after 2 seconds VirtualThread[#34]/runnable@ForkJoinPool-1-worker-7
         * 2023-10-27T15:46:59.633+07:00  INFO 12672 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncExecutionVirtualThread() after 2 seconds VirtualThread[#42]/runnable@ForkJoinPool-1-worker-1
         * 2023-10-27T15:46:59.633+07:00  INFO 12672 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncExecutionVirtualThread() after 2 seconds VirtualThread[#41]/runnable@ForkJoinPool-1-worker-4
         * 2023-10-27T15:46:59.641+07:00  INFO 12672 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncExecutionVirtualThread() after 2 seconds VirtualThread[#45]/runnable@ForkJoinPool-1-worker-4
         * 2023-10-27T15:46:59.641+07:00  INFO 12672 --- [               ] com.tutorial.data.HelloAsync             : run helloAsyncExecutionVirtualThread() after 2 seconds VirtualThread[#43]/runnable@ForkJoinPool-1-worker-3
         */

    }



}

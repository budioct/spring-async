package com.tutorial.data;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Slf4j
@Component // register bean ke configuration container spring
public class HelloAsync {

    @SneakyThrows
    public void helloNonAsync(){
        Thread.sleep(Duration.ofSeconds(2));
        log.info("run helloNonAsync() after 2 seconds {}", Thread.currentThread().getName());
    }

    @Async // menandai method ini harus berjalan secara asynchronouse (blocking) // secara default menggunakan arsitektur Thread Pool dengan max core pada cpu
    @SneakyThrows // akan di buatkan exception otomatis oleh lombok
    public void helloAsync() {
        Thread.sleep(Duration.ofSeconds(2));
        log.info("run helloAsync() after 2 seconds {}", Thread.currentThread().getName());
    }

    @Async
    @SneakyThrows
    public void helloAsyncWithCostumeExecutorService(){
        Thread.sleep(Duration.ofSeconds(2));
        log.info("run helloAsyncWithCostumeExecutorService() after 2 seconds {}", Thread.currentThread());
    }

    @Async
    @SneakyThrows
    public Future<String> helloAsyncWithFuture(final String name){

        CompletableFuture<String> future = new CompletableFuture<>();
        Thread.sleep(Duration.ofSeconds(2));
        future.complete("Hello " + name + " from Thread " + Thread.currentThread()); // Jika belum selesai, set nilai yang dikembalikan oleh get() dan metode terkait ke nilai yang diberikan.
        return future;
    }

    @Async("taskExecutor")
    @SneakyThrows
    public void helloAsyncExecutionVirtualThread() {
        Thread.sleep(Duration.ofSeconds(2));
        log.info("run helloAsyncExecutionVirtualThread() after 2 seconds {}", Thread.currentThread());
    }

    @Async("singleTaskExecutor")
    @SneakyThrows
    public Future<String> helloAsyncWithFutureExecutionSingleThread(final String name){

        CompletableFuture<String> future = new CompletableFuture<>();
        Thread.sleep(Duration.ofSeconds(2));
        future.complete("Hello " + name + " from Thread " + Thread.currentThread()); // Jika belum selesai, set nilai yang dikembalikan oleh get() dan metode terkait ke nilai yang diberikan.
        return future;
    }

}

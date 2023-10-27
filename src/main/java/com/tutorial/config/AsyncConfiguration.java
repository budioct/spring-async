package com.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
public class AsyncConfiguration {

    /**
     * Custom Executor
     * ● Walaupun secara default, Spring Boot akan membuatkan Thread Pool Executor, namun jika kita
     *   ingin membuat custom Executor, kita hanya cukup membuat bean dengan type Executor, dan nama
     *   bean taskExecutor
     * ● Secara otomatis, jika terdapat bean dengan type Executor, maka secara otomatis Spring Boot tidak
     *   akan membuatkan Thread Pool Executor lagi
     */

    @Bean
    public Executor taskExecutor(){
        return Executors.newVirtualThreadPerTaskExecutor(); // implement ExecutorService  dengan yang baru implement virtual thread arsitektur Forkjoin
    } // bean dengan type Executor parent dari ExecutorService untuk membuat Thread pool atau ForkJoin pool

    @Bean
    public Executor singleTaskExecutor(){
        return Executors.newSingleThreadExecutor(); // implementasi thread-pool dan max-thread-pool=1 thread untuk execution task worker
    }

    /**
     * Custom Scheduled Executor
     * ● Sama seperti Async, kita juga bisa membuat Scheduled Executor sendiri, caranya cukup membuat
     *   bean dengan type ScheduledExecutorService, dan dengan nama bean taskScheduler
     */

    @Bean
    public ScheduledExecutorService taskScheduled(){
        return Executors.newScheduledThreadPool(10);
    }

}

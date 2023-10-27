package com.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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


}

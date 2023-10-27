package com.tutorial.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
public class Job {

    private AtomicLong atomicLong = new AtomicLong(0);

    // method ini akan di eksekusi, initialDelay= diam dulu 2 detik. fixedDelay= setelah diam 2 detik, akan di jalankan setiap 2 detik
    // method Scheduled tidak perlu di pangil dia akan otomatis jalan sendiri. berbeda dengan method async di harus di panggil baru jalana
    @Scheduled(timeUnit = TimeUnit.SECONDS, initialDelay = 2, fixedDelay = 2) // implement timer di thread yang akan berjalan secara periodic
    public void runJob(){
        long value = atomicLong.incrementAndGet();
        log.info("{} Run Job {}", value, Thread.currentThread().getName());
    }

    public Long getJob(){
        return atomicLong.get();
    }

}

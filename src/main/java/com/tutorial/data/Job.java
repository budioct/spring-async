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

    /**
     * Cron Job
     * ● Salah satu fitur menarik di Scheduled adalah, kita bisa menggunakan Cron Expression untuk
     *   membuat jadwal schedule nya
     * ● Kita bisa gunakan attribute cron di @Scheduled
     *   https://crontab.guru/
     */

    // arutan expression * dari ke kanan sebanyak 6 digit * adalah:
    // * second(0-59), * minute(0-59), * hour(0-23), * day of the month (1-31), * month (1-12) (or JAN-DEC), * day of the week (0-7) (0 or 7 is Sundy, or MON-SUN)
    @Scheduled(cron = "*/2 * * * * *")
    public void cronJob(){
        log.info("run Cron Job every second");
    }

}

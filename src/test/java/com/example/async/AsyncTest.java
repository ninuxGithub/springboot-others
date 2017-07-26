package com.example.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * Created by daile on 2017/7/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest {

    @Autowired
    private AsyncTask async;

    @Test
    public void test() throws InterruptedException {

        long start = System.currentTimeMillis();

        Future<String> async1 = async.doTaskOne();
        Future<String> async2 = async.doTaskTwo();
        Future<String> async3 = async.doTaskThree();

        while (true) {
            if (async1.isDone() && async2.isDone() && async3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();

        System.out.println("总耗时：" + (end - start));
    }
}
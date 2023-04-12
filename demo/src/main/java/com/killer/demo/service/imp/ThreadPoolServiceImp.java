package com.killer.demo.service.imp;

import com.killer.demo.service.ThreadPoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
@Slf4j
public class ThreadPoolServiceImp implements ThreadPoolService {
    @Async
    @Override
    public void test(int start, int end) {
       log.info("当前线程"+Thread.currentThread().getName()+"数据范围"+start+"-"+end);
    }
}

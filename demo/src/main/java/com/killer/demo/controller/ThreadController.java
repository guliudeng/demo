package com.killer.demo.controller;

import com.killer.demo.service.ThreadPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("thread")
public class ThreadController {
    @Autowired
    private ThreadPoolService threadPoolService;

    @RequestMapping("more")
    public void thread(@RequestParam int thread){
        List<Integer>  list = new ArrayList<>();
        for (int i=1;i<=101;i++) {
            list.add(i);
        }
        int page = list.size() / thread;
        System.out.println("page="+page);
        for (int i=0;i<thread;i++) {
            int start = i*page;
            int end = start + page;
            if (thread-1 == i) {
                end = list.size();
            }
            threadPoolService.test(start,end);
        }

    }
}

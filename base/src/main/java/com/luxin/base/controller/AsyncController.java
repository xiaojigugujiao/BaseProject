package com.luxin.base.controller;

import com.luxin.base.service.IAsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class AsyncController {

    @Autowired
    private IAsyncTask asyncTask;

    @RequestMapping("/task1")
    public void testTask(){
        asyncTask.watchTV();
    }

    @RequestMapping("/task2")
    public void eat(){
        asyncTask.eat();
    }
}

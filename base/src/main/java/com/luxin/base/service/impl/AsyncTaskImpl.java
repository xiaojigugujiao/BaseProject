package com.luxin.base.service.impl;

import com.luxin.base.service.IAsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskImpl implements IAsyncTask {

    private Logger logger = LoggerFactory.getLogger(AsyncTaskImpl.class);

//    @Async("myTaskAsyncPool")
    @Async
    @Override
    public void watchTV() {
        logger.info("我边看电视边测试");
        String s = null;
        s.equals("");
    }

    @Override
    @Async
    public void eat() {
        logger.info("我边吃饭边测试");
    }
}

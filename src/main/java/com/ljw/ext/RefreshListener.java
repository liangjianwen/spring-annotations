package com.ljw.ext;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class RefreshListener {

    @EventListener(classes = ContextRefreshedEvent.class)
    public void testRefresh(ContextRefreshedEvent contextRefreshedEvent){
        System.out.println("------>>>>ljw test: 收到refresh事件");
    }
}

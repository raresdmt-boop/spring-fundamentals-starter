package com.example.notifications;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpamFilter {

    private final List<String> blacklist =  new ArrayList<>();

    @PostConstruct
    public void init() {
        blacklist.add("lottery");
        blacklist.add("winner");
        blacklist.add("prize");
    }

    public boolean isSpam(String message) {
        for(String blacklisted : blacklist){
            if(message.toLowerCase().contains(blacklisted.toLowerCase())){
                return true;
            }
        }
        return false;
    }
}

package com.springcore.springcore.compoClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "com.springcore.springcore.compoClass")
public class configNoXML {
//    @Bean(name = {"ls" , "hi" , "hello"})
    public List<Integer> ls() {
        // Define your list of integers here
        return Arrays.asList(10, 20, 30, 40, 50);
    }
    
//    @Bean
    public Map<String, Integer> mp(){
    	Map<String, Integer> map = new HashMap<>();
        map.put("key1", 100);
        map.put("key2", 200);
        map.put("key3", 300);
        return map;
    }
}

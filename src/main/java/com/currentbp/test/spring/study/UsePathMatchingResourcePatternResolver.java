package com.currentbp.test.spring.study;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class UsePathMatchingResourcePatternResolver {
    public static void main(String[] args) {
        try {
            ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resourcePatternResolver.getResources("classpath*:**/xxx.xml");
            System.out.println("===>resources:"+resources.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

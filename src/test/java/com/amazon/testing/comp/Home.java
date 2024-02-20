package com.amazon.testing.comp;

import org.testng.annotations.Test;

import com.amazon.testing.LaunchApp;

public class Home extends LaunchApp{

    @Test
    public void navigate() {
        System.out.println("Home");
    }
    
}

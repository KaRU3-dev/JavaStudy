package com.karu3;

import org.springframework.ui.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HelloControllerTest {
    private HelloController helloController;

    @BeforeEach
    public void setUp() {
        helloController = new HelloController();
    }

    @Test
    public void testHello() {
        String result = helloController.hello();
        assert result.equals("Hello World!");
    }

    @Test
    public void testHome() {
        Model model = new org.springframework.ui.ConcurrentModel();
        String viewName = helloController.home(model);
        assert viewName.equals("home");
        assert model.containsAttribute("message");
        assert model.getAttribute("message").equals("Hello Thymeleaf!");
    }
}

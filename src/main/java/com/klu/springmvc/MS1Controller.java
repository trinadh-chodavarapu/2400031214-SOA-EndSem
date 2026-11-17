package com.klu.springmvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.springmvc.model.User;
import com.klu.springmvc.service.UserService;

@RestController
@RequestMapping("/ms1")
public class MS1Controller {

    @Autowired
    UserService us;

    @GetMapping("/add")
    public String add(@RequestParam("a") int a,
                      @RequestParam("b") int b) {

        int result = a + b;

        return "MS1.1 addition" + result;
    }

    // http://localhost:8001/ms1/test
    @GetMapping("/test")
    public String test() throws InterruptedException {

        Thread.sleep(0000);

        return "MS1 service is working";
    }

    // http://localhost:8001/ms1/profile
    @GetMapping("/profile")
    public String profile() {

        return "Profile API is working";
    }

    @PostMapping("/signup")
    public Object signup(@RequestBody User u) {

        return us.signupservice(u);
    }

    @PostMapping("/signin")
    public Object signin(@RequestBody Map<String, String> u) {

        return us.signinservice(u);
    }
}
package com.example.SpringWeb;

import com.example.SpringWeb.repository.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView home(@RequestParam("name") String myName){
        ModelAndView mv=new ModelAndView();

        mv.addObject("name", myName);
        //String name = req.getParameter("name");

        mv.setViewName("home");

        return mv;
    }
    @RequestMapping("/display")
    public ModelAndView display() {
        String text = "";
        ModelAndView mv = new ModelAndView();
        try {
            File resource = ResourceUtils.getFile("classpath:customer.json");
            text = new String(Files.readAllBytes(resource.toPath()));


            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            //read json file and convert to customer object
            Customer cust = objectMapper.readValue(resource, Customer.class);

            //print customer details

            mv.addObject("name", cust.getName());
            mv.addObject("id", cust.getId());
            mv.addObject("email", cust.getEmail());
            mv.addObject("address", cust.getAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
        mv.setViewName("display");

        return mv;
    }
}

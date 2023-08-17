package com.todo.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.todo.app.service.PublicService;


@RestController
@RequestMapping("/public")
public class PublicController {
    private final PublicService publicItemService;

    @Autowired
    public PublicController( PublicService publicItemService) {
        this.publicItemService = publicItemService;
    }
    @GetMapping("/msg")
    public String getTodoItem() {
      
        String message= publicItemService.helloMsg();
        ApiResponse<String> response = new ApiResponse(true,"Total todo List",message);
        return "<h1 >"+response.getData().toString()+"</h1>";
    }
    
}

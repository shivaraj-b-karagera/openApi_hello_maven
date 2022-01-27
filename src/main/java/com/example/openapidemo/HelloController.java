package com.example.openapidemo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @ApiOperation(value = "getGreeting", notes="get greeting",nickname = "getGreeting")
    @RequestMapping(method = RequestMethod.GET,value = "demo")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "Successful retrieval")})
                   // ,response = Hello.class, responseContainer = "List") })
    public String sayHello(@ApiParam(value = "testId",
            required = true, defaultValue = "test")@PathVariable() final int testId){
    return "Hello World from OpenApi-Swagger";
}
}


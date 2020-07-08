package com.jskj.enquel.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class SwaggerController {

//    @ApiImplicitParam(name = "param", value = "invoke入参", required = true, dataType = "String", paramType = "query")
//    @GetMapping(value = "/invoke")
//    public String invoke(String param) {
//        System.out.println("This springCloudConsumerService 1:" + param);
//        String result = param + "_consumer_" + System.currentTimeMillis();
//        return result;
//    }
//
//    @ApiOperation(value = "线程池环境测试跟踪ID", notes = "TraceThreadPoolExecutor测试跟踪ID")
//    @ApiImplicitParam(name = "param", value = "入参", required = true, dataType = "String", paramType = "query")
//    @PostMapping(value = "/testTrackID_C")
//    public String testTrackID(@RequestParam(value = "param") String param) {
//        String result = param;
//        return result;
//    }

    @GetMapping(value = "/invoke/{id}")
    public String invoke(@PathVariable int id){

        System.out.println(id + System.currentTimeMillis());

        return "haha" + id;

    }

}

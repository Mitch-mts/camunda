package com.example.mtech;

import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/camunda")
public class CamundaRestController {
    @PostMapping
    public void initiateProcess(CamundaRequest camundaRequest){
    }

}

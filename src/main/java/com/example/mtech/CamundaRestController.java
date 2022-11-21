//package com.example.mtech;
//
//import org.springframework.cloud.client.loadbalancer.Response;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/v1/camunda")
//public class CamundaRestController {
//    private final CamundaService camundaService;
//
//    public CamundaRestController(CamundaService camundaService) {
//        this.camundaService = camundaService;
//    }
//
//    @PostMapping
//    public void initiateProcess(CamundaRequest camundaRequest){
//        camundaService.initiateProcess(camundaRequest);
//    }
//
//}

package com.example.mtech.worldcup;

import com.example.mtech.CamundaRequest;
import com.example.mtech.CamundaService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyTicketProcess implements JavaDelegate{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String country = (String) delegateExecution.getVariable("country");
        String moeny = (String) delegateExecution.getVariable("money");

        delegateExecution.setVariable("trip", "trip to " + country + " for " +  "$" +moeny);
    }

}

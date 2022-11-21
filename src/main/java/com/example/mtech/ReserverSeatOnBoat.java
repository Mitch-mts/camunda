package com.example.mtech;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named
@Component("reserverSeatOnBoat")
public class ReserverSeatOnBoat implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String money;
        String ticketType = "Coach";

        money = (String) delegateExecution.getVariable("fare");
        double moneyDouble = Double.parseDouble(money);

        if(moneyDouble >= 10000){
            ticketType = "First Class";
        } else if (moneyDouble >= 5000) {
            ticketType = "Business Class";
        } else if (moneyDouble <= 100) {
            ticketType = "Stowaway Class";
            throw new BpmnError("Fall_Overboard", "A cheap ticket has lead to a small wave throwing you overboard");
        }

        delegateExecution.setVariable("ticketType", ticketType);

    }
}

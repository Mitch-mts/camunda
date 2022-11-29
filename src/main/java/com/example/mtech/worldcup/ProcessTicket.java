package com.example.mtech.worldcup;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.math.BigDecimal;

public class ProcessTicket implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String money = (String) delegateExecution.getVariable("money");
        double amount = Double.parseDouble(money);
        boolean approved = false;

        if(amount > 100.0){
            approved = true;
        }
        delegateExecution.setVariable("approved", approved);
        delegateExecution.setVariable("amount", amount);
    }
}

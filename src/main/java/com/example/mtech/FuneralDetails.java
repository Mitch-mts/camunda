package com.example.mtech;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;
import java.util.Objects;

@Named
public class FuneralDetails implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String policyType;
        String personName = (String) delegateExecution.getVariable("person_name");
        String funeralPolicy = (String) delegateExecution.getVariable("funeral_policy");

        if(Objects.equals(funeralPolicy, "Nyaradzo")){
            policyType = "Private";
        } else if (Objects.equals(funeralPolicy, "Doves")) {
            policyType = "Premium";
        }else {
            policyType = "General";
        }

        delegateExecution.setVariable("policyType", policyType);
        delegateExecution.setVariable("benefactor", personName);

    }
}

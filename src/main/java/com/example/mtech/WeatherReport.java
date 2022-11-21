package com.example.mtech;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class WeatherReport implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        boolean isWeatherOk;
        String dayOfTheWeek = (String) delegateExecution.getVariable("day");

        if(dayOfTheWeek.equalsIgnoreCase("monday") || dayOfTheWeek.equalsIgnoreCase("FRIDAY")){
            isWeatherOk = true;
        }else {
            isWeatherOk = false;
        }
        delegateExecution.setVariable("isWeatherOk", isWeatherOk);
    }

}

package com.example.mtech;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class InputProcessor implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String name = (String) delegateExecution.getVariable("name");
        String team = (String) delegateExecution.getVariable("team");
        String myTeam;

        if(team.equals("Chelsea")){
            myTeam = team;
        }else{
            myTeam = "Real Madrid";
        }

        delegateExecution.setVariable("my_team", myTeam);
        delegateExecution.setVariable("myName", name);
        delegateExecution.setVariable("teams", team);
    }
}

import com.example.mtech.LoggerDelegate;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.Rule;


import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.withVariables;

@ExtendWith(MockitoExtension.class)
public class ProcessTest {
    private static final String PROCESS_ID = "sampleProcess";

    @Test
    @Deployment(resources = "process.bpmn")
    public void testHappyPath(){
        Mocks.register("reserverSeatOnBoat", new LoggerDelegate());
    }

    @Test
    @Deployment(resources = {"sampleProcess.bpmn"})
    void testSampleCaseHappyPath() {
        ProcessInstance instance = runtimeService().startProcessInstanceById(PROCESS_ID);

        assertThat(instance)
                .isActive()
                .hasPassed("processStart")
                .isWaitingAtExactly("task1")
                .task()
                .isNotAssigned();

        complete(task(), withVariables(
                "name", "neymar",
                "age", "21"
        ));

        assertThat(instance)
                .hasPassed("task1")
                .hasPassedInOrder("task1", "service1")
                .isWaitingAt("task2")
                .task()
                .isAssignedTo("neymar");

        complete(task(), withVariables(
                "attributeService", "variableServicevalue"
        ));

        assertThat(instance)
                .hasPassedInOrder("task2", "processFinish")
                .isEnded();
    }

}

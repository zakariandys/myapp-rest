package id.zakariandys.mockagent;

import java.lang.instrument.Instrumentation;

public class AgentLoader {
    public static void agentmain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new MockAgentApplication());
    }
}
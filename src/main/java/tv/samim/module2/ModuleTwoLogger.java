package tv.samim.module2;

import tv.samim.SamimLogger;

public class ModuleTwoLogger extends SamimLogger {

    public ModuleTwoLogger() {
    }

    public void startModuleTwo(String startName) {
        this.logInfo("001", "Start ModuleTwo with name: {} ", startName);
    }

    public void exceptionWhileStartModuleTwo(Exception e) {
        this.logError("002", "ModuleTwo exception while starting ModuleTwo: {}", e);
    }

    public void finishModuleTwo() {
        this.logDebug("003", "Finish ModuleTwo.", new Object());
    }
}

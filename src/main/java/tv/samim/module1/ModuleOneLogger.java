package tv.samim.module1;

import tv.samim.SamimLogger;

public class ModuleOneLogger extends SamimLogger {

    public ModuleOneLogger() {
    }

    public void startModuleOne(String startName) {
        this.logInfo("001", "Start ModuleOne with name: {} ", startName);
    }

    public void exceptionWhileStartModuleOne(Exception e) {
        this.logError("002", "ModuleOne exception while starting ModuleOne: {}", e);
    }

    public void finishModuleOne() {
        this.logDebug("003", "Finish ModuleOne.", new Object());
    }
}

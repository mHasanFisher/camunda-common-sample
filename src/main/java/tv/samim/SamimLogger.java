package tv.samim;

import org.camunda.commons.logging.BaseLogger;
import tv.samim.module1.ModuleOneLogger;
import tv.samim.module2.ModuleTwoLogger;

public class SamimLogger extends BaseLogger {

    public static final String PROJECT_CODE = "SAMIM";
    public static final SamimLogger INSTANCE = (SamimLogger)BaseLogger.createLogger(SamimLogger.class, PROJECT_CODE, "tv.samim", "00");
    public static final ModuleOneLogger MODULE_ONE_LOGGER = (ModuleOneLogger)BaseLogger.createLogger(ModuleOneLogger.class, PROJECT_CODE, "tv.samim.module1", "01");
    public static final ModuleTwoLogger MODULE_TWO_LOGGER = (ModuleTwoLogger)BaseLogger.createLogger(ModuleTwoLogger.class, PROJECT_CODE, "tv.samim.module2", "02");

    public SamimLogger(){

    }

    public void startSamim(String startName){
        this.logInfo("001", "Start Samim with name: {} ", startName);
    }

    public void exceptionWhileStartSamim(Exception e){
        this.logError("002", "Exception while starting Samim: {}", e);
    }

    public void finishSamim(){
        this.logDebug("003", "Finish Samim", new Object());
    }

}

package tv.samim;

import tv.samim.module1.ModuleOneLogger;
import tv.samim.module2.ModuleTwoLogger;

public class SamimStart {

    protected final static SamimLogger LOGGER = SamimLogger.INSTANCE;
    protected final static ModuleOneLogger MODULE_ONE_LOGGER = SamimLogger.MODULE_ONE_LOGGER;
    protected final static ModuleTwoLogger MODULE_TWO_LOGGER = SamimLogger.MODULE_TWO_LOGGER;

    public static void main(String[] args) throws InterruptedException {

        samimStart();

        Thread.sleep(2000);

        moduleOneStart();

        Thread.sleep(2000);

        moduleTwoStart();
    }

    public static void samimStart() throws InterruptedException {

        LOGGER.startSamim("SamimMain");
        Thread.sleep(500);
        LOGGER.exceptionWhileStartSamim(new Exception("SamimMainException"));
        Thread.sleep(500);
        LOGGER.finishSamim();
        Thread.sleep(500);
    }

    public static void moduleOneStart() throws InterruptedException {

        MODULE_ONE_LOGGER.startModuleOne("SamimMainForModuleOne");
        Thread.sleep(500);
        MODULE_ONE_LOGGER.exceptionWhileStartModuleOne(new Exception("SamimMainForModuleOneException"));
        Thread.sleep(500);
        MODULE_ONE_LOGGER.finishModuleOne();
        Thread.sleep(500);
    }

    public static void moduleTwoStart() throws InterruptedException {

        MODULE_TWO_LOGGER.startModuleTwo("SamimMainForModuleTwo");
        Thread.sleep(500);
        MODULE_TWO_LOGGER.exceptionWhileStartModuleTwo(new Exception("SamimMainForModuleTwoException"));
        Thread.sleep(500);
        MODULE_TWO_LOGGER.finishModuleTwo();
        Thread.sleep(500);
    }
}

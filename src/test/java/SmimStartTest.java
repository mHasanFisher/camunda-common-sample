import ch.qos.logback.classic.Level;
import org.camunda.commons.testing.ProcessEngineLoggingRule;
import org.camunda.commons.testing.WatchLogger;
import org.junit.Rule;
import org.junit.Test;
import tv.samim.SamimStart;

import static org.assertj.core.api.Assertions.assertThat;

public class SmimStartTest {

    private static final String SAMIM_LOGGER = "tv.samim"; // 00
    private static final String MODULE_ONE_LOGGER = "tv.samim.module1"; //01
    private static final String MODULE_TWO_LOGGER = "tv.samim.module2"; //02

    @Rule
    public ProcessEngineLoggingRule loggingRule = new ProcessEngineLoggingRule()
            .watch(MODULE_ONE_LOGGER, Level.ERROR);

    @Test
    @WatchLogger(loggerNames = SAMIM_LOGGER, level = "INFO")
    public void samimStartTest() {

        try {
            SamimStart.main(null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertThat(loggingRule.getFilteredLog(SAMIM_LOGGER, "SamimMain").size()).isEqualTo(1);
        assertThat(loggingRule.getFilteredLog(SAMIM_LOGGER, "Exception").size()).isEqualTo(1);
        assertThat(loggingRule.getFilteredLog(MODULE_ONE_LOGGER, "Exception").size()).isEqualTo(1);
    }

    @Test
    public void moduleOneStartTest() {

        try {
            SamimStart.main(null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertThat(loggingRule.getFilteredLog(MODULE_ONE_LOGGER, "Exception").size()).isEqualTo(1);
    }

    @Test
    @WatchLogger(loggerNames = MODULE_TWO_LOGGER, level = "DEBUG")
    public void moduleTwoStartTest() {

        try {
            SamimStart.main(null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertThat(loggingRule.getFilteredLog(MODULE_TWO_LOGGER, "SamimMainForModuleTwo").size()).isEqualTo(1);
        assertThat(loggingRule.getFilteredLog(MODULE_TWO_LOGGER, "Exception").size()).isEqualTo(1);
        assertThat(loggingRule.getFilteredLog(MODULE_TWO_LOGGER, "Finish").size()).isEqualTo(1);
        assertThat(loggingRule.getFilteredLog(MODULE_ONE_LOGGER, "Exception").size()).isEqualTo(1);
    }
}

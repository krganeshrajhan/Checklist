package in.net.bookkeeper.checklist.ui;

import com.vaadin.testbench.TestBenchTestCase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChecklistUITest extends TestBenchTestCase {

    @Before
    public void setUp() throws Exception {
        setDriver(new ChromeDriver()); // Firefox
    }

    @Test
    public void basic() throws Exception {
        getDriver().get("http://localhost:8080/");
    }

}

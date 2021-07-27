package task16_FrameworkJUnit.testSuites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import task16_FrameworkJUnit.tests.TestLogIn;
import task16_FrameworkJUnit.tests.Tests;

@RunWith(JUnitPlatform.class)
@SelectClasses({TestLogIn.class, Tests.class})
public class TestSuitesClasses {

    // заработало :)

}

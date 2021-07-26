package task16_FrameworkJUnit.testSuites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import task16_FrameworkJUnit.tests.LogIn;
import task16_FrameworkJUnit.tests.Tests;

@RunWith(JUnitPlatform.class)
@SelectClasses({LogIn.class, Tests.class})
public class TestSuitesClasses {

    // заработало :)

}

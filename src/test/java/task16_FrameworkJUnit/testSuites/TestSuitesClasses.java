package task16_FrameworkJUnit.testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import task16_FrameworkJUnit.tests.LogIn;
import task16_FrameworkJUnit.tests.Tests;


@RunWith(Suite.class)
@Suite.SuiteClasses({LogIn.class, Tests.class})
public class TestSuitesClasses {

    // не работает :(

}

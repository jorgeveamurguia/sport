import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for default package");
		//$JUnit-BEGIN$
		suite.addTestSuite(testSql.class);
		suite.addTestSuite(testPedido.class);
		suite.addTestSuite(testClientes.class);
		suite.addTest(AllTests.suite());
		//$JUnit-END$
		return suite;
	}

}

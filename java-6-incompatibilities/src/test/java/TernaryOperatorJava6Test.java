import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Preparing for the Oracle Certified Associate Java SE 8 Programmer 1 exam, I came across the following paragraph about
 * the ternary expression in the official Study Guide:
 * Ternary Expression Evaluation
 * As of Java 7, only one of the right-hand expressions of the ternary operator will be evaluated at runtime.
 * In a manner similar to the short-circuit operators, if one of the two right-hand expressions in a ternary
 * operator performs a side effect, then it may not be applied at runtime.
 * (See <a href="https://stackoverflow.com/q/29557106/1410078">Stack Overflow Question.</a>)
 * <p/>
 * This is not true! The ternary operator has not changed behavior!
 *
 * @author <a href="mailto:jhunovis@gmail.com">Jan Hackel</a>
 * @version $Revision$ $Date$ $Author$
 */
public class TernaryOperatorJava6Test {

    private int testNumber;

    @Test
    public void testLazyEvaluation_SinceJava7OnlyOneSideShouldEvaluate_1() throws Exception {
        System.out.println(true ? setTestNumberFieldSideBySideEffect(10) : setTestNumberFieldSideBySideEffect(20));
        assertThat(testNumber, is(10) );
    }

    @Test
    public void testLazyEvaluation_SinceJava7OnlyOneSideShouldEvaluate_2() throws Exception {
        System.out.println(false ? setTestNumberFieldSideBySideEffect(10) : setTestNumberFieldSideBySideEffect(20));
        assertThat(testNumber, is(20) );
    }

    private int setTestNumberFieldSideBySideEffect(int value) {
        System.out.println("Setting testNumber=" + value);
        return testNumber = value;
    }
}

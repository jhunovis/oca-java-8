import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test-case for operator precedence.
 *
 * @author <a href="mailto:jhunovis@gmail.com">Jan Hackel</a>
 * @version $Revision$ $Date$ $Author$
 */
public class OperatorTest {

    @Test
    public void testUnaryOperatorPrecedence_PostShouldHavePrecedenceOverPreOperators_1() throws Exception {
        int x = 10;
        assertThat(x++ + --x, is(20));
        assertThat(x, is(10));
    }

    @Test
    public void testUnaryOperatorPrecedence_PostShouldHavePrecedenceOverPreOperators_2() throws Exception {
        int x = 10;
        assertThat(--x + x++, is(18));
        assertThat(x, is(10));
    }

    @Test
    public void operatorPrecedence_UnaryAndBinaryOperators() throws Exception {
        int x = 3;
        assertThat(++x * 5 / x-- + --x, is(7));
        assertThat(x, is(2));
    }
}

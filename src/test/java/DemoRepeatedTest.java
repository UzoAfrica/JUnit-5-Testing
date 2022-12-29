import org.exampleCalculatorMavenProject.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    Calculator calculator;

    @BeforeEach
    void beforeEachTestMethod(){
        calculator = new Calculator();
        System.out.println("Executed @BeforeEach method");
    }

    @DisplayName("Division by Zero")
    @RepeatedTest(3)
        //@Disabled("TODO: Still to be worked at")
    void testIntegerDivision_WhenDividendISDividedByZero_ShouldThrowArithmeticException(
            RepetitionInfo repetitionInfo, TestInfo testInfo
    ){
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() +
                " of " + repetitionInfo.getTotalRepetitions());
        //Arrange
        int dividend = 12;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        //Act & Assert
        ArithmeticException actualException = assertThrows(ArithmeticException.class, ()->{
            //Act
            calculator.integerDivision(dividend, divisor);
        },"Division by zero should have thrown an Arithmetic exception");

        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage(),
                "Unexpected exception message");
    }
}

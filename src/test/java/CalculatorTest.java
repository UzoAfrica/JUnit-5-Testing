import org.exampleCalculatorMavenProject.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in Calculator Class")
public class CalculatorTest {
    Calculator calculator;


    @BeforeAll
    static void setup(){
        System.out.println("Executed @BeforeAll method");
    }

    @AfterAll
    static void cleanup(){
        System.out.println("Executed @AfterAll method");
    }


    @BeforeEach
    void beforeEachTestMethod(){
        calculator = new Calculator();
        System.out.println("Executed @BeforeEach method");
    }

    @AfterEach
    void afterEachTestMethod(){
        System.out.println("Executed @AfterEach method. ");
    }

    @Test
    @DisplayName("Test 4/2= 2")
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo(){
        System.out.println("Running test 12/4 = 3");
        //Arrange //Given
        int dividend= 12;
        int divisor = 4;
        int expectedResult = 3;

        //Act //When
        int ActualResult = calculator.integerDivision(dividend,divisor);

        //Assert //Then
        assertEquals(expectedResult, ActualResult, "4/2 did not produce 2");
    }

    @DisplayName("Division by Zero")
    @Test
    //@Disabled("TODO: Still to be worked at")
    void testIntegerDivision_WhenDividendISDividedByZero_ShouldThrowArithmeticException(){
        System.out.println("Running Division by Zero");
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

    @ParameterizedTest
    @ValueSource(strings= {"Victory", "Gabriel", "Justices"})
    void valueSourceDemonstration(String firstName){
        System.out.println(firstName);
        assertNotNull(firstName);
    }

    @DisplayName("Test integer Subtraction [minus, subtraction, expectedResult]")
    @ParameterizedTest
    //@MethodSource()
//    @CsvSource({
//            "500, 100, 400",
//            "600, 100, 500",
//            "800, 100, 700"
//    })
    @CsvFileSource(resources = "/integerSubtraction.csv")
    void integerSubtraction(int minuend, int subtrahend, int expectedResult ){
        System.out.println("Running Test " + minuend + " - " + subtrahend+ " = " + expectedResult);

        int actualResult = calculator.integerSubtraction(minuend,subtrahend);
        assertEquals(expectedResult, actualResult,()->minuend + " - " + subtrahend+ " did not produce the " +  expectedResult);
    }
//    private static Stream <Arguments> integerSubtraction(){
//        return Stream.of(
//                Arguments.of(500, 100, 400),
//                Arguments.of(600, 100, 500),
//                Arguments.of(700, 100, 600)
     //   );}
}

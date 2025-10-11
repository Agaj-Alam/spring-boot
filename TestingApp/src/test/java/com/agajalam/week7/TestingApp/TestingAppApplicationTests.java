package com.agajalam.week7.TestingApp;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@Slf4j
class TestingAppApplicationTests {

    @AfterEach
    void tearDown(){
        log.info("Tearing down the method");
    }

    @BeforeAll
    static void setUpOnce(){
        log.info("setup once....");
    }

    @AfterAll
    static void tearDownOnce(){
        log.info("Tearing down all");
    }

	@Test
//    @Disabled
	void testNumberOne() {
        int a=2;
        int b=4;
        int result=addTwoNumbers(a,b);

//        Assertions.assertEquals(6,result);

//        assertThat(result)
//                .isEqualTo(6)
//                .isCloseTo(9, Offset.offset(3));

        assertThat("Apple")
                .isEqualTo("Apple")
                .startsWith("App")
                .endsWith("le")
                .hasSize(5);
	}

    @Test
//    @DisplayName("DisplayTestNameTwo")
    void testDivideTwoNumbers_whenDenominatorIsZero_ThenArithmeticException(){
        int a=5;
        int b=0;

      assertThatThrownBy(()->divideTwoNumbers(a,b))
              .isInstanceOf(ArithmeticException.class)
              .hasMessage("tried to divide by zero");
    }



    int addTwoNumbers(int a, int b){
        return a+b;
    }
    double divideTwoNumbers(int a, int b){
        try{
            return  a /b;
        }catch (ArithmeticException e){
            log.error("Arithmetic exception occurred "+e.getLocalizedMessage());
            throw new ArithmeticException("tried to divide by zero");
        }
    }

}

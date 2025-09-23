package com.agajalam.week7.TestingApp;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

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

        Assertions.assertThat(result).isEqualTo(7).isCloseTo(9, Offset.offset(3));
	}

    @Test
//    @DisplayName("DisplayTestNameTwo")
    void testNumber2(){
        log.info("test number two ");
    }

    int addTwoNumbers(int a, int b){
        return a+b;
    }

}

// package com.alg.st;

// import static org.hamcrest.CoreMatchers.equalTo;

// import java.util.Comparator;

// import com.alg.BaseTest;

// import org.junit.Before;
// import org.junit.Test;

// public class OrderArraySTTest extends BaseTest {

//     private OrderArrayST<String, Integer> arrayST;

//     @Before
//     public void setUp() {
//         arrayST = new OrderArrayST<>(5);
//     }

//     @Test
//     public void shouldPutStringAndGetInteger() {
//         // Arrange
//         arrayST.put(ONE_STRING, ONE_INT);
//         arrayST.put(TWO_STRING, TWO_INT);
//         arrayST.put(THREE_STRING, THREE_INT);
//         arrayST.put(FOUR_STRING, FOUR_INT);
//         arrayST.put(FIVE_STRING, FIVE_INT);

//         // Act & Assert
//         collector.checkThat(arrayST.get(ONE_STRING), equalTo(ONE_INT));
//         collector.checkThat(arrayST.get(TWO_STRING), equalTo(TWO_INT));
//         collector.checkThat(arrayST.get(THREE_STRING), equalTo(THREE_INT));
//         collector.checkThat(arrayST.get(FOUR_STRING), equalTo(FOUR_INT));
//         collector.checkThat(arrayST.get(FIVE_STRING), equalTo(FIVE_INT));
//     }

// }
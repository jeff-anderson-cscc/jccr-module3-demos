package edu.cscc.datatypes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeff Anderson
 * @since 9/3/19
 */
public class JavaArrayTests {

  @Test
  @DisplayName("T01: basic array operation tests")
  public void test01 () {
    int month_days[] = new int[12];

    assertEquals(12, month_days.length);
    for (int value: month_days) {
      assertEquals(0, value);
    }

    month_days[0] = 31;
    month_days[8] = 30;
    for (int counter = 0; counter < 12; counter++) {
      if (counter == 0) {
        assertEquals(31, month_days[counter]);
      } else if (counter == 8) {
        assertEquals(30, month_days[counter]);
      } else {
        assertEquals(0, month_days[counter]);
      }
    }
  }


  @Test
  @DisplayName("T02: array initialization tests")
  public void moreArrayTests () {

    int month_days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    assertEquals(12, month_days.length);

    for (int counter = 0; counter < 12; counter++) {
      switch (counter) {
        case 0:
        case 2:
        case 4:
        case 6:
        case 7:
        case 9:
        case 11:
          assertEquals(31,month_days[counter]);
          break;
        case 1:
          assertEquals(28,month_days[counter]);
          break;
        default:
          assertEquals(30,month_days[counter]);
          break;
      }
    }
  }


  @Test()
  @DisplayName("Array exceptions test")
  public void test03() {

    int month_days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int index = -1;
    assertThrows(ArrayIndexOutOfBoundsException.class,
      () -> {System.out.println(month_days[index]);});
    assertThrows(ArrayIndexOutOfBoundsException.class,
      () -> {System.out.println(month_days[month_days.length]);});
    assertThrows(ArrayIndexOutOfBoundsException.class,
      () -> {System.out.println(month_days[100]);});
  }

}

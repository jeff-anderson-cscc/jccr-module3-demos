package edu.cscc.datatypes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
  @DisplayName("T03: Array exceptions test")
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


  @Test()
  @DisplayName("T04: Using object types test")
  public void test04() {
    String month_names[] = {"January", "February", "March",
      "April", "May", "June", "July", "August", "September",
      "October", "November", "December"};
    assertEquals("December", month_names[11]);
  }


  @Test()
  @DisplayName("T05: Initializing array elements with new and a constructor test")
  public void test05() {

    Random randomNumberGenerators[] = {new Random(12345), new Random(54321)};
    assertEquals(51, randomNumberGenerators[0].nextInt(100));
    assertEquals(28, randomNumberGenerators[1].nextInt(100));
  }


  @Test()
  @DisplayName("T06: Two dimensional array test")
  public void test06() {

    int twoD[][] = new int[4][5];

    // With index references:
    for (int rowIndex = 0; rowIndex < twoD.length; rowIndex++) {
      for (int columnIndex = 0; columnIndex < twoD[rowIndex].length; columnIndex++) {
        assertEquals(0, twoD[rowIndex][columnIndex]);
      }
    }
    // Without index references:
    for (int[] row : twoD) {
      for (int column : row) {
        assertEquals(0, column);
      }
    }
  }


  @Test()
  @DisplayName("T07: Two dimensional array with initializer test")
  public void test07() {

    String twoDimArr[][] = {
      {"r0c0", "r0c1", "r0c2"},
      {"r1c0", "r1c1", "r1c2"},
    };

    // With index references:
    for (int rowIndex = 0; rowIndex < twoDimArr.length; rowIndex++) {
      for (int columnIndex = 0; columnIndex < twoDimArr[rowIndex].length; columnIndex++) {
        assertEquals(String.format("r%dc%d",rowIndex,columnIndex),
          twoDimArr[rowIndex][columnIndex]);
      }
    }
  }


  @Test()
  @DisplayName("T08: Three dimensional array test")
  public void test08() {

    int threeD[][][] = new int[4][5][2];

    // With index references:
    for (int rowIndex = 0; rowIndex < threeD.length; rowIndex++) {
      for (int columnIndex = 0; columnIndex < threeD[rowIndex].length; columnIndex++) {
        for (int elementIndex = 0; elementIndex < threeD[rowIndex][columnIndex].length; elementIndex++ )
        assertEquals(0, threeD[rowIndex][columnIndex][elementIndex]);
      }
    }
    // Without index references:
    for (int[][] row : threeD) {
      for (int[] column : row) {
        for (int element : column) {
          assertEquals(0, element);
        }
      }
    }
  }

}

package edu.cscc.datatypes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jeff Anderson
 * @since 9/4/19
 */
public class IntegerRepresentationsTests {

  private final int SHORT_MASK = 0b00000000000000001111111111111111;
  private final int BYTE_MASK = 0b00000000000000000000000011111111;

  @Test
  @DisplayName("T01: Range Tests")
  public void test01 () {
    assertEquals(127, Byte.MAX_VALUE);
    assertEquals(-128, Byte.MIN_VALUE);
    assertEquals(32767, Short.MAX_VALUE);
    assertEquals(-32768, Short.MIN_VALUE);
    assertEquals(2147483647, Integer.MAX_VALUE);
    assertEquals(-2147483648, Integer.MIN_VALUE);
    assertEquals(9_223_372_036_854_775_807L, Long.MAX_VALUE);
    assertEquals(-9_223_372_036_854_775_808L, Long.MIN_VALUE);
  }

  @Test
  @DisplayName("T02: Bit Width Tests")
  public void test02() {
    // Byte doesn't have a toBinaryString() but we can use the Integer one and mask off extra bits
    assertEquals(8, Integer.toBinaryString(BYTE_MASK & Byte.MIN_VALUE).length());
    // Short doesn't have a toBinaryString() but we can use the Integer one and mask off extra bits
    assertEquals(16, Integer.toBinaryString(SHORT_MASK & Short.MIN_VALUE).length());
    assertEquals(32, Integer.toBinaryString(Integer.MIN_VALUE).length());
    assertEquals(64, Long.toBinaryString(Long.MIN_VALUE).length());
  }

  @Test
  @DisplayName("T03: Binary (base 2 / 1 bit) literals")
  public void test03 () {
    assertEquals(0, 0b000);
    assertEquals(0, 0b000_0000_0000_0000);
    assertEquals(1, 0b001);
    assertEquals(2, 0b010);
    assertEquals(3, 0b011);
    assertEquals(4, 0b100);

    // Note literals for negative numbers are denoted by the
    // prefix '-0b' rather than '0b' for positive numbers
    // which is more intuitive than using the actual binary
    // two's complement internal representation:
    assertEquals(128, 0b1000_0000);
    assertEquals(-128, -0b1000_0000);
    assertEquals(127, 0b0111_1111);
    assertEquals(-127, -0b0111_1111);
    assertEquals(-0, -0b0000_0000);
    assertEquals(0, 0b0000_0000);
  }

  @Test
  @DisplayName("T04: Octal (base 8 / 3 bit) literals")
  public void test04 () {
    assertEquals(-1, -01);
    assertEquals(0, -00);
    assertEquals(0, 00);
    assertEquals(1, 01);
    assertEquals(2, 02);
    assertEquals(3, 03);
    assertEquals(4, 04);
    assertEquals(5, 05);
    assertEquals(6, 06);
    assertEquals(7, 07);
    assertEquals(8, 010);
    assertEquals(9, 011);
    assertEquals(15, 017);
    assertEquals(16, 020);
    assertEquals(23, 027);
    assertEquals(24, 030);
    assertEquals(63, 077);
    assertEquals(64, 0100);
  }


  @Test
  @DisplayName("T05: Hexadecimal (base 16 / 4 bit) literals")
  public void test05 () {
    assertEquals(-127, -0x7f);
    assertEquals(-128, -0x80);
    assertEquals(-1, -0x1);
    assertEquals(0, 0x0);
    assertEquals(1, 0x1);
    assertEquals(9, 0x9);
    assertEquals(10, 0xa);
    assertEquals(11, 0xb);
    assertEquals(12, 0xc);
    assertEquals(13, 0xd);
    assertEquals(14, 0xe);
    assertEquals(15, 0xf);
    assertEquals(16, 0x10);
    assertEquals(17, 0x11);
    assertEquals(31, 0x1F);
    assertEquals(32, 0x20);
    assertEquals(47, 0x2F);
    assertEquals(48, 0x30);
    assertEquals(127, 0x7f);
    assertEquals(128, 0x80);
    assertEquals(175, 0xaf);
    assertEquals(176, 0xb0);
    assertEquals(255, 0xFF);
    assertEquals(256, 0x100);
    assertEquals(4095, 0xFFF);
    assertEquals(4096, 0x1000);
    assertEquals(65535, 0xFFFF);
  }

  @Test
  @DisplayName("T06: Meaning of life in various numbering schemes")
  public void test06 () {
    assertEquals(42, 0b101010);
    assertEquals(42, 0x2a);
    assertEquals(42, 052);
  }


}

package edu.cscc.datatypes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jeff Anderson
 * @since 9/4/19
 */
public class NumericTypeTests {

  @Test
  @DisplayName("T01: byte (8 bits) binary representation")
  public void test01 () {
    assertEquals(0, 0b0000000);
    assertEquals(1, 0b0000001);
    assertEquals(2, 0b0000010);
    assertEquals(3, 0b0000011);
    assertEquals(4, 0b0000100);

    byte byteData = 0b000_0000;
    assertEquals(0, byteData);
    byteData++;
    assertEquals(1, byteData);
    byteData--;
    assertEquals(0, byteData);
    byteData--;
    assertEquals(-1, byteData);

    assertEquals(127, Byte.MAX_VALUE);
    assertEquals(127, 0b0111_1111);

    assertEquals(-128, Byte.MIN_VALUE);
    assertEquals(-128, -0b1000_0000);
  }

  @Test
  @DisplayName("T02: short (16 bit) binary representation")
  public void test02 () {
    assertEquals(0, 0b000_0000_0000_0000);
    assertEquals(1, 0b000_0000_0000_0001);
    assertEquals(32767, Short.MAX_VALUE);
    assertEquals(32767, 0b0111_1111_1111_1111);

    assertEquals(-32768, Short.MIN_VALUE);
    assertEquals(-32768, -0b1000_0000_0000_0000);
  }

  @Test
  @DisplayName("T03: Octal (8 bits) notation")
  public void test03 () {
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
  @DisplayName("T04: Hexidecimal (16 bits) notation")
  public void test04 () {
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
  @DisplayName("T05: int (32 bit) numbers")
  public void test05 () {
    assertEquals(0, 0x00000000);
    assertEquals(1, 0x00000001);
    assertEquals(2147483647, Integer.MAX_VALUE);
    assertEquals("7fffffff", Integer.toHexString(Integer.MAX_VALUE));
    // Leading bit is 0 for positive numbers and, being implicit, is omitted:
    assertEquals("1111111111111111111111111111111", Integer.toBinaryString(Integer.MAX_VALUE));
    assertEquals(31, Integer.toBinaryString(Integer.MAX_VALUE).length());

    assertEquals(Integer.MAX_VALUE, 0x7fff_ffff);
    assertEquals(-2147483648, Integer.MIN_VALUE);
    assertEquals("80000000", Integer.toHexString(Integer.MIN_VALUE));
    // Leading bit is 1 for negative numbers and, being significant, is shown:
    assertEquals("10000000000000000000000000000000", Integer.toBinaryString(Integer.MIN_VALUE));
    assertEquals(32, Integer.toBinaryString(Integer.MIN_VALUE).length());
  }

  @Test
  @DisplayName("T06: long (64 bit) numbers")
  public void test06 () {
    assertEquals(0, 0x0000000000000000);
    assertEquals(1, 0x0000000000000001);
    assertEquals(9_223_372_036_854_775_807L, Long.MAX_VALUE);
    assertEquals("7fffffffffffffff", Long.toHexString(Long.MAX_VALUE));
    // Leading bit is 0 for positive numbers and, being implicit, is omitted:
    assertEquals("111111111111111111111111111111111111111111111111111111111111111", Long.toBinaryString(Long.MAX_VALUE));
    assertEquals(63, Long.toBinaryString(Long.MAX_VALUE).length());

    assertEquals(-9_223_372_036_854_775_808L, Long.MIN_VALUE);
    assertEquals("8000000000000000", Long.toHexString(Long.MIN_VALUE));
    // Leading bit is 1 for negative numbers and, being significant, is shown:
    assertEquals("1000000000000000000000000000000000000000000000000000000000000000", Long.toBinaryString(Long.MIN_VALUE));
    assertEquals(64, Long.toBinaryString(Long.MIN_VALUE).length());
  }

}

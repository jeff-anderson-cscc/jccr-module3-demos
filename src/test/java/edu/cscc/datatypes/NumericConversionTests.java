package edu.cscc.datatypes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jeff Anderson
 * @since 9/4/19
 */
public class NumericConversionTests {

  private final int SHORT_MASK = 0b00000000000000001111111111111111;
  private final int BYTE_MASK = 0b00000000000000000000000011111111;

  @Test
  @DisplayName("T01: Positive whole number upgrade tests")
  public void test01 () {
    byte byteValue = Byte.MAX_VALUE;
    assertEquals("1111111", Integer.toBinaryString(BYTE_MASK & byteValue));
    assertEquals(0b111_1111,byteValue);
    assertEquals(0x7F,byteValue);
    assertEquals(127,byteValue);
    short shortValue = byteValue;
    assertEquals("1111111", Integer.toBinaryString(SHORT_MASK & shortValue));
    assertEquals(0b000_0000_0111_1111,shortValue);
    assertEquals(0x007F,shortValue);
    assertEquals(127,shortValue);
    int intValue = byteValue;
    assertEquals("1111111", Integer.toBinaryString(intValue));
    assertEquals(0x0000007F,intValue);
    assertEquals(127,intValue);
    long longValue = intValue;
    assertEquals("1111111", Long.toBinaryString(longValue));
    assertEquals(0x0000007F,longValue);
    assertEquals(127L,longValue);
  }

  @Test
  @DisplayName("T02: Negative whole number upgrade tests")
  public void test02 () {
    byte byteValue = Byte.MIN_VALUE;
    assertEquals("10000000", Integer.toBinaryString(BYTE_MASK & byteValue));
    assertEquals(-0b1000_0000,byteValue);
    assertEquals(-0x80,byteValue);
    assertEquals(-128,byteValue);
    short shortValue = byteValue;
    assertEquals("1111111110000000", Integer.toBinaryString(SHORT_MASK & shortValue));
    assertEquals(-0b1000_0000,shortValue);
    assertEquals(-0x0080,shortValue);
    assertEquals(-128,shortValue);
    int intValue = shortValue;
    assertEquals("11111111111111111111111110000000", Integer.toBinaryString(intValue));
    assertEquals(-0b1000_0000,intValue);
    assertEquals(-0x00000080,intValue);
    assertEquals(-128,intValue);
    long longValue = intValue;
    assertEquals("1111111111111111111111111111111111111111111111111111111110000000", Long.toBinaryString(longValue));
    assertEquals(-0b1000_0000,longValue);
    assertEquals(-0x00000080L,longValue);
    assertEquals(-128,longValue);
  }

  @Test
  @DisplayName("T03: Max sized positive whole number downgrade tests")
  public void test03 () {
    long longValue = Long.MAX_VALUE;
    assertEquals(9_223_372_036_854_775_807L, longValue);
    assertEquals("7fffffffffffffff", Long.toHexString(longValue));
    assertEquals("111111111111111111111111111111111111111111111111111111111111111", Long.toBinaryString(longValue));
    int intValue = (int) longValue;
    assertEquals(-1, intValue);
    assertEquals("ffffffff", Integer.toHexString(intValue));
    assertEquals("11111111111111111111111111111111", Integer.toBinaryString(intValue));
    short shortValue = (short) intValue;
    assertEquals(-1, shortValue);
    assertEquals("ffff", Integer.toHexString(SHORT_MASK & shortValue));
    assertEquals("1111111111111111", Integer.toBinaryString(SHORT_MASK & shortValue));
    byte byteValue = (byte) shortValue;
    assertEquals(-1, byteValue);
    assertEquals("ff", Integer.toHexString(BYTE_MASK & byteValue));
    assertEquals("11111111", Integer.toBinaryString(BYTE_MASK & byteValue));
  }

  @Test
  @DisplayName("T04: Min sized positive whole number downgrade tests")
  public void test04 () {
    long longValue = Long.MIN_VALUE;
    assertEquals("8000000000000000", Long.toHexString(longValue));
    assertEquals("1000000000000000000000000000000000000000000000000000000000000000", Long.toBinaryString(longValue));
    int intValue = (int) longValue;
    assertEquals(0, intValue);
    assertEquals("0", Integer.toHexString(intValue));
    assertEquals("0", Integer.toBinaryString(intValue));
    short shortValue = (short) intValue;
    assertEquals(0, shortValue);
    assertEquals("0", Integer.toBinaryString(SHORT_MASK & shortValue));
    byte byteValue = (byte) shortValue;
    assertEquals(0, byteValue);
    assertEquals("0", Integer.toBinaryString(BYTE_MASK & byteValue));
  }

  @Test
  @DisplayName("T05: Long large positive whole number downgrade tests")
  public void test05 () {
    long longValue = 0x0123456789abcdefL;
    assertEquals(81985529216486895L, longValue);
    assertEquals("123456789abcdef", Long.toHexString(longValue));
    assertEquals("100100011010001010110011110001001101010111100110111101111", Long.toBinaryString(longValue));
    int intValue = (int) longValue;
    assertEquals(-1985229329, intValue);
    assertEquals("89abcdef", Integer.toHexString(intValue));
    assertEquals("10001001101010111100110111101111", Integer.toBinaryString(intValue));
    short shortValue = (short) intValue;
    assertEquals(-12817, shortValue);
    assertEquals("cdef", Integer.toHexString(SHORT_MASK & shortValue));
    assertEquals("1100110111101111", Integer.toBinaryString(SHORT_MASK & shortValue));
    byte byteValue = (byte) shortValue;
    assertEquals(-17, byteValue);
    assertEquals("ef", Integer.toHexString(BYTE_MASK & byteValue));
    assertEquals("11101111", Integer.toBinaryString(BYTE_MASK & byteValue));
  }

}

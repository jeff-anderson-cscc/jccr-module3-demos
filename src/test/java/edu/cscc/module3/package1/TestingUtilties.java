package edu.cscc.module3.package1;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Jeff Anderson
 * @since 2019-08-18
 */
public class TestingUtilties {

  public Class helperGetClass (String className, String classNotFoundFailureMessage) {
    Class aClass = null;
    try {
      aClass = Class.forName(className);
    }
    catch (ClassNotFoundException exception) {
      fail(classNotFoundFailureMessage);
    }
    return aClass;
  }


  public Field getField (Class aClass, String fieldName, String fieldNotFoundFailureMessage) {
    Field field = null;
    try {
      field = aClass.getDeclaredField(fieldName);
    } catch (NoSuchFieldException e) {
      fail(fieldNotFoundFailureMessage);
    }
    return field;
  }

}

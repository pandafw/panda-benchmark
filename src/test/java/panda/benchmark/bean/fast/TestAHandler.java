package panda.benchmark.bean.fast;

import java.lang.reflect.Type;

import panda.benchmark.bean.TestA;
import panda.lang.Exceptions;
import panda.lang.reflect.Types;

public class TestAHandler extends panda.bean.fast.AbstractFastBeanHandler<TestA> {
  public TestAHandler(panda.bean.Beans factory) {
    super(factory, TestA.class);
  }
  protected void init() {
    rpns = new String[] {
      "boolArray"
      , "boolField"
      , "boolWrap"
      , "byteArray"
      , "byteField"
      , "byteWrap"
      , "charArray"
      , "charField"
      , "charWrap"
      , "class"
      , "dateArray"
      , "dateField"
      , "dateMap"
      , "dateMapList"
      , "doubleArray"
      , "doubleField"
      , "doubleWrap"
      , "floatArray"
      , "floatField"
      , "floatWrap"
      , "getField"
      , "intArray"
      , "intArrayMap"
      , "intField"
      , "intWrap"
      , "longArray"
      , "longField"
      , "longWrap"
      , "numExtendMap"
      , "shortArray"
      , "shortField"
      , "shortWrap"
      , "stringArray"
      , "stringField"
      , "stringList"
      , "testB"
    };
    wpns = new String[] {
      "boolArray"
      , "boolField"
      , "boolWrap"
      , "byteArray"
      , "byteField"
      , "byteWrap"
      , "charArray"
      , "charField"
      , "charWrap"
      , "dateArray"
      , "dateField"
      , "dateMap"
      , "dateMapList"
      , "doubleArray"
      , "doubleField"
      , "doubleWrap"
      , "floatArray"
      , "floatField"
      , "floatWrap"
      , "intArray"
      , "intArrayMap"
      , "intField"
      , "intWrap"
      , "longArray"
      , "longField"
      , "longWrap"
      , "numExtendMap"
      , "setField"
      , "shortArray"
      , "shortField"
      , "shortWrap"
      , "stringArray"
      , "stringField"
      , "stringList"
      , "testB"
    };
    PropertyInfo pi;
    pi = new PropertyInfo();
    pi.index = 1;
    pi.readable = true;
    pi.writable = true;
    mm.put("boolArray", pi);
    pi = new PropertyInfo();
    pi.index = 2;
    pi.readable = true;
    pi.writable = true;
    mm.put("boolField", pi);
    pi = new PropertyInfo();
    pi.index = 3;
    pi.readable = true;
    pi.writable = true;
    mm.put("boolWrap", pi);
    pi = new PropertyInfo();
    pi.index = 4;
    pi.readable = true;
    pi.writable = true;
    mm.put("byteArray", pi);
    pi = new PropertyInfo();
    pi.index = 5;
    pi.readable = true;
    pi.writable = true;
    mm.put("byteField", pi);
    pi = new PropertyInfo();
    pi.index = 6;
    pi.readable = true;
    pi.writable = true;
    mm.put("byteWrap", pi);
    pi = new PropertyInfo();
    pi.index = 7;
    pi.readable = true;
    pi.writable = true;
    mm.put("charArray", pi);
    pi = new PropertyInfo();
    pi.index = 8;
    pi.readable = true;
    pi.writable = true;
    mm.put("charField", pi);
    pi = new PropertyInfo();
    pi.index = 9;
    pi.readable = true;
    pi.writable = true;
    mm.put("charWrap", pi);
    pi = new PropertyInfo();
    pi.index = 10;
    pi.readable = true;
    pi.writable = false;
    mm.put("class", pi);
    pi = new PropertyInfo();
    pi.index = 11;
    pi.readable = true;
    pi.writable = true;
    mm.put("dateArray", pi);
    pi = new PropertyInfo();
    pi.index = 12;
    pi.readable = true;
    pi.writable = true;
    mm.put("dateField", pi);
    pi = new PropertyInfo();
    pi.index = 13;
    pi.readable = true;
    pi.writable = true;
    mm.put("dateMap", pi);
    pi = new PropertyInfo();
    pi.index = 14;
    pi.readable = true;
    pi.writable = true;
    mm.put("dateMapList", pi);
    pi = new PropertyInfo();
    pi.index = 15;
    pi.readable = true;
    pi.writable = true;
    mm.put("doubleArray", pi);
    pi = new PropertyInfo();
    pi.index = 16;
    pi.readable = true;
    pi.writable = true;
    mm.put("doubleField", pi);
    pi = new PropertyInfo();
    pi.index = 17;
    pi.readable = true;
    pi.writable = true;
    mm.put("doubleWrap", pi);
    pi = new PropertyInfo();
    pi.index = 18;
    pi.readable = true;
    pi.writable = true;
    mm.put("floatArray", pi);
    pi = new PropertyInfo();
    pi.index = 19;
    pi.readable = true;
    pi.writable = true;
    mm.put("floatField", pi);
    pi = new PropertyInfo();
    pi.index = 20;
    pi.readable = true;
    pi.writable = true;
    mm.put("floatWrap", pi);
    pi = new PropertyInfo();
    pi.index = 21;
    pi.readable = true;
    pi.writable = false;
    mm.put("getField", pi);
    pi = new PropertyInfo();
    pi.index = 22;
    pi.readable = true;
    pi.writable = true;
    mm.put("intArray", pi);
    pi = new PropertyInfo();
    pi.index = 23;
    pi.readable = true;
    pi.writable = true;
    mm.put("intArrayMap", pi);
    pi = new PropertyInfo();
    pi.index = 24;
    pi.readable = true;
    pi.writable = true;
    mm.put("intField", pi);
    pi = new PropertyInfo();
    pi.index = 25;
    pi.readable = true;
    pi.writable = true;
    mm.put("intWrap", pi);
    pi = new PropertyInfo();
    pi.index = 26;
    pi.readable = true;
    pi.writable = true;
    mm.put("longArray", pi);
    pi = new PropertyInfo();
    pi.index = 27;
    pi.readable = true;
    pi.writable = true;
    mm.put("longField", pi);
    pi = new PropertyInfo();
    pi.index = 28;
    pi.readable = true;
    pi.writable = true;
    mm.put("longWrap", pi);
    pi = new PropertyInfo();
    pi.index = 29;
    pi.readable = true;
    pi.writable = true;
    mm.put("numExtendMap", pi);
    pi = new PropertyInfo();
    pi.index = 30;
    pi.readable = false;
    pi.writable = true;
    mm.put("setField", pi);
    pi = new PropertyInfo();
    pi.index = 31;
    pi.readable = true;
    pi.writable = true;
    mm.put("shortArray", pi);
    pi = new PropertyInfo();
    pi.index = 32;
    pi.readable = true;
    pi.writable = true;
    mm.put("shortField", pi);
    pi = new PropertyInfo();
    pi.index = 33;
    pi.readable = true;
    pi.writable = true;
    mm.put("shortWrap", pi);
    pi = new PropertyInfo();
    pi.index = 34;
    pi.readable = true;
    pi.writable = true;
    mm.put("stringArray", pi);
    pi = new PropertyInfo();
    pi.index = 35;
    pi.readable = true;
    pi.writable = true;
    mm.put("stringField", pi);
    pi = new PropertyInfo();
    pi.index = 36;
    pi.readable = true;
    pi.writable = true;
    mm.put("stringList", pi);
    pi = new PropertyInfo();
    pi.index = 37;
    pi.readable = true;
    pi.writable = true;
    mm.put("testB", pi);
  }
  public Type getPropertyType(TestA bo, String pn) {
    PropertyInfo pi = mm.get(pn);
    if (pi == null) {
      return null;
    }
    switch (pi.index) {
    case 1: return boolean[].class;
    case 2: return boolean.class;
    case 3: return java.lang.Boolean.class;
    case 4: return byte[].class;
    case 5: return byte.class;
    case 6: return java.lang.Byte.class;
    case 7: return char[].class;
    case 8: return char.class;
    case 9: return java.lang.Character.class;
    case 10: return Types.paramTypeOfOwner(null, java.lang.Class.class, Types.subTypeOf(java.lang.Object.class));
    case 11: return java.util.Date[].class;
    case 12: return java.util.Date.class;
    case 13: return Types.paramTypeOfOwner(null, java.util.Map.class, java.lang.String.class, java.util.Date.class);
    case 14: return Types.paramTypeOfOwner(null, java.util.List.class, Types.paramTypeOfOwner(null, java.util.Map.class, java.lang.String.class, java.util.Date.class));
    case 15: return double[].class;
    case 16: return double.class;
    case 17: return java.lang.Double.class;
    case 18: return float[].class;
    case 19: return float.class;
    case 20: return java.lang.Float.class;
    case 21: return java.lang.String.class;
    case 22: return int[].class;
    case 23: return Types.paramTypeOfOwner(null, java.util.Map.class, Types.subTypeOf(java.lang.Object.class), int[].class);
    case 24: return int.class;
    case 25: return java.lang.Integer.class;
    case 26: return long[].class;
    case 27: return long.class;
    case 28: return java.lang.Long.class;
    case 29: return Types.paramTypeOfOwner(null, java.util.Map.class, Types.subTypeOf(java.lang.Object.class), Types.subTypeOf(java.lang.Number.class));
    case 30: return java.lang.String.class;
    case 31: return short[].class;
    case 32: return short.class;
    case 33: return java.lang.Short.class;
    case 34: return java.lang.String[].class;
    case 35: return java.lang.String.class;
    case 36: return Types.paramTypeOfOwner(null, java.util.List.class, java.lang.String.class);
    case 37: return TestA.TestB.class;
    default:
      return null;
    }
  }
  public Object getPropertyValue(TestA bo, String pn) {
    PropertyInfo pi = mm.get(pn);
    if (pi == null) {
      return null;
    }
    try {
      switch (pi.index) {
      case 1: return bo.getBoolArray();
      case 2: return bo.isBoolField();
      case 3: return bo.getBoolWrap();
      case 4: return bo.getByteArray();
      case 5: return bo.getByteField();
      case 6: return bo.getByteWrap();
      case 7: return bo.getCharArray();
      case 8: return bo.getCharField();
      case 9: return bo.getCharWrap();
      case 10: return bo.getClass();
      case 11: return bo.getDateArray();
      case 12: return bo.getDateField();
      case 13: return bo.getDateMap();
      case 14: return bo.getDateMapList();
      case 15: return bo.getDoubleArray();
      case 16: return bo.getDoubleField();
      case 17: return bo.getDoubleWrap();
      case 18: return bo.getFloatArray();
      case 19: return bo.getFloatField();
      case 20: return bo.getFloatWrap();
      case 21: return bo.getGetField();
      case 22: return bo.getIntArray();
      case 23: return bo.getIntArrayMap();
      case 24: return bo.getIntField();
      case 25: return bo.getIntWrap();
      case 26: return bo.getLongArray();
      case 27: return bo.getLongField();
      case 28: return bo.getLongWrap();
      case 29: return bo.getNumExtendMap();
      case 30: return null;
      case 31: return bo.getShortArray();
      case 32: return bo.getShortField();
      case 33: return bo.getShortWrap();
      case 34: return bo.getStringArray();
      case 35: return bo.getStringField();
      case 36: return bo.getStringList();
      case 37: return bo.getTestB();
      default:return null;
      }
    } catch (Throwable e) { throw Exceptions.wrapThrow(e); }
  }
  @SuppressWarnings("unchecked")
public boolean setPropertyValue(TestA bo, String pn, Object value) {
    PropertyInfo pi = mm.get(pn);
    if (pi == null) {
      return false;
    }
    try {
      switch (pi.index) {
      case 1: bo.setBoolArray((boolean[])value); return true;
      case 2: bo.setBoolField((java.lang.Boolean)value); return true;
      case 3: bo.setBoolWrap((java.lang.Boolean)value); return true;
      case 4: bo.setByteArray((byte[])value); return true;
      case 5: bo.setByteField((java.lang.Byte)value); return true;
      case 6: bo.setByteWrap((java.lang.Byte)value); return true;
      case 7: bo.setCharArray((char[])value); return true;
      case 8: bo.setCharField((java.lang.Character)value); return true;
      case 9: bo.setCharWrap((java.lang.Character)value); return true;
      case 10: return false;
      case 11: bo.setDateArray((java.util.Date[])value); return true;
      case 12: bo.setDateField((java.util.Date)value); return true;
      case 13: bo.setDateMap((java.util.Map<java.lang.String, java.util.Date>)value); return true;
      case 14: bo.setDateMapList((java.util.List<java.util.Map<java.lang.String, java.util.Date>>)value); return true;
      case 15: bo.setDoubleArray((double[])value); return true;
      case 16: bo.setDoubleField((java.lang.Double)value); return true;
      case 17: bo.setDoubleWrap((java.lang.Double)value); return true;
      case 18: bo.setFloatArray((float[])value); return true;
      case 19: bo.setFloatField((java.lang.Float)value); return true;
      case 20: bo.setFloatWrap((java.lang.Float)value); return true;
      case 21: return false;
      case 22: bo.setIntArray((int[])value); return true;
//      case 23: bo.setIntArrayMap((java.util.Map<?, [I>)value); return true;
      case 23: bo.setIntArrayMap((java.util.Map)value); return true;
      case 24: bo.setIntField((java.lang.Integer)value); return true;
      case 25: bo.setIntWrap((java.lang.Integer)value); return true;
      case 26: bo.setLongArray((long[])value); return true;
      case 27: bo.setLongField((java.lang.Long)value); return true;
      case 28: bo.setLongWrap((java.lang.Long)value); return true;
      case 29: bo.setNumExtendMap((java.util.Map<?, ? extends java.lang.Number>)value); return true;
      case 30: bo.setSetField((java.lang.String)value); return true;
      case 31: bo.setShortArray((short[])value); return true;
      case 32: bo.setShortField((java.lang.Short)value); return true;
      case 33: bo.setShortWrap((java.lang.Short)value); return true;
      case 34: bo.setStringArray((java.lang.String[])value); return true;
      case 35: bo.setStringField((java.lang.String)value); return true;
      case 36: bo.setStringList((java.util.List<java.lang.String>)value); return true;
      case 37: bo.setTestB((TestA.TestB)value); return true;
      default:return false;
      }
    } catch (Throwable e) { throw Exceptions.wrapThrow(e); }
  }
}

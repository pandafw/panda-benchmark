package panda.benchmark.bean.fast;

import java.lang.reflect.Type;

import panda.bean.Beans;
import panda.bean.fast.AbstractFastBeanHandler;
import panda.benchmark.bean.TestA;
import panda.benchmark.bean.TestH;
import panda.lang.Exceptions;
import panda.lang.reflect.Types;

public class TestHHandler extends AbstractFastBeanHandler<TestH> {
  public TestHHandler(Beans factory) {
    super(factory, TestH.class);
  }
  protected void init() {
    rpns = new String[] {
      "class"
      , "lst"
      , "obj"
      , "ori"
    };
    wpns = new String[] {
      "ori"
    };
    PropertyInfo pi;
    pi = new PropertyInfo();
    pi.index = 1;
    pi.readable = true;
    pi.writable = false;
    mm.put("class", pi);
    pi = new PropertyInfo();
    pi.index = 2;
    pi.readable = true;
    pi.writable = false;
    mm.put("lst", pi);
    pi = new PropertyInfo();
    pi.index = 3;
    pi.readable = true;
    pi.writable = false;
    mm.put("obj", pi);
    pi = new PropertyInfo();
    pi.index = 4;
    pi.readable = true;
    pi.writable = true;
    mm.put("ori", pi);
  }
  public Type getPropertyType(TestH bo, String pn) {
    PropertyInfo pi = mm.get(pn);
    if (pi == null) {
      return null;
    }
    switch (pi.index) {
    case 1: return Types.paramTypeOfOwner(null, java.lang.Class.class, Types.subTypeOf(java.lang.Object.class));
    case 2: return Types.paramTypeOfOwner(null, java.util.List.class, TestA.class);
    case 3: return TestA.class;
    case 4: return java.lang.Object.class;
    default:
      return null;
    }
  }
  public Object getPropertyValue(TestH bo, String pn) {
    PropertyInfo pi = mm.get(pn);
    if (pi == null) {
      return null;
    }
    try {
      switch (pi.index) {
      case 1: return bo.getClass();
      case 2: return bo.getLst();
      case 3: return bo.getObj();
      case 4: return bo.getOri();
      default:return null;
      }
    } catch (Throwable e) { throw Exceptions.wrapThrow(e); }
  }
  public boolean setPropertyValue(TestH bo, String pn, Object value) {
    PropertyInfo pi = mm.get(pn);
    if (pi == null) {
      return false;
    }
    try {
      switch (pi.index) {
      case 1: return false;
      case 2: return false;
      case 3: return false;
      case 4: bo.setOri((TestA)value); return true;
      default:return false;
      }
    } catch (Throwable e) { throw Exceptions.wrapThrow(e); }
  }
}


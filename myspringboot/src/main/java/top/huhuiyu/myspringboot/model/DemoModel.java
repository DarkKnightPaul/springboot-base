package top.huhuiyu.myspringboot.model;

import top.huhuiyu.myspringboot.entity.TbTest;

public class DemoModel extends BaseModel {

  private static final long serialVersionUID = 2103408237256080317L;

  private TbTest test=new TbTest();

  public DemoModel() {
  }

  public TbTest getTest() {
    return test;
  }

  public void setTest(TbTest test) {
    this.test = test;
  }

  @Override
  public String toString() {
    return super.toString() + ",DemoModel [test=" + test + "]";
  }

}

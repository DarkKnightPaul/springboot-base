package top.huhuiyu.myspringboot.entity;

import java.io.Serializable;

public class TbDept implements Serializable{
  private static final long serialVersionUID = 1090470865095708661L;

  private int deptId;
  private String deptName;
  
  public TbDept() {
  }

  public int getDeptId() {
    return deptId;
  }

  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  @Override
  public String toString() {
    return "TbDept [deptId=" + deptId + ", deptName=" + deptName + "]";
  }
  
}

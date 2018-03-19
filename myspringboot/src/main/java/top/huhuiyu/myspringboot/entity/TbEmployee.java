package top.huhuiyu.myspringboot.entity;

import java.io.Serializable;

public class TbEmployee implements Serializable {

  private static final long serialVersionUID = 1448055368107984349L;

  private int empId;
  private String empName;
  private TbDept dept;

  public TbEmployee() {
  }

  public int getEmpId() {
    return empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public TbDept getDept() {
    return dept;
  }

  public void setDept(TbDept dept) {
    this.dept = dept;
  }

  @Override
  public String toString() {
    return "TbEmployee [empId=" + empId + ", empName=" + empName + ", dept=" + dept + "]";
  }

}

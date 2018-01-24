package top.huhuiyu.myspringboot.entity;

import java.io.Serializable;
import java.util.Date;

public class TbTest implements Serializable {

  private static final long serialVersionUID = 85720286004519839L;
  private Integer tid;
  private String tinfo;
  private Date createdTime;
  private Long modifyTime;

  public TbTest() {
  }

  @Override
  public String toString() {
    return "TbTest [tid=" + tid + ", tinfo=" + tinfo + ", createdTime=" + createdTime + ", modifyTime=" + modifyTime
        + "]";
  }

  public Integer getTid() {
    return tid;
  }

  public void setTid(Integer tid) {
    this.tid = tid;
  }

  public String getTinfo() {
    return tinfo;
  }

  public void setTinfo(String tinfo) {
    this.tinfo = tinfo;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Long getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Long modifyTime) {
    this.modifyTime = modifyTime;
  }

}

package top.huhuiyu.myspringboot.service;

import java.util.List;

import top.huhuiyu.myspringboot.entity.TbEmployee;
import top.huhuiyu.myspringboot.entity.TbTest;

public interface DemoService {
  List<TbTest> queryAll();
  List<TbEmployee> queryMapping();
}

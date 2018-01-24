package top.huhuiyu.myspringboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.myspringboot.entity.TbTest;
import top.huhuiyu.myspringboot.mapper.TbTestMapper;
import top.huhuiyu.myspringboot.service.DemoService;

@Component
@Transactional(rollbackFor = Exception.class)
public class DemoServiceImpl implements DemoService {
  @Autowired
  private TbTestMapper tbTestMapper;

  @Override
  public List<TbTest> queryAll() {
    return tbTestMapper.queryAll();
  }

}

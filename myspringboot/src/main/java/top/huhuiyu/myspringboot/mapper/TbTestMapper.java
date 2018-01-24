package top.huhuiyu.myspringboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.myspringboot.entity.TbTest;

@Mapper
public interface TbTestMapper {
  List<TbTest> queryAll();
}

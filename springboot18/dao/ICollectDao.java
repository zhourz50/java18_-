package com.example.springboot18.dao;

import com.example.springboot18.model.Collect;

import java.util.List;

public interface ICollectDao {

    public List<Collect> queryList(Collect collect);

    int save(Collect collect);

    int delete(Integer id);

    int deleteByUserIdAProductId(Collect collect);

}

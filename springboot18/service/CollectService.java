package com.example.springboot18.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.springboot18.dao.ICollectDao;
import com.example.springboot18.model.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 主要的业务逻辑处理
@Service
public class CollectService {

    @Autowired
    private ICollectDao collectDao;


    @Transactional
    public void collect(String userId, Integer productId) {
        // 判断这个用户对这个商品是否已经收藏过
        Collect collect = new Collect();
        collect.setUserId(Integer.valueOf(userId));
        collect.setProductId(productId);
        List<Collect> collectList = collectDao.queryList(collect);
        if (CollectionUtil.isEmpty(collectList)) {
            // 添加收藏
            Collect addCollect = new Collect();
            addCollect.setUserId(Integer.valueOf(userId));
            addCollect.setProductId(productId);
            collectDao.save(addCollect);

        } else {
            // 取消收藏
//            Collect delCollect = new Collect();
//            delCollect.setUserId(Integer.valueOf(userId));
//            delCollect.setProductId(productId);
//            collectDao.deleteByUserIdAProductId(delCollect);
            collectList.stream().forEach(s -> collectDao.delete(s.getId()));
        }


    }


}

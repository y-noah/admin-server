package com.example.adminserver.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.adminserver.sys.mapper.WineMapper;
import com.example.adminserver.sys.service.IWineService;
import com.example.adminserver.sys.entity.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WineServiceImpl extends ServiceImpl<WineMapper, Wine>  implements IWineService {
    @Autowired
    private WineMapper wineMapper;

    @Override
    public Map<String, Object> getWineForm() {

        List<Wine> wines = wineMapper.selectList(null);

        Map map = new HashMap();
        map.put("form",wines);

        return map;
    }

    @Override
    public int modifyWineForm(Wine wine) {
        QueryWrapper queryWrapper =  new QueryWrapper();
        queryWrapper.eq("id", wine.getId());
        queryWrapper.orderByAsc("id");


        int update = wineMapper.update(wine, queryWrapper);

        return update;
    }

    @Override
    public int addWineForm(Wine wine) {

        int i = wineMapper.insert(wine);

        return i;
    }

}

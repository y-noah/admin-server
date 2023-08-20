package com.example.adminserver.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.adminserver.sys.entity.Wine;

import java.util.Map;

public interface IWineService extends IService<Wine> {
    Map<String, Object> getWineForm();

    int modifyWineForm(Wine wine);

    int addWineForm(Wine wine);
}

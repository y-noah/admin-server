package com.example.adminserver.sys.controller;


import com.example.adminserver.common.vo.Result;
import com.example.adminserver.sys.service.IWineService;
import com.example.adminserver.sys.sys.entity.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired
    private IWineService iWineService;

    @PostMapping("/getForm")
    public Result<Map<String,Object>> getForm() {
        Map<String, Object> wineForm = iWineService.getWineForm();

        if (wineForm.size() > 0) {
            return Result.success(wineForm);
        } else {
            return Result.fail();
        }
    }

    @PostMapping("/modifyForm")
    public Result<Map<String,Object>> modifyForm(@RequestBody Wine wine) {

        int i = iWineService.modifyWineForm(wine);

        if (i > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @PostMapping("/addForm")
    public Result<Map<String,Object>> addForm(@RequestBody Wine wine) {

        int i = iWineService.addWineForm(wine);

        if (i > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }
}

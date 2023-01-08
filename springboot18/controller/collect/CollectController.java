package com.example.springboot18.controller.collect;

import com.example.springboot18.service.CollectService;
import com.example.springboot18.view.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @PostMapping("/{productId}")
    public ResultView collect(@RequestHeader("userId") String userId, @PathVariable Integer productId) {

        collectService.collect(userId, productId);
        return ResultView.success();

    }
}

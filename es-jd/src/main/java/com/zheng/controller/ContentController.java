package com.zheng.controller;

import com.zheng.service.serviceImpl.ContentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class ContentController {
    @Autowired
    private ContentServiceImpl contentServiceImpl;
    @GetMapping("/parse/{keywords}")
    public boolean parse(@PathVariable("keywords")  String keywords) throws Exception {
        return contentServiceImpl.parseContent(keywords);
    }
    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String,Object>> search(@PathVariable("keyword") String keyword,
                                           @PathVariable("pageNo") int pageNo,
                                           @PathVariable("pageSize") int pageSize) throws IOException {
        return contentServiceImpl.searchPage(keyword, pageNo, pageSize);
    }
}

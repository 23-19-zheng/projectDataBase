package com.zheng.service;
import java.io.IOException;
import java.util.Map;
import java.util.List;
public interface ContentService {
    boolean parseContent(String keywords) throws Exception;
    List<Map<String,Object>> searchPage(String keywords,int pageNo,int pageSize) throws IOException;
}

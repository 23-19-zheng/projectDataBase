package edu.xaufe.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/08/17:26
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResp<T> {
    private int code;
    private String massage;
    private T data;
    public HttpResp(int code,String massage){
        this.code = code;
        this.massage = massage;
    }
}

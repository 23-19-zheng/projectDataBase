package edu.xufe.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 后端返回给前端的同意对象
 * 
 */
public class ResponseResult {
	private Integer code;
	private String msg;
	private Object object;
	private LocalDateTime times;//获取当前本地时间
	public ResponseResult() {
		super();
	}
	public ResponseResult(Integer code, String msg, Object object, LocalDateTime times) {
		super();
		this.code = code;
		this.msg = msg;
		this.object = object;
		this.times = times;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public LocalDateTime getTimes() {
		return times;
	}
	public void setTimes(LocalDateTime times) {
		this.times = times;
	}
	@Override
	public String toString() {
		return "ResponseResult [code=" + code + ", msg=" + msg + ", object=" + object + ", times=" + times + "]";
	}
	
	

}

package com.djs.json;

import java.time.LocalDateTime;

public class HttpResp {
	private Integer code;
	private String msg;
	private  Object results;
	private LocalDateTime times;
	public HttpResp() {
		super();
	}
	public HttpResp(Integer code, String msg, Object results, LocalDateTime times) {
		super();
		this.code = code;
		this.msg = msg;
		this.results = results;
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
	public Object getResults() {
		return results;
	}
	public void setResults(Object results) {
		this.results = results;
	}
	public LocalDateTime getTimes() {
		return times;
	}
	public void setTimes(LocalDateTime times) {
		this.times = times;
	}
	@Override
	public String toString() {
		return "HttpResp [code=" + code + ", msg=" + msg + ", results=" + results + ", times=" + times + "]";
	}
	
}

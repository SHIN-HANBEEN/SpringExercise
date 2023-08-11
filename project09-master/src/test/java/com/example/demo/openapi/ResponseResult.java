package com.example.demo.openapi;

import java.util.List;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class ResponseResult {
	Response response;
}

@Setter
@ToString
class Response {
	Header header;
	Body body;
}

@Setter
@ToString
class Header {
	String resultCode;
	String resultMsg;
}

@Setter
@ToString
class Body {
	String dataType;
	Items items;
	int pageNo;
	int numOfRows;
	int totalCount;
}

@Setter
@ToString
class Items {
	List<Item> item;
}

@Setter
@ToString
class Item {
	String announceTime;
	String numEf;
	String regId;
	String rnSt;
	String rnYn;
	String ta;
	String wd1;
	String wd2;
	String wdTnd;
	String wf;
	String wfCd;
	String wsIt;
}
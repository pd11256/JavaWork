package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

// POJO : Plain Old Java Object


@JacksonXmlRootElement(localName = "WriteList")
public class AjaxWriteListJXML {
	int count; //  데이터 개수
	String status; //처리결과
	
	@JsonIgnore
	String memo; //response 에서 제외할 필드
	
	
	@JacksonXmlElementWrapper(useWrapping =false)
	@JacksonXmlProperty(localName = "Data")
	List<WriteDTO> list;
	
	
	
	
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<WriteDTO> getList() {
		return list;
	}

	public void setList(List<WriteDTO> list) {
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}


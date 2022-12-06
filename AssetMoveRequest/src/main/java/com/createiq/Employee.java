package com.createiq;

import org.bson.json.JsonObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "emp_db")
public class Employee {

	@Id
	private long _id;

	private Object data;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long _id, Object data) {
		super();
		this._id = _id;
		this.data = data;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Employee [_id=" + _id + ", data=" + data + "]";
	}
	
	

	
}

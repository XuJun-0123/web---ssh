package cn.imooc.pojo;

import java.io.Serializable;

public class Department_Employee_Relation implements Serializable{

	   int deid;
	   int did;
	   int eid;
	public int getDeid() {
		return deid;
	}
	public void setDeid(int deid) {
		this.deid = deid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	@Override
	public String toString() {
		return "Department_Employee_Relation [deid=" + deid + ", did=" + did + ", eid=" + eid + "]";
	}
	   

}

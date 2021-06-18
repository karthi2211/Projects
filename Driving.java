package Modern;

import java.io.InputStream;

public class Driving {
	private Integer regno;
	private String name,type,dateofjoin,bgroup,status;
	private String address,id;

	public Driving(Integer regno,String name,String type,String dateofjoin,String bgroup,String status,String address,String id) {
		super();
		this.regno=regno;
		this.name=name;
		this.type=type;
		this.dateofjoin=dateofjoin;
		this.bgroup=bgroup;
		this.status=status;
		this.address=address;
		this.id=id;
	}
	public Driving() {
		super();
		
	}
	public Integer getRegno() {
		return regno;
	}
	public void setRegno(Integer regno) {
		this.regno = regno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(String dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}

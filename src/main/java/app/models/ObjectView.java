package app.models;

import java.util.List;

public class ObjectView extends Entity{
	
	private Sharedcode sharedcode;
	private List<Sharedcode> list;
	
	
	public Sharedcode getSharedcode() {
		return sharedcode;
	}
	public void setSharedcode(Sharedcode sharedcode) {
		this.sharedcode = sharedcode;
	}
	public List<Sharedcode> getList() {
		return list;
	}
	public void setList(List<Sharedcode> list) {
		this.list = list;
	}

}

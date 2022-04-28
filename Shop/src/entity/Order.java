package entity;

public class Order {
private int idOrder;
private String tenKhach;
private String sdt;
private String Diachi;
public int getIdOrder() {
	return idOrder;
}
public void setIdOrder(int idOrder) {
	this.idOrder = idOrder;
}
public String getTenKhach() {
	return tenKhach;
}
public void setTenKhach(String tenKhach) {
	this.tenKhach = tenKhach;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}
public String getDiachi() {
	return Diachi;
}
public void setDiachi(String diachi) {
	Diachi = diachi;
}
public Order(int idOrder, String tenKhach, String sdt, String diachi) {
	super();
	this.idOrder = idOrder;
	this.tenKhach = tenKhach;
	this.sdt = sdt;
	Diachi = diachi;
}

}

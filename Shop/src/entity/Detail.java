package entity;

public class Detail {
private int maChiTietHoaDon;
private Order idOrder;
private Product  id;
private String soluong;
private float gi�;
public int getMaChiTietHoaDon() {
	return maChiTietHoaDon;
}
public void setMaChiTietHoaDon(int maChiTietHoaDon) {
	this.maChiTietHoaDon = maChiTietHoaDon;
}

public Order getIdOrder() {
	return idOrder;
}
public void setIdOrder(Order idOrder) {
	this.idOrder = idOrder;
}
public Product getId() {
	return id;
}
public void setId(Product id) {
	this.id = id;
}
public String getSoluong() {
	return soluong;
}
public void setSoluong(String soluong) {
	this.soluong = soluong;
}
public float getGi�() {
	return gi�;
}
public void setGi�(float gi�) {
	this.gi� = gi�;
}
public Detail() {
	
}
public Detail(int maChiTietHoaDon, Order idOrder, Product id, String soluong, float gi�) {
	super();
	this.maChiTietHoaDon = maChiTietHoaDon;
	this.idOrder = idOrder;
	this.id = id;
	this.soluong = soluong;
	this.gi� = gi�;
}


}

package entity;

import java.util.TreeMap;

public class Cart {
	
		private TreeMap<Product, Integer> list ; 
		private  long cartID;
		
		public Cart () {
			list = new TreeMap<>();
			cartID= System.currentTimeMillis();
		}
		public Cart(TreeMap<Product, Integer> list, long cartID) {
			super();
			this.list = list;
			this.cartID = cartID;
		}


		public TreeMap<Product, Integer> getList() {
			return list;
		}


		public void setList(TreeMap<Product, Integer> list) {
			this.list = list;
		}


		public long getCartID() {
			return cartID;
		}


		public void setCartID(long cartID) {
			this.cartID = cartID;
		}


		public void themGioHang (Product sp ,int soLuong) {
			boolean bln = list.containsKey(sp);
			if(bln) {
				int sl = list.get(sp);
				soLuong+=sl;
				list.put(sp, soLuong);
			}else {
				list.put(sp, soLuong);
			}
		}
		public void subToCart(Product sp , int s) {
			boolean bln = list.containsKey(sp);
			if(bln) {
				int sl = list.get(sp);
				s=sl-s;
				if(s<=0) {
					list.remove(sp);
				}else {
					list.remove(sp);
					list.put(sp, s);
				}
			
		}
	
		}
	}
	

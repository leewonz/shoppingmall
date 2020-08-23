package elecshopping;

//	장바구니 테이블 CART
//- CNUM 	(NUMBER)	카트 번호		PK
//- ID 		(STRING)	사용자 아이디	FK
//- PNUM 	(NUMBER)	상품명		FK


public class CartVO {
	private int cnum;
	private String id;
	private int pnum;
	
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	@Override
	public String toString() {
		return "CartVO [cnum=" + cnum + ", id=" + id + ", pnum=" + pnum + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cnum;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + pnum;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartVO other = (CartVO) obj;
		if (cnum != other.cnum)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pnum != other.pnum)
			return false;
		return true;
	}
	
	
}

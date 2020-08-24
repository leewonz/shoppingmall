package elecshopping;

//	��ٱ��� ���̺� CART
//- CNUM 	(NUMBER)	īƮ ��ȣ		PK
//- ID 		(STRING)	����� ���̵�	FK
//- PNUM 	(NUMBER)	��ǰ��		FK


public class CartVO {
	private int cnum;
	private String id;
	private int pnum;
	
	public CartVO(int cnum2, String id2, int pnum2) {
		// TODO Auto-generated constructor stub
	}
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

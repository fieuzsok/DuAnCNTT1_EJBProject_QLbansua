package entityBeans;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ct_hoadon database table.
 * 
 */
@Embeddable
public class CtHoadonPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String so_hoa_don;

	@Column(insertable=false, updatable=false)
	private String ma_sua;

	public CtHoadonPK() {
	}
	public String getSo_hoa_don() {
		return this.so_hoa_don;
	}
	public void setSo_hoa_don(String so_hoa_don) {
		this.so_hoa_don = so_hoa_don;
	}
	public String getMa_sua() {
		return this.ma_sua;
	}
	public void setMa_sua(String ma_sua) {
		this.ma_sua = ma_sua;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CtHoadonPK)) {
			return false;
		}
		CtHoadonPK castOther = (CtHoadonPK)other;
		return 
			this.so_hoa_don.equals(castOther.so_hoa_don)
			&& this.ma_sua.equals(castOther.ma_sua);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.so_hoa_don.hashCode();
		hash = hash * prime + this.ma_sua.hashCode();
		
		return hash;
	}
}
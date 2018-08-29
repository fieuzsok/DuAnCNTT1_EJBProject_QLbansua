package entityBeans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ct_hoadon database table.
 * 
 */
@Entity
@Table(name="ct_hoadon")
@NamedQuery(name="CtHoadon.findAll", query="SELECT c FROM CtHoadon c")
public class CtHoadon implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CtHoadonPK id;

	private int don_gia;

	private int so_luong;

	//bi-directional many-to-one association to HoaDon
	@ManyToOne
	@JoinColumn(name="So_hoa_don")
	private HoaDon hoaDon;

	//bi-directional many-to-one association to Sua
	@ManyToOne
	@JoinColumn(name="Ma_sua")
	private Sua sua;

	public CtHoadon() {
	}

	public CtHoadonPK getId() {
		return this.id;
	}

	public void setId(CtHoadonPK id) {
		this.id = id;
	}

	public int getDon_gia() {
		return this.don_gia;
	}

	public void setDon_gia(int don_gia) {
		this.don_gia = don_gia;
	}

	public int getSo_luong() {
		return this.so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public HoaDon getHoaDon() {
		return this.hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Sua getSua() {
		return this.sua;
	}

	public void setSua(Sua sua) {
		this.sua = sua;
	}

}
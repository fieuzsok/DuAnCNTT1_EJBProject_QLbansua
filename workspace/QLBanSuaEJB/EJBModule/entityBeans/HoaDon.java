package entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the hoa_don database table.
 * 
 */
@Entity
@Table(name="hoa_don")
@NamedQuery(name="HoaDon.findAll", query="SELECT h FROM HoaDon h")
public class HoaDon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String so_hoa_don;

	@Temporal(TemporalType.DATE)
	private Date ngay_HD;

	private double tri_gia;

	//bi-directional many-to-one association to CtHoadon
	@OneToMany(mappedBy="hoaDon")
	private List<CtHoadon> ctHoadons;

	//bi-directional many-to-one association to KhachHang
	@ManyToOne
	@JoinColumn(name="Ma_khach_hang")
	private KhachHang khachHang;

	public HoaDon() {
	}

	public String getSo_hoa_don() {
		return this.so_hoa_don;
	}

	public void setSo_hoa_don(String so_hoa_don) {
		this.so_hoa_don = so_hoa_don;
	}

	public Date getNgay_HD() {
		return this.ngay_HD;
	}

	public void setNgay_HD(Date ngay_HD) {
		this.ngay_HD = ngay_HD;
	}

	public double getTri_gia() {
		return this.tri_gia;
	}

	public void setTri_gia(double tri_gia) {
		this.tri_gia = tri_gia;
	}

	public List<CtHoadon> getCtHoadons() {
		return this.ctHoadons;
	}

	public void setCtHoadons(List<CtHoadon> ctHoadons) {
		this.ctHoadons = ctHoadons;
	}

	public CtHoadon addCtHoadon(CtHoadon ctHoadon) {
		getCtHoadons().add(ctHoadon);
		ctHoadon.setHoaDon(this);

		return ctHoadon;
	}

	public CtHoadon removeCtHoadon(CtHoadon ctHoadon) {
		getCtHoadons().remove(ctHoadon);
		ctHoadon.setHoaDon(null);

		return ctHoadon;
	}

	public KhachHang getKhachHang() {
		return this.khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

}
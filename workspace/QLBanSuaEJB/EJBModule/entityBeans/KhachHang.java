package entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the khach_hang database table.
 * 
 */
@Entity
@Table(name="khach_hang")
@NamedQuery(name="KhachHang.findAll", query="SELECT k FROM KhachHang k")
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ma_khach_hang;

	private String dia_chi;

	private String dien_thoai;

	private String email;

	private byte phai;

	private String ten_khach_hang;

	//bi-directional many-to-one association to HoaDon
	@OneToMany(mappedBy="khachHang")
	private List<HoaDon> hoaDons;

	public KhachHang() {
	}

	public String getMa_khach_hang() {
		return this.ma_khach_hang;
	}

	public void setMa_khach_hang(String ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}

	public String getDia_chi() {
		return this.dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getDien_thoai() {
		return this.dien_thoai;
	}

	public void setDien_thoai(String dien_thoai) {
		this.dien_thoai = dien_thoai;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getPhai() {
		return this.phai;
	}

	public void setPhai(byte phai) {
		this.phai = phai;
	}

	public String getTen_khach_hang() {
		return this.ten_khach_hang;
	}

	public void setTen_khach_hang(String ten_khach_hang) {
		this.ten_khach_hang = ten_khach_hang;
	}

	public List<HoaDon> getHoaDons() {
		return this.hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public HoaDon addHoaDon(HoaDon hoaDon) {
		getHoaDons().add(hoaDon);
		hoaDon.setKhachHang(this);

		return hoaDon;
	}

	public HoaDon removeHoaDon(HoaDon hoaDon) {
		getHoaDons().remove(hoaDon);
		hoaDon.setKhachHang(null);

		return hoaDon;
	}

}
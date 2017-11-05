package pl.klusek.Vegapi.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Local")
public class Local implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4552605032542426903L;
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String city;
	private String postalCode;
	private String street;
	private String streetNumber;
	private String tel;
	private String website;
	private String urlToLogo;
	private String shortDescription;
	private double xGPS;
	private double yGPS;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getUrlToLogo() {
		return urlToLogo;
	}
	public void setUrlToLogo(String urlToLogo) {
		this.urlToLogo = urlToLogo;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public double getxGPS() {
		return xGPS;
	}
	public void setxGPS(float xGPS) {
		this.xGPS = xGPS;
	}
	public double getyGPS() {
		return yGPS;
	}
	public void setyGPS(float yGPS) {
		this.yGPS = yGPS;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public void setxGPS(double xGPS) {
		this.xGPS = xGPS;
	}
	public void setyGPS(double yGPS) {
		this.yGPS = yGPS;
	}
	
	
}

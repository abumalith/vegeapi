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
	private String street;
	private String streetNumber;
	private String tel;
	private String website;
	private OpenHours openHours;
	private String urlToLogo;
	private String shortDescription;
	private float xGPS;
	private float yGPS;
	
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
	public OpenHours getOpenHours() {
		return openHours;
	}
	public void setOpenHours(OpenHours openHours) {
		this.openHours = openHours;
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
	public float getxGPS() {
		return xGPS;
	}
	public void setxGPS(float xGPS) {
		this.xGPS = xGPS;
	}
	public float getyGPS() {
		return yGPS;
	}
	public void setyGPS(float yGPS) {
		this.yGPS = yGPS;
	}
	
	
}

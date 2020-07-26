package dto;

public class TheaterDto {


	private long id;
	private String name;
	private String address;
	private String citi;
	private String img;
	private double rating;
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCiti() {
		return citi;
	}

	public void setCiti(String citi) {
		this.citi = citi;
	}

	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	

	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + ", address=" + address + ", citi=" + citi + "]";
	}

}

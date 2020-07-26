package dto;

public class MovieDto {

	private long id;
	private String name;
	private String description;
	private String length;
	private String img;
	private String cover;
	private String rating;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "MovieDto [id=" + id + ", name=" + name + ", description=" + description + ", length=" + length
				+ ", img=" + img + ", cover=" + cover + ", rating=" + rating + "]";
	}

	
	
}

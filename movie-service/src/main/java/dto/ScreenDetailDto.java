package dto;

import java.util.List;

public class ScreenDetailDto {

	private long id;
	private String name;
	private long capacity;
	private long availability;

	private List<ShowDto> showList;

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

	public List<ShowDto> getShowList() {
		return showList;
	}

	public void setShowList(List<ShowDto> showList) {
		this.showList = showList;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public long getAvailability() {
		return availability;
	}

	public void setAvailability(long availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "ScreenDto [id=" + id + ", name=" + name + ", capacity=" + capacity + ", availability=" + availability
				+ ", showList=" + showList + "]";
	}

	
	

}

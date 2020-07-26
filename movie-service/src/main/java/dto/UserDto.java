package dto;

import java.util.List;

public class UserDto {

	private long id;
	private String name;
	private String userid;
	private String role;

	private List<CommentDto> comments;

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

	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", userid=" + userid + ", role=" + role + ", comments="
				+ comments + "]";
	}

}

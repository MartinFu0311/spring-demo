package spring.martin.pojo;

import org.apache.ibatis.type.Alias;

@Alias(value="role")
public class Role {

	private Long id;
	
	private String roleName;
	
	private String note;
	
	/*
	 * 如果添加了参数不为空的构造函数，那么就需要补上默认构造函数，否则会报类似
	 * “No constructor found in com.tszhao.dao.User matching [java.lang.Integer, java.lang.String, java.lang.String]”
	 * 的错误，很可能是 Spring 或者 mybatis 反射时的机制所致
	 */
	public Role() {
		super();
	}

	public Role(Long id, String roleName, String note) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.note = note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}

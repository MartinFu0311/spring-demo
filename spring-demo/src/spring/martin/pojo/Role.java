package spring.martin.pojo;

import org.apache.ibatis.type.Alias;

@Alias(value="role")
public class Role {

	private Long id;
	
	private String roleName;
	
	private String note;
	
	/*
	 * �������˲�����Ϊ�յĹ��캯������ô����Ҫ����Ĭ�Ϲ��캯��������ᱨ����
	 * ��No constructor found in com.tszhao.dao.User matching [java.lang.Integer, java.lang.String, java.lang.String]��
	 * �Ĵ��󣬺ܿ����� Spring ���� mybatis ����ʱ�Ļ�������
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

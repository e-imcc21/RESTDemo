package pojo;
public class Department{
	private Integer id;
	private Employee manager;
	private String name;
	private String location;
	private Integer openPositions;
	private Integer parentDeptId;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getOpenPositions() {
		return this.openPositions;
	}

	public void setOpenPositions(Integer openPositions) {
		this.openPositions = openPositions;
	}

	public Integer getParentDeptId() {
		return this.parentDeptId;
	}

	public void setParentDeptId(Integer parentDeptId) {
		this.parentDeptId = parentDeptId;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

}
package az.atl.academy.lesson31task.model;

public class Department {
    private Long departmentId;
    private String departmentName;
    private Long locationId;

    public Department() {
    }

    public Department(Long departmentId, String departmentName, Long locationId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.locationId = locationId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", locationId=" + locationId +
                '}';
    }
}

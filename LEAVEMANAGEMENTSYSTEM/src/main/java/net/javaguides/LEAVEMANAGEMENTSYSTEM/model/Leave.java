package net.javaguides.LEAVEMANAGEMENTSYSTEM.model;

public class Leave {
    private int id;
    private String name;
    private String leaveType;
    private String status;

    public Leave() {
    }

    public Leave(int id, String name, String leaveType, String status) {
        super();
        this.id = id;
        this.name = name;
        this.leaveType = leaveType;
        this.status = status;
    }

    // Add this new constructor
    public Leave(String name, String leaveType, String status) {
        this.name = name;
        this.leaveType = leaveType;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
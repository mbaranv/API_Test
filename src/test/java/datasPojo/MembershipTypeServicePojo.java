package datasPojo;

public class MembershipTypeServicePojo {

private String name;

private String is_enabled;

private int app_id;


    public MembershipTypeServicePojo() {



    }


    public MembershipTypeServicePojo(String name, String is_enabled, int app_id) {
        this.name = name;
        this.is_enabled = is_enabled;
        this.app_id = app_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(String is_enabled) {
        this.is_enabled = is_enabled;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }
}

package datasPojo;

public class MembershipTypeServicePutPojo {



    private  int id;

    private String name;

    private String is_enabled;

    private int app_id;


    public MembershipTypeServicePutPojo() {

    }

    public MembershipTypeServicePutPojo(int id, String name, String is_enabled, int app_id) {
        this.id = id;
        this.name = name;
        this.is_enabled = is_enabled;
        this.app_id = app_id;


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

    @Override
    public String toString() {
        return "MembershipTypeServicePutPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_enabled='" + is_enabled + '\'' +
                ", app_id=" + app_id +
                '}';
    }
}

package datasPojo;

public class PermissisonStatusBodyPostPojo {

    /*
    {

            "resource": "file",
            "action": "read",
            "app_id": 2
    }
*/
    private String resource;
    private String action;
    private int app_id;


    public PermissisonStatusBodyPostPojo(String resource, String action, int app_Id) {
        this.resource = resource;
        this.action = action;
        this.app_id = app_Id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getAppId() {
        return app_id;
    }

    public void setAppId(int appId) {
        this.app_id = appId;
    }

    @Override
    public String toString() {
        return "PermissisonPostPojo{" +
                "resource='" + resource + '\'' +
                ", action='" + action + '\'' +
                ", appId=" + app_id +
                '}';
    }
}


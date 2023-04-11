package datasPojo;

public class UserStatusBodyPostPojo {
    /*
    {
    "id": 6,
        "name": "team06",
            "description": "User account is active"
    }

     */



    private String name;
    private String description;

    public UserStatusBodyPostPojo() {
    }

    public UserStatusBodyPostPojo(String name, String description) {

        this.name = name;
        this.description = description;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}



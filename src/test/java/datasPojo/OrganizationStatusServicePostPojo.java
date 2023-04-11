package datasPojo;

public class OrganizationStatusServicePostPojo {


    private String name;
    private String description;

    private boolean is_enabled;

    public OrganizationStatusServicePostPojo() {
    }

    public OrganizationStatusServicePostPojo(String name, String description, boolean is_enabled) {
        this.name = name;
        this.description = description;
        this.is_enabled = is_enabled;
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

    public boolean isIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(boolean is_enabled) {
        this.is_enabled = is_enabled;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", is_enabled=" + is_enabled +
                '}';
    }
}

package dataProver_class;

public enum apiResources {
    AddPlaceAPI("/maps/api/place/add/json"),
    DeletePlaceAPI("/maps/api/place/delete/json"),
    GetPlaceAPI("/maps/api/place/get/json"),
    UpdatePlaceAPI("/maps/api/place/update/json");

    private final String resource;

    apiResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

}

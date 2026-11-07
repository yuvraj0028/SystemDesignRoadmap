package SystemDesignRoadmap.lld.url_builder.models;

public class PathParam {
    private String actualPath;
    private String pathValue;

    public PathParam(String actualPath, String pathValue) {
        this.actualPath = actualPath;
        this.pathValue = pathValue;
    }

    public String getActualPath() {
        return actualPath;
    }

    public void setActualPath(String actualPath) {
        this.actualPath = actualPath;
    }

    public String getPathValue() {
        return pathValue;
    }

    public void setPathValue(String pathValue) {
        this.pathValue = pathValue;
    }
}

package SystemDesignRoadmap.lld.url_builder.models;

public class QueryParam {
    private String queryKey;
    private String queryValue;

    public QueryParam(String queryKey, String queryValue) {
        this.queryKey = queryKey;
        this.queryValue = queryValue;
    }

    public String getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }

    public String getQueryValue() {
        return queryValue;
    }

    public void setQueryValue(String queryValue) {
        this.queryValue = queryValue;
    }
}

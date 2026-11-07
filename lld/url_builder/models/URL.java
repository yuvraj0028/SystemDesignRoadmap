package SystemDesignRoadmap.lld.url_builder.models;

import java.util.ArrayList;
import java.util.List;

public class URL {
    private String protocol;
    private String domainName;
    private final List<PathParam> pathParams;
    private final List<QueryParam> queryParams;

    public URL(String protocol, String domainName) {
        this.protocol = protocol;
        this.domainName = domainName;
        this.pathParams = new ArrayList<>();
        this.queryParams = new ArrayList<>();
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public List<PathParam> getPathParams() {
        return pathParams;
    }

    public void addPathParams(PathParam pathParam) {
        pathParams.add(pathParam);
    }

    public void removePathParam(PathParam pathParam) {
        pathParams.remove(pathParam);
    }

    public List<QueryParam> getQueryParams() {
        return queryParams;
    }

    public void addQueryParams(QueryParam queryParam) {
        queryParams.add(queryParam);
    }

    public void removeQueryParam(QueryParam queryParam) {
        queryParams.remove(queryParam);
    }
}

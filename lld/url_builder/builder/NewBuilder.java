package SystemDesignRoadmap.lld.url_builder.builder;

import SystemDesignRoadmap.lld.url_builder.models.PathParam;
import SystemDesignRoadmap.lld.url_builder.models.QueryParam;
import SystemDesignRoadmap.lld.url_builder.models.URL;
import SystemDesignRoadmap.lld.url_builder.utils.URLUtils;

public class NewBuilder implements Builder {
    private final URL url;

    public NewBuilder(String protocol, String domain) {
        this.url = new URL(protocol, domain);
    }

    @Override
    public URL buildPathParams(PathParam pathParam) {
        url.addPathParams(pathParam);
        return url;
    }

    @Override
    public URL buildQueryParam(QueryParam queryParam) {
        url.addQueryParams(queryParam);
        return url;
    }

    @Override
    public String getCompleteURL() {
        return URLUtils.createUrlString(url);
    }
}

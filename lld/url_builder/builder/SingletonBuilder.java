package SystemDesignRoadmap.lld.url_builder.builder;

import SystemDesignRoadmap.lld.url_builder.models.PathParam;
import SystemDesignRoadmap.lld.url_builder.models.QueryParam;
import SystemDesignRoadmap.lld.url_builder.models.URL;
import SystemDesignRoadmap.lld.url_builder.utils.URLUtils;

public class SingletonBuilder implements Builder {
    private static final String NULL_URL_MESSAGE =
            "URL object is null, initialize it using init() method";

    private static volatile SingletonBuilder instance;

    private URL url;

    private SingletonBuilder() {
    }

    public static SingletonBuilder getInstance() {
        if (instance == null) {
            synchronized (SingletonBuilder.class) {
                if (instance == null) {
                    instance = new SingletonBuilder();
                }
            }
        }
        return instance;
    }

    public URL init(String protocol, String domain) {
        url = new URL(protocol, domain);
        return url;
    }

    @Override
    public URL buildPathParams(PathParam pathParam) {
        requireInitialized();
        url.addPathParams(pathParam);
        return url;
    }

    @Override
    public URL buildQueryParam(QueryParam queryParam) {
        requireInitialized();
        url.addQueryParams(queryParam);
        return url;
    }

    @Override
    public String getCompleteURL() {
        requireInitialized();
        String completeUrl = URLUtils.createUrlString(url);
        url = null;
        return completeUrl;
    }

    private void requireInitialized() {
        if (url == null) {
            throw new IllegalStateException(NULL_URL_MESSAGE);
        }
    }
}

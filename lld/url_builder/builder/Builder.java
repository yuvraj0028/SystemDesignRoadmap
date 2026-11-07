package SystemDesignRoadmap.lld.url_builder.builder;

import SystemDesignRoadmap.lld.url_builder.models.PathParam;
import SystemDesignRoadmap.lld.url_builder.models.QueryParam;
import SystemDesignRoadmap.lld.url_builder.models.URL;

public interface Builder {
    URL buildPathParams(PathParam pathParam);

    URL buildQueryParam(QueryParam queryParam);

    String getCompleteURL();
}

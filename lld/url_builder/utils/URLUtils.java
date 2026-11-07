package SystemDesignRoadmap.lld.url_builder.utils;

import java.util.List;
import java.util.Objects;

import SystemDesignRoadmap.lld.url_builder.models.PathParam;
import SystemDesignRoadmap.lld.url_builder.models.QueryParam;
import SystemDesignRoadmap.lld.url_builder.models.URL;

public final class URLUtils {
    private URLUtils() {
    }

    public static String createUrlString(URL url) {
        Objects.requireNonNull(url, "url must not be null");

        StringBuilder urlString = new StringBuilder();
        urlString.append(url.getProtocol()).append("://").append(url.getDomainName());

        for (PathParam pathParam : url.getPathParams()) {
            appendPathSegment(urlString, pathParam.getActualPath());
            appendPathSegment(urlString, pathParam.getPathValue());
        }

        appendQueryParams(urlString, url.getQueryParams());
        return urlString.toString();
    }

    private static void appendPathSegment(StringBuilder urlString, String segment) {
        if (segment == null || segment.isEmpty()) {
            return;
        }
        urlString.append('/').append(segment);
    }

    private static void appendQueryParams(StringBuilder urlString, List<QueryParam> queryParams) {
        if (queryParams.isEmpty()) {
            return;
        }

        urlString.append('?');
        for (int index = 0; index < queryParams.size(); index++) {
            if (index > 0) {
                urlString.append('&');
            }
            QueryParam queryParam = queryParams.get(index);
            urlString.append(queryParam.getQueryKey())
                    .append('=')
                    .append(queryParam.getQueryValue());
        }
    }
}

package SystemDesignRoadmap.lld.url_builder;

import SystemDesignRoadmap.lld.url_builder.builder.Builder;
import SystemDesignRoadmap.lld.url_builder.builder.BuilderConfig;
import SystemDesignRoadmap.lld.url_builder.builder.BuilderType;
import SystemDesignRoadmap.lld.url_builder.factory.BuilderFactory;
import SystemDesignRoadmap.lld.url_builder.models.PathParam;
import SystemDesignRoadmap.lld.url_builder.models.QueryParam;

public class Main {
    public static void main(String[] args) {
        Builder newBuilder = BuilderFactory.create(
                new BuilderConfig("https", "google.com", BuilderType.NEW));
        addSearchRoute(newBuilder);
        System.out.println("NewBuilder: " + newBuilder.getCompleteURL());

        Builder singletonBuilder = BuilderFactory.create(
                new BuilderConfig("https", "google.com", BuilderType.SINGLETON));
        addSearchRoute(singletonBuilder);
        System.out.println("SingletonBuilder: " + singletonBuilder.getCompleteURL());

        Builder reusedSingletonBuilder = BuilderFactory.create(
                BuilderType.SINGLETON, "http", "example.com");
        reusedSingletonBuilder.buildPathParams(new PathParam("users", "42"));
        System.out.println("SingletonBuilder reused: " + reusedSingletonBuilder.getCompleteURL());

        System.out.println("Same singleton instance: " + (singletonBuilder == reusedSingletonBuilder));
    }

    private static void addSearchRoute(Builder builder) {
        builder.buildPathParams(new PathParam("user", "user1"));
        builder.buildPathParams(new PathParam("order", "orderid"));
        builder.buildQueryParam(new QueryParam("search", "123"));
    }
}

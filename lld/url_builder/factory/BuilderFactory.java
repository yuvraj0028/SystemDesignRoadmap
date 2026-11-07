package SystemDesignRoadmap.lld.url_builder.factory;

import java.util.Objects;

import SystemDesignRoadmap.lld.url_builder.builder.Builder;
import SystemDesignRoadmap.lld.url_builder.builder.BuilderConfig;
import SystemDesignRoadmap.lld.url_builder.builder.BuilderType;
import SystemDesignRoadmap.lld.url_builder.builder.NewBuilder;
import SystemDesignRoadmap.lld.url_builder.builder.SingletonBuilder;

public final class BuilderFactory {
    private BuilderFactory() {
    }

    public static Builder create(BuilderConfig config) {
        Objects.requireNonNull(config, "config must not be null");

        return switch (config.builderType()) {
            case NEW -> new NewBuilder(config.protocol(), config.domain());
            case SINGLETON -> createSingletonBuilder(config);
        };
    }

    public static Builder create(BuilderType builderType, String protocol, String domain) {
        return create(new BuilderConfig(protocol, domain, builderType));
    }

    private static Builder createSingletonBuilder(BuilderConfig config) {
        SingletonBuilder builder = SingletonBuilder.getInstance();
        builder.init(config.protocol(), config.domain());
        return builder;
    }
}

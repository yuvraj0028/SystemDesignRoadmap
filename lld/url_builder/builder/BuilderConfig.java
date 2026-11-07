package SystemDesignRoadmap.lld.url_builder.builder;

import java.util.Objects;

public record BuilderConfig(String protocol, String domain, BuilderType builderType) {
    public BuilderConfig {
        Objects.requireNonNull(protocol, "protocol must not be null");
        Objects.requireNonNull(domain, "domain must not be null");
        Objects.requireNonNull(builderType, "builderType must not be null");
    }
}

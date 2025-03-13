package br.com.vrsoftware.config;

import java.net.*;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class HttpClientConfig {
    private static final int TIMEOUT_SECONDS = 10;

    public static HttpClient createHttpClient() {
        Optional<Proxy> proxy = detectSystemProxy();
        HttpClient.Builder builder = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(TIMEOUT_SECONDS));

        proxy.ifPresent(p -> builder.proxy(ProxySelector.of(p.address())));

        // Set proxy authenticator if proxy credentials are present
        Optional<Authenticator> proxyAuthenticator = createProxyAuthenticator();
        proxyAuthenticator.ifPresent(builder::authenticator);

        return builder.build();
    }

    private static Optional<Proxy> detectSystemProxy() {
        List<Proxy> proxies = ProxySelector.getDefault().select(URI.create("http://example.com"));
        return proxies.stream()
                .filter(proxy -> proxy.type() == Proxy.Type.HTTP)
                .findFirst();
    }

    private static Optional<Authenticator> createProxyAuthenticator() {
        Properties proxyProperties = System.getProperties();
        String proxyUser = proxyProperties.getProperty("http.proxyUser");
        String proxyPassword = proxyProperties.getProperty("http.proxyPassword");

        if (proxyUser != null && proxyPassword != null) {
            return Optional.of(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
                }
            });
        }

        return Optional.empty();
    }
}

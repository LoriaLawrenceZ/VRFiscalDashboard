package br.com.vrsoftware.frameworks;

import br.com.vrsoftware.entities.AuthCredentials;
import br.com.vrsoftware.usecases.DashboardApiClient;
import br.com.vrsoftware.usecases.SecureCredentialsLoader;

public class Main {

    public static void main(String[] args) {
        AuthCredentials credentials = SecureCredentialsLoader
                .loadSecureCredentials(args[0]);

        DashboardApiClient client = new DashboardApiClient(credentials);

        System.out.println(client.getIssue());
    }
}

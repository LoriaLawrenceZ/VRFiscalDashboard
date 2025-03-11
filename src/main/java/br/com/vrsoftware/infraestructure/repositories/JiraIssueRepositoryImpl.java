package br.com.vrsoftware.infraestructure.repositories;

import br.com.vrsoftware.application.usecases.interfaces.IJiraIssueRepository;
import br.com.vrsoftware.domain.entities.jira.JiraIssue;
import java.util.List;
import java.util.Arrays;

public class JiraIssueRepositoryImpl implements IJiraIssueRepository {
    @Override
    public JiraIssue getById(String id) {
        // Simulando requisição ao Jira (normalmente aqui usaria um cliente HTTP)
        return new JiraIssue(id, "Bug no sistema", "Corrigir erro 500", "TO DO");
    }
}

package br.com.vrsoftware.application.usecases;

import br.com.vrsoftware.application.usecases.interfaces.IJiraIssueRepository;
import br.com.vrsoftware.domain.entities.jira.JiraIssue;

public class GetJiraIssueUseCase {
    private final IJiraIssueRepository repository;

    public GetJiraIssueUseCase(IJiraIssueRepository repository) {
        this.repository = repository;
    }

    public JiraIssue execute(String id) {
        return repository.getById(id);
    }
}

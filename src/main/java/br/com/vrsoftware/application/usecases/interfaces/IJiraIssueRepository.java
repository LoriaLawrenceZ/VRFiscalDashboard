package br.com.vrsoftware.application.usecases.interfaces;

import br.com.vrsoftware.domain.entities.jira.JiraIssue;
import java.util.List;

public interface IJiraIssueRepository {
    JiraIssue getById(String id);
}

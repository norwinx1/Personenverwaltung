package ch.bbw.repository;

import ch.bbw.model.Article;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DataRepositoryMock {
    private final ArrayList<Article> articles;

    public DataRepositoryMock() {
        articles = new ArrayList<>();
        articles.add(
                new Article(1, "The Not-So-Simple Ethics Involved in Software Engineering",
                        "If you ask me, the absolute best series on Netflix is Black Mirror. As a software engineer, I am inherently interested in technology and seeing al…",
                        Date.from(Instant.now()),
                        "Tylor Borgeson"));
        articles.add(
                new Article(2, "Things you should know about Coding Interviews",
                        "I have participated in more than 100 coding interviews both as an interviewee and interviewer. For some inter-views, I had the worst experience, and for some it was fabulous. Today in this article I will talk…",
                        Date.from(Instant.now()),
                        "AhmadFaiyaz"));
        articles.add(
                new Article(3, "How to build an ecosystem",
                        "What’s the one experience that changed your life? Learning? Jobs? Traveling? Relationships? The StartupBus was the one thing that changed my professional life. I got to create a family in which I wasn’t born….",
                        Date.from(Instant.now()),
                        "PrateekGupta"));
    }

    public List<Article> getAllArticles() {
        return articles;
    }

    public Article getArticleById(int id) {
        return articles.stream()
                .filter(a -> a.getId() == id)
                .findFirst().orElse(new Article());
    }
}

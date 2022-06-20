package ch.bbw;

import ch.bbw.repository.ArticleRepository;
import ch.bbw.repository.DataRepositoryMock;
import ch.bbw.services.Counter;
import ch.bbw.services.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private final ArticleRepository articleRepository;
    private final Counter counter;
    private final User user;
    private final UserList userList;

    @Autowired
    public MainController(ArticleRepository articleRepository, Counter counter, User user, UserList userList) {
        this.articleRepository = articleRepository;
        this.counter = counter;
        this.user = user;
        this.userList = userList;
    }

    @GetMapping("/")
    public String index(Model model) {
        userList.addUser(user.getUuid());
        counter.incrementPageCount();
        model.addAttribute("pageCount", counter.getPageCount());
        model.addAttribute("users", userList.getUsers());
        return "index";
    }

    @GetMapping("/articles")
    public String articles(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "articles";
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable int id, Model model) {
        model.addAttribute("article", articleRepository.findById((long) id).get());
        return "article";
    }
}

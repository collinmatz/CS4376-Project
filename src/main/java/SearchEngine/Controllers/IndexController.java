package SearchEngine.Controllers;

import SearchEngine.Models.IndexFormData;
import SearchEngine.Services.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    @Autowired
    private ScraperService scraperService;

    @GetMapping("/index")
    public String index() {
        return "index.html";
    }

    @PostMapping("/submit")
    @ResponseBody
    public ResponseEntity<String> submit(@RequestBody IndexFormData formData) {
        String url = formData.getInputValue();
        Integer maxDepth = formData.getMaxDepth();
        scraperService.scrape(url, maxDepth);

        String responseMessage = "Value received: " + url;
        return new ResponseEntity<String>(responseMessage, HttpStatus.OK);
    }
}
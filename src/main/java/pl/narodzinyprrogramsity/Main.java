package pl.narodzinyprrogramsity;

import pl.narodzinyprrogramsity.api.DBExecutor;
import pl.narodzinyprrogramsity.api.Executor;
import pl.narodzinyprrogramsity.config.Config;
import pl.narodzinyprrogramsity.model.Author;
import pl.narodzinyprrogramsity.parser.AuthorParser;
import pl.narodzinyprrogramsity.parser.DataParser;
import pl.narodzinyprrogramsity.service.JDBCService;
import pl.narodzinyprrogramsity.service.MySQLService;
import pl.narodzinyprrogramsity.table.AuthorManager;
import pl.narodzinyprrogramsity.table.DataManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Class.forName("com.mysql.jdbc.Driver").newInstance();  //to uzywamy gdy nie działą baza danych 2
        Config config = new Config("jdbc:mysql://localhost/library","library","root","Lato1234");
        JDBCService service = new MySQLService(config);
        Executor executor = new DBExecutor(service);
        DataParser<Author> authorDataParser = new AuthorParser();

        DataManager<Author> authorDataManager = new AuthorManager(executor, config, authorDataParser);
        authorDataManager.createRepository();

//        authorDataManager.add(new Author("3","Nowy","Author",1970));
        Author author = new Author("1", "Paweł", "KukizV2", 1990);
        authorDataManager.update(author);

        List<Author> list = authorDataManager.getList();
        list.forEach(System.out::println);


    }
}

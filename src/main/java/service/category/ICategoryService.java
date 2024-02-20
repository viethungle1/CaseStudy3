package service.category;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<Category> showList();
    void addCategory(Category category);
    void deleteCategory(int id) throws SQLException;
    List<Category> findAllByBookId(int id_book);
}

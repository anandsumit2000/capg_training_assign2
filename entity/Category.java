package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String categoryName;


    @OneToMany(mappedBy = "cat", cascade = CascadeType.PERSIST)
    private List<Catalog> listt = new ArrayList<Catalog>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Catalog> getListt() {
        return listt;
    }

    public void setListt(List<Catalog> catList) {
        this.listt = catList;
    }
}

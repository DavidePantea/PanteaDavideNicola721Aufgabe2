import java.util.ArrayList;
import java.util.List;

public class Patienten {
    private Integer id;
    private String name;
    private Integer alter;

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    private String diagnose;
    private List<Medikamente> listeMedikamente;

    public Patienten(Integer id, String name, Integer alter, String diagnose) {
        this.id = id;
        this.name = name;
        this.alter = alter;
        this.listeMedikamente = new ArrayList<>();
        this.diagnose = diagnose;
    }

    public Patienten(Integer id, String name, Integer alter, List<Medikamente> listeMedikamente, String diagnose) {
        this.id = id;
        this.name = name;
        this.alter = alter;
        this.listeMedikamente = listeMedikamente;
        this.diagnose = diagnose;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAlter() {
        return alter;
    }

    public void setAlter(Integer alter) {
        this.alter = alter;
    }

    public List<Medikamente> getListeMedikamente() {
        return listeMedikamente;
    }

    public void setListeMedikamente(List<Medikamente> listeMedikamente) {
        this.listeMedikamente = listeMedikamente;
    }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Service {
    private Repository<Medikamente> medikamenteRepository;
    private Repository<Patienten> patientenRepository;

    public Service(Repository<Medikamente> medikamenteRepository, Repository<Patienten> patientenRepository) {
        this.medikamenteRepository = medikamenteRepository;
        this.patientenRepository = patientenRepository;
    }


    public List<Medikamente> alleMedikamentenZuruckgeben() {
        return this.medikamenteRepository.getAllElements();
    }

    public List<Patienten> allePatientenZuruckgeben() {
        return this.patientenRepository.getAllElements();
    }

    public void createAMedikament(String name, Integer price, String krankenheit) {
        this.medikamenteRepository.addElement(new Medikamente(name, price, krankenheit));
    }

    public Medikamente getMedikament(String name) {
        int id = -1;
        Iterator var3 = this.medikamenteRepository.getAllElements().iterator();

        while(var3.hasNext()) {
            Medikamente m = (Medikamente) var3.next();
            if (m.getName().equals(name)) {
                id = this.medikamenteRepository.getAllElements().indexOf(m);
                break;
            }
        }

        return (Medikamente) this.medikamenteRepository.getElement(id);
    }

    public void updateMedikament(Medikamente medikament) {
        Iterator var2 = this.medikamenteRepository.getAllElements().iterator();

        while(var2.hasNext()) {
            Medikamente m = (Medikamente) var2.next();
            if (m.getName().equals(medikament.getName())) {
                int index = this.medikamenteRepository.getAllElements().indexOf(m);
                m.setPrice(medikament.getPrice());
                m.setKrankenheit(medikament.getKrankenheit());
                this.medikamenteRepository.updateElement(index, medikament);
                break;
            }
        }

    }

    public void deleteMedikament(String name) {
        Iterator var2 = this.medikamenteRepository.getAllElements().iterator();

        while(var2.hasNext()) {
            Medikamente m = (Medikamente) var2.next();
            if (m.getName().equals(name)) {
                this.medikamenteRepository.remove(m);
                break;
            }
        }

    }

    public void createAPatient(String name, Integer alter,  String diagnose) {
        int id = -1;
        Iterator var4 = this.patientenRepository.getAllElements().iterator();

        while(var4.hasNext()) {
            Patienten p = (Patienten) var4.next();
            if (id < p.getId()) {
                id = p.getId();
            }
        }

        ++id;
        this.patientenRepository.addElement(new Patienten(id, name, alter, new ArrayList(), diagnose));
    }

    public Patienten getPatienten(int id) {
        Iterator var2 = this.patientenRepository.getAllElements().iterator();

        Patienten p;
        do {
            if (!var2.hasNext()) {
                throw new RuntimeException("Kunde nicht gefunden");
            }

            p = (Patienten) var2.next();
        } while(p.getId() != id);

        return p;
    }

    public void updatePatienten(Patienten patienten) {
        Iterator var2 = this.patientenRepository.getAllElements().iterator();

        while(var2.hasNext()) {
            Patienten p = (Patienten) var2.next();
            if (p.getId() == patienten.getId()) {
                int index = this.patientenRepository.getAllElements().indexOf(p);
                p.setName(patienten.getName());
                p.setAlter(patienten.getAlter());
                p.setDiagnose(patienten.getDiagnose());
                this.patientenRepository.updateElement(index, p);
                break;
            }
        }

    }

    public void deletePatient(int id) {
        Iterator var2 = this.patientenRepository.getAllElements().iterator();

        while(var2.hasNext()) {
            Patienten p = (Patienten) var2.next();
            if (p.getId() == id) {
                this.patientenRepository.remove(p);
                break;
            }
        }

    }

    public List<Patienten> filterNachDiagnose(String Diagnose) {
        new ArrayList();
        List<Patienten> patientenList = this.patientenRepository.getAllElements().stream().filter((patienten) -> {
            return Diagnose.equals(patienten.getDiagnose());
        }).toList();
        return patientenList;
    }


}
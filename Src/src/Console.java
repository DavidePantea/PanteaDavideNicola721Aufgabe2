

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }
    public Console() {}

    public void setController(Controller controller) {this.controller = controller;}

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0)
        {
            System.out.println("""
                    1. Alles anschreiben
                    2. Medikamente CRUD
                    3. Patienten CRUD
                    0. Exit""");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {controller.alleMedikamenteAnschreiben();
                    controller.allePatientenAnschreiben();
                    break;}

                case 2: {
                    System.out.println("""
                            1. Neues Medikament hinzufugen
                            2. Alle Medikament sehen
                            3. Ein bestimmtes Medikament finden
                            4. Ein Medikament aktualisieren
                            5. Ein Medikament loschen
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createMedikament(); break;}
                        case 2: {controller.alleMedikamenteAnschreiben(); break;}
                        case 3: {controller.showAMedikament(); break;}
                        case 4: {controller.updateMedikamentValidate(); break;}
                        case 5: {controller.deleteMedikament(); break;}
                        case 0:break;
                    }
                }

                case 3:
                {
                    System.out.println("""
                            1. Neuer Patient hinzufugen
                            2. Alle Patient sehen
                            3. Einen bestimmten Patient finden
                            4. Einen Patient aktualisieren
                            5. Einen Patient loschen
                            6. Patient nach Ort filtrieren
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createPatient(); break;}
                        case 2: {controller.allePatientenAnschreiben(); break;}
                        case 3: {controller.showPatient(); break;}
                        case 4: {controller.updatePatientValidate(); break;}
                        case 5: {controller.deletePatienten(); break;}
                        case 0:break;
                    }
                }

                case 0: break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Medikamente> medikamenteRepository = new Repository<>();
        Repository<Patienten> patientenRepository = new Repository<>();

        Console console = new Console();
        console.initialiseData(medikamenteRepository,patientenRepository);

        Service service = new Service(medikamenteRepository,patientenRepository);
        Controller controller = new Controller(service);

        console = new Console(controller);
        console.run();
    }

    public void initialiseData(Repository<Medikamente> medikamenteRepository, Repository<Patienten> patientenRepository) {
        Medikamente medikamente1 = new Medikamente("abc", 10, "hdghd");
        Medikamente medikamente2 = new Medikamente("ggg", 101, "hdghd");
        Medikamente medikamente3 = new Medikamente("ddd", 78, "agb");



       medikamenteRepository.addElement(medikamente1);
       medikamenteRepository.addElement(medikamente2);
       medikamenteRepository.addElement(medikamente3);

        List<Medikamente> listePatiente1 = new ArrayList<>();
        listePatiente1.add(medikamente1);
        listePatiente1.add(medikamente2);
        Patienten kunde1 = new Patienten(1,"Kevin",24, listePatiente1, "sick");





        patientenRepository.addElement(kunde1);
    }
}

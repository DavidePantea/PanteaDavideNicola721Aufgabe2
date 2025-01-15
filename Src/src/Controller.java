
import java.util.ArrayList;
import java.util.Scanner;


public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void alleMedikamenteAnschreiben(){
        for (Medikamente medikamente: service.alleMedikamentenZuruckgeben())
            System.out.println(medikamente);
    }
    public void allePatientenAnschreiben(){
        for (Patienten patienten: service.allePatientenZuruckgeben())
            System.out.println(patienten);
    }

    public void createMedikament(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Krankenheit");
        String krankenheit = sc.nextLine();

        service.createAMedikament(name, preis, krankenheit);
    }

    public void showAMedikament(){
        System.out.println("Gebe den Namen des Produktes ein: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Medikamente medikamente = service.getMedikament(name);
        System.out.println(medikamente);
    }

    public void updateMedikamentValidate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geandert werden soll: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Krankenheit:");
        String krankenheit = sc.nextLine();

        service.updateMedikament(new Medikamente(name, preis, krankenheit));
    }

    public void deleteMedikament(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Medikament, das geloescht werden soll: ");
        String name = sc.nextLine();
        service.deleteMedikament(name);
    }


    public void createPatient(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Alter: ");
        int alter = sc.nextInt();
        System.out.println("Diagnose: ");
        String diagnose = sc.nextLine();


        service.createAPatient(name, alter, diagnose);
    }

    public void showPatient(){
        for (Patienten patienten: service.allePatientenZuruckgeben())
            System.out.println(patienten);

        System.out.println("ID des Patienten:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(service.getPatienten(id));
    }

    public void updatePatientValidate(){
        Scanner sc = new Scanner(System.in);

        System.out.println("ID des Patienten, das geandert werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Neuer Name: ");
        String name = sc.nextLine();
        System.out.println("Alter: ");
        int alter = sc.nextInt();
        System.out.println("Neuer Diagnose: ");
        String diagnose = sc.nextLine();

        Patienten patienten = new Patienten(id,name,alter, new ArrayList<>() ,diagnose);
        service.updatePatienten(patienten);
    }

    public void deletePatienten(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID des Patienten, der geloescht werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();
        service.deletePatient(id);
    }

}

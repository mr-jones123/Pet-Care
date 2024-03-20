package Interface_Super;
import java.util.Map;
import java.util.HashMap;
public class superClass {
    private Map<Integer, Integer> tests = new HashMap<>();
    private Map<Integer, Integer>  medicalServices  = new HashMap<>();
    private Map<String , Integer> listOfTests = new HashMap<>();
    private Map<String, Integer> listOfServices = new HashMap<>();
    public superClass(){
        initializeDefaultTests();
        initializeDefaultMedicalServices();
        initalizedServicesLists();
        initalizedTestLists();
    }

    public void initalizedTestLists(){
        listOfTests.put("Routine Checkup", 1);
        listOfTests.put("Physical Exams", 2);
        listOfTests.put("Dental Checkups", 3);
        listOfTests.put("Allergy Testing:", 4);
        listOfTests.put("Geriatric Screening", 5);
    }
    public void initalizedServicesLists(){
        listOfServices.put("Emergency Surgery", 1);
        listOfServices.put("Intensive Care Unit (ICU)", 2);
        listOfServices.put("Diagnostic Imaging", 3);
        listOfServices.put("Blood Transfusion", 4);
        listOfServices.put("Oxygen Therapy", 5);
    }
    public void initializeDefaultTests(){
        tests.put(1, 50);
        tests.put(2, 60);
        tests.put(3, 70);
        tests.put(4, 80);   
        tests.put(5, 90);
    }
    public void initializeDefaultMedicalServices(){
        medicalServices.put(1, 5000);
        medicalServices.put(2 , 3000);
        medicalServices.put(3, 1500);
        medicalServices.put(4, 2000);
        medicalServices.put(5, 1000);
    }
    public Map <Integer, Integer> getTests(){
        return tests;
    }
    public Map <Integer, Integer> getMedicalServices(){
        return medicalServices;
    }
    public Map<String, Integer> getListofTests(){
        return listOfTests;
    }
    public Map<String, Integer> getListofServices(){
        return listOfServices;
    }
}
package Interface_Super;
import java.util.HashMap;
public class superClass {
    private HashMap<String, Integer> tests = new HashMap<>();
    private HashMap<String, Integer>  medicalServices  = new HashMap<>();

    public superClass(){
        initializeDefaultTests();
        initializeDefaultMedicalServices();
    }

    public void initializeDefaultTests(){
        tests.put("Routine Checkup", 50);
        tests.put("Physical Exams", 45);
        tests.put("Dental Checkups", 70);
        tests.put("Allergy Testing", 300);   
        tests.put("Geriatic Screening", 110);
    }
    public void initializeDefaultMedicalServices(){
        medicalServices.put("Bloodwork", 200);
        medicalServices.put("X-Rays", 150);
        medicalServices.put("Ultrasounds", 600);
        medicalServices.put("Oxygen Therapy", 3000);
        medicalServices.put("Emergency Surgery", 5000);
    }
    public HashMap <String, Integer> getTests(){
        return tests;
    }
    public HashMap <String, Integer> getMedicalServices(){
        return medicalServices;
    }
}
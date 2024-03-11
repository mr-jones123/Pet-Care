package Interface_Super;
import java.util.Map;
import java.util.HashMap;
public class superClass {
    private Map<Integer, Integer> tests = new HashMap<>();
    private Map<Integer, Integer>  medicalServices  = new HashMap<>();

    public superClass(){
        initializeDefaultTests();
        initializeDefaultMedicalServices();
    }

    public void initializeDefaultTests(){
        tests.put(1, 50);
        tests.put(2, 45);
        tests.put(3, 70);
        tests.put(4, 300);   
        tests.put(5, 110);
    }
    public void initializeDefaultMedicalServices(){
        medicalServices.put(1, 200);
        medicalServices.put(2 , 150);
        medicalServices.put(3, 600);
        medicalServices.put(4, 3000);
        medicalServices.put(5, 5000);
    }
    public Map <Integer, Integer> getTests(){
        return tests;
    }
    public Map <Integer, Integer> getMedicalServices(){
        return medicalServices;
    }
}
package masawamor.jackson;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import masawamor.data.Company;
import masawamor.data.Talent;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        
        ObjectMapper mapper = new ObjectMapper();
        
        // **********************************************************
        
        Company company1 = new Company();
        company1.setId(1);
        company1.setCompanyName("HONDA");
        
        Company company2 = new Company();
        company2.setId(2);
        company2.setCompanyName("フォスタープラス");
        
        Talent talent1 = new Talent();
        talent1.setId(1);
        talent1.setLastName("本田");
        talent1.setFirstName("翼");
        talent1.setCompany(company1);
        
        Talent talent2 = new Talent();
        talent2.setId(2);
        talent2.setLastName("広瀬");
        talent2.setFirstName("すず");
        talent2.setCompany(company2);
        
        List<Talent> outputTalents = new ArrayList<>();
        outputTalents.add(talent1);
        outputTalents.add(talent2);
        
        String outputJson = mapper.writeValueAsString(outputTalents);

        System.out.println("jsonString: " + outputJson);
        
        // **********************************************************
        
        String inputJson = "[{\"id\":1,\"lastName\":\"本田\",\"firstName\":\"翼\",\"company\":{\"id\":1,\"companyName\":\"HONDA\"}}]";
        
        List<Talent> inputTalents = mapper.readValue(inputJson, new TypeReference<List<Talent>>() {});
        
        System.out.println(inputTalents.get(0).getId());
        System.out.println(inputTalents.get(0).getLastName());
        System.out.println(inputTalents.get(0).getFirstName());
        System.out.println(inputTalents.get(0).getCompany().getId());
        System.out.println(inputTalents.get(0).getCompany().getCompanyName());
    }
}

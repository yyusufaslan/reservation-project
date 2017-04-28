import com.toyotaproject.dao.customerRepository;
import com.toyotaproject.dao.lmpl.customerRepositoryImpl;
import com.toyotaproject.domain.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by yusufaslan on 4.04.2017.
 */
public class Test {

    public static void main(String args []) throws SQLException{

        ApplicationContext ctx =new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");

        customerRepository cust = ctx.getBean(customerRepositoryImpl.class);

        Customer customer =new Customer("fakyu","Ali", "veki","12345");
        cust.save(customer);

        Customer found =cust.getCustomerByUserName("Ali");
        System.out.println(" getirilen " +found);

        ((ClassPathXmlApplicationContext) ctx).close();
    }
}

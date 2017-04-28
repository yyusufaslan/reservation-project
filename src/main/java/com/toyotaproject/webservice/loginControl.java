package com.toyotaproject.webservice;

import com.toyotaproject.domain.Customer;
import com.toyotaproject.security.authenticationProvider;
import com.toyotaproject.service.lmpl.customerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by burakgungor on 13.04.2017.
 */
@Component
@Path("/login")
public class loginControl {
    @Autowired
    private customerServiceImpl customerService;

    @GET
    @Produces("application/json")
    public Customer loginControl() {
        Customer login = new Customer();
        //Custom providerdan o anki oturumdan kullanıcı adı çekiliyor ve dto'nun ilgili alanına set ediliyor.
        login.setUserName(authenticationProvider.getUsername());
        //Eğer oturum açılmamışsa null dönebileceğinden bu durum kontrol ediliyor.
        if (login.getUserName() != null) {//eğer oturum açılmışsa
            Customer user = customerService.getCustomerByUserName(login.getUserName());//Username'e göre kullanıcı nesnesi dönüyor.
            //login nesnesinin ilgili alanlarına kullanıcı bilgileri set ediliyor.
            login.setName(user.getName());
            login.setLastName(user.getLastName());
            login.setEmail(user.getEmail());
            login.setRole(user.getRole());
        }
        if (login.getUserName() != null)//Kullanıcı giriş yaptıysa.
            login.setStatus(true);
        else
            login.setStatus(false);//Kullanıcı giriş yapmadıysa login durumunu false yapıyoruz.
        return login;
    }
}

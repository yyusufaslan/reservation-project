package com.toyotaproject.security;

import com.toyotaproject.domain.Customer;
import com.toyotaproject.service.lmpl.customerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusufaslan on 5.04.2017.
 */
@Component
public class authenticationProvider implements AuthenticationProvider {

    @Autowired
    private customerServiceImpl customerService;

    public static String getUsername() {

        //O anki oturum bilgileri alınıyor.
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName;

        //Eğer oturum varsa kullanıcı adı username degiskenine atanıyor.
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            //Eğer oturum yoksa kullanıcı adı "anonymousUser" döner.
            userName = principal.toString();
        }
        //Eğer kullanıcı adı varsayılan değerse null atanır.
        if (userName == "anonymousUser")
            userName = null;
        return userName;
    }


    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
//
//        //Girilen kullanıcı adına göre veritabanından kayıt arama işlemi yapılır.
            Customer customer = customerService.getCustomerByUserName(name);
//
        if (customer != null) {//Eğer eşleşme olduysa
                if (customer.getPassword().equals(password)) {//Eğer girilen şifre eşleşiyorsa
                    //Yeni bir yetki listesi oluşturulur.
                    List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
//                //Yetki listesine varsayılan Admin rolü eklenir.
                    grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//                //Bu kullanıcıya ait oturum için yeni bir token oluşturulur.
//                //İçerisine kullanıcı bilgileri ve yetkileri atanır.
                    Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
                return auth;
            } else
                return null;
        } else
            return null;
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}

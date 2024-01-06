package kg.vtsd.schooldiarybackend.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{

    ADMIN, MANAGER, TEACHER, PARENT, STUDENT;
    
    @Override
    public String getAuthority() {
        return name();
    }
    
}
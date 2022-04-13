
package com.fasttrack.cafe.tmcafes.model;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 7828419298616811182L;

    private Users user;

    public CurrentUser(Users user) {
        super(user.getUsername(), user.getPassword(), user.getAuthorities());
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public String getFullName() {
        return user.getFirstName() + ' ' + user.getLastName();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public Long getId() {
        return user.getUserId();
    }
}
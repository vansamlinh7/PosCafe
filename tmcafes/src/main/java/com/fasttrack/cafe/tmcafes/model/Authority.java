package com.fasttrack.cafe.tmcafes.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Authorities")
public class Authority implements GrantedAuthority, Serializable {

    @Id
    @Column(name = "authority_id")
    private Long authorityId;

    @Column(name = "authority")
    private String authority;

    @Column(name = "is_locked")
    private boolean isLocked;

    public Authority(){}

    public Authority(String authority) {
        this.authority = authority;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


    public boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }
}

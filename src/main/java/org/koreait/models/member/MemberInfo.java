package org.koreait.models.member;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import org.koreait.entities.Member;

@Data
@Builder
public class MemberInfo implements UserDetails {

    private String email;
    private String password;

    private Member member;

    private Collection<? extends GrantedAuthority> authorities;
    // 권한 기능
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    // Account 관리
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호 관리
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정활성화 관리
    @Override
    public boolean isEnabled() {
        return true;
    }
}

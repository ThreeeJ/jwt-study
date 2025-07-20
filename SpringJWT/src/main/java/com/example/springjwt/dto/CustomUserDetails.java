package com.example.springjwt.dto;

import com.example.springjwt.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final UserEntity userEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {

                return userEntity.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getUsername() { // 사용자 조회

        return userEntity.getUsername();
    }

    @Override
    public String getPassword() { // 비밀번호 비교

        return userEntity.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() { // 계정 만료 여부 확인

        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정 잠김 여부 확인

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 비밀번호 만료 여부 확인

        return true;
    }

    @Override
    public boolean isEnabled() { // 계정 활성화 여부 확인

        return true;
    }
}

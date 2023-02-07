package com.history.nappy.config.auth;

import com.history.nappy.domain.member.Member;
import com.history.nappy.domain.member.MemberImg;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
public class PrincipalDetail implements UserDetails, OAuth2User {

    private Member member;
    private MemberImg memberImg;
    private Map<String, Object> attributes;

    // 일반사용자
    public PrincipalDetail(Member member) {
        this.member = member;
    }

    // oauth 사용자
    public PrincipalDetail(Member member, Map<String, Object> attributes) {
        this.member = member;
        this.attributes = attributes;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(() -> member.getRoleKey());

        return collection;
    }

    // password
    @Override
    public String getPassword() {
        return member.getPassword();
    }

    // id
    @Override
    public String getUsername() {
        return member.getUsername();
    }

    // email
    public String getEmail() {
        return member.getEmail();
    }

    //사용자 닉네임
    public String getNickname() {
        return member.getNickname();
    }

    //사용자 pk
    public Long getId() {
        return member.getId();
    }

    // 사용자 이름
    public String getName() {
        return member.getName();
    }

    // 사용자 zipcode
    public int getZipcode() {
        return member.getZipcode();
    }

    // 사용자 address & detail
    public String getAddress() {
        return member.getAddress();
    }

    public String getDetailAddress() {
        return member.getDetailAddress();
    }

    // 학력
    public LocalDateTime getEducatedStart(){
        return member.getEducatedStart();
    }

    public LocalDateTime getEducatedEnd(){
        return member.getEducatedEnd();
    }

    public String getSchoolName(){
        return member.getSchoolName();
    }

    public String getMajor(){
        return member.getSchoolName();
    }

    public String getGraduationStatus(){
        return member.getGraduationStatus();
    }

    public String getImgUrl(){
        return memberImg.getImgUrl();
    }

    //계정이 만료되었는지 (true: 만료되지 않음)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정이 잠겨있는지 (true: 잠겨있지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //패스워드가 만료되지 않았는지 (true: 만료되지 않음)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정이 활성화되어 있는지 (true: 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }
}

package andrei.teplyh.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class JwtUser implements UserDetails {
    private final int userId;
    private final int mainWorkerId;
    private final String password;
    private final String email;
    private final String login;
    private final String avatarFilePath;
    private final Date lastLogOut;
    private final boolean enabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(
            int userId,
            int mainWorkerId,
            String password,
            String email,
            String login,
            String avatarFilePath,
            Date lastLogOut,
            boolean enabled,
            Collection<? extends GrantedAuthority> authorities
    ) {
        this.userId = userId;
        this.mainWorkerId = mainWorkerId;
        this.password = password;
        this.email = email;
        this.login = login;
        this.avatarFilePath = avatarFilePath;
        this.lastLogOut = lastLogOut;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public int getUserId() {
        return userId;
    }

    public int getMainWorkerId() {
        return mainWorkerId;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatarFilePath() {
        return avatarFilePath;
    }

    public Date getLastLogOut() {
        return lastLogOut;
    }
}

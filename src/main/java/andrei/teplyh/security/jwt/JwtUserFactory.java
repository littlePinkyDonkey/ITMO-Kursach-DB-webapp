package andrei.teplyh.security.jwt;

import andrei.teplyh.entity.Role;
import andrei.teplyh.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public static JwtUser createJwtUser(User user) {
        return new JwtUser(
                user.getUserId(),
                user.getWorker().getMainWorkerId(),
                user.getPassword(),
                user.getEmail(),
                user.getLogin(),
                user.getAvatarFilePath(),
                user.getLastLogOut(),
                true,
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getRole())
                )
                .collect(Collectors.toList());
    }
}

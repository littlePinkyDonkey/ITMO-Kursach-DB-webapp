package andrei.teplyh.config;

import andrei.teplyh.entity.User;
import andrei.teplyh.entity.enums.UserRoles;
import andrei.teplyh.security.jwt.config.JwtConfigurer;
import andrei.teplyh.security.jwt.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                
                .and()
                .authorizeRequests()
                .antMatchers("/api/roles").permitAll()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/registration").permitAll()
                .antMatchers("/api/processes/ability_description_process/**").hasRole(UserRoles.ROLES_DESIGNER.toString())
                .antMatchers("/api/processes/character_description_process/**").hasRole(UserRoles.ROLES_DESIGNER.toString())
                .antMatchers("/api/processes/adding_effect_process/**").hasRole(UserRoles.ARTIST.toString())
                .antMatchers("/api/processes/animation_process/**").hasRole(UserRoles.ARTIST.toString())
                .antMatchers("/api/processes/battle_drawing_process/**").hasRole(UserRoles.ARTIST.toString())
                .antMatchers("/api/processes/character_drawing_process/**").hasRole(UserRoles.ARTIST.toString())
                .antMatchers("/api/processes/coloring_process/**").hasRole(UserRoles.ARTIST.toString())
                .antMatchers("/api/processes/adding_sound_process/**").hasRole(UserRoles.AUDIO_SPECIALIST.toString())
                .antMatchers("/api/processes/advertising_process/**").hasRole(UserRoles.PRODUCER.toString())
                .antMatchers("/api/processes/battle_description_process/**").hasRole(UserRoles.SCREENWRITER.toString())
                .antMatchers("/api/processes/plot_process/**").hasAnyRole(UserRoles.SCREENWRITER.toString(), UserRoles.REGISSEUR.toString())
                .antMatchers("/api/processes/location_description_process/**").hasRole(UserRoles.REGISSEUR.toString())
                .antMatchers("/api/processes/character_select_process/**").hasRole(UserRoles.EDITOR.toString())
                .antMatchers("/api/processes/digitization_process/**").hasRole(UserRoles.DIGITIZER.toString())
                .antMatchers("/api/processes/revisions_process/**").hasRole(UserRoles.ART_DIRECTOR.toString())
                .antMatchers("/api/processes/smoothing_process/**").hasRole(UserRoles.SMOOTHING_SPECIALIST.toString())
                .antMatchers("/api/processes/storyboard_process/**").hasRole(UserRoles.STORYBOARD_ARTIST.toString())
                .antMatchers("/api/processes/voice_acting_process/**").hasRole(UserRoles.RECORDING_ACTOR.toString())
                .antMatchers("/*.png").permitAll()
                .antMatchers("/*.jpg").permitAll()
                .anyRequest().authenticated()

                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
        }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}

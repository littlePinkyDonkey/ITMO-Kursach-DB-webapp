package andrei.teplyh.service;

import andrei.teplyh.entity.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PasswordHashImpl implements PasswordHashService {
    private final byte[] PEPPER = "$%^&DSADdsaFBV<>?*!/".getBytes();
    private final int SALT_LENGTH = 12;
    private final String HASH_ALGORITHM = "SHA-1";

    public void createPassword(User user) {
        String salt = RandomStringUtils.random(SALT_LENGTH, true, true);
        String passwordHash = hash(user.getPassword(), salt);

        user.setSalt(salt);
        user.setHash(passwordHash);
    }

    public boolean checkAccess(User user) {
        return user.getHash().equals(hash(user.getPassword(), user.getSalt()));
    }

    private String hash(String password, String salt) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        messageDigest.update(PEPPER);
        messageDigest.update(password.getBytes());
        messageDigest.update(salt.getBytes());
        byte[] digest = messageDigest.digest();

        StringBuilder passwordHash = new StringBuilder();
        for (byte b : digest)
            passwordHash.append(String.format("%02x", b));

        return passwordHash.toString();
    }
}

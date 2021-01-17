package andrei.teplyh.repository.pivot;

import andrei.teplyh.entity.pivot.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    @Procedure("create_character")
    boolean createCharacter(int voiceActingId, int selectionId, int drawingId, int descriptionId, String name,
                            String gender, boolean protagonist, boolean positive, int age, Date birthDate);

    @Procedure("delete_character")
    boolean deleteCharacter(int characterId);
}

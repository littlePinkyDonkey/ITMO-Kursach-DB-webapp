package andrei.teplyh.repository.pivot;

import andrei.teplyh.entity.pivot.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    @Procedure("create_character")
    boolean createCharacter(int voiceActingId, int selectionId, int drawingId, int descriptionId, String name,
                            String gender, boolean protagonist, boolean positive, int age, Timestamp birthDate);

    @Procedure("delete_character")
    boolean deleteCharacter(int characterId);

    @Procedure("associate_character_and_ability")
    boolean associateCharacterAndAbility(int abilityId, int characterId);

    @Procedure("associate_battle_and_character")
    boolean associateBattleAndCharacter(int battleId, int characterId);

    @Procedure("associate_event_and_character")
    boolean associateEventAndCharacter(int eventId, int characterId);
}

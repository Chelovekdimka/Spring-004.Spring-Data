package comDimka.example.homework_04.repository;

import comDimka.example.homework_04.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(long id);
    User save(User user);


    // Метод оновлення інформації в БД
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.name = ?1, u.email = ?2 WHERE u.id = ?3")
    void updateUserInfo(String name, String email, Long id);

    // Метод видалення даних з використанням нативного SQL-запиту
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Users WHERE id = ?1", nativeQuery = true)
    void deleteUserById(Long id);

    List<User> findUserByName(String name);
}

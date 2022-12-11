package az.academy.atl.tutorials.app.repository;

import az.academy.atl.tutorials.app.entity.Tutorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findTutorialsByTitleContainingIgnoreCase(String title);

    List<Tutorial> findTutorialsByPublished(boolean published);

    Page<Tutorial> findAll(Pageable pageable);

    Page<Tutorial> findTutorialsByPublished(boolean published, Pageable pageable);
}

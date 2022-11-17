package az.academy.atl.tutorials.app.repository.impl;

import az.academy.atl.tutorials.app.model.Tutorial;
import az.academy.atl.tutorials.app.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TutorialRepositoryImpl implements TutorialRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int save(Tutorial tutorial) {
        String SQL = "INSERT INTO tutorials(title, description, published) VALUES(?, ?, ?)";
        return jdbcTemplate.update(SQL,
                tutorial.getTitle(), tutorial.getDescription(), tutorial.getPublished());
    }

    @Override
    public int update(Tutorial tutorial) {
        String SQL = "UPDATE tutorials SET title = ?, description = ?, published = ? WHERE id = ?";
        return jdbcTemplate.update(SQL,
                tutorial.getTitle(), tutorial.getDescription(), tutorial.getPublished(), tutorial.getId());
    }

    @Override
    public Tutorial findById(Long id) {
        try {

            String SQL = "SELECT * FROM tutorials where id = ?";
            Tutorial tutorial =
                    jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Tutorial.class), id);
            return tutorial;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        String SQL = "DELETE FROM tutorials WHERE id = ?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public List<Tutorial> findAll() {
        String SQL = "SELECT * FROM tutorials";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public List<Tutorial> findByPublished(boolean published) {
        String SQL = "SELECT * FROM tutorials WHERE published = ?";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Tutorial.class), published);
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        String SQL = "SELECT * FROM tutorials WHERE title LIKE '%" + title + "%'";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public int deleteALl() {
        String SQL = "DELETE FROM tutorials";
        return jdbcTemplate.update(SQL);
    }
}

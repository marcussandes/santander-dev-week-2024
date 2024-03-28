package me.dio.sdw24.adapters.out;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.domain.model.ports.ChampionsRepository;

@Repository
public class ChampionsJdbcRepository implements ChampionsRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Champions> rowMapper;
    

    public ChampionsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> mapRowToChampions(rs);
    }

    @Override
    public List<Champions> findAll() {
        return jdbcTemplate.query("SELECT * FROM champions", rowMapper);
    }

    @Override
    public Optional<Champions> findOne(Long id) {
        String sql = "SELECT * FROM champions WHERE id = ?";
        @SuppressWarnings("null")
        Champions champion = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return Optional.ofNullable(champion);
    }

    private Champions mapRowToChampions(ResultSet rs) throws SQLException {
        return new Champions(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("role"),
            rs.getString("lore"),
            rs.getString("image_url")
        );
    }
}


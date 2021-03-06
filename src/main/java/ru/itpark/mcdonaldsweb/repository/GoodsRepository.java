package ru.itpark.mcdonaldsweb.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.mcdonaldsweb.domain.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class GoodsRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public GoodsRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Goods> getAll() {
        return jdbcTemplate.query(
                "SELECT id, name, description, price, imageLink, imageLinkView FROM goods",
                (rs, i) -> new Goods(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("price"),
                        rs.getString("imageLink"),
                        rs.getString("imageLinkView")
                )
        );
    }

    public Goods getById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, name, description, price, imageLink, imageLinkView FROM goods WHERE id = :id",
                Map.of("id", id),
                (rs, i) -> new Goods(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("price"),
                        rs.getString("imageLink"),
                        rs.getString("imageLinkView")
                )
        );
    }
}

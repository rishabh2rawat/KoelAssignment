package com.example.KoelAssignment.Repository;

import com.example.KoelAssignment.Model.Entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Teams,Integer> {


    boolean existsByName(String name);

    Teams findAllByTeamid(int teamid);

    Teams findByTeamid(int teamid);

    Teams findOneByTeamid(int teamid);
}

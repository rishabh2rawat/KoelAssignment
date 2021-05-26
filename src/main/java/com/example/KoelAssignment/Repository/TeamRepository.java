package com.example.KoelAssignment.Repository;

import com.example.KoelAssignment.Model.Entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Teams,Integer> {

    Teams findAllByTeamid(int teamid);

}

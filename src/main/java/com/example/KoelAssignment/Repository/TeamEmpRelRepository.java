package com.example.KoelAssignment.Repository;

import com.example.KoelAssignment.Model.Entity.TeamEmpRel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamEmpRelRepository extends JpaRepository<TeamEmpRel,Integer> {


    List<TeamEmpRel> findAllByTeamid(int teamid);
}

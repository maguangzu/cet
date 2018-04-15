package com.wq.Team.persist;

import java.util.List;

import com.wq.Team.domain.Team;

public interface TeaminfoDao {

 public	 Team findteamByvolname(String volName);
 public  void addTeam(Team team);

}

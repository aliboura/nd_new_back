package dz.djezzydevs.networkdep.business.dao;

import dz.djezzydevs.networkdep.business.data.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate,Long> {


}

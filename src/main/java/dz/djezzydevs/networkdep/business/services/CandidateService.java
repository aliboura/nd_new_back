package dz.djezzydevs.networkdep.business.services;

import dz.djezzydevs.networkdep.business.dao.CandidateDao;
import dz.djezzydevs.networkdep.business.data.entities.Candidate;
import dz.djezzydevs.networkdep.business.data.entities.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    CandidateDao candidateRepo;

    public Candidate find (Long id) {
        return  candidateRepo.findById(id).get();
    }

    public List<Candidate> findAll () {
        return  candidateRepo.findAll();
    }

    public Candidate add (Candidate candidate) {
        return candidateRepo.save(candidate);
    }
}

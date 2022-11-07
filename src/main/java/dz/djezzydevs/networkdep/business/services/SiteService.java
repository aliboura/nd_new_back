package dz.djezzydevs.networkdep.business.services;

import dz.djezzydevs.networkdep.business.dao.CandidateDao;
import dz.djezzydevs.networkdep.business.dao.SiteDao;
import dz.djezzydevs.networkdep.business.data.dto.SiteInputDto;
import dz.djezzydevs.networkdep.business.data.entities.Candidate;
import dz.djezzydevs.networkdep.business.data.entities.Site;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SiteService {

    @Autowired
    SiteDao siteRepo;
    @Autowired
    CandidateDao candidaterepo;


    public Site find (String id) {
       return  siteRepo.findById(id).get();
    }



    public Candidate getActiveCandidate (String id) {
        List<Candidate>  candidates= siteRepo.findById(id).get().getCondidates();


                Candidate cand = candidates.stream()
                .filter(fl -> fl.getActiveCandidate()==true)
                .findAny()
                .orElse(null);
                return cand;
    }

    public Site findByCandidate (Long id) {
      return  candidaterepo.findById(id).get().getSite();
            //   Candidate cond
    }

    public List<Site> findAll () {
        return  siteRepo.findAll();
    }



    public SiteInputDto add (Site site) {

        ModelMapper modelMapper = new ModelMapper();

        Site newSite=siteRepo.save(site);
        Candidate candidate1=new Candidate();
        candidate1.setName("Condidat 1");
        candidate1.setActiveCandidate(true);
        candidate1.setSite(newSite);
        Candidate cnCreated=candidaterepo.save(candidate1);

        SiteInputDto siteDto = modelMapper.map(newSite, SiteInputDto.class);
        return siteDto;

    }


   // add(Site)

}

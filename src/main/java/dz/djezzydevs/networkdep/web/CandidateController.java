package dz.djezzydevs.networkdep.web;

import dz.djezzydevs.networkdep.business.data.dto.CandidateOutputDto;
import dz.djezzydevs.networkdep.business.data.entities.Candidate;
import dz.djezzydevs.networkdep.business.data.entities.Site;
import dz.djezzydevs.networkdep.business.services.CandidateService;
import dz.djezzydevs.networkdep.business.services.SiteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/cand")
public class CandidateController {

    @Autowired
    CandidateService candidateService;
    @Autowired
    SiteService siteService;


    @GetMapping("/single/{id}")
    public CandidateOutputDto get(@PathVariable(name = "id") Long id) {
       Candidate candidate = candidateService.find(id);
        ModelMapper modelMapper = new ModelMapper();
        CandidateOutputDto cand = modelMapper.map(candidate, CandidateOutputDto.class);
        return cand;

    }

    @GetMapping("/bysite/{site}")
    public CandidateOutputDto getCurrentCandidate(
            @PathVariable(name="site") String codeSite,
            @RequestParam(value = "idcandidate", required = false) Long idCondidate) {

        Candidate cand=new Candidate();
        if (idCondidate ==null) {
           cand= siteService.getActiveCandidate(codeSite);
        }else {
            cand=candidateService.find(idCondidate);
        }
     //   Candidate candidate = candidateService.find(idCondidate);
        ModelMapper modelMapper = new ModelMapper();
        CandidateOutputDto candDto = modelMapper.map(cand, CandidateOutputDto.class);
        return candDto;
    }
}
